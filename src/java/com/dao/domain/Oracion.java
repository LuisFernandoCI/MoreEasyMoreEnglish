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
public class Oracion {
    private int leccion_idLeccion, idOracion;
    private String oracionCorrecta, op1Oracion, op2Oracion, op3Oracion, estatusOracion;

    public Oracion(int leccion_idLeccion, int idOracion, String oracionCorrecta, String op1Oracion, String op2Oracion, String op3Oracion, String estatusOracion) {
        this.leccion_idLeccion = leccion_idLeccion;
        this.idOracion = idOracion;
        this.oracionCorrecta = oracionCorrecta;
        this.op1Oracion = op1Oracion;
        this.op2Oracion = op2Oracion;
        this.op3Oracion = op3Oracion;
        this.estatusOracion = estatusOracion;
    }
    
    public Oracion() {
        this.leccion_idLeccion = 0;
        this.idOracion = 0;
        this.oracionCorrecta = "";
        this.op1Oracion = "";
        this.op2Oracion = "";
        this.op3Oracion = "";
        this.estatusOracion = "";
    }

    public int getLeccion_idLeccion() {
        return leccion_idLeccion;
    }

    public void setLeccion_idLeccion(int leccion_idLeccion) {
        this.leccion_idLeccion = leccion_idLeccion;
    }

    public int getIdOracion() {
        return idOracion;
    }

    public void setIdOracion(int idOracion) {
        this.idOracion = idOracion;
    }

    public String getOracionCorrecta() {
        return oracionCorrecta;
    }

    public void setOracionCorrecta(String oracionCorrecta) {
        this.oracionCorrecta = oracionCorrecta;
    }

    public String getOp1Oracion() {
        return op1Oracion;
    }

    public void setOp1Oracion(String op1Oracion) {
        this.op1Oracion = op1Oracion;
    }

    public String getOp2Oracion() {
        return op2Oracion;
    }

    public void setOp2Oracion(String op2Oracion) {
        this.op2Oracion = op2Oracion;
    }

    public String getOp3Oracion() {
        return op3Oracion;
    }

    public void setOp3Oracion(String op3Oracion) {
        this.op3Oracion = op3Oracion;
    }

    public String getEstatusOracion() {
        return estatusOracion;
    }

    public void setEstatusOracion(String estatusOracion) {
        this.estatusOracion = estatusOracion;
    }
    
    
    
}
