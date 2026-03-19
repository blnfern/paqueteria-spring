package com.paqueteria.repositorio;

import com.paqueteria.modelo.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {

    List<Ruta> findByNombre(String nombre);
    List<Ruta> findByOrigen(String origen);
    List<Ruta> findByDestino(String destino);
    List<Ruta> findByOrigenContainingIgnoreCase(String origen);
    List<Ruta> findByDestinoContainingIgnoreCase(String destino);

    List<Ruta> findByDistancia(Double distancia);
    List<Ruta> findByDistanciaLessThan(Double distancia);
    List<Ruta> findByDistanciaGreaterThan(Double distancia);
    List<Ruta> findByDistanciaBetween(Double distancia1, Double distancia2);

    List<Ruta> findByDistribuidor(String distribuidor);
    List<Ruta> findByVehiculo(String vehiculo);
}
