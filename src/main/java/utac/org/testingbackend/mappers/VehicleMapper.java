package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import utac.org.testingbackend.dtos.VehicleDTO;
import utac.org.testingbackend.entities.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    VehicleDTO toDTO(Vehicle vehicle);
    Vehicle fromDTO(VehicleDTO dto);
}
