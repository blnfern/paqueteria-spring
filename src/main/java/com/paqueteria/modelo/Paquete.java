package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "paquetes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigoSeguimiento;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private String dimensiones;

    @ManyToMany(mappedBy = "paquetes")
    private List<Entrega> entregas;
}
