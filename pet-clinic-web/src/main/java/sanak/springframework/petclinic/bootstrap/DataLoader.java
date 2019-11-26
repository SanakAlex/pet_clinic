package sanak.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sanak.springframework.petclinic.model.Owner;
import sanak.springframework.petclinic.model.Vet;
import sanak.springframework.petclinic.services.OwnerService;
import sanak.springframework.petclinic.services.VetService;
import sanak.springframework.petclinic.services.map.OwnerServiceMap;
import sanak.springframework.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader() {
    this.ownerService = new OwnerServiceMap();
    this.vetService = new VetServiceMap();
  }

  @Override
  public void run(String... args) throws Exception {

    Owner owner = new Owner();
    owner.setId(1L);
    owner.setFirstName("Alex");
    owner.setLastName("Petrov");
    ownerService.save(owner);
    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("John");
    owner2.setLastName("Black");
    ownerService.save(owner2);
    System.out.println("Loaded owners");

    Vet vet = new Vet();
    vet.setId(1L);
    vet.setFirstName("Mike");
    vet.setLastName("Tycon");
    vetService.save(vet);
    Vet vet2 = new Vet();
    vet2.setId(1L);
    vet2.setFirstName("Mike");
    vet2.setLastName("Tycon");
    vetService.save(vet2);
    System.out.println("Loaded vets");
  }
}
