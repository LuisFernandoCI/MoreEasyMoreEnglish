/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.dao.domain.Curso;
import com.dao.domain.Grammar;
import com.web.dao.DAOGrammar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author COLINAS
 */
public class servletGrammar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Grammar g=null;
    private Curso c=null;
    DAOGrammar dao = new DAOGrammar();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "InsertarG":
                this.insertarGrammar(request, response);
                break;
            case "ActualizarG":
                this.actualizarGrammar(request, response);
                break;
            case "BuscarG":
                this.buscarGrammar(request, response);
                break;
            case "EliminarG":
                this.eliminarGrammar(request, response);
                break; 
            case "listaG":
                this.listaGrammar(request, response);
                break;
                default:
                break;
        }
        
    }
    private void insertarGrammar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            g = new Grammar();
            g.setNombreGrammar(request.getParameter("Nombre"));
            g.setSumaryGrammar(request.getParameter("Sumary"));
            g.setExampleGrammar(request.getParameter("Example"));
            g.setFromGrammar(request.getParameter("From"));
            g.setUseGrammar(request.getParameter("Use"));
            g.setCurso_idCurso(Integer.parseInt(request.getParameter("idCurso")));
            boolean a=dao.insertarGrammar(g);
            if(a){
                response.sendRedirect("listaUnidad.jsp");
            }else response.sendRedirect("agregarCurso.jsp");
        }
    private void actualizarGrammar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            g.setNombreGrammar(request.getParameter("Nombre"));
            g.setSumaryGrammar(request.getParameter("Sumary"));
            g.setExampleGrammar(request.getParameter("Example"));
            g.setFromGrammar(request.getParameter("From"));
            g.setUseGrammar(request.getParameter("Use"));
            boolean a= dao.ActualizarGrammar(g);
            if(a){
                response.sendRedirect("listaUnidad.jsp");
            }else response.sendRedirect("Error.jsp");
        }
    private void buscarGrammar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            g = dao.BuscarGrammar(Integer.parseInt(request.getParameter("id")));
        request.getSession().setAttribute("g", g);
        response.sendRedirect("modificarGrammar.jsp");
        }
    private void eliminarGrammar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if(dao.BajaGrammar(Integer.parseInt(request.getParameter("id")))){
                response.sendRedirect("listaUnidad.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }
            
    }
    private void listaGrammar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int idCurso = (Integer.parseInt(request.getParameter("id")));
            HttpSession actual =request.getSession(true);
            actual.setAttribute("idCurso", idCurso);
            response.sendRedirect("listaGrammar.jsp");
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
