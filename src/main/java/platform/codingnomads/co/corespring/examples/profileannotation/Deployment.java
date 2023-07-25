package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
@PropertySource(value = "application-deploy.properties", ignoreResourceNotFound = true)
public class Deployment {

    @Value("${app.version}")
    private String appVersion;

    public Deployment() {
        System.out.println("Application deployed.");
    }

    public String getAppVersion() {
        return appVersion;
    }
}
