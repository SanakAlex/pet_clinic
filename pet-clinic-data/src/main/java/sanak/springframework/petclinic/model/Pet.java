package sanak.springframework.petclinic.model;

import java.time.LocalDateTime;

public class Pet {

  private PetType petType;
  private Owner owner;
  private LocalDateTime birthDate;

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }
}
