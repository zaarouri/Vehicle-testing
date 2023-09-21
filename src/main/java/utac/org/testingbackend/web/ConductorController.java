package utac.org.testingbackend.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import utac.org.testingbackend.dtos.ConductorDTO;
import utac.org.testingbackend.exceptions.ConductorNotFoundException;
import utac.org.testingbackend.services.ConductorService;

import java.util.List;

@RestController
@RequestMapping("/conductors")
@AllArgsConstructor
public class ConductorController {

    private ConductorService conductorService;

    @GetMapping
    public ResponseEntity<List<ConductorDTO>> getAllConductors() {
        return new ResponseEntity<>(conductorService.getAllConductors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConductorDTO> getConductorById(@PathVariable Long id) throws ConductorNotFoundException {
        return new ResponseEntity<>(conductorService.getConductorById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ConductorDTO> createConductor(@RequestBody ConductorDTO conductorDTO) {
        try {
            ConductorDTO savedConductorDTO = conductorService.createConductor(conductorDTO);
            return new ResponseEntity<>(savedConductorDTO, HttpStatus.CREATED);
        } catch (ConductorNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ConductorDTO> updateConductor(@PathVariable Long id, @RequestBody ConductorDTO conductorDTO) {
        try {
            ConductorDTO updatedConductorDTO = conductorService.updateConductor(id, conductorDTO);
            return new ResponseEntity<>(updatedConductorDTO, HttpStatus.OK);
        } catch (ConductorNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteConductor(@PathVariable Long id) {
        try {
            conductorService.deleteConductor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ConductorNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
