package com.codewithsumedh.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsumedh.blog.entity.Student;
import com.codewithsumedh.blog.service.StudentService;


@RestController
@RequestMapping("/api/Student/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student stu=studentService.createuser(student);
		return ResponseEntity.ok().body(stu);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("studentId") Integer studentId){
		Student student1=studentService.updateStudent(student, studentId);
		System.out.println(student);
		System.out.println(student1);
		//
		student1.setId(student.getId());
		student1.setName(student.getName());
		student1.setCity(student.getCity());
		Student update1=studentService.createuser(student1);
		System.out.println(update1);
		return ResponseEntity.ok().body(update1);
		
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id){
		Student stu=studentService.getStudentById(id);
		return ResponseEntity.ok().body(stu);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> list=studentService.getAllStudent();
		return ResponseEntity.ok().body(list);
	}

}
