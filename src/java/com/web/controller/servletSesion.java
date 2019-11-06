/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.dao.domain.Sesion;
import com.web.dao.DAOSesion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amdza
 */
public class servletSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Sesion s=null;
    DAOSesion da = new DAOSesion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String accion = request.getParameter("accion");
        if (accion.equals("entrar"))
            this.entrar(request, response);
        else if (accion.equals("cerrar"))
            this.cerrar(request, response);
        else if (accion.equals("registrar"))
            this.registrar(request, response);
    }
    private void cerrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession actual =request.getSession();
        request.getSession().removeAttribute("logueado");
        actual.invalidate();
        response.sendRedirect("login.jsp");
    }
    private void entrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("pass");
        DAOSesion co = new DAOSesion();
        HttpSession actual =request.getSession(true);
        switch(co.autenticacion(usuario, contrasena)){
            case "ADMINISTRADOR":
                actual.setAttribute("logueado", usuario);
                actual.setAttribute("nivel", "ADMINISTRADOR");
                response.sendRedirect("principal.jsp");
            break;
            case "ALUMNO":
                actual.setAttribute("logueado", usuario);
                actual.setAttribute("nivel", "EMPLEADO");
                s = da.buscarSesion(request.getParameter("usuario"));
                request.getSession().setAttribute("s", s);
                response.sendRedirect("principal.jsp");
            break;
            default:
            response.sendRedirect("login.jsp");
        }
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s = new Sesion();
        s.setNombre(request.getParameter("nombreusuario").toUpperCase());
        s.setApellido(request.getParameter("apellidos").toUpperCase());
        s.setCorreo(request.getParameter("correo"));
        s.setPassword(request.getParameter("pass"));
        boolean a=da.registrar(s);
        if(a){
           response.sendRedirect("principal.jsp");
        }else {response.sendRedirect("registro.jsp");
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
