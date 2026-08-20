package main;

import com.ex05.service.ShoppingCategoryService;
import com.exemple.core.GreetingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  CORE  __________" + OutColor.RESET.getCode());
        String name = args.length > 0 ? args[0] : "World";
        GreetingService service = new GreetingService();
        logger.info(service.greet(name));


        logger.info(OutColor.GREEN.getCode() + "__________  01  __________" + OutColor.RESET.getCode());
        AnnotationConfigApplicationContext context01 = new AnnotationConfigApplicationContext(com.ex01.config.AppConfig.class);
        com.ex01.service.MessageService messageService01 = context01.getBean(com.ex01.service.MessageService.class);
        logger.info(messageService01.getMessage());
        context01.close();


        logger.info(OutColor.GREEN.getCode() + "__________  02  __________" + OutColor.RESET.getCode());

        // ===  Method 1  ===
        AnnotationConfigApplicationContext context02 = new AnnotationConfigApplicationContext(com.ex02.config.AppConfig.class);

        // ===  Method 2  ===
        // AnnotationConfigApplicationContext context02 = new AnnotationConfigApplicationContext();
        // context02.scan("com.ex02");
        // context02.refresh();

        com.ex02.service.MessageService messageService02 = context02.getBean(com.ex02.service.MessageService.class);
        logger.info(messageService02.getMessage());
        context02.close();


        logger.info(OutColor.GREEN.getCode() + "__________  03  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(com.ex03.config.CollegeConfig.class); // bean
        com.ex03.entity.College college3 = context3.getBean(
                "collegeBean", // Méthode appelée
                com.ex03.entity.College.class // Retouné par la classe 'collegeBean'
        );
        logger.info(college3);


        logger.info(OutColor.GREEN.getCode() + "__________  04  __________" + OutColor.RESET.getCode());

        // Le @ComponentScan fait tjs référence à un service
        AnnotationConfigApplicationContext context4 = new AnnotationConfigApplicationContext(com.ex04.config.CollegeConfig.class); // bean
        com.ex04.entity.College college4 = context4.getBean("collegeBean", com.ex04.entity.College.class);
        com.ex04.service.CollegeService collegeService4 = context4.getBean(com.ex04.service.CollegeService.class);
        logger.info(collegeService4.getMessage(college4)); // Display via le service


        logger.info(OutColor.GREEN.getCode() + "__________  05  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.ex05.config.ShoppingCategoryConfig.class);

        // Création des instances
        com.ex05.entity.Product asus = context.getBean("asus", com.ex05.entity.Product.class);
        com.ex05.entity.Product redmi = context.getBean("redmi", com.ex05.entity.Product.class);
        com.ex05.entity.Product hp = context.getBean("hp", com.ex05.entity.Product.class);
        com.ex05.entity.Product oneplus = context.getBean("oneplus", com.ex05.entity.Product.class);
        com.ex05.entity.Product samsung = context.getBean("samsung", com.ex05.entity.Product.class);

        com.ex05.service.ShoppingCategoryService laptops = context.getBean("shoppingCategoryService", com.ex05.service.ShoppingCategoryService.class);
        laptops.addItem(asus);
        laptops.addItem(redmi);
        laptops.addItem(hp);
        logger.info("Category : Laptops");
        logger.info(laptops.getItems());

        ShoppingCategoryService mobiles1 = context.getBean("shoppingCategoryService", com.ex05.service.ShoppingCategoryService.class);
        mobiles1.addItem(oneplus);
        mobiles1.addItem(samsung);
        logger.info("Category : Mobile phones");
        logger.info(mobiles1.getItems());



        logger.info(OutColor.GREEN.getCode() + "__________  06  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context06 = new AnnotationConfigApplicationContext(com.ex06.config.ShoppingCategoryConfig.class);

        // Création des instances
        com.ex06.entity.Product asus2 = context06.getBean("asus", com.ex06.entity.Product.class);
        com.ex06.entity.Product redmi2 = context06.getBean("redmi", com.ex06.entity.Product.class);
        com.ex06.entity.Product hp2 = context06.getBean("hp", com.ex06.entity.Product.class);
        com.ex06.entity.Product oneplus2 = context06.getBean("oneplus", com.ex06.entity.Product.class);
        com.ex06.entity.Product samsung2 = context06.getBean("samsung", com.ex06.entity.Product.class);


        com.ex06.service.ShoppingCategoryService laptops2 = context06.getBean(com.ex06.service.ShoppingCategoryService.class);
        laptops2.addItem(asus2);
        laptops2.addItem(redmi2);
        laptops2.addItem(hp2);
        logger.info("Category : Laptops");
        logger.info(laptops2.getItems());

        com.ex06.service.ShoppingCategoryService mobiles2 = context06.getBean(com.ex06.service.ShoppingCategoryService.class);
        mobiles2.addItem(oneplus2);
        mobiles2.addItem(samsung2);
        logger.info("Category : Mobile phones");
        logger.info(mobiles2.getItems());

    }
}
