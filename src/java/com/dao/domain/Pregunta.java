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
public class Pregunta {
    private int lectura_idLectura, idPreguntas;
    private String pregunta, opcion1, opcion2, opcion3, correcta, estatusPregunta;

    public Pregunta(int lectura_idLectura, int idPreguntas, String pregunta, String opcion1, String opcion2, String opcion3, String correcta, String estatusPregunta) {
        this.lectura_idLectura = lectura_idLectura;
        this.idPreguntas = idPreguntas;
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.correcta = correcta;
        this.estatusPregunta = estatusPregunta;
    }

    public int getLectura_idLectura() {
        return lectura_idLectura;
    }

    public void setLectura_idLectura(int lectura_idLectura) {
        this.lectura_idLectura = lectura_idLectura;
    }

    public int getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(int idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String getEstatusPregunta() {
        return estatusPregunta;
    }

    public void setEstatusPregunta(String estatusPregunta) {
        this.estatusPregunta = estatusPregunta;
    }
    
    
}
