package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
