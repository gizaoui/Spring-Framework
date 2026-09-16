package main;


import com.ex10.config.AppConfig;
import com.ex10.controller.RunClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ex10.service.WordService;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  09  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Remplacement de l'instruction 'WordService wordService = context.getBean("wordService", WordService.class)' du 'Main'
        // par '@Autowired WordService wordService' du 'RunClass'
        // cf. 09_Autowire_without

        RunClass runClass = context.getBean("runClassBean", RunClass.class);
        runClass.Run();

        context.close();
    }

}
