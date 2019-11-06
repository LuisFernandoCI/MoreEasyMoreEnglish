/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import com.dao.domain.Curso;
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
public class DAOCurso {
    public boolean insertarCurso(Curso c){
    boolean res = false;
    Connection con= null;  
    CallableStatement cs = null; 
    try{
        String sql="INSERT INTO curso VALUES (?,?,?,?,?)";
        con=conexion.getConexion();
        if(con!=null){
            //con.setAutoCommit(false);
            cs = con.prepareCall(sql);
            cs.setInt(1, c.getIdCurso());
            cs.setString(2, c.getNombreCurso());
            cs.setString(3, c.getNivelCompetencia());
            cs.setString(4, c.getDescripcion());
            cs.setString(5, "A");
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
    
     public boolean ActualizarCurso(Curso c){
        boolean res=false;
        Connection con=null;
        PreparedStatement cs=null;
        try{
            String sql="UPDATE curso "
                    + "SET NombreCurso=?,NivelCompetencia=?,Descripcion=?"
                    + "WHERE IDCurso=?";
            con=conexion.getConexion();
            if(con!=null){
                con.setAutoCommit(false);
                cs=con.prepareStatement(sql);                
                cs.setString(1, c.getNombreCurso());
                cs.setString(2, c.getNivelCompetencia());
                cs.setString(3, c.getDescripcion());
                cs.setInt(4, c.getIdCurso());
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
    public boolean BajaCurso(int idCurso){
        boolean bor=false;
        Connection con=null;
        CallableStatement ps=null;
        String sql="UPDATE curso SET EstatusCurso='I' WHERE IDCurso=? ";
        try{
            con=conexion.getConexion();
            if(con!=null){
                ps=con.prepareCall(sql);
                ps.setInt(1,idCurso);
                ps.execute();
                bor=true;
            }
        }catch(SQLException sqle){
            System.err.printf("Error al borrar ->"+sqle.getMessage());
        }
        return bor;
    }
    
    public ArrayList<Curso> obtenerCursos(){
       ArrayList<Curso> lista=new ArrayList<Curso>();
       Connection con=null;
       PreparedStatement ps=null;
       String sql="SELECT * FROM curso where EstatusCurso='A'";
       try{
           con=conexion.getConexion();
           if(con!=null){
               ps=con.prepareStatement(sql);
               ResultSet rs= ps.executeQuery();
               while(rs.next()){
                    Curso c = new Curso();
                    c.setIdCurso(rs.getInt("IDCurso"));
                    c.setNombreCurso(rs.getString("NombreCurso"));
                    c.setNivelCompetencia(rs.getString("NivelCompetencia"));
                    c.setDescripcion(rs.getString("Descripcion"));
                    c.setEstatusCurso(rs.getString("EstatusCurso"));
                    lista.add(c);
                    System.out.println(lista);
               }
           }
       }catch(SQLException e){
            System.err.print("Error en la busqueda "+e.getMessage());
       }
       return lista;
    }
    public Curso BuscarCurso(int idCurso){
        Curso c = new Curso();
        Connection con=null;
        ResultSet rs=null;
        CallableStatement cs= null;   
        try{
           String sql="SELECT * FROM curso WHERE  IDCurso = ?";
           con=conexion.getConexion();
           if(con!=null){
               cs=con.prepareCall(sql);
               cs.setInt(1,idCurso);
               rs = cs.executeQuery();
               if(rs.next()){
                    c.setIdCurso(rs.getInt("IDCurso"));
                    c.setNombreCurso(rs.getString("NombreCurso"));
                    c.setNivelCompetencia(rs.getString("NivelCompetencia"));
                    c.setDescripcion(rs.getString("Descripcion"));
                    c.setEstatusCurso(rs.getString("EstatusCurso"));
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
       return c;
    }
}
