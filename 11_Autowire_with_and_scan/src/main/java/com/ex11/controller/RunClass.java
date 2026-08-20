package com.ex11.controller;


import com.ex11.service.WordService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class RunClass {

    private static final Logger logger = LogManager.getLogger(RunClass.class);

    @Autowired
    WordService wordService;

    public void Run() {
        wordService.all().stream().forEach(word -> logger.info(word));
    }

}
