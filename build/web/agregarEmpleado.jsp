<%-- 
    Document   : Frm_Insertar
    Created on : 13/02/2018, 08:19:39 PM
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
        <div class="col-md-12">
            <nav class="navbar navbar-default navbar-inverse" role="navigation">
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                    </button> <a class="navbar-brand active" href="#">"Germán García Fotógrafo"</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
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
            <div class="col-md-3">
                <div class="list-group">
                    <a href="ListaEmpleados.jsp" class="list-group-item active" >Empleado</a>
                    <div class="list-group-item"><a href="ListaServicios.jsp" >Servicio</a></div>
                    <div class="list-group-item"><a href="ListaEventos.jsp" >Evento</a></div>
                    <div class="list-group-item"><a href="ListaPuesto_Empleado.jsp" >Puesto</a></div>
                    <div class="list-group-item"><a href="ListaClientes.jsp" >Cliente</a></div>
                </div>
            </div>
            <div class="col-md-8">
                <form id="form1" name="form1" method="post" action="servletEmpleado">
                    <input type="hidden" name="accion" value="InsertarE"/>
                    <h1>Nuevo Empleado</h1>
                    <div class="form-group">

                        <label for="exampleInputEmail1">
                            Nombre(s)
                        </label>
                        <input type="text" class="form-control" id="nom_emp" name="nom_emp"  placeholder="Nombres..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">
                            Apellido Paterno
                        </label>
                        <input type="text" class="form-control" id="ape_pat" name="ape_pat" placeholder="Apellido Paterno..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword2">
                            Apellido Materno
                        </label>
                        <input type="text" class="form-control" id="ape_mat" name="ape_mat" placeholder="Apellido Materno..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword2">
                            Telefono
                        </label>
                        <input type="text" class="form-control" id="tel" name="tel" placeholder="Telefono..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword2">
                            Correo
                        </label>
                        <input type="text" class="form-control" id="correo" name="correo" placeholder="Correo..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword2">
                            CURP
                        </label>
                        <input type="text" class="form-control" id="curp" name="curp" placeholder="CURP..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword2">
                            RFC
                        </label>
                        <input type="text" class="form-control" id="rfc" name="rfc" placeholder="RFC..." required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword2">
                            PASSWORD
                        </label>
                        <input type="text" class="form-control" id="pass" name="pass" placeholder="Ingrese contraseña" maxlength="20" minlength="8" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword2">
                            TIPO DE EMPLEADO
                        </label>
                        <select name="tipo_emp" id="tipo_emp">
                            <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                            <option value="EMPLEADO">EMPLEADO</option>
                        </select>
                    </div>
                    <div class="form-group">

                        <label for="exampleInputFile">
                            File input
                        </label>
                        <input type="file" id="exampleInputFile" />
                        <p class="help-block">
                            Example block-level help text here.
                        </p>
                    </div>
                    <div class="checkbox">

                        <label>
                            <input type="checkbox" /> Check me out
                        </label>
                    </div> 
                    <button type="submit" class="btn btn-default" id="btnInsertarE" name="btnInsertarE">
                        Aceptar
                    </button>
                </form>
            </div>
        </div>
    </body>
</html>
<%}%>