package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String bastidor;
    @Column(nullable = false, unique = true)
    private String matricula;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String tipo; // Ej: Furgoneta, Moto, Camión
    @Column(nullable = false)
    private Double capacidadCarga;
    @Column(nullable = false)
    private Double kilometrajeKM;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEntrega estadoVehiculo;

    //Falta el ManyToMany del repartidor?

    @OneToMany(mappedBy = "vehiculo")
    private List<Vehiculo> vehiculos;

    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private Repartidor repartidor;
}
