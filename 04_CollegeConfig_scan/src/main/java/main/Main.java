package main;


import com.ex04.config.CollegeConfig;
import com.ex04.entity.College;
import com.ex04.service.CollegeService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  04  __________" + OutColor.RESET.getCode());

        // Le @ComponentScan fait tjs référence à un service
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class); // bean

        // Factory
        College college = context.getBean(
                "collegeBean", // Appel de la méthode
                College.class // Objet de retour (class College)
        );

        // CollegeService non instancié (via Factory ds CollegeConfig)
        CollegeService collegeService4 = context.getBean(CollegeService.class);
        logger.info(collegeService4.getMessage(college)); // Display via le service
    }

}