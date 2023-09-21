package utac.org.testingbackend.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utac.org.testingbackend.dtos.ManufacturerDTO;
import utac.org.testingbackend.exceptions.ManufacturerNotFoundException;
import utac.org.testingbackend.services.ManufacturerService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j

@RequestMapping("/manufacturer")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;



    @GetMapping("/list")
    public ResponseEntity<List<ManufacturerDTO>> listManufacturers() {
        List<ManufacturerDTO> manufacturers = manufacturerService.findAll();
        return ResponseEntity.ok().body(manufacturers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerDTO> getManufacturer(@PathVariable Long id)throws ManufacturerNotFoundException {
        ManufacturerDTO manufacturer = manufacturerService.findById(id);
        return ResponseEntity.ok().body(manufacturer);
    }

    @PostMapping("/save")
    public ResponseEntity<ManufacturerDTO> createManufacturer(@RequestBody ManufacturerDTO manufacturerDTO)  {
        ManufacturerDTO savedManufacturer = manufacturerService.saveManufacturer(manufacturerDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedManufacturer.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedManufacturer);
    }

    @PutMapping("/update")
    public ResponseEntity<ManufacturerDTO> updateManufacturer(@RequestBody ManufacturerDTO manufacturerDTO) {
        ManufacturerDTO updatedManufacturer = manufacturerService.saveManufacturer(manufacturerDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedManufacturer.getId())
                .toUri();

        return ResponseEntity.created(location).body(updatedManufacturer);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable Long id) throws ManufacturerNotFoundException{
        manufacturerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
