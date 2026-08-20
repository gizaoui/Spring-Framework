package main;


import com.ex09.config.AppConfig;
import com.ex09.controller.RunClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ex09.service.WordService;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  09  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        WordService wordService = context.getBean("wordService", WordService.class);
        RunClass runClass = context.getBean("runClassBean", RunClass.class);
        runClass.Run(wordService);

        context.close();
    }

}
