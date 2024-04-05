package org.lenguajes1700.jpa.jpademo.services.impl;

import java.util.List;
import java.util.Optional;

import org.lenguajes1700.jpa.jpademo.entities.Cliente;
import org.lenguajes1700.jpa.jpademo.entities.ClienteProducto;
import org.lenguajes1700.jpa.jpademo.repositories.ClienteProductoRepository;
import org.lenguajes1700.jpa.jpademo.repositories.ClienteRepository;
import org.lenguajes1700.jpa.jpademo.repositories.TipoProductoRepository;
import org.lenguajes1700.jpa.jpademo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private ClienteProductoRepository clienteProductoRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorDni(String dni) {
        return this.clienteRepository.findById(dni);
    }

    @Override
    public Cliente actualizarCliente(String dni, Cliente cliente) {

        Optional<Cliente> clienteOptional = this.clienteRepository.findById(dni);

        if(clienteOptional.isPresent()){
            Cliente clienteActualizar = clienteOptional.get();
            clienteActualizar.setCorreo(cliente.getCorreo());
            clienteActualizar.setNombre(cliente.getNombre());
            clienteActualizar.setApellido(cliente.getApellido());
            return this.clienteRepository.save(clienteActualizar); //devuelve el tipo de objeto guardado en la base de datos
        } else{
            return null;
        }
    }

    @Override
    public String eliminarCliente(String dni) {
        Optional<Cliente> clienteOptional = this.clienteRepository.findById(dni);

        if(clienteOptional.isPresent()){ //se verifica si el optional contiene un valor mediante el present
          Cliente clienteEliminar = clienteOptional.get();
          this.clienteRepository.delete(clienteEliminar);
          return "El cliente ha sido eliminado";
        }
        return "No existe el cliente";
    }

    @Override
    public Cliente agregarClienteProducto(String dni, int codigoTipoProducto) {

        if(this.clienteRepository.existsById(dni)){
            Cliente clienteActualizar = this.clienteRepository.findById(dni).orElse(null);
            //aqui validamos si existe el tipo de producto
            if(this.tipoProductoRepository.existsById(codigoTipoProducto)){
                //necesitamos crear la entidad para asociarla a un usuario
                //creamos objeto para asignarle las propiedades
                ClienteProducto nvoClienteProducto = new ClienteProducto(); //instanciamos la clase/entidad ClienteProducto
                nvoClienteProducto.setEstado('A');
                nvoClienteProducto.setSaldo(5000);
                nvoClienteProducto.setCliente(this.clienteRepository.findById(dni).orElse(null));
                nvoClienteProducto.setTipoproducto(this.tipoProductoRepository.findById(codigoTipoProducto).get());

                //Guardamos el producto desde el cliente sin embargo debemos recuperar la lista y a;adir el
                //objeto creado luego guardarlo en su respectivo repositorio
                clienteActualizar.getClienteProductos().add(nvoClienteProducto);//recuperamos lista para poder a;adir el producto al cliente
                this.clienteProductoRepository.save(nvoClienteProducto);
                
                return clienteActualizar;
                
                //no necesitamos recuperar lista desde clientes, se hace directo mediante la relacion bidireccional y la cascadeUpdate
                /*
                this.clienteProductoRepository.save(nvoClienteProducto);
                return nvoClienteProducto.getCliente();*/
            }
            return null;
        }
        return null;
    }

    

    
}