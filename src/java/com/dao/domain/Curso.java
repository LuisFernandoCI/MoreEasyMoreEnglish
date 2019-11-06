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
public class Curso {
    private int idCurso;
    private String nombreCurso,nivelCompetencia, descripcion,estatusCurso;

    public Curso(int idCurso, String nombreCurso, String nivelCompetencia, String estatusCurso,
            String descripcion) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.nivelCompetencia = nivelCompetencia;
        this.estatusCurso = estatusCurso;
        this.descripcion = descripcion;
    }
    
    public Curso() {
        this.idCurso = 0;
        this.nombreCurso = "";
        this.nivelCompetencia = "";
        this.estatusCurso = "";
        this.descripcion = "";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNivelCompetencia() {
        return nivelCompetencia;
    }

    public void setNivelCompetencia(String nivelCompetencia) {
        this.nivelCompetencia = nivelCompetencia;
    }

    public String getEstatusCurso() {
        return estatusCurso;
    }

    public void setEstatusCurso(String estatusCurso) {
        this.estatusCurso = estatusCurso;
    }
}
