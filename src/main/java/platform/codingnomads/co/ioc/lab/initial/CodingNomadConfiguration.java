package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab.initial")
public class CodingNomadConfiguration {

    @Bean
    public Framework framework() {
        return Framework.builder().name("Spring Boot").version("2.5").build();
    }

    @Bean
    public IDE ide() {
        return IDE.builder().name("IntelliJ IDEA").version("Community 2023.1.2").build();
    }

    @Bean
    public JDK jdk () {
        return JDK.builder().name("Open JDK").version("11").build();
    }

    @Bean
    public Computer computer() {
        return Computer.builder().name("Dell XPS").year(2022).build();
    }

    @Bean
    public Location location () {
        return Location.builder().city("Saint-Rémy-lès-Chevreuse").build();
    }
}
