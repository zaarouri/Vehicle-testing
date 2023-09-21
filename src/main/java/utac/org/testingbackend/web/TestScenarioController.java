package utac.org.testingbackend.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utac.org.testingbackend.dtos.TestScenarioDTO;
import utac.org.testingbackend.services.TestScenarioService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test-scenario")
public class TestScenarioController {

    private TestScenarioService testScenarioService;

    @PostMapping("/save")
    public TestScenarioDTO saveTestScenario(@RequestBody TestScenarioDTO testScenarioDTO) {
        return testScenarioService.saveTestScenario(testScenarioDTO);
    }

    @GetMapping("/list")
    public List<TestScenarioDTO> listTestScenarios() {
        return testScenarioService.listTestScenarios();
    }

    @GetMapping("/{id}")
    public TestScenarioDTO getTestScenarioById(@PathVariable Long id) {
        return testScenarioService.getTestScenarioById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTestScenario(@PathVariable Long id) {
        testScenarioService.deleteTestScenario(id);
    }

    @PutMapping("update")
    public TestScenarioDTO updateTestScenario(@RequestBody TestScenarioDTO testScenarioDTO) {
        return testScenarioService.updateTestScenario(testScenarioDTO);
    }
}
