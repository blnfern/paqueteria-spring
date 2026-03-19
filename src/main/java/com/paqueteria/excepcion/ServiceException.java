package com.paqueteria.excepcion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
