package utac.org.testingbackend.web;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import utac.org.testingbackend.dtos.VehicleDTO;
import utac.org.testingbackend.exceptions.VehicleNotFoundException;
import utac.org.testingbackend.services.VehicleService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/list")
    public ResponseEntity<List<VehicleDTO>> listVehicles() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id) throws VehicleNotFoundException {
        VehicleDTO vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok().body(vehicle);
    }

    @PostMapping("/save")
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO savedVehicle = vehicleService.saveVehicle(vehicleDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedVehicle.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedVehicle);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable Long id, @RequestBody VehicleDTO vehicleDTO) throws VehicleNotFoundException {
        vehicleDTO.setId(id);
        VehicleDTO updatedVehicle = vehicleService.saveVehicle(vehicleDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(updatedVehicle.getId())
                .toUri();

        return ResponseEntity.created(location).body(updatedVehicle);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
