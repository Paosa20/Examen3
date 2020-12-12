package com.cenfotec.examen3.RESTFUL.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@Data
@EqualsAndHashCode
@Entity

public class Cliente {


    @Id
//    @Column(name = "id", nullable = false)
    private int id;

//    @Column(name = "nombre")
    private String nombre;

//    @Column(name = "apellido1")
    private String apellido1;

//    @Column(name = "apellido2")
    private String apellido2;

//    @Column(name = "direccionVivienda")
    private String direccionVivienda;

//    @Column(name = "direccionCobro")
    private String direccionCobro;

//    @Column(name = "numeroTarjeta")
    private String numeroTarjeta;

    //@Column(name = "vencimiento")
    private String vencimiento;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido1, String apellido2, String direccionVivienda, String direccionCobro, String numeroTarjeta, String vencimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccionVivienda = direccionVivienda;
        this.direccionCobro = direccionCobro;
        this.numeroTarjeta = numeroTarjeta;
        this.vencimiento = vencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccionVivienda() {
        return direccionVivienda;
    }

    public void setDireccionVivienda(String direccionVivienda) {
        this.direccionVivienda = direccionVivienda;
    }

    public String getDireccionCobro() {
        return direccionCobro;
    }

    public void setDireccionCobro(String direccionCobro) {
        this.direccionCobro = direccionCobro;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
}
