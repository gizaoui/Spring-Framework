package com.ex02.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.ex02")
public class AppConfig {
    // Pas de @Bean de création d'instance :
    // @Bean public MessageService messageService() { return new MessageService();  }
}