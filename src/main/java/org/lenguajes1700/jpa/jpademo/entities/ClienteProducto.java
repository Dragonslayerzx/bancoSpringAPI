package org.lenguajes1700.jpa.jpademo.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clienteproducto")
@Data
public class ClienteProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroproducto")
    private long numeroProducto;

    //@JsonIgnore
    @ManyToOne //al no especificar actualizacion en cascada al cliente y tipoproducto, no los creara en la tabla
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente; //dni solo representa la relacion

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigotipoproducto", referencedColumnName = "codigotipoproducto")
    private TipoProducto tipoproducto;

    @Column(name = "fechaapertura")
    private LocalDate fechaApertura;

    private char estado;
    
    private double saldo;

    @JsonManagedReference 
    @OneToMany(mappedBy = "clienteproducto",cascade = CascadeType.ALL) //indica que al recibir movimientos
    //con clienteProducto, estas deberan impactar en la db
    private List<Movimientos> movimientos;

}
