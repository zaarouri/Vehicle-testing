package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import utac.org.testingbackend.dtos.TestManagerDTO;
import utac.org.testingbackend.entities.TestManager;

@Mapper(componentModel = "spring")
public interface TestManagerMapper {
    TestManager toEntity(TestManagerDTO dto);
    TestManagerDTO toDto(TestManager entity);
}
