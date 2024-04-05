package org.lenguajes1700.jpa.jpademo.repositories;

import org.lenguajes1700.jpa.jpademo.entities.TipoProducto;
import org.springframework.data.repository.CrudRepository;

public interface TipoProductoRepository extends CrudRepository<TipoProducto, Integer> { //(Entidad/modelo),(Tipo de datos envoltorio/compuesto)


}
