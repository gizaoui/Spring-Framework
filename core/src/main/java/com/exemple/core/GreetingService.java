package com.exemple.core;

public class GreetingService {

    private final Greeter greeter = new Greeter();

    public String greet(String name) {
        return greeter.buildMessage(name);
    }
}
