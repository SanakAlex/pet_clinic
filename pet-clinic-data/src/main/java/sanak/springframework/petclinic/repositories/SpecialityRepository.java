package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
