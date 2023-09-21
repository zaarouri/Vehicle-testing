package utac.org.testingbackend.services;

import utac.org.testingbackend.dtos.VehicleDTO;

import java.util.List;

public interface VehicleService {

    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);

    VehicleDTO getVehicleById(Long id);

    List<VehicleDTO> getAllVehicles();

    void deleteVehicle(Long id);
}
