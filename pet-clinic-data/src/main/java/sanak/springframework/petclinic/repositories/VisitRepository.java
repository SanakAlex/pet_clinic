package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
