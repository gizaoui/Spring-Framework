package com.ex14.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class WordService {

    private final List<String> words = Arrays.asList("pen", "sky", "rock", "forest", "falcon", "eagle");

    public List<String> all() {
        return words;
    }
}