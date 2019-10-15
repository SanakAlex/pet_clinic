package sanak.springframework.petclinic.services;

import sanak.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);
}
