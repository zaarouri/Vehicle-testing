package utac.org.testingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int age;
    private String licenseNumber;
    private String name;
    @OneToMany(mappedBy = "conductor")
    private Collection<TestScenario> testScenarios;


}
