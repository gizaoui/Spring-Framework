package com.ex11.config;

import com.ex11.controller.RunClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.ex11")
public class AppConfig {

    @Bean
    public RunClass runClassBean() {
        return new RunClass();
    }
}
