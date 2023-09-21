package utac.org.testingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String modelId;
    private String modelName;
    private String _Year ;
    private double batteryCapacity_kWh;
    private double maxRange_miles;
    private double topSpeed_mph;
    private double acceleration_0to60_seconds;
    private double weight_kg;
    private String category;
    private String engine ;
    @ManyToOne
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "vehicle")
    private List<Evaluation> results;
}