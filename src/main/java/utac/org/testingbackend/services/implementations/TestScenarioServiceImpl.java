package utac.org.testingbackend.services.implementations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utac.org.testingbackend.dtos.TestScenarioDTO;
import utac.org.testingbackend.mappers.TestScenarioMapper;
import utac.org.testingbackend.repositories.TestScenarioRepository;
import utac.org.testingbackend.services.TestScenarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class TestScenarioServiceImpl implements TestScenarioService {
    private TestScenarioRepository testScenarioRepository;
    private TestScenarioMapper testScenarioMapper;

    @Override
    public TestScenarioDTO saveTestScenario(TestScenarioDTO testScenarioDTO) {
        return testScenarioMapper.toDto(testScenarioRepository.save(testScenarioMapper.toEntity(testScenarioDTO)));
    }

    @Override
    public List<TestScenarioDTO> listTestScenarios() {
        return testScenarioRepository.findAll().stream()
                .map(testScenarioMapper::toDto)
                .collect(Collectors.toList()) ;
    }

    @Override
    public TestScenarioDTO getTestScenarioById(Long id) {
        return testScenarioMapper.toDto(testScenarioRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteTestScenario(Long id) {
        testScenarioRepository.deleteById(id);
    }

    @Override
    public TestScenarioDTO updateTestScenario(TestScenarioDTO testScenarioDTO) {
        return saveTestScenario(testScenarioDTO);  // Reuse the save method for update.
    }
}
