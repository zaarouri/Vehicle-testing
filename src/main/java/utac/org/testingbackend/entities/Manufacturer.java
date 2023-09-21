package utac.org.testingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {
    @Column(unique = true)
    private String company ;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id ;
    @OneToMany(mappedBy = "manufacturer",fetch = FetchType.EAGER)
    @Column(name = "vehicles")
    private Collection<Vehicle> submited_vehicles;
}