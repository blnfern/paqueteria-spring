package com.paqueteria.repositorio;

import com.paqueteria.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByFechaPedido(LocalDate fechaPedido);
    List<Pedido> findByFechaPedidoLessThan(LocalDate fechaPedido);
    List<Pedido> findByFechaPedidoGreaterThan(LocalDate fechaPedido);
    List<Pedido> findByFechaPedidoBetween(LocalDate fechaPedido1, LocalDate fechaPedido2);

    List<Pedido> findByTotalLessThan(Double total);
    List<Pedido> findByTotalGreaterThan(Double total);
    List<Pedido> findByTotal(Double total);
    List<Pedido> findByTotalBetween(Double total1, Double total2);

    List<Pedido> findByEstadoPedido(String estadoPedido);
    List<Pedido> findByEstadoPedidoContainingIgnoreCase(String estadoPedido);
}
