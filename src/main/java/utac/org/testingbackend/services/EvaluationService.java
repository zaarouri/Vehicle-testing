package utac.org.testingbackend.services;

import utac.org.testingbackend.dtos.EngineEvaluationDTO;
import utac.org.testingbackend.dtos.EvaluationDTO;
import utac.org.testingbackend.dtos.SafetyEvaluationDTO;
import utac.org.testingbackend.entities.Evaluation;
import utac.org.testingbackend.entities.SafetyEvaluation;
import utac.org.testingbackend.exceptions.EvaluationNotFoundException;

import java.util.List;

public interface EvaluationService {
    EvaluationDTO getEvaluation(String id) throws EvaluationNotFoundException;

    EngineEvaluationDTO saveEngineEvaluation(EngineEvaluationDTO engineEvaluationDTO);
    SafetyEvaluationDTO saveSafetyEvaluation(SafetyEvaluationDTO safetyEvaluationDTO);

    List<EngineEvaluationDTO> listEngineEvaluations();
    List<SafetyEvaluationDTO> listSafetyEvaluations();

    EngineEvaluationDTO getEngineEvaluationById(String id) throws EvaluationNotFoundException;
    SafetyEvaluationDTO getSafetyEvaluationById(String id) throws EvaluationNotFoundException;

    void deleteEngineEvaluation(String id) throws EvaluationNotFoundException;
    void deleteSafetyEvaluation(String id);

    EngineEvaluationDTO updateEngineEvaluation(EngineEvaluationDTO engineEvaluationDTO) throws EvaluationNotFoundException;
    SafetyEvaluationDTO updateSafetyEvaluation(SafetyEvaluationDTO safetyEvaluationDTO) throws EvaluationNotFoundException;

    List<EvaluationDTO> listAllEvaluations();

    void deleteEvaluation(String id) throws EvaluationNotFoundException;
}
