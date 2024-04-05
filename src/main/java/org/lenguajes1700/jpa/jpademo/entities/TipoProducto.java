package org.lenguajes1700.jpa.jpademo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipoproducto")
@Data
public class TipoProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigotipoproducto")
    private int codigoTipoProducto; //Tipo de datos deber ser igual al declarado en la db para evitar excepciones

    private String descripcion;

    @Column(name = "tasainteres")
    private double tasaInteres;

    @OneToMany(mappedBy = "tipoproducto") //revisar como esta mappeado en la tabla relacionada
    //@JsonBackReference
    private List<ClienteProducto> clienteProducto;
    
}