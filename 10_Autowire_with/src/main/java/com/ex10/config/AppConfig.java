package com.ex10.config;

import com.ex10.controller.RunClass;
import com.ex10.service.WordService;
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
