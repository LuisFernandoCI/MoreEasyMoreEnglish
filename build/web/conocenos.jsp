<%-- 
    Document   : conocenos
    Created on : 28/03/2018, 08:08:41 PM
    Author     : amdza
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.domain.Sesion"%>
<%@page import="com.web.dao.DAOSesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession actual = request.getSession(true);
    String correo = (String) actual.getAttribute("logueado");
    String nivel = (String) actual.getAttribute("nivel");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Camara Y Video 3G</title>
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
                            </button> <a class="navbar-brand active" href="#">"More English More Easy"</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="">
                                    <a href="login.jsp">Inicio</a>
                                </li>
                                <li class="active">
                                    <a href="principal.jsp">Cursos</a>
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
                                <%if (nivel == "ALUMNO") {%>
                                <li class="active">
                                    <a href="servletCliente?accion=BuscarC&correo=<%=correo%>">Datos</a>
                                </li>
                                <li>
                                    <a href="listaEventos.jsp">Evento </a>
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
                    <dl>
                        <dt>
                            La ubicacion es:
                        </dt>
                        <div class="row">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3763.975214643103!2d-98.99151348584876!3d19.37022584769328!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x85d1e2eaca308911%3A0xae458392b91ef4cd!2zSm9zw6kgTWFyw61hIE1vcmVsb3MgeSBQYXbDs24gODAsIExvbWEgQm9uaXRhLCA1Nzk0MCBOZXphaHVhbGPDs3lvdGwsIE3DqXgu!5e0!3m2!1ses!2smx!4v1522292694103" width="800" height="600" frameborder="0" style="border:0" allowfullscreen></iframe>
                        </div>
                        <dt>
                            <h1>
                                Empleados:
                            </h1>
                        </dt>
                        <%
                            DAOPuesto_Empleado tarea = new DAOPuesto_Empleado();
                            ArrayList<Puesto_Empleado> lista = tarea.obtenerPuesto_Empleado();
                            for (Puesto_Empleado e : lista) {
                        %>
                        <div class="col-md-4">
                            <dt>
                                Nombre del Empleado:
                            </dt>
                            <dd> 
                                <%= e.getNom_emp()%>  <%= e.getApellido_pat()%> <%= e.getApellido_mat()%>
                            </dd>
                            <dt>
                                Puesto:
                            </dt>      
                            <dd> 
                                <%= e.getNom_pu()%>
                            </dd>
                        </div>
                        <%
                            }
                        %>
                    </dl>
                </div>
            </div>
        </div>
    </div>
</body>
</html>


