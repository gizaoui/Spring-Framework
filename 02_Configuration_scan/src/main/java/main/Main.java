package main;


import com.ex02.config.AppConfig;
import com.ex02.service.MessageService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  02  __________" + OutColor.RESET.getCode());

        // ===  Method 1  ===
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // ===  Method 2  ===
        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // context.scan("com.ex02");
        // context.refresh();

        MessageService messageService = context.getBean(MessageService.class);
        logger.info(messageService.getMessage());
        context.close();
    }

}