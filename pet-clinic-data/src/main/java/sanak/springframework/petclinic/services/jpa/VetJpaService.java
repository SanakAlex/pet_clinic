package sanak.springframework.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.repositories.VetRepository;
import sanak.springframework.petclinic.services.VetService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile("jpa")
public class VetJpaService implements VetService {

  private final VetRepository vetRepository;

  public VetJpaService(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Set<Vet> findAll() {
    return new HashSet<>(vetRepository.findAll());
  }

  @Override
  public Vet findById(Long aLong) {
    return vetRepository.findById(aLong).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Vet save(Vet object) {
    return vetRepository.save(object);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    vetRepository.deleteById(aLong);
  }
}
