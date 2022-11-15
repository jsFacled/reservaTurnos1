package com.dh.reservaTurnoOdontologico.model;

import java.sql.Time;
import java.util.List;

public class Odontologo {

    private Long id_Odontologo;
    private Integer numeroMatricula;
    private String apellido;
    private String nombre;

    public Odontologo() {
            }

    public Odontologo(Integer numeroMatricula, String apellido, String nombre) {
        this.numeroMatricula = numeroMatricula;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Long getId_Odontologo() {
        return id_Odontologo;
    }

    public void setId_Odontologo(Long id_Odontologo) {
        this.id_Odontologo = id_Odontologo;
    }
    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id_Odontologo=" + id_Odontologo +
                ", numeroMatricula=" + numeroMatricula +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
