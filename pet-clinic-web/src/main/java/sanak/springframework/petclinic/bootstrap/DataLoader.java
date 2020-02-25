package sanak.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.model.Pet;
import sanak.springframework.petclinic.model.PetType;
import sanak.springframework.petclinic.model.Speciality;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.services.OwnerService;
import sanak.springframework.petclinic.services.PetTypeService;
import sanak.springframework.petclinic.services.SpecialityService;
import sanak.springframework.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;

  public DataLoader(
      OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
      SpecialityService specialityService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialityService = specialityService;
  }

  @Override
  public void run(String... args) {
    if (petTypeService.findAll().isEmpty()) {
      loadData();
    }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);
    PetType cat = new PetType();
    cat.setName("Dog");
    PetType savedCatPetType = petTypeService.save(cat);
    System.out.println("Loaded pet types");

    Owner owner = new Owner();
    owner.setFirstName("Alex");
    owner.setLastName("Petrov");
    owner.setAddress("Petrivka st.");
    owner.setCity("Kyiv");
    owner.setTelephone("+7777");
    Pet alexPet = new Pet();
    alexPet.setName("Rex");
    alexPet.setPetType(savedDogPetType);
    alexPet.setOwner(owner);
    alexPet.setBirthDate(LocalDate.now());
    owner.getPets().add(alexPet);

    ownerService.save(owner);
    Owner owner2 = new Owner();
    owner2.setFirstName("John");
    owner2.setLastName("Black");
    owner2.setAddress("Minska st.");
    owner2.setCity("New York");
    owner2.setTelephone("+7777");
    Pet johnPet = new Pet();
    johnPet.setName("Toni");
    johnPet.setPetType(savedCatPetType);
    johnPet.setOwner(owner2);
    johnPet.setBirthDate(LocalDate.now());
    owner.getPets().add(johnPet);
    ownerService.save(owner2);
    System.out.println("Loaded owners");

    Speciality radiology = new Speciality();
    radiology.setDescription("radiology");
    Speciality savedRadiology = specialityService.save(radiology);
    Speciality surgery = new Speciality();
    surgery.setDescription("surgery");
    Speciality savedSurgery = specialityService.save(surgery);
    Speciality dentistry = new Speciality();
    radiology.setDescription("dentistry");
    Speciality savedDensity = specialityService.save(dentistry);

    Vet vet = new Vet();
    vet.setFirstName("Mike");
    vet.setLastName("Tycon");
    vet.getSpecialities().add(savedRadiology);
    vet.getSpecialities().add(savedSurgery);
    vetService.save(vet);
    Vet vet2 = new Vet();
    vet2.setFirstName("John");
    vet2.setLastName("Snow");
    vet2.getSpecialities().add(savedDensity);
    vetService.save(vet2);
    System.out.println("Loaded vets");
  }
}
