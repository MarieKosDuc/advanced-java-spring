package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                ZooConfig.class);

        Tiger tiger = ctx.getBean(Tiger.class);
        Elephant elephant = ctx.getBean(Elephant.class);

        System.out.println("*_* *_* *_* Welcome to the zoo! *_* *_* *_* ");


        System.out.println("See the tigers!");
        System.out.println(tiger.getSound());

        System.out.println("Wave to the elephants!");
        System.out.println(elephant.getSound());
    }
}
