package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;
import utac.org.testingbackend.dtos.EngineEvaluationDTO;
import utac.org.testingbackend.dtos.EvaluationDTO;
import utac.org.testingbackend.dtos.SafetyEvaluationDTO;
import utac.org.testingbackend.entities.EngineEvaluation;
import utac.org.testingbackend.entities.Evaluation;
import utac.org.testingbackend.entities.SafetyEvaluation;

@Mapper(componentModel = "spring")
@Primary
public interface EvaluationMapper {
    EvaluationDTO toDTO(Evaluation evaluation);
    Evaluation toEntity(EvaluationDTO evaluationDTO);

    EngineEvaluationDTO toEngineDTO(EngineEvaluation engineEvaluation);
    EngineEvaluation toEngineEntity(EngineEvaluationDTO engineEvaluationDTO);

    SafetyEvaluationDTO toSafetyDTO(SafetyEvaluation safetyEvaluation);
    SafetyEvaluation toSafetyEntity(SafetyEvaluationDTO safetyEvaluationDTO);
}


