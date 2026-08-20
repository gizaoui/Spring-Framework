package com.ex03.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.ex03.entity.College;

@PropertySource("classpath:param.properties")
@ComponentScan(basePackages = "com.ex02")
public class CollegeConfig {

    @Value("${myname:me}") // 'me' est la valeur par défaut si 'myname' non définie
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
