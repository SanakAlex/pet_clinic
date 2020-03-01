package sanak.springframework.petclinic.services.map;

import sanak.springframework.petclinic.model.Visit;
import sanak.springframework.petclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public Visit findById(Long aLong) {
    return super.findById(aLong);
  }

  @Override
  public Visit save(Visit object) {
    if (object == null
        || object.getPet() == null
        || object.getPet().getId() == null
        || object.getPet().getOwner() == null
        || object.getPet().getOwner().getId() == null) {
      throw new RuntimeException("Invalid Visit");
    }
    return super.save(object);
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    super.deleteById(aLong);
  }
}
