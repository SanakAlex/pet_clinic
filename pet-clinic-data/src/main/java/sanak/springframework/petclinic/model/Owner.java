package sanak.springframework.petclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(exclude = "pets")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "owners")
public class Owner extends Person {

  @Column(name = "address")
  private String address;
  @Column(name = "city")
  private String city;
  @Column(name = "telephone")
  private String telephone;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  @Builder.Default
  private Set<Pet> pets = new HashSet<>();

  public void addPet(Pet pet) {
    this.pets.add(pet);
  }
}