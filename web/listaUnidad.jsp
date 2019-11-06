<%-- 
    Document   : listaUnidad
    Created on : 24/10/2019, 09:43:14 AM
    Author     : amdza
--%>
<%@page import="java.util.List"%>
<% 
    HttpSession actual = request.getSession(true);
    int idCurso = (Integer) actual.getAttribute("idCurso");%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.domain.Unidad"%>
<%@page import="com.web.dao.DAOUnidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Unidad</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"> <!--Iconos--> 
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500" rel="stylesheet">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
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
                                <li class="">
                                    <a href="principal.jsp">Plan de Estudios</a>
                                </li>
                                <li class="">
                                    <a href="conocenos.jsp">Conocenos</a>
                                </li>
                                <li class="active">
                                    <a href="ListaCurso.jsp">Cursos</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                            </ul>
                        </div>

                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h1>
                            Lista de Unidades
                        </h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <td class="" ><p>ID</p></td>
                                    <td class="" ><p>Nombre</p></td>
                                    <td class="" ><p>Descripcion</p></td>
                                    <td class="" ><p>Actualizar</p></td>
                                    <td class="" ><p>Eliminar</p></td>
                                    <td class="" ><p>Leccion</p></td>
                                </tr>
                            </thead>
                            <%
                                DAOUnidad tarea = new DAOUnidad();
                                List<Unidad>lista =tarea.obtenerUnidad(idCurso);
                                for (Unidad e : lista) {
                            %>
                            <tbody>
                                <tr>
                                    <td> <%= e.getIdUnidad()%> </td>
                                    <td> <%= e.getNombreUnidad()%></td>
                                    <td> <%= e.getDescripcion()%></td>
                                    <td><a href="servletCurso?accion=BuscarC&id=<%=e.getIdUnidad()%>" class="btn btn-primary glyphicon glyphicon-refresh" role="button"></a></td>
                                    <td><a href="servletCurso?accion=EliminarC&id=<%=e.getIdUnidad()%>" class="btn btn-danger glyphicon glyphicon-remove" role="button"></a></td>
                                    <td><a href="servletUnidad?accion=BuscarU&id=<%=e.getIdUnidad() %>" class="btn btn-primary glyphicon glyphicon-pencil" role="button"></a></td>
                                </tr>
                            </tbody>
                            <%
                                }
                            %>
                        </table> 
                        <a href="agregarCurso.jsp" class="btn btn-primary" role="button">Nuevo Unidad</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

