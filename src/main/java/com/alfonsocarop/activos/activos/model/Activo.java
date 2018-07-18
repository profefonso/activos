package com.alfonsocarop.activos.activos.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "activos")
@ApiModel("Model Activo")
@JsonPropertyOrder({"nombre", "descripcion", "tipo", "serial", "numero_inventario", "peso", "alto", "ancho",
        "largo", "valor_compra", "fecha_compra", "feha_baja", "estado", "color"})
public class Activo implements Serializable{

    @Id
    private String id;
    @NotNull
    @ApiModelProperty(value = "Nombre del Activo", required = true)
    private String nombre;
    @ApiModelProperty(value = "Descripcion del Activo", required = true)
    private String descripcion;
    @ApiModelProperty(value = "Tipo de Activo", required = true)
    private String tipo;
    private String serial;
    private String numero_inventario;
    private Float peso;
    private Float alto;
    private Float ancho;
    private Float largo;
    private Double valor_compra;
    private Date fecha_compra;
    private Date feha_baja;
    private String estado;
    private String color;
    private Asignacion asignacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumero_inventario() {
        return numero_inventario;
    }

    public void setNumero_inventario(String numero_inventario) {
        this.numero_inventario = numero_inventario;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAlto() {
        return alto;
    }

    public void setAlto(Float alto) {
        this.alto = alto;
    }

    public Float getAncho() {
        return ancho;
    }

    public void setAncho(Float ancho) {
        this.ancho = ancho;
    }

    public Float getLargo() {
        return largo;
    }

    public void setLargo(Float largo) {
        this.largo = largo;
    }

    public Double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Date getFeha_baja() {
        return feha_baja;
    }

    public void setFeha_baja(Date feha_baja) {
        this.feha_baja = feha_baja;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        asignacion = asignacion;
    }
}
