package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/zoo_config.xml"})
public class ZooConfig {

    @Bean
    public Tiger tiger() {return new Tiger();}

}
