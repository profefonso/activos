package com.alfonsocarop.activos.activos.exception;

import org.springframework.core.NestedRuntimeException;

public class ActivoNotFoundException extends NestedRuntimeException {
    public ActivoNotFoundException(String id) {
        super(String.format("Activo con id '%s' not Encontrado", id));
    }
}
