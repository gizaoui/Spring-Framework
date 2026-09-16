package main;


import com.ex16.config.StudentConfig;
import com.ex16.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  16  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

        StudentService studentService = context.getBean(StudentService.class);
        studentService.LoadData();
        studentService.ForEach();
        studentService.List();
        studentService.GroupBy();
        studentService.Distinct();
        studentService.InnerJoin();
    }
}
