<%-- 
    Document   : principal
    Created on : 5/02/2018, 08:17:41 AM
    Author     : amdza

--%>
<%@page import="java.util.List"%>
<%@page import="com.dao.domain.Unidad"%>
<%@page import="com.dao.domain.Curso"%>
<%@page import="com.dao.domain.Sesion"%>
<%@page import="java.util.ArrayList"%>
<% Sesion s = (Sesion) request.getSession().getAttribute("s");%>
<%@page import="com.dao.domain.Sesion "%>
<%@page import="com.web.dao.DAOCurso"%>
<%@page import="com.web.dao.DAOUnidad"%>
<%
    HttpSession actual = request.getSession(true);
    String correo = (String) actual.getAttribute("logueado");
    String nivel = (String) actual.getAttribute("nivel");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cursos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"> <!--Iconos--> 
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500" rel="stylesheet">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
        <style>
            div.a{
                text-align: center;
            }
        </style>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-light" style="background-color: #e3f2fd;" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed " data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                            </button> <a class="navbar-brand active" href="#">"More English More Easy"</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <% if(correo == null){%>
                                <li class="">
                                    <a href="login.jsp">Inicio</a>
                                </li><%}%>
                                <li class="active">
                                    <a href="principal.jsp">Plan de Estudios</a>
                                </li>
                                <li class="">
                                    <a href="conocenos.jsp">Conocenos</a>
                                </li>
                                <%if (nivel == "ADMINISTRADOR") {%>
                                <li class="">
                                    <a href="listaCurso.jsp">Cursos</a>
                                </li>
                                <li class="">
                                    <a href="listaUsuario.jsp">Usuarios</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                                <%}%>
                                <%if (nivel == "ALUMNO") {%>
                                <li class="active">
                                    <a href="servletCliente?accion=BuscarC&correo=<%=correo%>">Datos</a>
                                </li>
                                <li>
                                    <a href="listaLecciones.jsp">Lecciones</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                                <% } %>
                            </ul>
                        </div> 

                    </nav>
                </div>
                <div class="row">
                    <%
                        DAOCurso tarea = new DAOCurso();
                        ArrayList<Curso> lista = tarea.obtenerCursos();
                        for (Curso c : lista) {
                    %>
                    <div class="col-md-12">
                        <h2>
                            <strong><%= c.getNombreCurso() %></strong> 
                        </h2>
                        <p><%= c.getDescripcion() %></p>
                         <%
                            DAOUnidad ta = new DAOUnidad();
                            List<Unidad> lis = ta.obtenerUnidad(c.getIdCurso());
                            for (Unidad u: lis) {
                        %>
                            <h3>
                                <strong><%= u.getNombreUnidad() %></strong> 
                            </h3>
                            <p><%= u.getDescripcion() %></p>
                         <%
                            }
                        %>
                    </div>
                    <%
                        }
                    %>
                </div>
               

            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
        
    </body>
</html>
