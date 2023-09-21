package utac.org.testingbackend.services;

import utac.org.testingbackend.dtos.ConductorDTO;
import utac.org.testingbackend.exceptions.ConductorNotFoundException;

import java.util.List;

public interface ConductorService {
    List<ConductorDTO> getAllConductors();
    ConductorDTO getConductorById(Long id) throws ConductorNotFoundException;
    ConductorDTO createConductor(ConductorDTO conductorDTO) throws ConductorNotFoundException;
    ConductorDTO updateConductor(Long id, ConductorDTO conductorDTO) throws ConductorNotFoundException;
    void deleteConductor(Long id) throws ConductorNotFoundException;
    boolean existsById(Long id);

}
