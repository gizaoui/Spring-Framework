package com.ex10.controller;


import com.ex10.service.WordService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class RunClass {

    private static final Logger logger = LogManager.getLogger(RunClass.class);

    // Remplacement de l'instruction 'WordService wordService = context.getBean("wordService", WordService.class)' du 'Main'
    // par '@Autowired WordService wordService' du 'RunClass'
    // cf. 09_Autowire_without
    @Autowired
    WordService wordService;

    public void Run() {
        wordService.all().stream().forEach(word -> logger.info("- " + word));
    }
}
