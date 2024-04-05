package org.lenguajes1700.jpa.jpademo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.lenguajes1700.jpa.jpademo.entities.Direccion;
import org.lenguajes1700.jpa.jpademo.services.impl.DireccionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/direccion/crear")
    public Direccion guardarDireccion(@RequestBody Direccion direccion) {
        return this.direccionServiceImpl.crearDireccion(direccion);
    }

}
