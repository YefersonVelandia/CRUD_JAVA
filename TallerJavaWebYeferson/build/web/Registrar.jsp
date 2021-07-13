<%-- 
    Document   : Registrar
    Created on : 23/02/2021, 10:28:42 PM
    Author     : andre
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
        <div class="row">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="RegistrarCTO?menu=Usuario" method="POST">
                        <div class="form-group">
                            <label> Primer Nombre: </label>
                            <input class="form-control" type="text" name="txt_nombre1" required value="${usuario.getNombre1()}">
                        </div>
                        <div class="form-group">
                            <label> Segundo Nombre: </label>
                            <input class="form-control" type="text" name="txt_nombre2" required value="${usuario.getNombre2()}">
                        </div>
                        <div class="form-group">
                            <label> Primer Apellido: </label>
                            <input class="form-control" type="text" name="txt_apellido1" required value="${usuario.getApellido1()}">
                        </div>
                        <div class="form-group">
                            <label> Segundo Apellido: </label>
                            <input class="form-control" type="text" name="txt_apellido2" required value="${usuario.getApellido2()}">
                        </div>
                        <div class="form-group">
                            <label> Identificacion: </label>
                            <input class="form-control" type="text" name="txt_n_identificacion" required value="${usuario.getIdentificacion()}">
                        </div>
                        <div class="form-group">
                            <label> Correo: </label>
                            <input class="form-control" type="text" name="txt_correo" required value="${usuario.getCorreo()}">
                        </div>
                        <div class="form-group">
                            <label> Clave: </label>
                            <input class="form-control" type="text" name="txt_clave" required value="${usuario.getClave()}">
                        </div>
                        <div class="form-group">
                            <label> Sexo: </label>
                            <input class="form-control" type="text" name="txt_sexo" required value="${usuario.getSexo()}">
                        </div>
                        <div class="form-group">
                            <label> Fecha de nacimiento: </label>
                            <input class="form-control" type="text" name="txt_fecha_nac" required value="${usuario.getFecha_nac()}">
                        </div>
                            <c:if test="${usuario.getFecha_nac()==null}">
                                <input class="btn btn-success" type="submit" name="accion" value="Agregar" id="add">
                            </c:if>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

