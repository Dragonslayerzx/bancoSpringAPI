package org.lenguajes1700.jpa.jpademo.services;

import java.util.List;
import java.util.Optional;

import org.lenguajes1700.jpa.jpademo.entities.Cliente;

public interface ClienteService {
    
    public List<Cliente> obtenerClientes();

    public Cliente crearCliente(Cliente cliente);

    public Optional<Cliente> buscarClientePorDni(String dni);

    public Cliente actualizarCliente(String dni, Cliente cliente);
    
    public String eliminarCliente(String dni);

    public Cliente agregarClienteProducto(String dni, int codigoTipoProducto);
}