<%-- 
    Document   : listaCurso
    Created on : 23/10/2019, 06:17:44 PM
    Author     : COLINAS
--%>
<% Curso c = (Curso) request.getSession().getAttribute("c");%>
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
                                    <a href="ListaCurso.jsp">Cursos</a>
                                </li>
                                <li>
                                    <a href="servletSesion?accion=cerrar">Cerrar</a>
                                </li>
                            </ul>
                        </div>

                    </nav>
                </div>
                <div class="col-md-8">
                <form id="form1" name="form1" method="post" action="servletCurso">
                    <input type="hidden" name="accion" value="InsertarC"/>
                    <h1>Nuevo Curso</h1>
                    <div class="form-group">
                        <label for="exampleNombreCurso">
                            Nombre Curso:
                        </label>
                        <input type="text" class="form-control" id="NombreCurso" name="NombreCurso"  placeholder="Nombre del curso..." maxlength="100" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleNivelCompetencia">
                            Nivel de Competencia :
                        </label>
                        <input type="text" class="form-control" id="NivelCompetencia" name="NivelCompetencia" placeholder="Nivel de Competencia..." maxlength="50" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleDescripcion">
                            Descripcion :
                        </label>
                        <input type="text" class="form-control" id="Descripcion" name="Descripcion" placeholder="Descripcion..." maxlength="500" required/>
                    </div>
                    
                    <button type="submit" class="btn btn-default" id="btnInsertarE" name="btnInsertarE">
                        Aceptar
                    </button>
                </form>
            </div>
            </div>
        </div>
    </body>
</html>