<%-- 
    Document   : principal
    Created on : 5/02/2018, 08:17:41 AM
    Author     : amdza

--%>
<%@page import="com.dao.domain.Sesion"%>
<%@page import="java.util.ArrayList"%>
<% Sesion s = (Sesion) request.getSession().getAttribute("s");%>
<%@page import="com.dao.domain."%>
<%@page import="com.web.dao.DAOServicio"%>
<%
    HttpSession actual = request.getSession(true);
    String correo = (String) actual.getAttribute("logueado");
    String nivel = (String) actual.getAttribute("nivel");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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
                            </button> <a class="navbar-brand active" href="#">"Germ�n Garc�a Fot�grafo"</a>
                        </div>
<%-- 
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <% if(correo == null){%>
                                <li class="">
                                    <a href="login.jsp">Inicio</a>
                                </li><%}%>
                                <li class="active">
                                    <a href="principal.jsp">Principal</a>
                                </li>
                                <li class="">
                                    <a href="conocenos.jsp">Conocenos</a>
                                </li>
                                <%if (nivel == "ADMINISTRADOR") {%>
                                <li class="">
                                    <a href="ListaEmpleados.jsp">Catalogos</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                                <%}%>
                                <%if (nivel == "CLIENTE") {%>
                                <li class="active">
                                    <a href="servletCliente?accion=BuscarC&correo=<%=correo%>">Datos</a>
                                </li>
                                <li>
                                    <a href="listaEventos.jsp">Evento</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                                <% } %>
                                <%if (nivel == "EMPLEADO") {%>
                                <li>
                                    <a href="mostrarEventos.jsp?correo=<%= e.getCorreo() %>">Eventos asignados</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                                <% } %>  
                            </ul>
                        </div> --%>

                    </nav>

                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="imagenes/Ejemplo.jpg" alt="Los Angeles" style="width:100%;">
                            </div>

                            <div class="item">
                                <img src="imagenes/Ejemplo1.jpg" alt="Chicago" style="width:100%;">
                            </div>

                            <div class="item">
                                <img src="imagenes/Ejemplo2.jpg" alt="New york" style="width:100%;">
                            </div>
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="row">
<%--                     <%
                        DAOServicio tarea = new DAOServicio();
                        ArrayList<Servicio> lista = tarea.obtenerServicios();
                        for (Servicio s : lista) {
                    %>
                    <div class="col-md-4">
                        <h2>
                            <strong><%= s.getNombre()%></strong> 
                        </h2>
                        <p><%= s.getDescripcion()%></p>
                        <p>
                            <a class="btn" href="servletServicio?accion=BuscarSe&id=<%=s.getId_servicio()%>">Detalle</a>
                        </p>
                    </div>
                    <%
                        }
                    %>--%>
                </div>
                <div class="row">
                    <div class="col-md-12">

                        <address>
                            <strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br /> San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123) 456-7890
                        </address>
                    </div>
                </div>

            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.myCarousel').carousel()
            });
        </script>
    </body>
</html>
