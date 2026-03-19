package com.paqueteria.servicio;

import com.paqueteria.modelo.Repartidor;
import com.paqueteria.repositorio.RepartidorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartidorService {

    public RepartidorRepository repartidorRepository;

    public RepartidorService (RepartidorRepository repartidorRepository) {
        this.repartidorRepository = repartidorRepository;
    }

    // Métodos JPA
    public List<Repartidor> obtenerTodosLosRepartidores() { return this.repartidorRepository.findAll(); }
    public Repartidor buscarPorId(Long id) { return this.repartidorRepository.findById(id).orElse(null); }

    // Métodos CrUD
    @Transactional
    public Repartidor crearRepartidor(Repartidor repartidor) { return this.repartidorRepository.save(repartidor); }

    @Transactional
    public Repartidor actualizarRepartidor(Long id, Repartidor repartidorNuevo) {
        Repartidor repartidorExistente = this.repartidorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Repartidor no encontrado con id:" + id));

        repartidorExistente.setNombre(repartidorNuevo.getNombre());
        repartidorExistente.setApellidos(repartidorNuevo.getApellidos());
        repartidorExistente.setDni(repartidorNuevo.getDni());
        repartidorExistente.setTelefono(repartidorNuevo.getTelefono());
        repartidorExistente.setZonaAsignada(repartidorNuevo.getZonaAsignada());

        return this.repartidorRepository.save(repartidorExistente);
    }

    @Transactional
    public void eliminarRepartidor(Long id) { this.repartidorRepository.deleteById(id); }
}
