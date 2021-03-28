package com.example.demo1;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
             Student Michael = new Student(
                null, "Michael",
                "mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5), null
            );
            
             Student alex = new Student(
                1L,
                "Alex",
                "Alex.jamal@gmail.com",
                LocalDate.of(2004, Month.JANUARY, 5), null
            );

            repository.saveAll(
                List.of(Michael, alex)
            );
        };
    }
}
