package com.ex09.config;

import com.ex09.controller.RunClass;
import com.ex09.service.WordService;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public WordService wordService() {
        return new WordService();
    }

    @Bean
    public RunClass runClassBean() {
        return new RunClass();
    }
}
