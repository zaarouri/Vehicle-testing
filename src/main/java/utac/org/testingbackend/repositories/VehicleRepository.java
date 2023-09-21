package utac.org.testingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utac.org.testingbackend.entities.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
    Vehicle findById(long id );
    List<Vehicle> findAllByManufacturer_Id(long id );
    void deleteById(Long id );
    Boolean existsById(Long  id );
}
