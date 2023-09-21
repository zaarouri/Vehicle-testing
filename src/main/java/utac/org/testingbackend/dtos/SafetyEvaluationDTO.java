package utac.org.testingbackend.dtos;
import lombok.Data;
import lombok.EqualsAndHashCode;
import utac.org.testingbackend.enums.EvaluationStatus;


@Data
public class SafetyEvaluationDTO  {
    private String id;
    private int testDuration_minutes;
    private double score;
    private String comments;
    private EvaluationStatus status;
    private int crashTestRating;
    private boolean antiLockBrakes;
    private boolean airbags;
    private boolean stabilityControl;
    private boolean laneDepartureWarning;
    private boolean collisionAvoidanceSystem;
}

