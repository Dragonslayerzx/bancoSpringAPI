package org.lenguajes1700.jpa.jpademo.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.lenguajes1700.jpa.jpademo.entities.Cliente;
import org.lenguajes1700.jpa.jpademo.services.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class ClienteController {
    
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/cliente/obtener")
    public List<Cliente> obtenerClientes(){
        return this.clienteServiceImpl.obtenerClientes();
    }

    @PostMapping("/cliente/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return this.clienteServiceImpl.crearCliente(cliente);
    }
    
    @GetMapping("/usuario/obtener")
    public Optional<Cliente> buscarClientePorDni(@RequestParam String dni){
        return this.clienteServiceImpl.buscarClientePorDni(dni);
    }


    @PutMapping("/cliente/actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable String id,
                                    @RequestBody Cliente cliente){
        return this.clienteServiceImpl.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/cliente/eliminar")
    public String eliminarCliente(@RequestParam String dni) {
        return this.clienteServiceImpl.eliminarCliente(dni);
    }

    @PutMapping("/cliente/agregarProducto")
    public Cliente agregarProductoCliente(@RequestParam String dni, Integer codigoTipoProducto) {
        return this.clienteServiceImpl.agregarClienteProducto(dni, codigoTipoProducto);
    }

}
