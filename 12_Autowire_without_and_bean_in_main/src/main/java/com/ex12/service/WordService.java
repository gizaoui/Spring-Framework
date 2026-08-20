package com.ex12.service;

import java.util.Arrays;
import java.util.List;


public class WordService {

    private final List<String> words = Arrays.asList("pen", "sky", "rock", "forest", "falcon", "eagle");

    public List<String> all() {
        return words;
    }
}