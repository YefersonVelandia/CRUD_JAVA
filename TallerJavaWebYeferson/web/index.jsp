<%-- 
    Document   : index
    Created on : 26-nov-2020, 8:12:33
    Author     : yeferson
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Taller Java Web</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
        <div class="modal-dialog text-center">
            <div class="col-lg-8">
                <div class="modal-content">
                    <div class="col-12">
                        <img src="img/login.png" height="128" width="128">
                    </div>
                    <form class="col-12" action="MiSesionCTO?accion=Validar" method="POST">
                        <div class="form-group text-center">
                            <p><strong>Bienvenidos al sistema de Login</strong></p>
                        </div>
                        <div class="form-group">
                            <label>Usuario: </label>
                            <input class="form-control" type="text" name="txtUsuario" placeholder="Ejemplo@gmail.com" required>
                        </div>

                        <div class="form-group">
                            <label>Clave de acceso: </label>
                            <input class="form-control" type="password" name="txtPss" required>
                        </div>
                        <input type="submit" name="btnIngresar" value="Ingresar" class="btn btn-primary">
                    </form>
                    <div class="col-12">
                        <a href="#">Olvide mi clave</a>
                        <a href="MiSesionCTO?accion=Registrar">Registrar</a>
                    </div>
                </div>
            </div>

        </div>
        <h1>Aqui va un control de proceso</h1>
        <a href="Principal.jsp">Pagina Principal</a>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>


</html>
