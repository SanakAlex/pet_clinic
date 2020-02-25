package sanak.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.model.Pet;
import sanak.springframework.petclinic.services.OwnerService;
import sanak.springframework.petclinic.services.PetService;
import sanak.springframework.petclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

  private final PetTypeService petTypeService;
  private final PetService petService;

  public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
    this.petTypeService = petTypeService;
    this.petService = petService;
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.findById(id);
  }

  @Override
  public void delete(Owner owner) {
    super.delete(owner);
  }

  @Override
  public Owner save(Owner owner) {
    if (owner != null) {
      boolean hasNoPetType = owner.getPets().stream()
          .anyMatch(pet -> pet.getPetType() == null);
      if (hasNoPetType) {
        throw new RuntimeException("Per type is required");
      }

      owner.getPets().stream()
          .map(Pet::getPetType)
          .filter(petType -> petType.getId() == null)
          .forEach(petTypeService::save);

      owner.getPets().stream()
          .filter(pet -> pet.getId() == null)
          .forEach(petService::save);
      return super.save(owner);
    }
    return null;
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return null;
  }
}
