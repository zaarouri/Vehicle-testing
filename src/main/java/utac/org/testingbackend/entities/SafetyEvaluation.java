package utac.org.testingbackend.entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("SE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SafetyEvaluation extends Evaluation{
    private int crashTestRating; // Safety rating from crash tests (e.g., 5-star rating)
    private boolean antiLockBrakes; // Presence of anti-lock brakes (true/false)
    private boolean airbags; // Presence of airbags (true/false)
    private boolean stabilityControl; // Presence of stability control system (true/false)
    private boolean laneDepartureWarning; // Presence of lane departure warning system (true/false)
    private boolean collisionAvoidanceSystem; // Presence of collision avoidance system (true/false)
}

