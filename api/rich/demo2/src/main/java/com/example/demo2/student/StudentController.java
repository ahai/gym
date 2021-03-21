package com.example.demo2.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getStudent(){
        return List.of(
        		new Student(
        				1L,
        				"Mike",
        				"Mike@family.com",
        				LocalDate.of(2000, Month.JANUARY, 5),
        				21
        				)
        		);
    }
    
}
