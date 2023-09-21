package utac.org.testingbackend.dtos;

import lombok.Data;

import java.util.Date;


@Data
public class TestScenarioDTO {
    private Long id;
    private String scenarioName;
    private Date date;
    private String description;
    private double ambientTemperature_C;
    private double humidityPercent;
    private double windSpeed_mph;
    private String evaluationId;
    private Long conductorId;
    private Long testManagerId;
}