package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

public interface VetService {

    Vet create(Vet vet);

    Vet update(Vet vet);

    void delete(Integer id) throws VetNotFoundException;

    Vet findById(Integer id) throws VetNotFoundException;

    // Fetch pets by first name
    List<Vet> findByFirstName(String firstName);

    // Fetch pets by last name
    List<Vet> findByLastName(String lastName);

    List<Vet> findAll();
}
