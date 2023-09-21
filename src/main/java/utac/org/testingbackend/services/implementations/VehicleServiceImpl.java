package utac.org.testingbackend.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import utac.org.testingbackend.dtos.VehicleDTO;
import utac.org.testingbackend.entities.Vehicle;
import utac.org.testingbackend.mappers.VehicleMapper;
import utac.org.testingbackend.repositories.VehicleRepository;
import utac.org.testingbackend.services.VehicleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper mapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        log.info("Saving vehicle: {}", vehicleDTO.getModelName());
        Vehicle vehicle = mapper.fromDTO(vehicleDTO);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return mapper.toDTO(savedVehicle);
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        log.info("Fetching vehicle by id: {}", id);
        Vehicle vehicle = vehicleRepository.findById(id);
        return mapper.toDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        log.info("Fetching all vehicles");
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVehicle(Long id) {
        log.info("Deleting vehicle by id: {}", id);
        vehicleRepository.deleteById(id);
    }
}
