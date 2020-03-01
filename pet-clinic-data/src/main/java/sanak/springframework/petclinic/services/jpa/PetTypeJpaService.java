package sanak.springframework.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.PetType;
import sanak.springframework.petclinic.repositories.PetTypeRepository;
import sanak.springframework.petclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeJpaService implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  public PetTypeJpaService(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<PetType> findAll() {
    return new HashSet<>(petTypeRepository.findAll());
  }

  @Override
  public PetType findById(Long aLong) {
    return petTypeRepository.findById(aLong).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public PetType save(PetType object) {
    return petTypeRepository.save(object);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    petTypeRepository.deleteById(aLong);
  }
}
