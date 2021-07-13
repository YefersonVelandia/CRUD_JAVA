<%-- 
    Document   : UsuarioVTA
    Created on : 23/02/2021, 08:00:46 PM
    Author     : andre
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<% HttpSession objSesion = request.getSession();
    if(objSesion.getAttribute("usuario")==null){
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1>Usuarios</h1>
                </div>
            </div>
            
            <div class="card col-sm-6 col-md-6 col-lg-8">
                    <table class="table table-hover border-primary">

                        <thead>
                        <th>No. ID</th>
                        <th>Nombre</th>
                        <th>Segundo Nombre</th>
                        <th>Primer Apeliido</th>
                        <th>Segundo Apellido</th>
                        <th>Correo</th>
                        <th>Clave</th>
                        <th>Estado</th>
                        <th>Rol</th>
                        </thead>
                        <tbody>
                            <c:forEach var="objUsu" items="${lista_usuarios}">
                                <tr>
                                    <td>${objUsu.getId_usu}</td>
                                    <td>${objUsu.getNombre1}</td>
                                    <td>${objUsu.getNombre2}</td>
                                    <td>${objUsu.getApellido1}</td>
                                    <td>${objUsu.getApellido2}</td>
                                    <td>${objUsu.getCorreo}</td>
                                    <td>${objUsu.getClave}</td>
                                    <td>${objUsu.getEstado}</td>
                                    <td>${objUsu.getRol}</td>
                                    <!--<td>-->
                                        <!--<a class="btn btn-outline-success" href="ProductoCTO?menu=Producto&accion=Editar&id=${objP.getId_pro()}">Editar</a>-->
                                        <!--<a class="btn btn-outline-danger " href="ProductoCTO?menu=Producto&accion=Eliminar&id=${objP.getId_pro()}">Eliminar</a>-->
                                    <!--</td>-->
                                </tr>
                            </c:forEach>    
                        </tbody>
                    </table>
                </div>
            
        </div>
        
        
    </body>
</html>

