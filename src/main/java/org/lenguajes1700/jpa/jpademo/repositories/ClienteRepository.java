package org.lenguajes1700.jpa.jpademo.repositories;

import org.lenguajes1700.jpa.jpademo.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{

    public List<Cliente> getByCorreo(String correo); //genero un metodo automaticamente que obtiene el correo
    //getByNombredeCampo
}
