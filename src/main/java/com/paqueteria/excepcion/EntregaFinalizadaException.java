package com.paqueteria.excepcion;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Podría ser peligroso activar ToString y otros métodos con Lombok en una excepción personalizada?
 * docs: https://projectlombok.org/features/GetterSetter
 */
@Getter
@Setter
public class EntregaFinalizadaException extends RuntimeException {

    private final String errorCode;
    private final LocalDateTime timestamp;
    private final Map<String, Object> details; // Para datos extra (id, nombre, etc.)

    public EntregaFinalizadaException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
        this.details = new HashMap<>();
    }

    // Metodo para añadir contexto dinámicamente
    public EntregaFinalizadaException addDetail(String key, Object value) {
        this.details.put(key, value);
        return this;
    }

}
