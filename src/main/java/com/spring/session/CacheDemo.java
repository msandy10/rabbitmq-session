package com.spring.session;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.spring.session.service.SlowService;

@Component
public class CacheDemo implements CommandLineRunner{
	private static Log logger = LogFactory.getLog(CacheDemo.class);
	
	private final StringRedisTemplate stringRedisTemplate;
	
	private final SlowService slowService;
	
	@Autowired
	public CacheDemo(StringRedisTemplate stringRedisTemplate, SlowService slowService) {
		super();
		this.stringRedisTemplate = stringRedisTemplate;
		this.slowService = slowService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		reset();
		operations();
		caching();
	}

	private void reset() {
		stringRedisTemplate.delete(Arrays.asList("BOOT","abc","pqr"));
	}

	private void operations() {
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		Arrays.asList(1,2,3,6).forEach((i) -> ops.increment("abc", i));
		logger.info("Ops -===========> "+ops.get("abc"));
	}
	
	private void caching() {
		logger.info("-------> 1 "+this.slowService.execute("BOOT"));
		logger.info("-------> 2 "+this.slowService.execute("BOOT"));
		logger.info("-------> 3 "+this.slowService.execute("BOOT"));
	}

}
