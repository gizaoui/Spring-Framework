package com.ex04.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ex04.entity.College;

@PropertySource("classpath:param.properties")
@ComponentScan(basePackages = "com.ex04")
public class CollegeConfig {

    @Value("${myname}")
    private String myName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public College collegeBean() {
        return new College("Test College Method : " + myName);
    }
}
