package com.codewithsumedh.blog.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsumedh.blog.Repository.StudentRepo;
import com.codewithsumedh.blog.entity.Student;
import com.codewithsumedh.blog.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createuser(Student student) {
		Student student1=studentRepo.save(student);
		return student1;
	}

	@Override
	public Student updateStudent(Student student, Integer studentId) {
		Student stu=studentRepo.findById(studentId).orElseThrow();
		return stu;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Student student=studentRepo.findById(studentId).orElseThrow();
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list=studentRepo.findAll();
		return list;
	}

	@Override
	public void deleteStudent(Integer studentId) {
		studentRepo.deleteById(studentId);
		
	}
	

}
