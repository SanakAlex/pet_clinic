package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Vet;

import java.util.Collection;

public interface VetRepository extends CrudRepository<Vet, Long> {

  Collection<Vet> findAll();
}
