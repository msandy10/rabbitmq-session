package com.spring.session.service;

import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SlowService {
	@Cacheable("slow")
	public String execute(String data){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return UUID.randomUUID().toString();
	}
}
