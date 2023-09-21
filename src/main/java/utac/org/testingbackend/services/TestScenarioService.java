package utac.org.testingbackend.services;

import utac.org.testingbackend.dtos.TestScenarioDTO;
import java.util.List;

public interface TestScenarioService {
    TestScenarioDTO saveTestScenario(TestScenarioDTO testScenarioDTO);
    List<TestScenarioDTO> listTestScenarios();
    TestScenarioDTO getTestScenarioById(Long id);
    void deleteTestScenario(Long id);
    TestScenarioDTO updateTestScenario(TestScenarioDTO testScenarioDTO);
}
