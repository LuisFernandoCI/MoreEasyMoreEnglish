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
public class Grammar {
    private int curso_idCurso, idGrammar;
    private String nombreGrammar, sumaryGrammar, exampleGrammar, fromGrammar, useGrammar, estatusGrammar;

    public Grammar(int curso_idCurso, int idGrammar, String nombreGrammar, String sumaryGrammar, String exampleGrammar, String fromGrammar, String useGrammar, String estatusGrammar) {
        this.curso_idCurso = curso_idCurso;
        this.idGrammar = idGrammar;
        this.nombreGrammar = nombreGrammar;
        this.sumaryGrammar = sumaryGrammar;
        this.exampleGrammar = exampleGrammar;
        this.fromGrammar = fromGrammar;
        this.useGrammar = useGrammar;
        this.estatusGrammar = estatusGrammar;
    }
    
    public Grammar() {
        this.curso_idCurso = 0;
        this.idGrammar = 0;
        this.nombreGrammar = "";
        this.sumaryGrammar = "";
        this.exampleGrammar = "";
        this.fromGrammar = "";
        this.useGrammar = "";
        this.estatusGrammar = "";
    }
    
    public int getCurso_idCurso() {
        return curso_idCurso;
    }

    public void setCurso_idCurso(int curso_idCurso) {
        this.curso_idCurso = curso_idCurso;
    }

    public int getIdGrammar() {
        return idGrammar;
    }

    public void setIdGrammar(int idGrammar) {
        this.idGrammar = idGrammar;
    }

    public String getNombreGrammar() {
        return nombreGrammar;
    }

    public void setNombreGrammar(String nombreGrammar) {
        this.nombreGrammar = nombreGrammar;
    }

    public String getSumaryGrammar() {
        return sumaryGrammar;
    }

    public void setSumaryGrammar(String sumaryGrammar) {
        this.sumaryGrammar = sumaryGrammar;
    }

    public String getExampleGrammar() {
        return exampleGrammar;
    }

    public void setExampleGrammar(String exampleGrammar) {
        this.exampleGrammar = exampleGrammar;
    }

    public String getFromGrammar() {
        return fromGrammar;
    }

    public void setFromGrammar(String fromGrammar) {
        this.fromGrammar = fromGrammar;
    }

    public String getUseGrammar() {
        return useGrammar;
    }

    public void setUseGrammar(String useGrammar) {
        this.useGrammar = useGrammar;
    }

    public String getEstatusGrammar() {
        return estatusGrammar;
    }

    public void setEstatusGrammar(String estatusGrammar) {
        this.estatusGrammar = estatusGrammar;
    }
    
    
}
