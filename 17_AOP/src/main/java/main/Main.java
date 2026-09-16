package main;

import com.ex17.service.BusinessService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  17  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.ex17.config.ShoppingCategoryConfig.class);

        // Création des instances
        com.ex17.entity.Product asus1 = context.getBean("asus", com.ex17.entity.Product.class);
        com.ex17.entity.Product redmi1 = context.getBean("redmi", com.ex17.entity.Product.class);
        com.ex17.entity.Product hp1 = context.getBean("hp", com.ex17.entity.Product.class);
        com.ex17.entity.Product oneplus1 = context.getBean("oneplus", com.ex17.entity.Product.class);
        com.ex17.entity.Product samsung1 = context.getBean("samsung", com.ex17.entity.Product.class);

        // Création de l'instance
        com.ex17.service.ShoppingCategoryService laptops = context.getBean( com.ex17.service.ShoppingCategoryService.class);
        laptops.addItem(asus1);
        laptops.addItem(redmi1);
        laptops.addItem(hp1);
        logger.info("Category : Laptops");
        logger.info(laptops.getItems());

        // Création de l'instance
        com.ex17.service.ShoppingCategoryService mobiles = context.getBean( com.ex17.service.ShoppingCategoryService.class);
        mobiles.addItem(oneplus1);
        mobiles.addItem(samsung1);
        logger.info("Category : Mobile phones");
        logger.info(mobiles.getItems());

        BusinessService businessService= context.getBean(BusinessService.class);
        businessService.doSomething();

        context.close();
    }

}
