package sanak.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.model.PetType;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.services.OwnerService;
import sanak.springframework.petclinic.services.PetTypeService;
import sanak.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

  public DataLoader(OwnerService ownerService, VetService vetService,
      PetTypeService petTypeService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }

  @Override
  public void run(String... args) throws Exception {

    Owner owner = new Owner();
    owner.setFirstName("Alex");
    owner.setLastName("Petrov");
    ownerService.save(owner);
    Owner owner2 = new Owner();
    owner2.setFirstName("John");
    owner2.setLastName("Black");
    ownerService.save(owner2);
    System.out.println("Loaded owners");

    Vet vet = new Vet();
    vet.setFirstName("Mike");
    vet.setLastName("Tycon");
    vetService.save(vet);
    Vet vet2 = new Vet();
    vet2.setFirstName("John");
    vet2.setLastName("Snow");
    vetService.save(vet2);
    System.out.println("Loaded vets");

    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);
    PetType cat = new PetType();
    cat.setName("Dog");
    PetType savedCatPetType = petTypeService.save(cat);
    System.out.println("Loaded pet types");


  }
}
