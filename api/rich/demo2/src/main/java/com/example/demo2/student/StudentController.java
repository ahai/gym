package com.example.demo2.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "api/v1/students")
@Slf4j
public class StudentController {

	private final StudentService studentService ;
	
	@Autowired
	public StudentController(StudentService studentService) {
		
		this.studentService = studentService;
		
	}


	@GetMapping
	public List<Student> getStudent() {
		//log.debug("inside StudentController now ");
		return studentService.getStudent();
	}

}
	