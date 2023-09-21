package utac.org.testingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utac.org.testingbackend.enums.EvaluationStatus;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evaluations")

@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Evaluation {
    @Id
    private String id;
    private int testDuration_minutes;
    private double score;
    private String comments;
    @Enumerated(value = EnumType.STRING)
    private EvaluationStatus status;
    @ManyToOne
    private Vehicle vehicle;
    @OneToOne(mappedBy = "scenarioResult")
    private TestScenario testScenario;
}
