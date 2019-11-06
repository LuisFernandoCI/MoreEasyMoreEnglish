/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import com.dao.domain.Unidad;
import com.dao.domain.Curso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author COLINAS
 */
public class DAOUnidad { 
   public boolean insertarUnidad(Unidad d){
    boolean res = false;
    Connection con= null;  
    CallableStatement cs = null; 
    try{
        String sql="INSERT INTO unidades VALUES (?,?,?,?,?)";
        con=conexion.getConexion();
        if(con!=null){
            //con.setAutoCommit(false);
            cs = con.prepareCall(sql);
            cs.setInt(1, d.getCurso_idCurso());
            cs.setInt(2, d.getIdUnidad());
            cs.setString(3, d.getNombreUnidad());
            cs.setString(4, d.getDescripcion());
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
    
     public boolean ActualizarUnidad(Unidad d){
        boolean res=false;
        Connection con=null;
        PreparedStatement cs=null;
        try{
            String sql="UPDATE unidades "
                    + "SET NombreUnidad = ?, Descripcion = ? "
                    + "WHERE IDUnidad=?";
            con=conexion.getConexion();
            if(con!=null){
                con.setAutoCommit(false);
                cs=con.prepareStatement(sql);
                cs.setString(1, d.getNombreUnidad());
                cs.setString(2, d.getDescripcion());
                cs.setInt(3, d.getIdUnidad());
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
    public boolean BajaUnidad(int idUnidad){
        boolean bor=false;
        Connection con=null;
        CallableStatement ps=null;
        String sql="UPDATE unidades SET EstatusUnidad='I' WHERE IDUnidad=? ";
        try{
            con=conexion.getConexion();
            if(con!=null){
                ps=con.prepareCall(sql);
                ps.setInt(1,idUnidad);
                ps.execute();
                bor=true;
            }
        }catch(SQLException sqle){
            System.err.printf("Error al borrar ->"+sqle.getMessage());
        }
        return bor;
    }
    
    public List obtenerUnidad(int idCurso){
       ArrayList<Unidad> lista=new ArrayList<Unidad>();
       Connection con=null;
       PreparedStatement ps=null;
       String sql="SELECT * FROM unidades where EstatusUnidad='A' and Curso_IDCurso = ?";
       try{
           con=conexion.getConexion();
           if(con!=null){
               ps=con.prepareStatement(sql);
               ps.setInt(1, idCurso);
               ResultSet rs= ps.executeQuery();
               while(rs.next()){
                    Unidad u = new Unidad();
                    u.setCurso_idCurso(rs.getInt("Curso_IDCurso"));
                    u.setIdUnidad(rs.getInt("IDUnidad"));
                    u.setNombreUnidad(rs.getString("NombreUnidad"));
                    u.setDescripcion(rs.getString("Descripcion"));
                    u.setEstatusUnidad(rs.getString("EstatusUnidad"));
                    lista.add(u);
                    System.out.println(lista);
               }
           }
       }catch(SQLException e){
            System.err.print("Error en la busqueda "+e.getMessage());
       }
       return lista;
    }
    
    public Unidad BuscarUnidad(int idUnidad){
        Unidad u = new Unidad();
        Connection con=null;
        ResultSet rs=null;
        CallableStatement cs= null;   
        try{
           String sql="SELECT * FROM unidades WHERE  IDUnidad = '%"+ idUnidad +"'%";
           con=conexion.getConexion();
           if(con!=null){
               cs=con.prepareCall(sql);
               rs = cs.executeQuery();
               if(rs.next()){
                    u.setCurso_idCurso(rs.getInt("Curso_IDCurso"));
                    u.setIdUnidad(rs.getInt("IDUnidad"));
                    u.setNombreUnidad(rs.getString("NombreUnidad"));
                    u.setDescripcion(rs.getString("Descripcion"));
                    u.setEstatusUnidad(rs.getString("EstatusUnidad"));
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
       return u;
    }
    
}
