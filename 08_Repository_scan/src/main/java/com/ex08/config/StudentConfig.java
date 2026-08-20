package com.ex08.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;

import com.ex08.entity.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan("com.ex08")
public class StudentConfig {

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
