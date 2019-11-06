<%-- 
    Document   : login
    Created on : 9/12/2017, 11:22:02 AM
    Author     : amdza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
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
                            <h3>Ingresa a nuestro sitio.</h3>
                              <p>Digita tu usuario y contraseña:</p>
                          </div>
                          <div class="myform-top-right">
                            <i class="glyphicon glyphicon-lock"></i>
                          </div>
                      </div>
                      <div class="myform-bottom">
                          
                        <form role="form" action="servletSesion" method="post" class="">
                            <input type="hidden" name="accion" value="entrar"/>
                          <div class="form-group">
                              <input type="email" name="usuario" placeholder="Correo..." class="form-control" id="usuario">
                          </div>
                          <div class="form-group">
                              <input type="password" name="pass" placeholder="Contraseña..." class="form-control" id="pass">
                          </div>
                          <div class="form-group">
                              <button type="submit" class="mybtn">Entrar</button>
                          </div>
                          <div class="form-group">
                              <a type="button" href="registro.jsp" class="mybtn">Registrate...</a>
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