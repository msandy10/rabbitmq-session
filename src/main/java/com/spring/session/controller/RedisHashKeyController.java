package com.spring.session.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.session.pojo.Student;
import com.spring.session.redis.repository.StudentRedisRepositoryImpl;

@RestController
@RequestMapping("/redis-test")
public class RedisHashKeyController {

	@Autowired
	StudentRedisRepositoryImpl studentRedisRepositoryImpl;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = studentRedisRepositoryImpl.getStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createStudent(@RequestBody Student student ){
		studentRedisRepositoryImpl.saveStudent(student);
		System.out.println("------------> "+studentRedisRepositoryImpl.findStudent(student.getId()));
		return new ResponseEntity<String>("Student has been create in Redis",HttpStatus.OK);
	}
}
