package utac.org.testingbackend.services.implementations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import utac.org.testingbackend.dtos.EngineEvaluationDTO;
import utac.org.testingbackend.dtos.EvaluationDTO;
import utac.org.testingbackend.dtos.SafetyEvaluationDTO;
import utac.org.testingbackend.entities.EngineEvaluation;
import utac.org.testingbackend.entities.SafetyEvaluation;
import utac.org.testingbackend.exceptions.EvaluationNotFoundException;
import utac.org.testingbackend.mappers.EngineEvaluationMapper;
import utac.org.testingbackend.mappers.EvaluationMapper;
import utac.org.testingbackend.mappers.SafetyEvaluationMapper;
import utac.org.testingbackend.repositories.EvaluationRepository;
import utac.org.testingbackend.services.EvaluationService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private EvaluationRepository evaluationRepository;
    private EngineEvaluationMapper engineMapper;
    private EvaluationMapper evaluationMapper;


    private SafetyEvaluationMapper safetyMapper;

    public  boolean existById(String id){
        return evaluationRepository.existsById(id);
    }
    @Override
    public EvaluationDTO getEvaluation(String id) throws EvaluationNotFoundException {
        if(!existById(id)){ throw new EvaluationNotFoundException("id not found");}
        EvaluationDTO evaluationDTO = evaluationMapper.toDTO(evaluationRepository.findById(id).get());
        return evaluationDTO;
    }



    @Override
    public EngineEvaluationDTO saveEngineEvaluation(EngineEvaluationDTO engineEvaluationDTO) {
        // Convert DTO to Entity, save and then convert the result back to DTO
        engineEvaluationDTO.setId(UUID.randomUUID().toString());
        EngineEvaluation engineEvaluation = engineMapper.toEntity(engineEvaluationDTO);
        evaluationRepository.save(engineEvaluation);
        return engineMapper.toDto(evaluationRepository.save(engineMapper.toEntity(engineEvaluationDTO)));
    }

    @Override
    public SafetyEvaluationDTO saveSafetyEvaluation(SafetyEvaluationDTO safetyEvaluationDTO) {
        safetyEvaluationDTO.setId(UUID.randomUUID().toString());
        SafetyEvaluation safetyEvaluation = safetyMapper.toEntity(safetyEvaluationDTO);
        evaluationRepository.save(safetyEvaluation);
        return safetyMapper.toDto(evaluationRepository.save(safetyMapper.toEntity(safetyEvaluationDTO)));
    }

    @Override
    public List<EngineEvaluationDTO> listEngineEvaluations() {
        return evaluationRepository.findAll().stream().filter(e -> e instanceof EngineEvaluation).map(e -> engineMapper.toDto((EngineEvaluation) e)).collect(Collectors.toList());
    }

    @Override
    public List<SafetyEvaluationDTO> listSafetyEvaluations() {
        return evaluationRepository.findAll().stream().filter(e -> e instanceof SafetyEvaluation).map(e -> safetyMapper.toDto((SafetyEvaluation) e)).collect(Collectors.toList());
    }

    @Override
    public EngineEvaluationDTO getEngineEvaluationById(String id) throws EvaluationNotFoundException {
        if(!existById(id)){ throw new EvaluationNotFoundException("id not found");}
        EngineEvaluation engineEvaluation = (EngineEvaluation) evaluationRepository.findById(id).orElse(null);
        return engineMapper.toDto(engineEvaluation);
    }

    @Override
    public SafetyEvaluationDTO getSafetyEvaluationById(String id) throws EvaluationNotFoundException{
        if(!existById(id)){ throw new EvaluationNotFoundException("id not found");}
        SafetyEvaluation safetyEvaluation = (SafetyEvaluation) evaluationRepository.findById(id).orElse(null);
        return safetyMapper.toDto(safetyEvaluation);
    }

    @Override
    public void deleteEngineEvaluation(String id) throws EvaluationNotFoundException{
        if(!existById(id)){ throw new EvaluationNotFoundException("id not found");}
        evaluationRepository.deleteById(id);
    }

    @Override
    public void deleteSafetyEvaluation(String id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public EngineEvaluationDTO updateEngineEvaluation(EngineEvaluationDTO engineEvaluationDTO)throws EvaluationNotFoundException{
        if(!existById(engineEvaluationDTO.getId())){ throw new EvaluationNotFoundException("id not found");}
        return saveEngineEvaluation(engineEvaluationDTO);
    }

    @Override
    public SafetyEvaluationDTO updateSafetyEvaluation(SafetyEvaluationDTO safetyEvaluationDTO)throws EvaluationNotFoundException {
        if(!existById(safetyEvaluationDTO.getId())){ throw new EvaluationNotFoundException("id not found");}
        return saveSafetyEvaluation(safetyEvaluationDTO);
    }

    @Override
    public List<EvaluationDTO> listAllEvaluations() {
        List<EvaluationDTO> listEvaluation = evaluationRepository.findAll().stream().map(evaluationMapper::toDTO).collect(Collectors.toList());
        return listEvaluation;
    }

    @Override
    public void deleteEvaluation(String id) throws EvaluationNotFoundException {
        if(!existById(id)){ throw new EvaluationNotFoundException("id not found");}
        evaluationRepository.deleteById(id);
    }
}