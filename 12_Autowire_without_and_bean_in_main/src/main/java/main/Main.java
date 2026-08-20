package main;


import com.ex12.service.WordService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    @Bean
    public WordService wordService() {
        return new WordService();
    }

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  12  __________" + OutColor.RESET.getCode());

        // Le param. 'Main.class' indique l'emplacement des @Bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        WordService ws  = context.getBean("wordService", WordService.class);
        ws.all().stream().forEach(word -> logger.info(word));
        context.close();
    }

}
