package platform.codingnomads.co.corespring.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
public class Elephant {

    private String sound = "------------Trumpets------------";
    public Elephant() {
        System.out.println("Pachyderms...");
    }

}
