package main;

import com.ex08.config.StudentConfig;
import com.ex08.entity.Student;
import com.ex08.repository.StudentRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  07  __________" + OutColor.RESET.getCode());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

        StudentRepository repository = context.getBean(StudentRepository.class);

        repository.save(new Student(1L, "Anshul", 25)); // Méthode direct
        repository.save(context.getBean("studentBean", Student.class)); // Méthode via bean
        repository.save(context.getBean(Student.class, 3L, "GZI", 50));

        Student student = repository.findStudentById(3L);

        logger.info(student);
    }

}