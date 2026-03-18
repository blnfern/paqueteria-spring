package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "repartidores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false, unique = true)
    private String dni;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = true)
    private String zonaAsignada;

    @OneToMany(mappedBy = "repartidor")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "repartidor")
    private List<Entrega> entregas;
}
