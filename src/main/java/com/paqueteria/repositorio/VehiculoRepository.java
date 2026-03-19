package com.paqueteria.repositorio;

import com.paqueteria.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    List<Vehiculo> findByBastidorContainingIgnoreCase(String bastidor);
    List<Vehiculo> findByMatriculaContainingIgnoreCase(String matricula);
    List<Vehiculo> findByModeloContainingIgnoreCase(String modelo);
    List<Vehiculo> findByMarcaContainingIgnoreCase(String marca);
    List<Vehiculo> findByTipo(String tipo);
    List<Vehiculo> findByCapacidadCarga(Double capacidadCarga);
    List<Vehiculo> findByKilometrajeKM(Double kilometrajeKM);
    List<Vehiculo> findByEstadoVehiculo(String estadoVehiculo);

    List<Vehiculo> findByRepartidor(String repartidor);
    List<Vehiculo> findByEntregas(String entregas);
    List<Vehiculo> findByRutas(String rutas);
    List<Vehiculo> findByPaquetes(String paquetes);
    List<Vehiculo> findByPedidos(String pedidos);
}
