package sanak.springframework.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Speciality;
import sanak.springframework.petclinic.repositories.SpecialityRepository;
import sanak.springframework.petclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile("jpa")
public class SpecialityJpaService implements SpecialityService {

  private final SpecialityRepository specialityRepository;

  public SpecialityJpaService(SpecialityRepository specialityRepository) {
    this.specialityRepository = specialityRepository;
  }

  @Override
  public Set<Speciality> findAll() {
    return new HashSet<>(specialityRepository.findAll());
  }

  @Override
  public Speciality findById(Long aLong) {
    return specialityRepository.findById(aLong).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Speciality save(Speciality object) {
    return specialityRepository.save(object);
  }

  @Override
  public void delete(Speciality object) {
    specialityRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    specialityRepository.deleteById(aLong);
  }
}
