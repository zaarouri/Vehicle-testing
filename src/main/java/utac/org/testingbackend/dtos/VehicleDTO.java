package utac.org.testingbackend.dtos;

import lombok.Data;


@Data
public class VehicleDTO {
    private Long id ;
    private String modelId;
    private String modelName;
    private String _Year ;
    private double batteryCapacity_kWh;
    private double maxRange_miles;
    private double topSpeed_mph;
    private double acceleration_0to60_seconds;
    private double weight_kg;
    private String category;
    private String status;
    private String engine ;
}