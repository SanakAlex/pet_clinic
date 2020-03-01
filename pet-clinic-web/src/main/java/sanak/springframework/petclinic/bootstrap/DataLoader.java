package sanak.springframework.petclinic.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.model.Pet;
import sanak.springframework.petclinic.model.PetType;
import sanak.springframework.petclinic.model.Speciality;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.model.Visit;
import sanak.springframework.petclinic.services.OwnerService;
import sanak.springframework.petclinic.services.PetTypeService;
import sanak.springframework.petclinic.services.SpecialityService;
import sanak.springframework.petclinic.services.VetService;
import sanak.springframework.petclinic.services.VisitService;

import java.time.LocalDate;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;
  private final VisitService visitService;

  public DataLoader(
      OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
      SpecialityService specialityService, VisitService visitService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialityService = specialityService;
    this.visitService = visitService;
  }

  @Override
  @Transactional
  public void run(String... args) {
    if (petTypeService.findAll().isEmpty()) {
      log.info("Starting loading data");
      loadData();
      log.info("Data is loaded");
    }
  }

  private void loadData() {
    PetType dog = PetType.builder().name("Dog").build();
    dog = petTypeService.save(dog);
    PetType cat = PetType.builder().name("Cat").build();
    cat = petTypeService.save(cat);
    log.info("Loaded pet types");

    Owner ownerAlex = Owner.builder()
        .firstName("Alex")
        .lastName("Petrov")
        .address("Petrivka st.")
        .city("Kyiv")
        .telephone("+7777")
        .build();
    Pet alexPet = Pet.builder()
        .name("Rex")
        .petType(dog)
        .owner(ownerAlex)
        .birthDate(LocalDate.now())
        .build();
    ownerAlex.addPet(alexPet);
    ownerService.save(ownerAlex);

    Owner ownerJohn = Owner.builder()
        .firstName("John")
        .lastName("Black")
        .address("Minska st.")
        .city("New York")
        .telephone("+7777")
        .build();
    Pet johnPet = Pet.builder()
        .name("Toni")
        .petType(cat)
        .owner(ownerJohn)
        .birthDate(LocalDate.now())
        .build();
    ownerJohn.addPet(johnPet);
    ownerService.save(ownerJohn);
    log.info("Loaded owners");

    Visit dogVisit = Visit.builder()
        .description("first dog visit")
        .date(LocalDate.now())
        .pet(alexPet)
        .build();
    visitService.save(dogVisit);
    Visit catVisit = Visit.builder()
        .description("first cat visit")
        .date(LocalDate.now())
        .pet(johnPet)
        .build();
    visitService.save(catVisit);
    log.info("Loaded visits");

    Speciality radiology = Speciality.builder().description("radiology").build();
    radiology = specialityService.save(radiology);
    Speciality surgery = Speciality.builder().description("surgery").build();
    surgery = specialityService.save(surgery);
    Speciality dentistry = Speciality.builder().description("dentistry").build();
    dentistry = specialityService.save(dentistry);

    Vet vet = Vet.builder()
        .firstName("Mike")
        .lastName("Tycon")
        .build()
        .addSpeciality(radiology)
        .addSpeciality(surgery);
    vetService.save(vet);

    Vet vet2 = Vet.builder()
        .firstName("John")
        .lastName("Snow")
        .build()
        .addSpeciality(dentistry);
    vetService.save(vet2);
    log.info("Loaded vets");
  }
}
