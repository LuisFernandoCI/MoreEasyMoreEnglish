<%-- 
    Document   : registro
    Created on : 28/03/2018, 09:02:46 PM
    Author     : amdza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registro</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"> <!--Iconos--> 
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500" rel="stylesheet">
        <link rel="stylesheet" href="css/inicio.css">
    </head>


    <body >
        <div class="my-content" >
            <div class="container" > 

                <div class="row">
                    <div class="col-sm-12" >
                        <h1><strong>More English More Easy</h1>
                        <div class="mydescription">
                            <h3>La mejor pagina para que aprendas ingles.</h3>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 myform-cont" >
                        <div class="myform-top">
                            <div class="myform-top-left">
                                <h3>Registrate a nuestro sitio.</h3>
                                <p>Digita tus datos:</p>
                            </div>
                            <div class="myform-top-right">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </div>
                        </div>
                        <div class="myform-bottom">
                            <form role="form" action="servletSesion" method="post" class="">
                                <input type="hidden" name="accion" value="registrar"/>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="nom_cli" name="nombreusuario"  placeholder="Nombre(s)..." autocomplete="off" required/>
                                </div>
                                <div class="form-group">
                                    
                                    <input type="text" class="form-control" id="ape_pat" name="apellidos" placeholder="Apellido(s)..." autocomplete="off"required/>
                                </div>
                                <div class="form-group">
                                    
                                    <input type="email" class="form-control" id="correo" name="correo" placeholder="Correo..." autocomplete="off" required/>
                                </div>
                                <div class="form-group">
                                    
                                    <input type="password" class="form-control" id="pass" name="pass" placeholder="Password..." autocomplete="off" required/>
                                </div>
                                
                                <div class="form-group">
                                    <button type="submit" class="mybtn">Entrar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>