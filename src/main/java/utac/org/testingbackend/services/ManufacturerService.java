package utac.org.testingbackend.services;

import utac.org.testingbackend.dtos.ManufacturerDTO;
import utac.org.testingbackend.dtos.VehicleDTO;
import utac.org.testingbackend.entities.Manufacturer;
import utac.org.testingbackend.exceptions.ManufacturerNotFoundException;

import java.util.List;

public interface ManufacturerService {
    public ManufacturerDTO saveManufacturer(ManufacturerDTO manufacturerDTO) ;



   public ManufacturerDTO findById(Long id) throws ManufacturerNotFoundException;

    List<ManufacturerDTO> findAll();

    ManufacturerDTO updateManufacturer(ManufacturerDTO manufacturer) throws ManufacturerNotFoundException;

    void deleteById(Long id) throws ManufacturerNotFoundException;
    List<VehicleDTO> findAllVehiclesByManufacturer(Long manufacturerId);
}
