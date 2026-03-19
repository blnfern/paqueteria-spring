package com.paqueteria.servicio;

import com.paqueteria.modelo.Pedido;
import com.paqueteria.repositorio.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    public PedidoRepository pedidoRepository;

    public PedidoService (PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Métodos JPA
    public List<Pedido> obtenerTodosLosPedidos() { return this.pedidoRepository.findAll(); }
    public Pedido buscarPorId(Long id) { return this.pedidoRepository.findById(id).orElse(null); }

    // Métodos CrUD
    @Transactional
    public Pedido crearPedido(Pedido pedido) { return this.pedidoRepository.save(pedido); }

    @Transactional
    public Pedido actualizarPedido(Long id, Pedido pedidoNuevo) {
        Pedido pedidoExistente = this.pedidoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Pedido no encontrado con id:" + id));

        pedidoExistente.setFechaPedido(pedidoNuevo.getFechaPedido());
        pedidoExistente.setTotal(pedidoNuevo.getTotal());
        pedidoExistente.setEstadoPedido(pedidoNuevo.getEstadoPedido());

        return this.pedidoRepository.save(pedidoExistente);
    }

    @Transactional
    public void eliminarPedido(Long id) { this.pedidoRepository.deleteById(id); }
}
