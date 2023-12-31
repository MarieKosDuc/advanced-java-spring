package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
@PropertySource(value = "application-test.properties", ignoreResourceNotFound = true)
public class SpringDeveloper {

    @Value("${app.version}")
    private String appVersion;

    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready.");
    }

    public String getAppVersion() {
        return appVersion;
    }
}
