package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cedis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cedis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ubicacion;
    private Integer capacidadPaquetes;

    @OneToMany(mappedBy = "cedis")
    private List<Envio> envios;

    @ManyToMany
    @JoinTable(name = "producto_id")
    private List<Producto> productos;

}
