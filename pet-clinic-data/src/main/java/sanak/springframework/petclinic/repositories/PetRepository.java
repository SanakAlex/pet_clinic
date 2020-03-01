package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Pet;

import java.util.Collection;

public interface PetRepository extends CrudRepository<Pet, Long> {

  Collection<Pet> findAll();
}
