package utac.org.testingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestScenario {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String scenarioName;
    private Date date;
    private String description;
    private double ambientTemperature_C;
    private double humidityPercent;
    private double windSpeed_mph;

    @OneToOne
    private Evaluation scenarioResult;
    @ManyToOne
    private Conductor conductor;
    @ManyToOne
    private TestManager testManager;
}