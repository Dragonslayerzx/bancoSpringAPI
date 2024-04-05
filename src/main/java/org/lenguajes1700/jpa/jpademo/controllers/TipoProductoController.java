package org.lenguajes1700.jpa.jpademo.controllers;

import java.util.List;

import org.lenguajes1700.jpa.jpademo.entities.TipoProducto;
import org.lenguajes1700.jpa.jpademo.services.impl.TipoProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api") //Como llegamos al controlador, por convencion los controladores tengan el mismo fqdn
public class TipoProductoController {
 
    @Autowired
    private TipoProductoServiceImpl tipoProductoServiceImpl;
    
    @PostMapping("/tipoproducto/crear")
    public TipoProducto crearTipoProducto(@RequestBody TipoProducto tipoProducto) {
        return this.tipoProductoServiceImpl.crearProducto(tipoProducto);
    }

    @GetMapping("/tipoproducto/obtener")
    public List<TipoProducto> obtenerTiposProductos() {
        return this.tipoProductoServiceImpl.obtenerTiposProductos();
    }
    
    @DeleteMapping("/tipoproducto/eliminar")
    public String eliminarTipoProducto(@RequestParam int id){
        return this.tipoProductoServiceImpl.eliminarTipoProducto(id);
    }

}
