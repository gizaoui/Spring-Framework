package main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  05  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context05 = new AnnotationConfigApplicationContext(com.ex05.config.ShoppingCategoryConfig.class);

        // Création des instances
        com.ex05.entity.Product asus1 = context05.getBean("asus", com.ex05.entity.Product.class);
        com.ex05.entity.Product redmi1 = context05.getBean("redmi", com.ex05.entity.Product.class);
        com.ex05.entity.Product hp1 = context05.getBean("hp", com.ex05.entity.Product.class);
        com.ex05.entity.Product oneplus1 = context05.getBean("oneplus", com.ex05.entity.Product.class);
        com.ex05.entity.Product samsung1 = context05.getBean("samsung", com.ex05.entity.Product.class);

        // Création de l'instance
        com.ex05.service.ShoppingCategoryService laptops1 = context05.getBean("shoppingCategoryService", com.ex05.service.ShoppingCategoryService.class);
        laptops1.addItem(asus1);
        laptops1.addItem(redmi1);
        laptops1.addItem(hp1);
        logger.info("Category : Laptops");
        logger.info(laptops1.getItems());

        // Création de l'instance
        com.ex05.service.ShoppingCategoryService mobiles1 = context05.getBean("shoppingCategoryService", com.ex05.service.ShoppingCategoryService.class);
        mobiles1.addItem(oneplus1);
        mobiles1.addItem(samsung1);
        logger.info("Category : Mobile phones");
        logger.info(mobiles1.getItems());
    }

}