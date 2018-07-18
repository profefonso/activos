package com.alfonsocarop.activos.activos.repository;


import com.alfonsocarop.activos.activos.model.Activo;

import java.util.List;
import java.util.Optional;

public interface ActivoRepository {
    Optional<List<Activo>> findAll();

    Optional<List<Activo>> findByType(String type);

    Optional<List<Activo>> findByDate(String dateFind);

    Optional<List<Activo>> findBySerial(String serial);

    Optional<Activo> findOne(String id);

    public Activo saveActivo(Activo activo);

    public void updateActivo(Activo activo);

    public void deleteActivo(String id);
}
