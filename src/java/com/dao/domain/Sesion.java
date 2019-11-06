/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.domain;

/**
 *
 * @author amdza
 */
public class Sesion {
    private int idusuario, curso_idCurso;
    private String correo,password,tipo, nombre, apellido, diagnostico, fecha;

    public Sesion(int idusuario, String correo, String password, String tipo, String nombre, 
            String apellido, int curso_idCurso, String diagnostico, String fecha) {
        this.idusuario = idusuario;
        this.correo = correo;
        this.password = password;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso_idCurso = curso_idCurso;
        this.diagnostico = diagnostico;
        this.fecha = fecha;
    }

    public Sesion() {
        this.correo = "";
        this.password = "";
        this.tipo = "";
        this.nombre = "";
        this.apellido = "";
        this.idusuario = 0;
        this.curso_idCurso = 0;
        this.diagnostico = "";
        this.fecha = "";
    }

    public int getCurso_idCurso() {
        return curso_idCurso;
    }

    public void setCurso_idCurso(int curso_idCurso) {
        this.curso_idCurso = curso_idCurso;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public Sesion(String sesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
