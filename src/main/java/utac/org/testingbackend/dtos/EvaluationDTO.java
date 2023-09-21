package utac.org.testingbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utac.org.testingbackend.enums.EvaluationStatus;

@Data
public class EvaluationDTO {
    private String id;
    private int testDuration_minutes;
    private double score;
    private String comments;
    private EvaluationStatus status;
    private double maxSpeedAchieved;
    private double fuelEfficiency;
    private double emissions;
    private double torque;
    private double horsepower;
    private double accelerationTimeSeconds;
    private double fuelConsumptionRate;
    private double airFuelRatio;
    private int crashTestRating;
    private boolean antiLockBrakes;
    private boolean airbags;
    private boolean stabilityControl;
    private boolean laneDepartureWarning;
    private boolean collisionAvoidanceSystem;
}
