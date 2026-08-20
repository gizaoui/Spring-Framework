package com.ex01.config;

import com.ex01.service.MessageService;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public MessageService messageService() {
        return new MessageService();
    }
}
