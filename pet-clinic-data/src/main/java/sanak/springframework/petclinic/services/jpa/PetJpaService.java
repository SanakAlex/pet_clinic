package sanak.springframework.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Pet;
import sanak.springframework.petclinic.repositories.PetRepository;
import sanak.springframework.petclinic.services.PetService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile("jpa")
public class PetJpaService implements PetService {

  private final PetRepository petRepository;

  public PetJpaService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public Set<Pet> findAll() {
    return new HashSet<>(petRepository.findAll());
  }

  @Override
  public Pet findById(Long aLong) {
    return petRepository.findById(aLong).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Pet save(Pet object) {
    return petRepository.save(object);
  }

  @Override
  public void delete(Pet object) {
    petRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    petRepository.deleteById(aLong);
  }
}
