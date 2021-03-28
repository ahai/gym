package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Student mariam = new Student(
                1L,
                "Mariam",
                "mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student alex = new Student(
                1L,
                "Alex",
                "alex@gmail.com",
                LocalDate.of(2004, Month.JANUARY, 5)
            );

//            repository.saveAll(
//                List.of(mariam, alex)
//            );
        };
    }
}