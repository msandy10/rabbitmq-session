package com.spring.session.redis.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.session.pojo.Student;

@Component
public class StudentRedisRepositoryImpl implements StudentRedisRepository {

	
	@Autowired
	private RedisTemplate<String,Student> redisStudentTemplate;
	
	private HashOperations<String, String, Student> hashOperations;
	
	@PostConstruct
	public void init(){
		hashOperations = redisStudentTemplate.opsForHash();
	}
	
	@Override
	public void saveStudent(Student student) {
		hashOperations.put(student.OBJECT_KEY, student.getId(), student);
	}

	@Override
	public Student findStudent(String id) {
		return hashOperations.get(Student.OBJECT_KEY, id);
	}

	@Override
	public Map<String, Student> findAllStudent() {
		return hashOperations.entries(Student.OBJECT_KEY);
	}

	@Override
	public List<Student> getStudents() {
		return hashOperations.values(Student.OBJECT_KEY);
	}

}
