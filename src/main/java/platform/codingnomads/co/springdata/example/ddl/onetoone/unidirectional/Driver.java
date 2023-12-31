package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
@NoArgsConstructor
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Car car;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Team team;
}