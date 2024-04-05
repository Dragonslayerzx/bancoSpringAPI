package org.lenguajes1700.jpa.jpademo.services.impl;

import org.lenguajes1700.jpa.jpademo.entities.Cliente;
import org.lenguajes1700.jpa.jpademo.entities.ClienteProducto;
import org.lenguajes1700.jpa.jpademo.entities.Movimientos;
import org.lenguajes1700.jpa.jpademo.entities.TipoProducto;
import org.lenguajes1700.jpa.jpademo.repositories.ClienteProductoRepository;
import org.lenguajes1700.jpa.jpademo.repositories.ClienteRepository;
import org.lenguajes1700.jpa.jpademo.repositories.MovimientosRepository;
import org.lenguajes1700.jpa.jpademo.repositories.TipoProductoRepository;
import org.lenguajes1700.jpa.jpademo.services.ClienteProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ClienteProductoServiceImpl implements ClienteProductoService {

    @Autowired
    private ClienteProductoRepository clienteProductoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public ClienteProducto crearClienteProducto(ClienteProducto clienteProducto) {
        

        Cliente nvoCliente = null;
        TipoProducto tipoProducto = null;

        //verificamos que el cliente ya existe
        if(null != clienteProducto.getCliente()){
            nvoCliente = clienteProducto.getCliente();
            //recuperamos toda la lista de productos y le hacemos una insercion con add
            this.clienteRepository.save(nvoCliente);
        };

        if(null != clienteProducto.getTipoproducto()){
            tipoProducto = clienteProducto.getTipoproducto();
            this.tipoProductoRepository.save(tipoProducto);
        }

        clienteProducto.setCliente(nvoCliente);
        clienteProducto.setTipoproducto(tipoProducto);

        ClienteProducto clienteProducto2 = this.clienteProductoRepository.save(clienteProducto);

        if(null != clienteProducto.getMovimientos()){
            for (Movimientos movimiento : clienteProducto.getMovimientos()) {
                movimiento.setClienteproducto(clienteProducto2);
                //cp2 ya que este ya tiene un id generado
                this.movimientosRepository.save(movimiento);
            }
        }
        return clienteProducto2;

    }

}
