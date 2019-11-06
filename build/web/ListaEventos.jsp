<%-- 
    Document   : ListaEventos
    Created on : 28/03/2018, 06:26:48 PM
    Author     : amdza
--%>
<%
    HttpSession actual = request.getSession(true);
    String correo = (String) actual.getAttribute("logueado");
    String nivel = (String) actual.getAttribute("nivel");
    if (correo == null) {
        response.sendRedirect("login.jsp");
    }
    if (nivel.equals("ADMINISTRADOR")) {
%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sons.dao.domain.Evento"%>
<%@page import="com.sons.web.dao.DAOEvento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <nav class="navbar navbar-default navbar-inverse" role="navigation">
                        <div class="navbar-header">

                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                            </button> <a class="navbar-brand active" href="#">"Germán García Fotógrafo"</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="">
                                    <a href="principal.jsp">Principal</a>
                                </li>
                                <li class="">
                                    <a href="conocenos.jsp">Conocenos</a>
                                </li>
                                <li class="active">
                                    <a href="ListaEventos.jsp">Catalogos</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                            </ul>
                        </div>

                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="list-group">
                            <div class="list-group-item"><a href="ListaEventos.jsp">Evento</a></div>
                            <div class="list-group-item"><a href="ListaServicios.jsp" >Servicio</a></div>
                            <a href="ListaEventos.jsp" class="list-group-item active">Evento</a>
                            <div class="list-group-item"><a href="ListaPuesto_Evento.jsp" >Puesto</a></div>
                            <div class="list-group-item"><a href="ListaClientes.jsp" >Cliente</a></div>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <h1>
                            Lista de  Eventos
                        </h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <td class="" ><p>ID</p></td>
                                    <td class="" ><p>DOMICILIO</p></td>
                                    <td class="" ><p>FECHA</p></td>
                                    <td class="" ><p>HORA</p></td>
                                </tr>
                            </thead>
                            <%
                                DAOEvento tarea = new DAOEvento();
                                ArrayList<Evento> lista = tarea.obtenerEventos();
                                for (Evento e : lista) {
                            %>
                            <tbody>
                                <tr>
                                    <td> <%= e.getId_evento()%> </td>
                                    <td> <%= e.getFecha()%></td>
                                    <td> <%= e.getHora()%></td>
                                    <td><a href="servletEvento?accion=BuscarE&id=<%=e.getId_evento()%>" class="btn btn-primary glyphicon glyphicon-refresh" role="button"></a></td>
                                    <td><a href="servletEvento?accion=EliminarE&id=<%=e.getId_evento()%>" class="btn btn-danger glyphicon glyphicon-remove" role="button"></a></td>
                                </tr>
                            </tbody>
                            <%
                                }
                            %>
                        </table> 
                        <a href="agregarEvento.jsp" class="btn btn-primary" role="button">Nuevo</a>
                        <a href="agregarPuesto_Evento.jsp" class="btn btn-primary" role="button">Puesto Evento</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<%}%>