<%-- 
    Document   : listaCurso
    Created on : 23/10/2019, 06:17:44 PM
    Author     : COLINAS
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.domain.Curso"%>
<%@page import="com.web.dao.DAOCurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Curso</title>
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
                                    <a href="listaCurso.jsp">Cursos</a>
                                </li>
                                <li class="active">
                                    <a href="listaUsuario.jsp">Cursos</a>
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
                            Lista de Cursos
                        </h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <td class="" ><p>ID</p></td>
                                    <td class="" ><p>Nombre</p></td>
                                    <td class="" ><p>Nivel</p></td>
                                    <td class="" ><p>Descripcion</p></td>
                                    <td class="" ><p>Actualizar</p></td>
                                    <td class="" ><p>Eliminar</p></td>
                                    <td class="" ><p>Unidades</p></td>
                                    <td class="" ><p>Grammar</p></td>
                                </tr>
                            </thead>
                            <%
                                DAOCurso tarea = new DAOCurso();
                                ArrayList<Curso> lista = tarea.obtenerCursos();
                                for (Curso e : lista) {
                            %>
                            <tbody>
                                <tr>
                                    <td> <%= e.getIdCurso()%> </td>
                                    <td> <%= e.getNombreCurso()%></td>
                                    <td> <%= e.getNivelCompetencia()%></td>
                                    <td> <%= e.getDescripcion()%></td>
                                    <td><a href="servletCurso?accion=BuscarC&id=<%=e.getIdCurso()%>" class="btn btn-primary glyphicon glyphicon-refresh" role="button"></a></td>
                                    <td><a href="servletCurso?accion=EliminarC&id=<%=e.getIdCurso()%>" class="btn btn-danger glyphicon glyphicon-remove" role="button"></a></td>
                                    <td><a href="servletUnidad?accion=listaU&id=<%=e.getIdCurso()%>" class="btn btn-primary glyphicon glyphicon-pencil" role="button"></a></td>
                                     <td><a href="servletGrammar?accion=listaG&id=<%=e.getIdCurso()%>" class="btn btn-primary glyphicon glyphicon-pencil" role="button"></a></td>
                                </tr>
                            </tbody>
                            <%
                                }
                            %>
                        </table> 
                        <a href="agregarCurso.jsp" class="btn btn-primary" role="button">Nuevo Curso</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
