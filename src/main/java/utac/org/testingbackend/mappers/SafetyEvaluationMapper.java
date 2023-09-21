package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import utac.org.testingbackend.dtos.SafetyEvaluationDTO;
import utac.org.testingbackend.entities.SafetyEvaluation;

@Mapper(componentModel = "spring")
public interface SafetyEvaluationMapper {
    SafetyEvaluationDTO toDto(SafetyEvaluation safetyEvaluation);
    SafetyEvaluation toEntity(SafetyEvaluationDTO safetyEvaluationDTO);
}