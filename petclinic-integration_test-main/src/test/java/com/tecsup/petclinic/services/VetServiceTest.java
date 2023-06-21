package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.exception.VetNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;
    /**
    *
    */
  /** @Test
   public void testFindVetById() {

       Integer ID = 1;
       String FIRST_NAME = "James";
       Vet vet = null;

       try {
           vet = this.vetService.findById(ID);
       } catch (VetNotFoundException e) {
           fail(e.getMessage());
       }

       log.info("" + vet);
       assertEquals(FIRST_NAME, vet.getFirstName());

   }

   /**
    *
    */
  /** @Test
   public void testFindVetByFirstName() {

       String FIRST_NAME = "James";
       int SIZE_EXPECTED = 1;

       List<Vet> vets = this.vetService.findByFirstName(FIRST_NAME);

       assertEquals(SIZE_EXPECTED, vets.size());
   }
    /**
    *
    */
    @Test
    public void testDeleteVet() {

    	String FIRST_NAME = "Helen";
	    String LAST_NAME = "Leary";

        // ------------ Create ---------------

        Vet vet = new Vet(FIRST_NAME, LAST_NAME);
        vet = this.vetService.create(vet);
        log.info("" + vet);

        // ------------ Delete ---------------

        try {
            this.vetService.delete(vet.getId());
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        // ------------ Validation ---------------

        try {
            this.vetService.findById(vet.getId());
            assertTrue(false);
        } catch (VetNotFoundException e) {
            assertTrue(true);
        }

    }
}
