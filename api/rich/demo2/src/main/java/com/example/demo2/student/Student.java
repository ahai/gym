package com.example.demo2.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {


	//TODO: RICH001 who do i need this one?
	public Student(long l, String string, String string2, LocalDate of, int i) {
		this.id = l;
		this.name=string;
		this.email=string2;
		this.dob=of;
		this.age=i;
	}

	@Id
	@SequenceGenerator (
		name= "student_sequence",
		sequenceName = "student_sequence",
		allocationSize = 1
	)
	@GeneratedValue (
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
	)
	private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
    
    
}
