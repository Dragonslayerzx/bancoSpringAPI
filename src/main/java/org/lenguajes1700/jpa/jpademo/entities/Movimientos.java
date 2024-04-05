package org.lenguajes1700.jpa.jpademo.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movimientos")
@Data
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovimiento")
    private long idMovimiento;

    private double monto;

    private LocalDate fecha;
    
    @JsonBackReference //la que tiene llave foranea
    @ManyToOne
    @JoinColumn(name = "numeroproducto", referencedColumnName = "numeroproducto")
    private ClienteProducto clienteproducto;

}
