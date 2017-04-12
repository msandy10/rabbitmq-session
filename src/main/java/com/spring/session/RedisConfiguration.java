package com.spring.session;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.spring.session.pojo.Student;

@Configuration
@EnableRedisRepositories(basePackages = "com.spring.session.redis.repository")
public class RedisConfiguration extends CachingConfigurerSupport {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public Jackson2JsonRedisSerializer<Student> studentSerializer() {
		Jackson2JsonRedisSerializer<Student> studentSerializer = new Jackson2JsonRedisSerializer<>(Student.class);
		return studentSerializer;
	}

	@Bean
	public RedisSerializer<String> redisStringSerializer() {
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		return stringRedisSerializer;
	}

	@Bean
	RedisTemplate<String, Student> redisStudentTemplate() {
		final RedisTemplate<String, Student> template = new RedisTemplate<String, Student>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(studentSerializer());
		template.setValueSerializer(studentSerializer());
		return template;
	}
	
	@Bean(name="redisTemplate")
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setDefaultSerializer(redisStringSerializer());
        return redisTemplate;
    }

	@Bean
	public CacheManager cacheManager() {
		return new RedisCacheManager(redisTemplate());
	}
}
