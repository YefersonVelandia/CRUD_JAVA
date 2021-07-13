/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.dto.ProductoDTO;
import java.util.List;
/*
@author yeferson Reinel Velandia Arias 20171578037

 */
public class ProductoCTO extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu= request.getParameter("menu");
        String accion= request.getParameter("accion");
        
        if(menu.equalsIgnoreCase("producto")){
            Facade obj = new Facade();
            switch(accion){
                case "Listar":{
                    List<ProductoDTO> lis = obj.listarProductos();
                    request.setAttribute("lista_productos", lis);
                    break;
                }
                case "Agregar":{
                    String nombre = request.getParameter("txt_nombre_pro");
                    String des = request.getParameter("txt_descripcion_pro");
                    int und = Integer.parseInt(request.getParameter("txt_unidades_pro"));
                    int val = Integer.parseInt(request.getParameter("txt_valor_pro"));
                    ProductoDTO nuevo = new ProductoDTO(nombre, des, und, val);
                    obj.crearProducto(nuevo);
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
                } 
                
                case "Editar":{
                    ProductoDTO edit =new ProductoDTO();
                    edit.setId_pro(Integer.parseInt(request.getParameter("id")));
                    edit=obj.verProducto(edit);
                    request.setAttribute("producto", edit);
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
                }
                
                case "Actualizar":{
                    int id1=Integer.parseInt(request.getParameter("txt_id_pro"));
                    String Nombre1=request.getParameter("txt_nombre_pro");
                    String Desc1=request.getParameter("txt_descripcion_pro");
                    int und1=Integer.parseInt(request.getParameter("txt_unidades_pro"));
                    int val1=Integer.parseInt(request.getParameter("txt_valor_pro"));
                    ProductoDTO actual = new ProductoDTO(id1, Nombre1, Desc1, und1, val1);
                    obj.ActualizarProd(actual);
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
                }
                
                case "Eliminar":{
                   ProductoDTO elim =new ProductoDTO();
                    elim.setId_pro(Integer.parseInt(request.getParameter("id")));
                    obj.EliminarProd(elim);
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
                }
            }
            request.getRequestDispatcher("ProductoVTA.jsp").forward(request, response);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductoCTO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoCTO at " + request.getContextPath() + "</h1>");
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
