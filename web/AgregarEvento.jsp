<%-- 
    Document   : newjs
    Created on : 28/03/2018, 06:26:06 PM
    Author     : amdza
--%>
<%
    HttpSession actual = request.getSession(true);
    String correo = (String) actual.getAttribute("logueado");
    String nivel = (String) actual.getAttribute("nivel");
    if (correo == null) {
        response.sendRedirect("login.jsp");
    }
    if (nivel.equals("CLIENTE")) {
%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sons.dao.domain.Servicio"%>
<%@page import="com.sons.web.dao.DAOServicio"%>
<%@page import="com.sons.dao.domain.Empleado"%>
<%@page import="com.sons.web.dao.DAOEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Camara Y Video 3G</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"> <!--Iconos--> 
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500" rel="stylesheet">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
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
                            <a href="login.jsp">Inicio</a>
                        </li>
                        <li class="">
                            <a href="principal.jsp">Principal</a>
                        </li>
                        <li class="">
                            <a href="conocenos.jsp">Conocenos</a>
                        </li>
                        <li class="active">
                            <a href="ListaEmpleados.jsp">Catalogos</a>
                        </li>
                        <li>
                            <a href="servletSesion?accion=cerrar">Cerrar</a>
                        </li>
                    </ul>
                </div>

            </nav>
        </div>
        <div class="row">
            <div class="col-md-8">
                <form id="Form_AgregarEvento" name="Form_AgregarEvento" method="post" action="servletServicio">
                    <input type="hidden" name="accion" value="InsertarS"/>
                    <h1>Nuevo Evento</h1>
                    <div class="form-group">
                        <label for="exampleInputEmail1">
                            Domicilio:
                        </label>
                        <input type="text" class="form-control" id="domicilio" name="domicilio" placeholder="Ingrese el domicilio del evento..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">
                            Fecha:
                        </label>
                        <input type="date" class="form-control" id="fecha" name="fecha" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">
                            Hora:
                        </label>
                        <input type="time" class="form-control" id="hora" name="hora" required/>
                    </div>
                    <div class="form-group">
                        <label for="servivio">
                            Servicio:
                        </label>
                        <select name="servicio" id="servicio">
                            <%
                                DAOServicio tarea = new DAOServicio();
                                ArrayList<Servicio> lista = tarea.obtenerServicios();
                                for (Servicio s : lista) {
                            %>
                            <option value="<%=s.getId_servicio()%>"><%=s.getNombre()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="servivio">
                            Empleado:
                        </label>
                        <select name="empleado" id="empleado">
                            <%
                                DAOEmpleado emp = new DAOEmpleado();
                                ArrayList<Empleado> listaEmp = emp.obtenerEmpleados();
                                for (Empleado e : listaEmp) {
                            %>
                            <option value="<%=e.getId_emp()%>"><%=e.getNombre()%> <%=e.getApePa()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">
                        Enviar 
                    </button>
                </form>
            </div>
        </div>
    </body>
</html>
<%}%>