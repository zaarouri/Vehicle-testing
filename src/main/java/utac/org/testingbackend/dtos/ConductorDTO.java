package utac.org.testingbackend.dtos;

import lombok.Data;

@Data
public class ConductorDTO {
    private Long id ;
    private int age;
    private String licenseNumber;
    private String name;
}
