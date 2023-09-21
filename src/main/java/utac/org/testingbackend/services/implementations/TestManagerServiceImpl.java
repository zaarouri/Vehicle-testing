package utac.org.testingbackend.services.implementations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import utac.org.testingbackend.dtos.TestManagerDTO;
import utac.org.testingbackend.exceptions.TestManagerNotFoundException;
import utac.org.testingbackend.mappers.TestManagerMapper;
import utac.org.testingbackend.repositories.TestManagerRepository;
import utac.org.testingbackend.services.TestManagerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TestManagerServiceImpl implements TestManagerService {
    private TestManagerRepository testManagerRepository;
    private TestManagerMapper testManagerMapper;

    public boolean ExistById(Long id){
        return testManagerRepository.existsById(id);
    }
    @Override
    public TestManagerDTO saveTestManager(TestManagerDTO testManagerDTO) throws TestManagerNotFoundException {
        if(!ExistById(testManagerDTO.getId())){throw new TestManagerNotFoundException("id not found");}
        return testManagerMapper.toDto(testManagerRepository.save(testManagerMapper.toEntity(testManagerDTO)));
    }

    @Override
    public List<TestManagerDTO> listTestManagers() {
        return testManagerRepository.findAll().stream()
                .map(testManagerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TestManagerDTO getTestManagerById(Long id) throws TestManagerNotFoundException {
        if(!ExistById(id)){throw new TestManagerNotFoundException("id not found");}
        return testManagerMapper.toDto(testManagerRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteTestManager(Long id) throws TestManagerNotFoundException{
        if(!ExistById(id)){throw new TestManagerNotFoundException("id not found");}
        testManagerRepository.deleteById(id);
    }

    @Override
    public TestManagerDTO updateTestManager(TestManagerDTO testManagerDTO) throws TestManagerNotFoundException {
        if(!ExistById(testManagerDTO.getId())){throw new TestManagerNotFoundException("id not found");}
        return saveTestManager(testManagerDTO);  // Reuse the save method for update.
    }
}