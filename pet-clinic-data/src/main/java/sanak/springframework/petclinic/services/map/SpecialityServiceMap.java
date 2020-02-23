package sanak.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Speciality;
import sanak.springframework.petclinic.services.SpecialityService;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements
    SpecialityService {

  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.findById(id);
  }

  @Override
  public void delete(Speciality vet) {
    super.delete(vet);
  }

  @Override
  public Speciality save(Speciality vet) {
    return super.save(vet);
  }

  @Override
  public Speciality findById(Long id) {
    return super.findById(id);
  }
}
