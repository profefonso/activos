package com.alfonsocarop.activos.activos.model;

import java.io.Serializable;

public class Asignacion implements Serializable {
    private String tipo_asignacion;
    private String detalle;
    private String ciudad;

    public Asignacion(String tipo_asignacion, String detalle, String ciudad) {
        this.detalle = detalle;
        this.tipo_asignacion = tipo_asignacion;
        this.ciudad = ciudad;
    }

    public String getTipo_asignacion() {
        return tipo_asignacion;
    }

    public void setTipo_asignacion(String tipo_asignacion) {
        this.tipo_asignacion = tipo_asignacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
