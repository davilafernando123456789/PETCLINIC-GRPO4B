package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Vet;


@Repository
public interface VetRepository 
	extends CrudRepository<Vet, Integer> {

    // Fetch pets by first name
    List<Vet> findByFirstName(String firstName);

    // Fetch pets by last name
    List<Vet> findByLastName(String lastName);


	@Override
	List<Vet> findAll();

}
