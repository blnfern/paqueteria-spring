package com.paqueteria.servicio;

import com.paqueteria.modelo.Paquete;
import com.paqueteria.repositorio.PaqueteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {

    public PaqueteRepository paqueteRepository;

    public PaqueteService (PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    // Métodos JPA
    public List<Paquete> obtenerTodosLosPaquetes() { return this.paqueteRepository.findAll(); }
    public Paquete buscarPorId(Long id) { return this.paqueteRepository.findById(id).orElse(null); }

    // Métodos CrUD
    @Transactional
    public Paquete crearPaquete(Paquete paquete) { return this.paqueteRepository.save(paquete); }

    @Transactional
    public Paquete actualizarPaquete(Long id, Paquete paqueteNuevo) {
        Paquete paqueteExistente = this.paqueteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Paquete no encontrado con id:" + id));

        paqueteExistente.setCodigoSeguimiento(paqueteNuevo.getCodigoSeguimiento());
        paqueteExistente.setDescripcion(paqueteNuevo.getDescripcion());
        paqueteExistente.setPeso(paqueteNuevo.getPeso());
        paqueteExistente.setLargo(paqueteNuevo.getLargo());
        paqueteExistente.setAncho(paqueteNuevo.getAncho());

        return this.paqueteRepository.save(paqueteExistente);
    }

    @Transactional
    public void eliminarPaquete(Long id) { this.paqueteRepository.deleteById(id); }

}
