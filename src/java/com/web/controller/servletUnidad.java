/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.dao.domain.Curso;
import com.dao.domain.Unidad;
import com.web.dao.DAOUnidad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author COLINAS
 */
public class servletUnidad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Unidad u=null;
    private Curso c=null;
    DAOUnidad dao = new DAOUnidad();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "InsertarU":
                this.insertarUnidad(request, response);
                break;
            case "ActualizarU":
                this.actualizarUnidad(request, response);
                break;
            case "BuscarU":
                this.buscarUnidad(request, response);
                break;
            case "EliminarU":
                this.eliminarUnidad(request, response);
                break; 
            case "listaU":
                this.listaUnidad(request, response);
                break;
                default:
                break;
        }
        
    }
    private void insertarUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            u = new Unidad();
            u.setNombreUnidad(request.getParameter("NombreUnidad"));
            u.setDescripcion(request.getParameter("Descripcion"));
            boolean a=dao.insertarUnidad(u);
            if(a){
                response.sendRedirect("listaUnidad.jsp");
            }else response.sendRedirect("agregarCurso.jsp");
        }
    private void actualizarUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            u.setNombreUnidad(request.getParameter("NombreUnidad"));
            u.setDescripcion(request.getParameter("Descripcion"));
            boolean a= dao.ActualizarUnidad(u);
            if(a){
                response.sendRedirect("listaUnidad.jsp");
            }else response.sendRedirect("Error.jsp");
        }
    private void buscarUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            u = dao.BuscarUnidad(Integer.parseInt(request.getParameter("id")));
        request.getSession().setAttribute("u", u);
        response.sendRedirect("modificarUnidad.jsp");
        }
    private void eliminarUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if(dao.BajaUnidad(Integer.parseInt(request.getParameter("id")))){
                response.sendRedirect("listaUnidad.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }
            
    }
    private void listaUnidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int idCurso = (Integer.parseInt(request.getParameter("id")));
            HttpSession actual =request.getSession(true);
            actual.setAttribute("idCurso", idCurso);
            response.sendRedirect("listaUnidad.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
