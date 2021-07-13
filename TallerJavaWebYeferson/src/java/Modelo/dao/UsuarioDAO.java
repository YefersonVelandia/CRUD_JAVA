/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Conexiones.ConexionMsql;
import Modelo.dto.ProductoDTO;
import Modelo.dto.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class UsuarioDAO {
    private static final String SQL_INSERT = "INSERT INTO tb_usuario "
            +"(nombre1, nombre2, apellido1, apellido2, n_identificacion, correo, clave, sexo, fecha_nac, estado, rol) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM tb_usuario WHERE id_usuario= ?";
    private static final String SQL_UPDATE = "UPDATE tb_usuario SET nombre_usuario = ?, correo_usuario= ?, contraseña_usuario = ? "
            + "WHERE id_usuario = ?";
    private static final String SQL_READ = "SELECT * FROM tb_usuario WHERE id_usuario = ? ";
    private static final String SQL_READALL = "SELECT * FROM tb_usuario";
    private static final ConexionMsql con = ConexionMsql.getInstance();
    
    public boolean Create(UsuarioDTO c){
        try {
            PreparedStatement ps;
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, c.getNombre1());
            ps.setString(2, c.getNombre2());
            ps.setString(3, c.getApellido1());
            ps.setString(4, c.getApellido2());
            ps.setString(5, c.getIdentificacion());
            ps.setString(6, c.getCorreo());
            ps.setString(7, c.getClave());
            ps.setString(8, String.valueOf(c.getSexo()));
            ps.setString(9, c.getFecha_nac());
            ps.setString(10, c.getEstado());
            ps.setString(11, c.getRol());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            
        } finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public List<UsuarioDTO> readAll(){
        List<UsuarioDTO> lst = null;
        PreparedStatement psnt;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs = psnt.executeQuery();
            lst = new ArrayList<>();
            while(rs.next()){
                UsuarioDTO objUsu = new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nombre1"),
                    rs.getString("nombre2"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("n_identificacion"),
                    rs.getString("correo"),
                    rs.getString("clave"),
                    rs.getString("sexo").charAt(0),
                    rs.getString("fecha_nac"),
                    rs.getString("estado"),
                    rs.getString("rol")
                );
                lst.add(objUsu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return lst;
    }
    
    public boolean delete(UsuarioDTO item){
        PreparedStatement ps;
        try{
            ps = con.getCnn().prepareCall(SQL_DELETE);
            ps.setInt(1, item.getId_usu());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
          throw new Error(ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public boolean update(UsuarioDTO item){
        PreparedStatement ps;
        try{
            ps= con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, item.getNombre1());
            ps.setString(2, item.getNombre2());
            ps.setString(3, item.getApellido1());
            ps.setString(4, item.getApellido2());
            ps.setString(5, item.getIdentificacion());
            ps.setString(6, item.getCorreo());
            ps.setString(7, item.getClave());
            ps.setString(8, String.valueOf(item.getSexo()));
            ps.setString(9, item.getFecha_nac());
            ps.setString(10, item.getEstado());
            ps.setString(11, item.getRol());
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println("Error al Actualizar");
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    
    public UsuarioDTO read(UsuarioDTO filter){
        UsuarioDTO objRes = null;
        PreparedStatement psnt;
        try{
            psnt=con.getCnn().prepareStatement(SQL_READ);
            psnt.setInt(1, filter.getId_usu());
            ResultSet rs = psnt.executeQuery();
            while(rs.next()){
                objRes= new UsuarioDTO(
                        rs.getInt("id"),
                        rs.getString("nombre1"),
                        rs.getString("nombre2"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("n_identificacion"),
                        rs.getString("correo"),
                        rs.getString("clave"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("fecha_nac"),
                        rs.getString("estado"),
                        rs.getString("rol")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return objRes;
    }
}
