package sanak.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import sanak.springframework.petclinic.model.Speciality;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.services.SpecialityService;
import sanak.springframework.petclinic.services.VetService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialityService specialityService;

  public VetServiceMap(SpecialityService specialityService) {
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
