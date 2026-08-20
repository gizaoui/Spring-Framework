package com.ex02.service;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    public String getMessage() {
        return "Bonjour depuis MessageService 02 !";
    }
}