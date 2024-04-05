package org.lenguajes1700.jpa.jpademo.services.impl;

import java.util.List;

import org.lenguajes1700.jpa.jpademo.entities.TipoProducto;
import org.lenguajes1700.jpa.jpademo.repositories.TipoProductoRepository;
import org.lenguajes1700.jpa.jpademo.services.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoServiceImpl implements TipoProductoService{

    //Declaramos objeto
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Override
    public TipoProducto crearProducto(TipoProducto tipoProducto) {
        return this.tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public List<TipoProducto> obtenerTiposProductos() {
        return (List<TipoProducto>) this.tipoProductoRepository.findAll();
                    //tipo de datos 
    }
        /*Iterable<TipoProducto> iterable = this.tipoProductoRepository.findAll();
        List<TipoProducto> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista; */          //tipo de datos 

    @Override
    public String eliminarTipoProducto(int id) {
        TipoProducto tipoProductoEliminar = this.tipoProductoRepository.findById(id).orElse(null); //se evita excepcion al devolver null si no encuentra
        //findById retorna una objeto optional
        if(this.tipoProductoRepository.existsById(id)){
           this.tipoProductoRepository.delete(tipoProductoEliminar);
        }
        return "Cliente no encontrado";
    }
}
