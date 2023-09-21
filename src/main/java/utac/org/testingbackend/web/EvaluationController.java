package utac.org.testingbackend.web;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import utac.org.testingbackend.dtos.EngineEvaluationDTO;
import utac.org.testingbackend.dtos.EvaluationDTO;
import utac.org.testingbackend.dtos.SafetyEvaluationDTO;
import utac.org.testingbackend.exceptions.EvaluationNotFoundException;
import utac.org.testingbackend.services.EvaluationService;

import java.util.List;

@RestController
@Transactional
@AllArgsConstructor
@RequestMapping("/evaluation")
public class EvaluationController {

    private EvaluationService evaluationService;


    @GetMapping("/list")
    public List<EvaluationDTO> getAllEvaluations(){
        return evaluationService.listAllEvaluations();
    }

    @GetMapping("/{id}")
    public EvaluationDTO getEvaluationById(@PathVariable String id) throws EvaluationNotFoundException {
        return evaluationService.getEvaluation(id);
    }

    @PostMapping("/engine/save")
    public EngineEvaluationDTO saveEngineEvaluation(@RequestBody EngineEvaluationDTO engineEvaluationDTO) {
        return evaluationService.saveEngineEvaluation(engineEvaluationDTO);
    }

    @PostMapping("/safety/save")
    public SafetyEvaluationDTO saveSafetyEvaluation(@RequestBody SafetyEvaluationDTO safetyEvaluationDTO) {
        return evaluationService.saveSafetyEvaluation(safetyEvaluationDTO);
    }

    @GetMapping("/engine")
    public List<EngineEvaluationDTO> listEngineEvaluations() {
        return evaluationService.listEngineEvaluations();
    }

    @GetMapping("/safety")
    public List<SafetyEvaluationDTO> listSafetyEvaluations() {
        return evaluationService.listSafetyEvaluations();
    }

//    @GetMapping("/engine/{id}")
//    public EngineEvaluationDTO getEngineEvaluationById(@PathVariable String id) throws EvaluationNotFoundException {
//        return evaluationService.getEngineEvaluationById(id);
//    }

//    @GetMapping("/safety/{id}")
//    public SafetyEvaluationDTO getSafetyEvaluationById(@PathVariable String id) throws EvaluationNotFoundException {
//        return evaluationService.getSafetyEvaluationById(id);
//    }

//    @DeleteMapping("/engine/{id}")
//    public void deleteEngineEvaluation(@PathVariable String id) throws EvaluationNotFoundException {
//        evaluationService.deleteEngineEvaluation(id);
//    }
//
//    @DeleteMapping("/safety/{id}")
//    public void deleteSafetyEvaluation(@PathVariable String id) {
//        evaluationService.deleteSafetyEvaluation(id);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteSafetyEvaluation(@PathVariable String id) throws EvaluationNotFoundException {
        evaluationService.deleteEvaluation(id);
    }




    @PutMapping("/engine")
    public EngineEvaluationDTO updateEngineEvaluation(@RequestBody EngineEvaluationDTO engineEvaluationDTO) throws EvaluationNotFoundException {
        return evaluationService.updateEngineEvaluation(engineEvaluationDTO);
    }

    @PutMapping("/safety")
    public SafetyEvaluationDTO updateSafetyEvaluation(@RequestBody SafetyEvaluationDTO safetyEvaluationDTO) throws EvaluationNotFoundException {
        return evaluationService.updateSafetyEvaluation(safetyEvaluationDTO);
    }
}

