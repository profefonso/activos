package com.alfonsocarop.activos.activos.service;

import com.alfonsocarop.activos.activos.model.Activo;

import java.util.List;

public interface ActivoService {
    List<Activo> findAll();

    List<Activo> findByType(String type);

    List<Activo> findByDate(String dateFind);

    List<Activo> findBySerial(String serial);

    Activo findByActivoId(String id);

    Activo saveActivo(Activo activo);

    public void updateActivo(Activo activo);

    public void deleteActivo(String id);
}
