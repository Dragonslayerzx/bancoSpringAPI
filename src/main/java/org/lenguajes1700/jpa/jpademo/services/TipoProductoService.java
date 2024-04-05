package org.lenguajes1700.jpa.jpademo.services;

import java.util.List;

import org.lenguajes1700.jpa.jpademo.entities.TipoProducto;

public interface TipoProductoService {

    public TipoProducto crearProducto(TipoProducto tipoProducto);

    public List<TipoProducto> obtenerTiposProductos();

    public String eliminarTipoProducto(int id);
    
}
