package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import utac.org.testingbackend.dtos.ManufacturerDTO;
import utac.org.testingbackend.entities.Manufacturer;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    ManufacturerMapper INSTANCE = Mappers.getMapper(ManufacturerMapper.class);

    ManufacturerDTO toDTO(Manufacturer manufacturer);
    Manufacturer fromDTO(ManufacturerDTO dto);
}
