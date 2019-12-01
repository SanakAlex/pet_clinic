package sanak.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.services.OwnerService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
    return super.save(owner);
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
