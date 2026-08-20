package com.ex09.controller;


import com.ex09.service.WordService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RunClass {

    private static final Logger logger = LogManager.getLogger(RunClass.class);

    public void Run( WordService wordService) {
        wordService.all().stream().forEach(word -> logger.info(word));
    }

}
