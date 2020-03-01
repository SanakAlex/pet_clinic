package sanak.springframework.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Person extends BaseEntity {

  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

}
