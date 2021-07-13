/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.dto.ProductoDTO;
import Modelo.dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
public class UsuarioCTO extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if(menu.equalsIgnoreCase("usuario")){
            Facade obj = new Facade();
            switch(accion){
                case "Listar":{
                    List<UsuarioDTO> lis = obj.listarUsuarios();
                    request.setAttribute("lista_usuarios", lis);
                    break;
                }
                case "Agregar":{
                    String nombre1 = request.getParameter("txt_nombre1");
                    String nombre2 = request.getParameter("txt_nombre2");
                    String apellido1 = request.getParameter("txt_apellido1");
                    String apellido2 = request.getParameter("txt_apellido2");
                    String identificacion = request.getParameter("txt_n_identificacion");
                    String correo = request.getParameter("txt_correo");
                    String clave = request.getParameter("txt_clave"); 
                    char sexo = request.getParameter("txt_sexo").charAt(0);
                    String fecha_nac = request.getParameter("txt_fecha_nac"); 
                    String estado = request.getParameter("txt_estado"); 
                    String rol = request.getParameter("txt_rol"); 
                    UsuarioDTO nuevo = new UsuarioDTO(nombre1, nombre2, apellido1, apellido2, identificacion, correo, clave, sexo, fecha_nac, estado, rol);
                    obj.crearUsuario(nuevo);
                    request.getRequestDispatcher("UsuarioCTO?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                } 
                
                case "Editar":{
                    UsuarioDTO edit = new UsuarioDTO();
                    edit.setId_usu(Integer.parseInt(request.getParameter("id")));
                    edit=obj.verUsuario(edit);
                    request.setAttribute("usuario", edit);
                    request.getRequestDispatcher("UsuarioCTO?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                }
                
                case "Actualizar":{
                    int id1=Integer.parseInt(request.getParameter("txt_id"));
                    String nombre1 = request.getParameter("txt_nombre1");
                    String nombre2 = request.getParameter("txt_nombre2");
                    String apellido1 = request.getParameter("txt_apellido1");
                    String apellido2 = request.getParameter("txt_apellido2");
                    String identificacion = request.getParameter("txt_n_identificacion");
                    String correo = request.getParameter("txt_correo");
                    String clave = request.getParameter("txt_clave"); 
                    char sexo = request.getParameter("txt_sexo").charAt(0);
                    String fecha_nac = request.getParameter("txt_fecha_nac"); 
                    String estado = request.getParameter("txt_estado"); 
                    String rol = request.getParameter("txt_rol"); 
                    UsuarioDTO actual = new UsuarioDTO(id1, nombre1, nombre2, apellido1, apellido2, identificacion, correo, clave, sexo, fecha_nac, estado, rol);
                    obj.ActualizarUsuario(actual);
                    request.getRequestDispatcher("UsuarioCTO?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                }
                
                case "Eliminar":{
                   UsuarioDTO elim =new UsuarioDTO();
                    elim.setId_usu(Integer.parseInt(request.getParameter("id")));
                    obj.EliminarUsuario(elim);
                    request.getRequestDispatcher("UsuarioCTO?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                }
            }
            request.getRequestDispatcher("UsuarioVTA.jsp").forward(request, response);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioCTO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioCTO at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
