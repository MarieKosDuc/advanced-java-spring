package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoreConfiguration {
    @Bean
    public Framework framework() {return  new Framework();}
}
