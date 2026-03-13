package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "entregas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaEntrega;
    private String horaEntrega;
    private String receptorNombre;
    private String firmaDigital;

    @OneToMany(mappedBy = "entrega")
    private List<Paquete> paquete;

    @OneToMany(mappedBy = "entrega")
    private List<Incidencia> incidencia;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private Repartidor repartidor;
}
