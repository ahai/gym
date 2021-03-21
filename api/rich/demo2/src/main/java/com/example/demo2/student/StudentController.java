package com.example.demo2.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping (path="api/v1/students")
    public String getStudent(){
        return "hello, i am richard, again";
    }
    
}
