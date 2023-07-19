package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    // used for constructor dependency injection
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    // field dependency injection
    @Autowired
    private Computer computer;

    // used for setter dependency injection
    private Location location;


    // setter dependency injection
    @Autowired
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocation(){
        return location.getCity();
    }



    public String createAwesomeSoftware() {
        return MessageFormat.format("This coding nomad is creating awesome software using: " +
                        "\nIDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5})," +
                        "\non a ({6}:{7}) computer, in ({8})!",
                ide.getName(),
                ide.getVersion(),
                jdk.getName(),
                jdk.getVersion(),
                framework.getName(),
                framework.getVersion(),
                computer.getYear(),
                computer.getName(),
                location.getCity()
        );
    }

}
