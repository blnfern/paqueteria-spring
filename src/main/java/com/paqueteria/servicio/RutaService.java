package com.paqueteria.servicio;

import com.paqueteria.modelo.Ruta;
import com.paqueteria.repositorio.RutaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    public RutaRepository rutaRepository;

    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    // Métodos JPA
    public List<Ruta> obtenerTodasLasRutas() { return this.rutaRepository.findAll(); }
    public Ruta buscarPorId(Long id) { return this.rutaRepository.findById(id).orElse(null); }


    // Métodos CrUD
    @Transactional
    public Ruta crearRuta(Ruta ruta) { return this.rutaRepository.save(ruta); }

    @Transactional
    public Ruta actualizarRuta(Long id, Ruta rutaNueva) {
        Ruta rutaExistente = this.rutaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Ruta no encontrada con id:" + id));

        rutaExistente.setOrigen(rutaNueva.getOrigen());
        rutaExistente.setDestino(rutaNueva.getDestino());
        rutaExistente.setDistanciaKM(rutaNueva.getDistanciaKM());
        rutaExistente.setTiempoEstimadoMin(rutaNueva.getTiempoEstimadoMin());
        rutaExistente.setDistribuidor(rutaNueva.getDistribuidor());
        rutaExistente.setVehiculo(rutaNueva.getVehiculo());

        return this.rutaRepository.save(rutaExistente);
    }
}
