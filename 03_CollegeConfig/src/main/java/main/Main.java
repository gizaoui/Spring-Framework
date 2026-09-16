package main;


import com.ex03.config.CollegeConfig;
import com.ex03.entity.College;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  03  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(CollegeConfig.class); // bean
        College college3 = context3.getBean(
                "collegeBean", // Méthode appelée
                College.class // Retouné par la classe 'collegeBean'
        );
        logger.info(college3);

    }

}