package com.alfonsocarop.activos.activos.controller;

import com.alfonsocarop.activos.activos.exception.ActivoNotFoundException;
import com.alfonsocarop.activos.activos.model.Activo;
import com.alfonsocarop.activos.activos.service.ActivoService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
    Autor:      Alfonso Caro
    Objeto:     ActivoController
    Fecha:      16/07/2018
    Objetivo:   Controlador API de los activos disponibles usando Spring hace el CRUD sobre activos

 */

@RestController
@CrossOrigin
@Api(value = "Activo microservice", description = "This API has a CRUD for Activos Fijos")
@RequestMapping("api/activos")
public class ActivoController {
    static Logger log = Logger.getLogger(ActivoController.class);

    private final ActivoService activoService;
    private Activo activo;

    @Autowired
    public ActivoController(ActivoService activoService) {
        this.activoService = activoService;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Find an activo", notes = "Return a activo by Id" )
    public ResponseEntity<Activo> activoById(@PathVariable String id)  throws ActivoNotFoundException {
        log.info("Get activoById");
        try{
            activo = activoService.findByActivoId(id);
        }catch(ActivoNotFoundException e){
            activo = null;
        }
        return ResponseEntity.ok(activo);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find all activos", notes = "Return all activos" )
    public ResponseEntity<List<Activo>> activoById(){
        log.info("Get all activos");
        return ResponseEntity.ok(activoService.findAll());
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an activo", notes = "Delete a activo by Id")
    public ResponseEntity<Void> deleteActivo(@PathVariable String id){
        log.info("Delete resource " + id);
        activoService.deleteActivo(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value = "Create an activo", notes = "Create a new activo")
    public ResponseEntity<Activo> saveActivo(@RequestBody @Valid Activo activo){
        log.info("Save new resource");
        return ResponseEntity.ok(activoService.saveActivo(activo));
    }

    @RequestMapping(method=RequestMethod.PUT)
    @ApiOperation(value = "Create an activo", notes = "Create a new activo")
    public ResponseEntity<Activo> updateActivo(@RequestBody @Valid Activo activo){
        log.info("Update resource");
        activoService.updateActivo(activo);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/ByType/{type}", method = RequestMethod.GET)
    @ApiOperation(value = "Find an activo", notes = "Return a activo by Type" )
    public ResponseEntity<List<Activo>> activoByType(@PathVariable String type)  throws ActivoNotFoundException {
        log.info("Get activoByType");
        return ResponseEntity.ok(activoService.findByType(type));
    }

    @RequestMapping(value="/ByDate/{dateFind}", method = RequestMethod.GET)
    @ApiOperation(value = "Find an activo", notes = "Return a activo by Date" )
    public ResponseEntity<List<Activo>> activoByDate(@PathVariable String dateFind)  throws ActivoNotFoundException {
        log.info("Get activoByDate");
        return ResponseEntity.ok(activoService.findByDate(dateFind));
    }

    @RequestMapping(value="/BySerial/{serial}", method = RequestMethod.GET)
    @ApiOperation(value = "Find an activo", notes = "Return a activo by Serial" )
    public ResponseEntity<List<Activo>> activoBySerial(@PathVariable String serial)  throws ActivoNotFoundException {
        log.info("Get activoBySerial");
        return ResponseEntity.ok(activoService.findBySerial(serial));
    }

}
