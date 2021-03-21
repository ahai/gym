package com.example.demo2.student;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {


	//TODO: RICH001 who do i need this one?
	public Student(long l, String string, String string2, LocalDate of, int i) {
		this.id = l;
		this.name=string;
		this.email=string2;
		this.dob=of;
		this.age=i;
	}
	private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
    
    
}
