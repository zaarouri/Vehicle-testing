package utac.org.testingbackend.services.implementations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import utac.org.testingbackend.dtos.ConductorDTO;
import utac.org.testingbackend.entities.Conductor;
import utac.org.testingbackend.exceptions.ConductorNotFoundException;
import utac.org.testingbackend.mappers.ConductorMapper;
import utac.org.testingbackend.repositories.ConductorRepository;
import utac.org.testingbackend.services.ConductorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional

public class ConductorServiceImpl implements ConductorService {

    private ConductorRepository conductorRepository;
    private ConductorMapper conductorMapper;

    @Override
    public List<ConductorDTO> getAllConductors() {
        return conductorRepository.findAll()
                .stream()
                .map(conductorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConductorDTO getConductorById(Long id) throws ConductorNotFoundException {
        Conductor conductor = conductorRepository.findById(id)
                .orElseThrow(() -> new ConductorNotFoundException(id));
        return conductorMapper.toDTO(conductor);
    }

    @Override
    public ConductorDTO createConductor(ConductorDTO conductorDTO) throws ConductorNotFoundException {
        if (conductorDTO.getId() != null && existsById(conductorDTO.getId())) {
            throw new ConductorNotFoundException(conductorDTO.getId());
        }
        Conductor savedConductor = conductorRepository.save(conductorMapper.toEntity(conductorDTO));
        return conductorMapper.toDTO(savedConductor);
    }

    @Override
    public ConductorDTO updateConductor(Long id, ConductorDTO conductorDTO) throws ConductorNotFoundException {
        if (!existsById(id)) {
            throw new ConductorNotFoundException(id);
        }
        conductorDTO.setId(id);
        Conductor updatedConductor = conductorRepository.save(conductorMapper.toEntity(conductorDTO));
        return conductorMapper.toDTO(updatedConductor);
    }

    @Override
    public void deleteConductor(Long id) throws ConductorNotFoundException {
        if (!existsById(id)) {
            throw new ConductorNotFoundException(id);
        }
        conductorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return conductorRepository.existsById(id);
    }
}