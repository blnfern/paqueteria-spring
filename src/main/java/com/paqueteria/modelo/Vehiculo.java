package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String modelo;
    private String marca;
    private String tipo; // Ej: Furgoneta, Moto, Camión
    private Double capacidadCarga;

    @OneToMany(mappedBy = "repartidor")
    private Repartidor repartidor;

    
}
