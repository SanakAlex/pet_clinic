package sanak.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.services.OwnerService;
import sanak.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
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
  }
}
