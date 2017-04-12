package com.spring.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
//@EnableSpringHttpSession
@EntityScan(basePackages = { "com.spring.session.pojo" })
@EnableJpaRepositories(basePackages = { "com.spring.session.repository" })

public class RabbitmqSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqSessionApplication.class, args);
	}
}
