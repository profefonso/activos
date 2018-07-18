package com.alfonsocarop.activos.activos.repository;

import com.alfonsocarop.activos.activos.model.Activo;
import com.alfonsocarop.activos.activos.model.Asignacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ActivoRepositoryImpl implements ActivoRepository {
    private final MongoOperations mongoOperations;

    @Autowired
    public ActivoRepositoryImpl(MongoOperations mongoOperations) {
        Assert.notNull(mongoOperations);
        this.mongoOperations = mongoOperations;
    }

    //Find all Resources
    public Optional<List<Activo>> findAll() {
        List<Activo> activos = this.mongoOperations.find(new Query(), Activo.class);
        Optional<List<Activo>> optionalActivos=Optional.ofNullable(activos);
        return optionalActivos;
    }

    public Optional<List<Activo>> findByType(String type) {
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("tipo").is(type));
        List<Activo> activos = this.mongoOperations.find(query2, Activo.class);
        Optional<List<Activo>> optionalActivos=Optional.ofNullable(activos);
        return optionalActivos;
    }

    public Optional<List<Activo>> findByDate(String dateFind) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(dateFind);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        Query query2 = new Query();

        query2.addCriteria(Criteria.where("fecha_compra").gte(fecha));
        List<Activo> activos = this.mongoOperations.find(query2, Activo.class);
        Optional<List<Activo>> optionalActivos=Optional.ofNullable(activos);
        return optionalActivos;
    }

    public Optional<List<Activo>> findBySerial(String serial) {
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("serial").is(serial));
        List<Activo> activos = this.mongoOperations.find(query2, Activo.class);
        Optional<List<Activo>> optionalActivos=Optional.ofNullable(activos);
        return optionalActivos;
    }

    public Optional<Activo> findOne(String id) {
        Activo a = this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Activo.class);
        Optional<Activo> activo = Optional.ofNullable(a);
        return activo;
    }

    public Activo saveActivo(Activo activo) {
        Asignacion asignacion =new Asignacion("","","");
        activo.setAsignacion(asignacion);
        this.mongoOperations.save(activo);
        return findOne(activo.getId()).get();
    }

    public void updateActivo(Activo activo) {
        this.mongoOperations.save(activo);
    }

    public void deleteActivo(String id) {
        this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Activo.class);
    }
}
