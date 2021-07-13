/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeferson Reinel Velandia Arias 20171578037
 */

public class ConexionMsql {
    public static ConexionMsql instance;
    private Connection cnn; //Se crea el objeto de la interface connection
    
    private ConexionMsql(){
        try{
        Class.forName("com.mysql.jdbc.Driver"); //se añade el driver de la base de datos 
            try{
                cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_tallerjavaweb","root","");
                /*Se especifica el puerto y los usuarios para la conexion a la base de datos*/
            } catch (SQLException ex) {
                Logger.getLogger(ConexionMsql.class.getName()).log(Level.SEVERE, null, ex);
            }   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionMsql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized ConexionMsql getInstance(){
        if(instance==null){
            instance= new ConexionMsql();
        }
        return instance;
    }
    
    public Connection getCnn(){
        return cnn;
    }
    
    public void cerrarConexion(){
         instance=null;
    }
    
}
