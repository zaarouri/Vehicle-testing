package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import utac.org.testingbackend.dtos.ConductorDTO;
import utac.org.testingbackend.entities.Conductor;

@Mapper(componentModel = "spring")
public interface ConductorMapper {
    ConductorDTO toDTO(Conductor conductor);
    Conductor toEntity(ConductorDTO conductorDTO);
}