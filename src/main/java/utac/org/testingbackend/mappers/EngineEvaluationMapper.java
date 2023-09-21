package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import utac.org.testingbackend.dtos.EngineEvaluationDTO;
import utac.org.testingbackend.entities.EngineEvaluation;

@Mapper(componentModel = "spring")
public interface EngineEvaluationMapper {
    EngineEvaluationDTO toDto(EngineEvaluation engineEvaluation);
    EngineEvaluation toEntity(EngineEvaluationDTO engineEvaluationDTO);
}
