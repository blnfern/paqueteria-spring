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

    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String zonaAsignada;

    @OneToMany(mappedBy = "repartidor")
    private List<Entrega> entrega;

    @ManyToMany(mappedBy = "repartidor")
    private List<Vehiculo> vehiculo;

    @ManyToOne
    @JoinColumn(name = "distribuidora_id")
    private Distribuidora distribuidora;
}
