package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @Column(nullable = false)
    private String horaInicio;
    @Column(nullable = false)
    private String horaFin;

    @Column(nullable = false)
    private LocalDate fechaEntrega;
    @Column(nullable = false)
    private LocalTime horaEntrega;
    @Column(nullable = false)
    private String receptorNombre;
    @Column(nullable = false)
    private String firmaDigital;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEntrega estadoEntrega;

    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private Repartidor repartidor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "entrega_paquete",
            joinColumns = @JoinColumn(name = "entrega_id"),
            inverseJoinColumns = @JoinColumn(name = "paquete_id")
    )
    private List<Paquete> paquetes;
}
