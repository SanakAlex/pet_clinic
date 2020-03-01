package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.PetType;

import java.util.Collection;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

  Collection<PetType> findAll();
}
