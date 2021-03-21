package com.example.demo2.student;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping (path="api/v1/students")
    public List<String> getStudent(){
        return List.of("hello, i am richard, again","hello, michael");
    }
    
}
