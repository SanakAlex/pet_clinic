package sanak.springframework.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

  @Column(name = "date")
  private LocalDate date;
  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

}
