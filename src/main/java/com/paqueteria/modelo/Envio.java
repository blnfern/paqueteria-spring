package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "envios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaSalida;
    private String fechaLlegadaEstimada;
    private String estadoEnvio;

    @ManyToOne
    @JoinColumn(name = "paquete_id")
    private Paquete paquete;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

}
