package sanak.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sanak.springframework.petclinic.model.Speciality;

import java.util.Collection;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

  Collection<Speciality> findAll();
}
