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
public class Lectura {
    private int leccion_idLeccion, idLectura;
    private String temaLectura, lectura, estatusLectura;

    public Lectura(int leccion_idLeccion, int idLectura, String temaLectura, String lectura, String estatusLectura) {
        this.leccion_idLeccion = leccion_idLeccion;
        this.idLectura = idLectura;
        this.temaLectura = temaLectura;
        this.lectura = lectura;
        this.estatusLectura = estatusLectura;
    }
    
    public Lectura() {
        this.leccion_idLeccion = 0;
        this.idLectura = 0;
        this.temaLectura = "";
        this.lectura = "";
        this.estatusLectura = "";
    }

    public int getLeccion_idLeccion() {
        return leccion_idLeccion;
    }

    public void setLeccion_idLeccion(int leccion_idLeccion) {
        this.leccion_idLeccion = leccion_idLeccion;
    }

    public int getIdLectura() {
        return idLectura;
    }

    public void setIdLectura(int idLectura) {
        this.idLectura = idLectura;
    }

    public String getTemaLectura() {
        return temaLectura;
    }

    public void setTemaLectura(String temaLectura) {
        this.temaLectura = temaLectura;
    }

    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }

    public String getEstatusLectura() {
        return estatusLectura;
    }

    public void setEstatusLectura(String estatusLectura) {
        this.estatusLectura = estatusLectura;
    }
    
    
}
