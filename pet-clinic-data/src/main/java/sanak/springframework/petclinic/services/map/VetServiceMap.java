package sanak.springframework.petclinic.services.map;

import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {


  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.findById(id);
  }

  @Override
  public void delete(Vet vet) {
    super.delete(vet);
  }

  @Override
  public Vet save(Vet vet) {
    return super.save(vet.getId(), vet);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
