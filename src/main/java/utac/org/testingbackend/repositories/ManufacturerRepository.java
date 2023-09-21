package utac.org.testingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utac.org.testingbackend.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
    boolean existsByCompany(String company);

    @Override
    boolean existsById(Long id);

    Manufacturer findByCompany(String company);
}
