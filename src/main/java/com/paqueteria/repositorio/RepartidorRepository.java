package com.paqueteria.repositorio;

import com.paqueteria.modelo.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepartidorRepository extends JpaRepository<Repartidor, Long> {

    List<Repartidor> findByNombreContainingIgnoreCase(String nombre);

    List<Repartidor> findByNombre(String nombre);
    List<Repartidor> findByApellidos(String apellidos);
    List<Repartidor> findByDni(String dni);
    List<Repartidor> findByEmail(String email);
    List<Repartidor> findByTelefono(String telefono);

    List<Repartidor> findByVehiculo(String vehiculo);
    List<Repartidor> findByEntregas(String entregas);
}
