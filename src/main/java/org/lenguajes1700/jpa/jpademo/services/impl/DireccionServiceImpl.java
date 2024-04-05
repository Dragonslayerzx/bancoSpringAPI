package org.lenguajes1700.jpa.jpademo.services.impl;

import org.lenguajes1700.jpa.jpademo.entities.Direccion;
import org.lenguajes1700.jpa.jpademo.repositories.DireccionRepository;
import org.lenguajes1700.jpa.jpademo.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionServiceImpl implements DireccionService {
    
    @Autowired
    private DireccionRepository direccionRepository;
    
    @Override
    public Direccion crearDireccion(Direccion direccion) {
        return this.direccionRepository.save(direccion);
    }

}
