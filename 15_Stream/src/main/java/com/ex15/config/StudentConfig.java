package com.ex15.config;

import com.ex15.repository.StudentRepository;
import com.ex15.service.StudentService;
import org.springframework.context.annotation.Bean;

// @ComponentScan("com.ex15")
public class StudentConfig {

    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }

    @Bean
    public StudentService studentService() {
        return new StudentService();
    }
}
