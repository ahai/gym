package com.example.demo1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository 
        extends JpaRepository<Student, Long> {
        @Quary("Select s FROM Student s WHERE s.email = ?1")
        Optional<Student> findStudentByEmail(String email);    }
