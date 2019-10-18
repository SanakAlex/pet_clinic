package sanak.springframework.petclinic.services.map;

import sanak.springframework.petclinic.model.Pet;
import sanak.springframework.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {


  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.findById(id);
  }

  @Override
  public void delete(Pet pet) {
    super.delete(pet);
  }

  @Override
  public Pet save(Pet pet) {
    return super.save(pet.getId(), pet);
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }
}
