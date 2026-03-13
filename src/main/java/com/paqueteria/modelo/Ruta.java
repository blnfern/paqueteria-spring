package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "rutas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreRuta;
    private String origen;
    private String destino;
    private Double distanciaKm;
    private Integer tiempoEstimadoMin;

    @ManyToOne
    @JoinColumn(name = "distribuidora_id")
    private Distribuidora distribuidora;

    @OneToMany(mappedBy = "ruta")
    private List<Envio> envios;

}
