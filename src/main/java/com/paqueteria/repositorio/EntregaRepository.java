package com.paqueteria.repositorio;

import com.paqueteria.modelo.Entrega;
import com.paqueteria.modelo.EstadoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    List<Entrega> findByEstadoEntrega(EstadoEntrega estadoEntrega);

    List<Entrega> findByFechaEntrega(LocalDate fechaEntrega);
    List<Entrega> findByFechaEntregaLessThan(LocalDate fechaEntrega);
    List<Entrega> findByFechaEntregaGreaterThan(LocalDate fechaEntrega);
    List<Entrega> findByFechaEntregaBetween(LocalDate fechaEntrega1, LocalDate fechaEntrega2);

    List<Entrega> findByHoraEntregaBetween(LocalDate horaEntrega1, LocalDate horaEntrega2);
    List<Entrega> findByHoraEntregaLessThan(LocalDate horaEntrega);
    List<Entrega> findByHoraEntregaGreaterThan(LocalDate horaEntrega);
    List<Entrega> findByHoraEntrega(LocalDate horaEntrega);

    List<Entrega> findByReceptorNombre(String receptorNombre);
    List<Entrega> findByFirmaDigital(String firmaDigital);
}
