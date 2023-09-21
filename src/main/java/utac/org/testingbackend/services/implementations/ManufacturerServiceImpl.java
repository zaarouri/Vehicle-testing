package utac.org.testingbackend.services.implementations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import utac.org.testingbackend.dtos.ManufacturerDTO;
import utac.org.testingbackend.dtos.VehicleDTO;
import utac.org.testingbackend.entities.Manufacturer;
import utac.org.testingbackend.exceptions.ManufacturerNotFoundException;
import utac.org.testingbackend.mappers.ManufacturerMapper;
import utac.org.testingbackend.repositories.ManufacturerRepository;
import utac.org.testingbackend.repositories.VehicleRepository;
import utac.org.testingbackend.services.ManufacturerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;
    private VehicleRepository vehicleRepository;
    private ManufacturerMapper mapper;


    @Override
    public ManufacturerDTO saveManufacturer(ManufacturerDTO manufacturerDTO) {
        log.info("saving new manufacturer ");

        Manufacturer savedManufacturer = manufacturerRepository.save(mapper.fromDTO(manufacturerDTO));

        return mapper.toDTO(savedManufacturer);
    }

    @Override
    public ManufacturerDTO findById(Long id) throws ManufacturerNotFoundException {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException("id not found"));
        return mapper.toDTO(manufacturer);
    }

    @Override
    public List<ManufacturerDTO> findAll() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return manufacturers.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ManufacturerDTO updateManufacturer(ManufacturerDTO manufacturerDTO) throws ManufacturerNotFoundException{
        if (manufacturerRepository.existsByCompany(manufacturerDTO.getCompany())) {
            throw new ManufacturerNotFoundException("manufacturer not  found");
        }
        log.info("updating new manufacturer ");
        Manufacturer updatedManufacturer = manufacturerRepository.save(mapper.fromDTO(manufacturerDTO));

        return mapper.toDTO(updatedManufacturer);
    }

    @Override
    public void deleteById(Long id) {
    vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleDTO> findAllVehiclesByManufacturer(Long manufacturerId) {
        return null;
    }
}
