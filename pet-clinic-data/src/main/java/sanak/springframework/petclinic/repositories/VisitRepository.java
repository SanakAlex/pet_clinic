package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Visit;

import java.util.Collection;

public interface VisitRepository extends CrudRepository<Visit, Long> {

  Collection<Visit> findAll();
}
