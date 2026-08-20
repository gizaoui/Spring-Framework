package main;


import com.ex15.config.StudentConfig;
import com.ex15.service.StudentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  15  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.LoadData();
        studentService.ForEach();
        studentService.List();
        studentService.GroupBy();
        studentService.Distinct();
        studentService.InnerJoin();
    }
}
