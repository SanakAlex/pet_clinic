package sanak.springframework.petclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "vets")
public class Vet extends Person {

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "vet_specialities",
      joinColumns = @JoinColumn(name = "vet_id"),
      inverseJoinColumns = @JoinColumn(name = "speciality_id")
  )
  @Builder.Default
  private Set<Speciality> specialities = new HashSet<>();

  public Vet addSpeciality(Speciality speciality) {
    this.specialities.add(speciality);
    return this;
  }
}
