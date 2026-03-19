package com.paqueteria.servicio;


import com.paqueteria.modelo.Entrega;
import com.paqueteria.modelo.EstadoEntrega;
import com.paqueteria.repositorio.EntregaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    // Métodos JPA
    public List<Entrega> obtenerTodasLasEntregas() { return this.entregaRepository.findAll(); }
    public Entrega buscarPorId(Long id) { return this.entregaRepository.findById(id).orElse(null); }

    // Métodos CrUD
    @Transactional
    public Entrega crearEntrega(Entrega entrega) { return this.entregaRepository.save(entrega); }

    /**
     * La entrega es la parte final del ciclo de negocio.
     * Lo más lógico es prohibir la actualización del objeto si la entrega ya ha sido completada,
     * es decir, si receptorNombre o firmaDigital ya existen.
     * @param id
     * @param entregaNueva
     * @return Entrega
     */
    @Transactional
    public Entrega actualizarEntrega(Long id, Entrega entregaNueva) {
        if (entregaNueva.getReceptorNombre() != null || entregaNueva.getFirmaDigital() != null) {
            // Entrega finalizada Exception
            return null;
        } else {
            Entrega entregaExistente = this.entregaRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Entrega no encontrada con id:" + id));

            entregaExistente.setFechaEntrega(entregaNueva.getFechaEntrega());
            entregaExistente.setHoraEntrega(entregaNueva.getHoraEntrega());
            entregaExistente.setReceptorNombre(entregaNueva.getReceptorNombre());
            entregaExistente.setFirmaDigital(entregaNueva.getFirmaDigital());
            entregaExistente.setEstadoEntrega(entregaNueva.getEstadoEntrega());

            return this.entregaRepository.save(entregaExistente);
        }

    }
    @Transactional
    public void eliminarEntrega(Long id) { this.entregaRepository.deleteById(id); }

    // Métodos de interfaz
    public List<Entrega> buscarPorEstadoEntrega(EstadoEntrega estadoEntrega) { return this.entregaRepository.findByEstadoEntrega(estadoEntrega); }
    public List<Entrega> buscarPorFechaEntrega(LocalDate fechaEntrega) { return this.entregaRepository.findByFechaEntrega(fechaEntrega); }
    public List<Entrega> buscarPorFechaEntregaLessThan(LocalDate fechaEntrega) { return this.entregaRepository.findByFechaEntregaLessThan(fechaEntrega); }

}
