package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private long id;
    private String title, author;
    private int year;

}
