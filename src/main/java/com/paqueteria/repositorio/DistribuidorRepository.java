package com.paqueteria.repositorio;

import com.paqueteria.modelo.Distribuidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistribuidorRepository extends JpaRepository<Distribuidor, Long> {

    List<Distribuidor> findByNombreContainingIgnoreCase(String nombre);
    List<Distribuidor> findByNombre(String nombre);
    List<Distribuidor> findByDireccion(String direccion);
    List<Distribuidor> findByTelefono(String telefono);
    List<Distribuidor> findByCiudad(String ciudad);

    List<Distribuidor> findByRutas(String rutas);
    List<Distribuidor> findByPedidos(String pedidos);
}
