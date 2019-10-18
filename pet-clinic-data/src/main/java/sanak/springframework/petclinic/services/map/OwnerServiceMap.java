package sanak.springframework.petclinic.services.map;

import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {


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
    return super.save(owner.getId(), owner);
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }
}
