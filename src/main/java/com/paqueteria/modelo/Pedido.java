package com.paqueteria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private OffsetDateTime fechaPedido;
    @Column(nullable = false)
    private Double total;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEntrega estadoPedido;

    @ManyToOne
    @JoinColumn(name = "distribuidor_id")
    private Distribuidor distribuidor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
