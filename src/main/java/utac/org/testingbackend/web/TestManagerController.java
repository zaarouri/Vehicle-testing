package utac.org.testingbackend.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import utac.org.testingbackend.dtos.TestManagerDTO;
import utac.org.testingbackend.entities.TestManager;
import utac.org.testingbackend.exceptions.TestManagerNotFoundException;
import utac.org.testingbackend.services.TestManagerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test-manager")
public class TestManagerController {

    private TestManagerService testManagerService;

    @PostMapping("/save")
    public TestManagerDTO saveTestManager(@RequestBody TestManagerDTO testManagerDTO) throws TestManagerNotFoundException {
        return testManagerService.saveTestManager(testManagerDTO);
    }

    @GetMapping("/list")
    public List<TestManagerDTO> listTestManagers() {
        return testManagerService.listTestManagers();
    }

    @GetMapping("/{id}")
    public TestManagerDTO getTestManagerById(@PathVariable Long id) throws TestManagerNotFoundException {
        return testManagerService.getTestManagerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTestManager(@PathVariable Long id) throws TestManagerNotFoundException {
        testManagerService.deleteTestManager(id);
    }

    @PutMapping
    public TestManagerDTO updateTestManager(@RequestBody TestManagerDTO testManagerDTO) throws TestManagerNotFoundException {
        return testManagerService.updateTestManager(testManagerDTO);
    }
}
