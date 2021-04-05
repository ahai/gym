package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.student.Quary;
import com.example.demo.student.Student;

@Repository
public interface StudentRepository 
extends JpaRepository<Student, Long> {
	@Quary("Select s FROM Student s WHERE s.email = ?1")
	Optional<Student> findStudentByEmail(String email);    }
