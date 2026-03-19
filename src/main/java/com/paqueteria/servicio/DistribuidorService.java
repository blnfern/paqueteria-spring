package com.paqueteria.servicio;

import com.paqueteria.modelo.Distribuidor;
import com.paqueteria.repositorio.DistribuidorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidorService {

    private final DistribuidorRepository distribuidorRepository;

    public DistribuidorService(DistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }

    // Métodos JPA
    public List<Distribuidor> obtenerTodosLosDistribuidores() { return this.distribuidorRepository.findAll(); }
    public Distribuidor buscarPorId(Long id) { return this.distribuidorRepository.findById(id).orElse(null); }

    // Métodos CrUD
    @Transactional
    public Distribuidor crearDistribuidor(Distribuidor distribuidor) { return this.distribuidorRepository.save(distribuidor); }

    @Transactional
    public Distribuidor actualizarDistribuidor(Long id, Distribuidor distribuidorNuevo) {
        Distribuidor distribuidorExistente = this.distribuidorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Distribuidor no encontrado con id: " + id));

        distribuidorExistente.setNombre(distribuidorNuevo.getNombre());
        distribuidorExistente.setDireccion(distribuidorNuevo.getDireccion());
        distribuidorExistente.setTelefono(distribuidorNuevo.getTelefono());
        distribuidorExistente.setCiudad(distribuidorNuevo.getDireccion());

        return this.distribuidorRepository.save(distribuidorExistente);
    }

    @Transactional
    public void eliminarDistribuidor(Long id) { this.distribuidorRepository.deleteById(id); }

    // Métodos de interfaz
    public List<Distribuidor> buscarPorNombre(String nombre) { return this.distribuidorRepository.findByNombreContainingIgnoreCase(nombre); }
    public List<Distribuidor> buscarPorDireccion(String direccion) { return this.distribuidorRepository.findByDireccion(direccion); }
    public List<Distribuidor> buscarPorTelefono(String telefono) { return this.distribuidorRepository.findByTelefono(telefono); }
    public List<Distribuidor> buscarPorCiudad(String ciudad) { return this.distribuidorRepository.findByCiudad(ciudad); }
}
