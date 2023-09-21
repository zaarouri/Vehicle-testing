package utac.org.testingbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import utac.org.testingbackend.entities.Conductor;

public interface ConductorRepository extends JpaRepository<Conductor,Long> {
    @Override
    boolean existsById(Long id);
}
