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
public class Palabra {
    private int idPalabra, leccion_idLeccion;
    private String nombrePalabra, traduccion, categoria, ejemplo, palabra1, palabra2, palabra3, estatusPalabra;

    public Palabra(int idPalabra, int leccion_idLeccion, String nombrePalabra, String traduccion, String categoria, String ejemplo, String palabra1, String palabra2, String palabra3, String estatusPalabra) {
        this.idPalabra = idPalabra;
        this.leccion_idLeccion = leccion_idLeccion;
        this.nombrePalabra = nombrePalabra;
        this.traduccion = traduccion;
        this.categoria = categoria;
        this.ejemplo = ejemplo;
        this.palabra1 = palabra1;
        this.palabra2 = palabra2;
        this.palabra3 = palabra3;
        this.estatusPalabra = estatusPalabra;
    }

    public Palabra() {
        this.idPalabra = 0;
        this.leccion_idLeccion = 0;
        this.nombrePalabra = "";
        this.traduccion = "";
        this.categoria = "";
        this.ejemplo = "";
        this.palabra1 = "";
        this.palabra2 = "";
        this.palabra3 = "";
        this.estatusPalabra = "";
    }

    public int getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(int idPalabra) {
        this.idPalabra = idPalabra;
    }

    public int getLeccion_idLeccion() {
        return leccion_idLeccion;
    }

    public void setLeccion_idLeccion(int leccion_idLeccion) {
        this.leccion_idLeccion = leccion_idLeccion;
    }

    public String getNombrePalabra() {
        return nombrePalabra;
    }

    public void setNombrePalabra(String nombrePalabra) {
        this.nombrePalabra = nombrePalabra;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

    public String getPalabra1() {
        return palabra1;
    }

    public void setPalabra1(String palabra1) {
        this.palabra1 = palabra1;
    }

    public String getPalabra2() {
        return palabra2;
    }

    public void setPalabra2(String palabra2) {
        this.palabra2 = palabra2;
    }

    public String getPalabra3() {
        return palabra3;
    }

    public void setPalabra3(String palabra3) {
        this.palabra3 = palabra3;
    }

    public String getEstatusPalabra() {
        return estatusPalabra;
    }

    public void setEstatusPalabra(String estatusPalabra) {
        this.estatusPalabra = estatusPalabra;
    }
    
    
}
