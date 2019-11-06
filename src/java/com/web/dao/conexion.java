/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daphne
 */
public class conexion {
    public static Connection getConexion() throws SQLException{
        Connection con=null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/moemoe";
        String usu="root";
        String pass="";
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url,usu,pass);
            System.out.print("Conexion");
        }catch(ClassNotFoundException cnfe){
            System.err.print("Error en la conexión ->"+cnfe.getMessage());
        }
        return con;
    }
    public static synchronized void cerrarCall(CallableStatement cs){
        try{cs.close();}catch(SQLException sqle){}
    }
    public static synchronized void cerrarConexion(ResultSet rs){
        try{rs.close();}catch(SQLException sqle){}
    }
    public static synchronized void cerrarConexion(Connection con){
        try{con.close();}catch(SQLException sqle){}
    }
    public static synchronized void deshacerCambios(Connection con){
        try{con.rollback();}catch(SQLException sqle){}
    }
}
