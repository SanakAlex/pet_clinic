package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
