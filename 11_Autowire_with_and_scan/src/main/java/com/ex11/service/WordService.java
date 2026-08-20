package com.ex11.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WordService {

    private final List<String> words = Arrays.asList("pen", "sky", "rock", "forest", "falcon", "eagle");

    public List<String> all() {
        return words;
    }
}