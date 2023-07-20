package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Hey, this bean didn't want to be called ".concat(name));
    }
}
