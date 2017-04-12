package com.spring.session.redis.repository;

import java.util.List;
import java.util.Map;

import com.spring.session.pojo.Student;


public interface StudentRedisRepository {

	void saveStudent(Student student);
	
	Student findStudent(String id);
	
	Map<String, Student> findAllStudent();
	
	List<Student> getStudents();
 	
}
