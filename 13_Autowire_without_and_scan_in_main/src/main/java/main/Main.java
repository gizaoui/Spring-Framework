package main;


import com.ex13.service.WordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  13  __________" + OutColor.RESET.getCode());

        // Autre méthode : 'context.scan("com.ex13"); context.refresh();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ex13");

        // Remplacement de @Bean (cf. 12) grâce au scan
        WordService wordService = context.getBean(WordService.class);

        wordService.all().stream().forEach(word -> logger.info(word));
        context.close();
    }

}
