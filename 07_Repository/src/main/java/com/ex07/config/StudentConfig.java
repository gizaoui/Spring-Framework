package com.ex07.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;

import com.ex07.entity.Student;
import com.ex07.repository.StudentRepository;
import org.springframework.context.annotation.Scope;


public class StudentConfig {

    @Bean
    public StudentRepository studentRepositoryBean() {
        return new StudentRepository();
    }

    @Bean
    public Student studentBean() {
        return new Student(2L, "Mayank", 23);
    }


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Student studentBean(Long id, String name, int age) {
        return new Student(id, name, age);
    }

}
