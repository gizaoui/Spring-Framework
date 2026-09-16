package main;

import com.ex11.config.AppConfig;
import com.ex11.controller.RunClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  11  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        RunClass runClass = context.getBean("runClassBean", RunClass.class);
        runClass.Run();
        context.close();
    }

}
