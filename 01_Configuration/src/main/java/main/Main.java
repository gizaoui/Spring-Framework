package main;


import com.ex01.config.AppConfig;
import com.ex01.service.MessageService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  01  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Appel de la méthode 'messageService' de la classe 'AppConfig'
        MessageService messageService = context.getBean("messageService", MessageService.class);
        logger.info(messageService.getMessage());
        context.close();

    }

}