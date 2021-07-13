<%-- 
    Document   : Principal
    Created on : 27-nov-2020, 2:04:55
    Author     : yeferson
--%>

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
   <nav class="navbar navbar-expand-sm navbar-light bg-dark">
            <div id="navbar">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a  class="btn btn-outline-light" style="margin-left: 10px; border: none" href="#">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 10px; border: none" href="ProductoCTO?menu=Producto&accion=Listar" target="Frame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light" style="margin-left: 10px; border: none" href="UsuarioCTO?menu=Usuario&accion=Listar" target="Frame">Cuenta</a>
                    </li>
                </ul>
            </div>
        </nav>
        
        <div style="height: 630px;">
            <iframe name="Frame" style="height: 100%; width: 100%; border: 2px"></iframe>
        </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
