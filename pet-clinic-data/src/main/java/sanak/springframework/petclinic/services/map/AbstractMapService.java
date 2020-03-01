package sanak.springframework.petclinic.services.map;

import sanak.springframework.petclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

  protected Map<Long, T> map = new HashMap<>();

  Set<T> findAll() {
    return new HashSet<>(map.values());
  }

  T findById(ID id) {
    return map.get(id);
  }

  T save(T object) {
    if (object != null) {
      Long objectId = object.getId();
      if (objectId == null) {
        object.setId(getNextId());
      }
      map.put(object.getId(), object);
    } else {
      throw new RuntimeException("Object can not be null");
    }
    return object;
  }

  void deleteById(ID id) {
    map.remove(id);
  }

  void delete(T object) {
    map.entrySet().removeIf(entry -> entry.getValue().equals(object));
  }

  private Long getNextId() {
    try {
      return Collections.max(map.keySet()) + 1;
    } catch (NoSuchElementException e) {
      return 1L;
    }
  }
}
