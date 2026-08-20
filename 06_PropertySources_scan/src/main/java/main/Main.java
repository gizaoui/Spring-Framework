package main;

import com.ex06.config.ShoppingCategoryConfig;
import com.ex06.entity.Product;
import com.ex06.service.ShoppingCategoryService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  06  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ShoppingCategoryConfig.class); // @Configuration : Bean

        // Création des instances
        Product asus = context.getBean("asus", Product.class); // @Component : Appel de la methoed 'asus' de la classe 'ShoppingCategoryConfig'
        Product redmi = context.getBean("redmi", Product.class); // @Component : Appel de la methoed 'redmi' de la classe 'ShoppingCategoryConfig'
        Product hp = context.getBean("hp", Product.class); // @Component : Appel de la methoed 'hp' de la classe 'ShoppingCategoryConfig'
        Product oneplus = context.getBean("oneplus", Product.class); // @Component : Appel de la methoed 'oneplus' de la classe 'ShoppingCategoryConfig'
        Product samsung = context.getBean("samsung", Product.class); // @Component : Appel de la methoed 'samsung' de la classe 'ShoppingCategoryConfig'


        // Création de l'instance
        ShoppingCategoryService laptops = context.getBean(ShoppingCategoryService.class); /* Classe non instancier  -> ComponentScan dans ShoppingCategoryConfig */
        laptops.addItem(asus);
        laptops.addItem(redmi);
        laptops.addItem(hp);
        logger.info("Category : Laptops");
        logger.info(laptops.getItems());

        // Création de l'instance
        ShoppingCategoryService mobiles = context.getBean(ShoppingCategoryService.class); /* Classe non instancier -> ComponentScan dans ShoppingCategoryConfig */
        mobiles.addItem(oneplus);
        mobiles.addItem(samsung);
        logger.info("Category : Mobile phones");
        logger.info(mobiles.getItems());
    }

}