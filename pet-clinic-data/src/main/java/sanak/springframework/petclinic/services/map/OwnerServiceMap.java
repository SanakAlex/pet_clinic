package sanak.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.model.PetType;
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
      if (owner.getPets() != null) {
        owner.getPets().forEach(pet -> {
          PetType petType = pet.getPetType();
          if (petType != null) {
            if (petType.getId() == null) {
              petTypeService.save(petType);
            }
          } else {
            throw new RuntimeException("Per type is required");
          }

          if (pet.getId() == null) {
            petService.save(pet);
          }
        });
      }
      return super.save(owner);
    } else {
      return null;
    }
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
