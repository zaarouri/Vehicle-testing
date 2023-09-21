package utac.org.testingbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import utac.org.testingbackend.dtos.TestScenarioDTO;
import utac.org.testingbackend.entities.TestScenario;

@Mapper(componentModel = "spring")
public interface TestScenarioMapper {
    TestScenario toEntity(TestScenarioDTO dto);
    TestScenarioDTO toDto(TestScenario entity);
}