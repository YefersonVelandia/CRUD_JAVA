<%-- 
    Document   : ProductoVTA
    Created on : 27-nov-2020, 1:29:06
    Author     : yeferson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h1>Productos</h1>
                </div>
            </div>

            <div class="row">
                <div class="card col-sm-4">
                    <div class="card-body">
                        <form action="ProductoCTO?menu=Producto" method="POST">
                            <div class="form-group">
                                <label>Nombre Producto: </label>
                                <input class="form-control" type="text" name="txt_nombre_pro" required placeholder="Nombre de producto..." value="${producto.getNombre_pro()}">
                                <input type="hidden" value="${producto.getId_pro()}" name="txt_id_pro">
                            </div>
                            <div class="form-group">
                                <label>Descripcion Producto: </label>
                                <input class="form-control" type="text" name="txt_descripcion_pro" required placeholder="Descripcion..." value="${producto.getDescripcion_pro()}">
                            </div>
                            <div class="form-group">
                                <label>Unidades Producto: </label>
                                <input class="form-control" type="number" name="txt_unidades_pro" required min="1" placeholder="Unidades..." value="${producto.getUnidades_pro()}">
                            </div>
                            <div class="form-group">
                                <label>Valor Producto: </label>
                                <input class="form-control" type="number" name="txt_valor_pro" required min="1" placeholder="Valor..." value="${producto.getValor_pro()}"><br><br>
                            </div>
                            <c:if test="${producto.getValor_pro()==null}">
                                <input class="btn btn-success" type="submit" name="accion" value="Agregar" id="add">
                            </c:if>

                            <c:if test="${producto.getValor_pro()!=null}">
                                <input class="btn btn-warning" type="submit" name="accion" value="Actualizar">
                            </c:if>
                        </form>
                    </div>
                </div>

                <div class="card col-sm-6 col-md-6 col-lg-8">
                    <table class="table table-hover border-primary">

                        <thead>
                        <th>No. ID</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Unidades</th>
                        <th>Valor</th>
                        <th>Acciones</th>
                        </thead>
                        <tbody>
                            <c:forEach var="objP" items="${lista_productos}">
                                <tr>
                                    <td>${objP.getId_pro()}</td>
                                    <td>${objP.getNombre_pro()}</td>
                                    <td>${objP.getDescripcion_pro()}</td>
                                    <td>${objP.getUnidades_pro()}</td>
                                    <td>${objP.getValor_pro()}</td>
                                    <td>
                                        <a class="btn btn-outline-success" href="ProductoCTO?menu=Producto&accion=Editar&id=${objP.getId_pro()}">Editar</a>
                                        <a class="btn btn-outline-danger " href="ProductoCTO?menu=Producto&accion=Eliminar&id=${objP.getId_pro()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>    
                        </tbody>
                    </table>
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        </div>
    </body>
</html>
