package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.mapper.VetMapper;
import com.tecsup.petclinic.domain.VetTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VetController {

    private final VetService vetService;
    private final VetMapper vetMapper;

    public VetController(VetService vetService, VetMapper vetMapper) {
        this.vetService = vetService;
        this.vetMapper = vetMapper;
    }

    /**
     * Get all vets
     *
     * @return
     */
    @GetMapping(value = "/vets")
    public ResponseEntity<List<VetTO>> findAllVets() {
        List<Vet> vets = vetService.findAll();
        log.info("vets: {}", vets);
        vets.forEach(item -> log.info("Vet >> {}", item));

        List<VetTO> vetsTO = vetMapper.toVetTOList(vets);
        log.info("vetsTO: {}", vetsTO);
        vetsTO.forEach(item -> log.info("VetTO >> {}", item));

        return ResponseEntity.ok(vetsTO);
    }

    /**
     * Create vet
     *
     * @param vetTO
     * @return
     */
    @PostMapping(value = "/vets")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VetTO> create(@RequestBody VetTO vetTO) {
        Vet newVet = vetMapper.toVet(vetTO);
        VetTO newVetTO = vetMapper.toVetTO(vetService.create(newVet));

        return ResponseEntity.status(HttpStatus.CREATED).body(newVetTO);
    }

    /**
     * Find vet by id
     *
     * @param id
     * @return
     * @throws VetNotFoundException
     */
    @GetMapping(value = "/vets/{id}")
    public ResponseEntity<VetTO> findById(@PathVariable Integer id) {
        VetTO vetTO;
        try {
            Vet vet = vetService.findById(id);
            vetTO = vetMapper.toVetTO(vet);
        } catch (VetNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vetTO);
    }

    /**
     * Update vet
     *
     * @param vetTO
     * @param id
     * @return
     */
    @PutMapping(value = "/vets/{id}")
    public ResponseEntity<VetTO> update(@RequestBody VetTO vetTO, @PathVariable Integer id) {
        VetTO updatedVetTO;
        try {
            Vet updatedVet = vetService.findById(id);
            updatedVet.setFirstName(vetTO.getFirstName());
            updatedVet.setLastName(vetTO.getLastName());
            vetService.update(updatedVet);
            updatedVetTO = vetMapper.toVetTO(updatedVet);
        } catch (VetNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVetTO);
        
    }
    
    
    
/*******           ELIMINAR POR ID   ********/

    @DeleteMapping(value = "/vets/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            vetService.delete(id);
            return ResponseEntity.ok("Delete ID: " + id);
        } catch (VetNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
