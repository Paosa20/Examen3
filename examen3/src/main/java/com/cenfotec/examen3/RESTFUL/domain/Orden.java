package com.cenfotec.examen3.RESTFUL.domain;

import javax.persistence.*;

@Entity
//@Table(name = "orden")
public class Orden {

    @Id
    private Long id;

    //@Column(name = "tipo")
    private String tipo;

    //@Column(name = "cantidad")
    private String cantidad;

    //@Column(name = "pathImagen")
    private String pathImagen;

    private String costo;

    //@Column(name = "idCliente")
    private long idCliente; //hace referencia al cliente

    public Orden() {
    }

    public Orden(Long id, String tipo, String cantidad, String pathImagen, long idCliente) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.pathImagen = pathImagen;
        this.idCliente = idCliente;
    }

    public Orden(Long id, String tipo, String cantidad, String pathImagen, String costo, long idCliente) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.pathImagen = pathImagen;
        this.costo = costo;
        this.idCliente = idCliente;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}
