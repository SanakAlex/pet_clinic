package sanak.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.services.SpecialityService;
import sanak.springframework.petclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default, map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialityService specialityService;

  public VetMapService(SpecialityService specialityService) {
    this.specialityService = specialityService;
  }

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
    if (vet != null) {
      vet.getSpecialities().stream()
          .filter(speciality -> speciality.getId() == null)
          .forEach(specialityService::save);
    }
    return super.save(vet);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
