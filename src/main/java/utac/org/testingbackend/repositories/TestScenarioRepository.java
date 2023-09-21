package utac.org.testingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utac.org.testingbackend.entities.TestScenario;

public interface TestScenarioRepository extends JpaRepository<TestScenario,Long> {
    @Override
    boolean existsById(Long id);
}
