package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        // CodingNomads example with Employee class
        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        // books
        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE books (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(255) NOT NULL, author VARCHAR(255) NOT NULL, year INT NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        // create a list of books
        List<Object[]> books = Stream.of("The Lord of the Rings|JRR Tolkien|1954", "Royal Assassin|Robin Hobb|1996", "The Hobbit|JRR Tolkien|1937", "Dragonriders of Pern|Ann McCaffrey|1967")
                        .map(book -> book.split("\\|"))
                                .collect(Collectors.toList());

        // insert it into DB
        for (Object[] book : books) {
            jdbcTemplate.execute(String.format("INSERT INTO books(title, author, year) VALUES ('%s','%s','%s')", book[0], book[1], book[2]));
        }


        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));


        // DB query for books by JRR Tolkien
        jdbcTemplate.query("SELECT id, title, author, year FROM books WHERE author = 'JRR Tolkien'",
                (rs, rowNum) -> new Book(rs.getLong("id"), rs.getString("title"), rs.getString("author"), rs.getInt("year"))
            // print each found book to the console
            ).forEach(book -> System.out.println(book.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE employees");

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE books;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE books");
    }

}
