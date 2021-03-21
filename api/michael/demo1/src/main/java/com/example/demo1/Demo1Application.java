package com.example.demo1;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@GetMapping
	public List<Student> hello() {
		return List.of(
				new Student(
						1L,
						"Michael",
						"mariam.jamal@gmail.com",
						LocalDate.of(2000, Month.JANUARY, 5),
						21
					)
		);
	}

}
