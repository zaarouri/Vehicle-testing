package utac.org.testingbackend.dtos;

import lombok.Data;

import java.util.List;


@Data

public class TestManagerDTO {
    private Long id;
    private String name;
    private List<Long> testScenarioIds;
}
