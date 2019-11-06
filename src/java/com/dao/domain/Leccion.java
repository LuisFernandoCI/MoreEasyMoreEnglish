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
public class Leccion {
    private int unidades_idUnidad, idLeccion;
    private String nombreLeccion, estatusLeccion;

    public Leccion(int unidades_idUnidad, int idLeccion, String nombreLeccion, String estatusLeccion) {
        this.unidades_idUnidad = unidades_idUnidad;
        this.idLeccion = idLeccion;
        this.nombreLeccion = nombreLeccion;
        this.estatusLeccion = estatusLeccion;
    }
    
    public Leccion() {
        this.unidades_idUnidad = 0;
        this.idLeccion = 0;
        this.nombreLeccion = "";
        this.estatusLeccion = "";
    }

    public int getUnidades_idUnidad() {
        return unidades_idUnidad;
    }

    public void setUnidades_idUnidad(int unidades_idUnidad) {
        this.unidades_idUnidad = unidades_idUnidad;
    }

    public int getIdLeccion() {
        return idLeccion;
    }

    public void setIdLeccion(int idLeccion) {
        this.idLeccion = idLeccion;
    }

    public String getNombreLeccion() {
        return nombreLeccion;
    }

    public void setNombreLeccion(String nombreLeccion) {
        this.nombreLeccion = nombreLeccion;
    }

    public String getEstatusLeccion() {
        return estatusLeccion;
    }

    public void setEstatusLeccion(String estatusLeccion) {
        this.estatusLeccion = estatusLeccion;
    }
    
    
}
