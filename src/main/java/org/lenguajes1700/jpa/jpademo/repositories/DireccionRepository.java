package org.lenguajes1700.jpa.jpademo.repositories;

import org.lenguajes1700.jpa.jpademo.entities.Direccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Integer>{

}
