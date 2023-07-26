package platform.codingnomads.co.corespring.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Tiger {

    private String sound =  "-----------ROARRRS--------------";

    public Tiger() {
        System.out.println("Felines...");
    }

    public String getSound() {
        return sound;
    }
}
