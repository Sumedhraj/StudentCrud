package com.codewithsumedh.blog.service;

import java.util.List;

import com.codewithsumedh.blog.entity.Student;

public interface StudentService {
	
	Student createuser(Student student);
	
	Student updateStudent(Student student,Integer studentId);
	
	Student getStudentById(Integer studentId);
	
	List<Student> getAllStudent();
	
	void deleteStudent(Integer studentId);

}
