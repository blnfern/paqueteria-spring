package com.paqueteria.repositorio;

import com.paqueteria.modelo.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {

    List<Paquete> findByNombreContainingIgnoreCase(String nombre);

    List<Paquete> findByPesoLessThan(Double peso);
    List<Paquete> findByPesoGreaterThan(Double peso);
    List<Paquete> findByPeso(Double peso);

    List<Paquete> findByLargoLessThan(Double largo);
    List<Paquete> findByLargoGreaterThan(Double largo);
    List<Paquete> findByLargo(Double largo);

    List<Paquete> findByAnchoLessThan(Double ancho);
    List<Paquete> findByAnchoGreaterThan(Double ancho);
    List<Paquete> findByAncho(Double ancho);

    List<Paquete> findByAltoLessThan(Double alto);
    List<Paquete> findByAltoGreaterThan(Double alto);
    List<Paquete> findByAlto(Double alto);
}
