/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.dao.domain.Curso;
import com.web.dao.DAOCurso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author COLINAS
 */
public class servletCurso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Curso c=null;
    DAOCurso dao = new DAOCurso();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "InsertarC":
                this.insertarCurso(request, response);
                break;
            case "ActualizarC":
                this.actualizarCurso(request, response);
                break;
            case "BuscarC":
                this.buscarCurso(request, response);
                break;
            case "EliminarC":
                this.eliminarCurso(request, response);
                break;
            default:
                break;
        }
        
    }
    private void insertarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            c = new Curso();
            c.setNombreCurso(request.getParameter("NombreCurso").toUpperCase());
            c.setNivelCompetencia(request.getParameter("NivelCompetencia").toUpperCase());
            c.setDescripcion(request.getParameter("Descripcion"));
            boolean a=dao.insertarCurso(c);
            if(a){
                response.sendRedirect("listaCurso.jsp");
            }else response.sendRedirect("agregarCurso.jsp");
        }
    private void actualizarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            c.setNombreCurso(request.getParameter("NombreCurso").toUpperCase());
            c.setNivelCompetencia(request.getParameter("NivelCompetencia").toUpperCase());
            c.setDescripcion(request.getParameter("Descripcion"));
            boolean a= dao.ActualizarCurso(c);
            if(a){
                response.sendRedirect("listaCurso.jsp");
            }else response.sendRedirect("Error.jsp");
        }
    private void buscarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            c = dao.BuscarCurso(Integer.parseInt(request.getParameter("id")));
        request.getSession().setAttribute("c", c);
        response.sendRedirect("modificarCurso.jsp");
        }
    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if(dao.BajaCurso(Integer.parseInt(request.getParameter("id")))){
                response.sendRedirect("listaCurso.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }
            
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
