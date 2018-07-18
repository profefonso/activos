package com.alfonsocarop.activos.activos.service;

import com.alfonsocarop.activos.activos.exception.ActivoNotFoundException;
import com.alfonsocarop.activos.activos.model.Activo;
import com.alfonsocarop.activos.activos.repository.ActivoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("activoService")
@Transactional
public class ActivoServiceImpl implements ActivoService {
    static Logger log = Logger.getLogger(ActivoServiceImpl.class);
    private ActivoRepository activoRepository;

    @Autowired
    public ActivoServiceImpl(ActivoRepository activoRepository){
        this.activoRepository = activoRepository;
    }

    public Activo findByActivoId(String id) {
        Optional<Activo> activo = activoRepository.findOne(id);
        if (activo.isPresent()) {
            log.debug(String.format("Read activoId '{}'", id));
            return activo.get();
        }else
            throw new ActivoNotFoundException(id);
    }

    public List<Activo> findAll() {
        Optional<List<Activo>> activo=activoRepository.findAll();
        return activo.get();
    }

    public List<Activo> findByType(String type) {
        Optional<List<Activo>> activo=activoRepository.findByType(type);
        return activo.get();
    }

    public List<Activo> findByDate(String dateFind) {
        Optional<List<Activo>> activo=activoRepository.findByDate(dateFind);
        return activo.get();
    }

    public List<Activo> findBySerial(String serial) {
        Optional<List<Activo>> activo=activoRepository.findBySerial(serial);
        return activo.get();
    }

    public Activo saveActivo(Activo activo) {
        return activoRepository.saveActivo(activo);
    }

    public void updateActivo(Activo activo) {
        activoRepository.updateActivo(activo);
    }

    public void deleteActivo(String id) {
        activoRepository.deleteActivo(id);
    }
}
