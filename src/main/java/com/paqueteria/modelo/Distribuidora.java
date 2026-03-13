package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "distribuidoras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distribuidora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;

    @OneToMany(mappedBy = "distribuidora")
    private List<Repartidor> repartidores;

    @OneToMany(mappedBy = "distribuidora")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "distribuidora")
    private List<Ruta> rutas;

}
