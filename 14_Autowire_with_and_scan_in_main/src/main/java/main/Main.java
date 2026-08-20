package main;


import com.ex14.service.WordService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.ex14")
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static AnnotationConfigApplicationContext context;

    @Autowired
    private WordService wordService;


    public void run() {
        // WordService wordService = context.getBean(WordService.class); // Peut-être l'@Autowired
        wordService.all().stream().forEach(word -> logger.info(word));
    }


    public static void main(String[] args) {

        logger.info(OutColor.GREEN.getCode() + "__________  14  __________" + OutColor.RESET.getCode());

        // Le Main est considéré comme classe de configuration (@ComponentScan)
        context = new AnnotationConfigApplicationContext(Main.class);

        // La classe Main est dans le scope du @ComponentScan
        Main bean = context.getBean(Main.class);
        bean.run();

        context.close();
    }

}
