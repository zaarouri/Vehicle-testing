package utac.org.testingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utac.org.testingbackend.entities.TestManager;

public interface TestManagerRepository extends JpaRepository<TestManager,Long> {
    @Override
    boolean existsById(Long id);
}
