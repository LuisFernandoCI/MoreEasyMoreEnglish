/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.domain;

/**
 *
 * @author COLINAS
 */
public class Unidad {
     private int idUnidad, curso_idCurso;
    private String nombreUnidad, descripcion, estatusUnidad;

    public Unidad(int idUnidad, String nombreUnidad, String descripcion, String estatusUnidad, int curso_idCurso) {
        this.idUnidad = idUnidad;
        this.nombreUnidad = nombreUnidad;
        this.descripcion = descripcion;
        this.estatusUnidad = estatusUnidad;
        this.curso_idCurso = curso_idCurso; 
    }

    public Unidad() {
        this.idUnidad = 0;
        this.nombreUnidad = "";
        this.descripcion = "";
        this.estatusUnidad = "";
        this.curso_idCurso = 0;
    }

    public int getCurso_idCurso() {
        return curso_idCurso;
    }

    public void setCurso_idCurso(int curso_idCurso) {
        this.curso_idCurso = curso_idCurso;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatusUnidad() {
        return estatusUnidad;
    }

    public void setEstatusUnidad(String estatusUnidad) {
        this.estatusUnidad = estatusUnidad;
    }
}
