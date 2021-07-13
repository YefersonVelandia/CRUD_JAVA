/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.dto.SesionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yeferson Reinel Velandia Arias 20171578037
 */
public class MiSesionCTO extends HttpServlet {
    
    private String vetIni = "avanzada301udud4";
    private String keyIni = "4dudu103adaznava";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion=request.getParameter("accion");
        Facade obj = new Facade();
        
        switch(accion){
            case "Validar":{
                String usuario= request.getParameter("txtUsuario");
                String clave= request.getParameter("txtPss");
                clave = asegurarClave(clave); 
                clave = cifrarAES_cbc(clave);
                SesionDTO filter = new SesionDTO(clave,usuario);
                filter=obj.ValidarSesion(filter);
                if(filter!=null){
                    System.out.println("Ingreso sesion");
                    HttpSession session=request.getSession();
                    System.out.println("ID sesion = "+session.getId());
                    session.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    
                }else{
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                    System.out.println("Usuario o correo no valido"); 
                }
                break;
            }
            case "Registrar":{
                request.getRequestDispatcher("Registrar.jsp").forward(request, response);
            }
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
    private String asegurarClave(String clave) throws UnsupportedEncodingException{
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(clave.getBytes("UTF-8"));
            clave = String.format("%064x", new BigInteger(1, sha256.digest()));
            System.out.println("clave: " + clave);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("sha1 " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            System.out.println("sha2 " + ex.getMessage());
        }
        return clave;
    }
    
    private String cifrarAES_cbc(String texto){
        Cipher AES_CBC;
        try {

            AES_CBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec skeySpec = new SecretKeySpec(keyIni.getBytes("UTF-8"), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(vetIni.getBytes("UTF-8"));
//            inicializar Cipher con modo, clave inicial, vector inicial
            AES_CBC.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] byteCifrado = AES_CBC.doFinal(texto.getBytes("UTF-8"));
            texto = Base64.getEncoder().encodeToString(byteCifrado);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException
                | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException ex) {
            System.out.println("Error al Cifrar: " + ex.getMessage());
        }
        System.out.println("Clave cifrada AES: "+texto);            
        return texto;
    }
}

