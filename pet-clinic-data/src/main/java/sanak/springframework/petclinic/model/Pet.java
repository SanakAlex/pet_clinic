package sanak.springframework.petclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(exclude = {"visits"})
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "pet_type_id")
  private PetType petType;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @Column(name = "birth_day")
  private LocalDate birthDate;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
  @Builder.Default
  private Set<Visit> visits = new HashSet<>();

}
