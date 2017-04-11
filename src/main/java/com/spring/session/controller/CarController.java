package com.spring.session.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	private final JdbcTemplate jdbc;

	public CarController(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@RequestMapping("/cars")
	public String hello() {
		return jdbc.queryForObject("select model from car where id = 1", String.class);
	}
	

}