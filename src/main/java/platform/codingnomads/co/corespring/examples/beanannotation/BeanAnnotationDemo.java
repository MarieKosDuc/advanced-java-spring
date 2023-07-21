package platform.codingnomads.co.corespring.examples.beanannotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanAnnotationConfig.class);
        ctx.refresh();
        SampleBean sampleBean = ctx.getBean("friendly_bean_name", SampleBean.class);
        //System.out.println("-------Haschode: " + sampleBean.hashCode());
        //SampleBean sampleBean2 = ctx.getBean("not_so_friendly_bean", SampleBean.class);
        //System.out.println("-------Haschode: " + sampleBean2.hashCode());
        ctx.close();
    }
}
