package utac.org.testingbackend.services;

import utac.org.testingbackend.dtos.TestManagerDTO;
import utac.org.testingbackend.exceptions.TestManagerNotFoundException;

import java.util.List;

public interface TestManagerService {
    TestManagerDTO saveTestManager(TestManagerDTO testManagerDTO) throws TestManagerNotFoundException;
    List<TestManagerDTO> listTestManagers();
    TestManagerDTO getTestManagerById(Long id) throws TestManagerNotFoundException;
    void deleteTestManager(Long id) throws TestManagerNotFoundException;
    TestManagerDTO updateTestManager(TestManagerDTO testManagerDTO) throws TestManagerNotFoundException;
}
