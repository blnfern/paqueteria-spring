package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paquetes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoSeguimiento;
    private String descripcion;
    private Double peso;
    private String dimensiones;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "distribuidora_id")
    private Distribuidora distribuidora;

    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private Repartidor repartidor;
}
