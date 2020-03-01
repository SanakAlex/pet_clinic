package sanak.springframework.petclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.repositories.OwnerRepository;
import sanak.springframework.petclinic.repositories.PetRepository;
import sanak.springframework.petclinic.repositories.PetTypeRepository;
import sanak.springframework.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile("jpa")
public class OwnerJpaService implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;

  public OwnerJpaService(OwnerRepository ownerRepository,
      PetRepository petRepository, PetTypeRepository petTypeRepository) {
    this.ownerRepository = ownerRepository;
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }

  @Override
  public Set<Owner> findAll() {
    return new HashSet<>(ownerRepository.findAll());
  }

  @Override
  public Owner findById(Long id) {
    return ownerRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Owner save(Owner object) {
    return ownerRepository.save(object);
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    ownerRepository.deleteById(id);
  }
}
