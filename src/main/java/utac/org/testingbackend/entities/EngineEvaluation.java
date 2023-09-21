package utac.org.testingbackend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("EA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineEvaluation extends Evaluation {
    private double maxSpeedAchieved; // Maximum speed achieved during the test
    private double fuelEfficiency; // Fuel efficiency during the test
    private double emissions; // Emissions data during the test
    private double torque; // Engine torque
    private double horsepower; // Engine horsepower
    private double accelerationTimeSeconds;
    private double fuelConsumptionRate;
    private double airFuelRatio;

}