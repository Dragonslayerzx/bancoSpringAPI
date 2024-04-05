package org.lenguajes1700.jpa.jpademo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id //no lleva generated value ya que el valor se lo daremos nosostros
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;
   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddireccion", referencedColumnName = "iddireccion")
    //   nombre de columna en la entidad actual, nombre de la colum en entidad referenciada
    private Direccion direccion;

    @OneToMany(mappedBy = "cliente") //el nombre sale de la forma en la que fue mapeada en entidad relacionada
    private List<ClienteProducto> clienteProductos;

}
