<%-- 
    Document   : agregarGrammar
    Created on : 27/10/2019, 03:28:14 PM
    Author     : amdza
--%>
<% 
    HttpSession actual = request.getSession(true);
    int idCurso = (Integer) actual.getAttribute("idCurso");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Grammar</title>
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
                <form id="form1" name="form1" method="post" action="servletGrammar">
                    <input type="hidden" name="accion" value="InsertarG"/>
                    <h1>Nuevo Grammar</h1>
                    <input type="hidden" id="idCurso" name="idCurso" value="<%= idCurso %>">
                    <div class="form-group">
                        <label for="exampleNombreCurso">
                            Nombre Grammar:
                        </label>
                        <input type="text" class="form-control" id="NombreGrammar" name="NombreGrammar"  placeholder="Nombre del curso..." maxlength="100" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleNivelCompetencia">
                            Sumary :
                        </label>
                        <input type="text" class="form-control" id="SumaryGrammar" name="SumaryGrammar" placeholder="Nivel de Competencia..." maxlength="50" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleDescripcion">
                            Example :
                        </label>
                        <input type="text" class="form-control" id="ExampleGrammar" name="ExampleGrammar" placeholder="Descripcion..." maxlength="500" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleDescripcion">
                            From :
                        </label>
                        <input type="text" class="form-control" id="FromGrammar" name="FromGrammar" placeholder="Descripcion..." maxlength="500" required/>
                    </div>
                    <div class="form-group">
                        <label for="exampleDescripcion">
                            Use :
                        </label>
                        <input type="text" class="form-control" id="UseGrammar" name="UseGrammar" placeholder="Descripcion..." maxlength="500" required/>
                    </div>
                    <button type="submit" class="btn btn-default" id="btnInsertarG" name="btnInsertarG">
                        Aceptar
                    </button>
                </form>
            </div>
            </div>
        </div>
    </body>
</html>