/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import com.dao.domain.Grammar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author COLINAS
 */
public class DAOGrammar {
    public boolean insertarGammar(Grammar g){
    boolean res = false;
    Connection con= null;  
    CallableStatement cs = null; 
    try{
        String sql="INSERT INTO grammar VALUES (?,?,?,?,?,?,?)";
        con=conexion.getConexion();
        if(con!=null){
            //con.setAutoCommit(false);
            cs = con.prepareCall(sql);
            cs.setInt(1, g.getIdGrammar());
            cs.setString(2, g.getNombreGrammar());
            cs.setString(3, g.getSumaryGrammar());
            cs.setString(4, g.getExampleGrammar());
            cs.setString(5, g.getFromGrammar());
            cs.setString(6, g.getUseGrammar());
            cs.setString(7, "A");
            cs.setString(8, g.getEstatusGrammar());
            res = cs.executeUpdate()== 1;
            if(res)
                con.commit();
            else
                conexion.deshacerCambios(con);
        }
        conexion.cerrarCall(cs);
        conexion.cerrarConexion(con);
    }catch(SQLException ex){
        conexion.deshacerCambios(con);
        conexion.cerrarCall(cs);
        conexion.cerrarConexion(con);
    }catch (Exception e){
       conexion.deshacerCambios(con);
       conexion.cerrarCall(cs);
       conexion.cerrarConexion(con);
    }
    return res;
    }
    
     public boolean ActualizarGrammar(Grammar g){
        boolean res=false;
        Connection con=null;
        PreparedStatement cs=null;
        try{
            String sql="UPDATE grammar "
                    + "SET NombreGrammar=?, SumaryGrammar=?, ExampleGrammar=?, FromGrammar=?, UseGrammar=?"
                    + "WHERE IDGrammar=?";
            con=conexion.getConexion();
            if(con!=null){
                con.setAutoCommit(false);
                cs=con.prepareStatement(sql);  
                cs.setString(1, g.getNombreGrammar());
                cs.setString(2, g.getSumaryGrammar());
                cs.setString(3, g.getExampleGrammar());
                cs.setString(4, g.getFromGrammar());
                cs.setString(5, g.getUseGrammar());
                cs.setInt(6, g.getIdGrammar());
                res = cs.executeUpdate() == 1;
                if(res)
                    con.commit();
                else
                    conexion.deshacerCambios(con);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            conexion.cerrarConexion(con);
            conexion.deshacerCambios(con);
        }catch(Exception e){
            e.printStackTrace();
            conexion.cerrarConexion(con);
            conexion.deshacerCambios(con);
        }
        
        return res;
    }
    public boolean BajaGrammar(int idGrammar){
        boolean bor=false;
        Connection con=null;
        CallableStatement ps=null;
        String sql="UPDATE grammar SET EstatusGrammar='I' WHERE IDGrammar=? ";
        try{
            con=conexion.getConexion();
            if(con!=null){
                ps=con.prepareCall(sql);
                ps.setInt(1,idGrammar);
                ps.execute();
                bor=true;
            }
        }catch(SQLException sqle){
            System.err.printf("Error al borrar ->"+sqle.getMessage());
        }
        return bor;
    }
    
    public ArrayList<Grammar> obtenerGrammar(){
       ArrayList<Grammar> lista=new ArrayList<Grammar>();
       Connection con=null;
       PreparedStatement ps=null;
       String sql="SELECT * FROM grammar where EstatusGrammar='A'";
       try{
           con=conexion.getConexion();
           if(con!=null){
               ps=con.prepareStatement(sql);
               ResultSet rs= ps.executeQuery();
               while(rs.next()){
                    Grammar g = new Grammar();
                    g.setIdGrammar(rs.getInt("IDGrammar"));
                    g.setNombreGrammar(rs.getString("NombreGrammar"));
                    g.setSumaryGrammar(rs.getString("SumaryGrammar"));
                    g.setExampleGrammar(rs.getString("ExampleGrammar"));
                    g.setFromGrammar(rs.getString("FromGrammar"));
                    g.setUseGrammar(rs.getString("UseGrammar"));
                    g.setEstatusGrammar(rs.getString("EstatusGrammar"));
                    g.setCurso_idCurso(rs.getInt("Curso_IDCurso"));
                    lista.add(g);
                    System.out.println(lista);
               }
           }
       }catch(SQLException e){
            System.err.print("Error en la busqueda "+e.getMessage());
       }
       return lista;
    }
    public Grammar BuscarGrammar(int idGrammar){
        Grammar g = new Grammar();
        Connection con=null;
        ResultSet rs=null;
        CallableStatement cs= null;   
        try{
           String sql="SELECT * FROM grammar WHERE  IDGrammar = ?";
           con=conexion.getConexion();
           if(con!=null){
               cs=con.prepareCall(sql);
               cs.setInt(1,idGrammar);
               rs = cs.executeQuery();
               if(rs.next()){
                    g.setIdGrammar(rs.getInt("IDGrammar"));
                    g.setNombreGrammar(rs.getString("NombreGrammar"));
                    g.setSumaryGrammar(rs.getString("SumaryGrammar"));
                    g.setExampleGrammar(rs.getString("ExampleGrammar"));
                    g.setFromGrammar(rs.getString("FromGrammar"));
                    g.setUseGrammar(rs.getString("UseGrammar"));
                    g.setEstatusGrammar(rs.getString("EstatusGrammar"));
                    g.setCurso_idCurso(rs.getInt("Curso_IDCurso"));
               }
           }
           conexion.cerrarCall(cs);
           conexion.deshacerCambios(con);
       }catch(SQLException sqle){
           sqle.printStackTrace();
           conexion.cerrarCall(cs);
           conexion.cerrarConexion(con);
       }catch(Exception e){
           System.err.print("Error en la busqueda"+e.getMessage());
           e.printStackTrace();
           conexion.cerrarCall(cs);
           conexion.cerrarConexion(con);
       }
       return g;
    }
}
