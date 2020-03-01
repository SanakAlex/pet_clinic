package sanak.springframework.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Visit;
import sanak.springframework.petclinic.repositories.VisitRepository;
import sanak.springframework.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitJpaService implements VisitService {

  private final VisitRepository vetRepository;

  public VisitJpaService(VisitRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Set<Visit> findAll() {
    return new HashSet<>(vetRepository.findAll());
  }

  @Override
  public Visit findById(Long aLong) {
    return vetRepository.findById(aLong).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Visit save(Visit object) {
    return vetRepository.save(object);
  }

  @Override
  public void delete(Visit object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    vetRepository.deleteById(aLong);
  }
}
