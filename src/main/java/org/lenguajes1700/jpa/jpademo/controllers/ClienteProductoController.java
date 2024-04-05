package org.lenguajes1700.jpa.jpademo.controllers;

import org.lenguajes1700.jpa.jpademo.entities.ClienteProducto;
import org.lenguajes1700.jpa.jpademo.services.impl.ClienteProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteProductoController {

    @Autowired
    private ClienteProductoServiceImpl clienteProductoServiceImpl;

    @PostMapping("/clienteproducto/crear")
    public ClienteProducto crearClienteProducto(@RequestBody ClienteProducto clienteProducto){
        return this.clienteProductoServiceImpl.crearClienteProducto(clienteProducto);
    }


}
