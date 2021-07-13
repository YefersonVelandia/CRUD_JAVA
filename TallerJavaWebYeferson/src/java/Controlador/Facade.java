/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.util.List;
import Modelo.dao.ProductoDAO;
import Modelo.dao.SesionDAO;
import Modelo.dao.UsuarioDAO;
import Modelo.dto.ProductoDTO;
import Modelo.dto.SesionDTO;
import Modelo.dto.UsuarioDTO;
/*
@author yeferson Reinel Velandia Arias 20171578037

 */
public class Facade {
    
    public boolean crearProducto(ProductoDTO objP){
        boolean rta = false;
        if(objP!=null){
            ProductoDAO dao = new ProductoDAO();
            rta = dao.Create(objP);
        }
        return rta;
    }
    
    public List<ProductoDTO> listarProductos(){
        List<ProductoDTO> lst = null;
        ProductoDAO dao = new ProductoDAO();
        lst = dao.readAll();
        return lst;
    }
    
    public ProductoDTO verProducto(ProductoDTO item){
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO obj;
        obj=dao.read(item);
        return obj;
    }
    
    public boolean ActualizarProd(ProductoDTO objp){
        boolean rta=false;
        if(objp!=null){
           ProductoDAO dao = new ProductoDAO();
           rta=dao.update(objp);
        }
        return rta;
    }
    
    public boolean EliminarProd(ProductoDTO Objp){
        boolean rta= false;
        if(Objp!=null){
            ProductoDAO dao = new ProductoDAO();
            rta=dao.delete(Objp);
        }
        return rta;
    }
    
    public SesionDTO ValidarSesion(SesionDTO filter){
        SesionDTO obj;
        SesionDAO dao= new SesionDAO();
        obj=dao.read(filter);
        return obj;
        
    }
    
    public boolean crearUsuario(UsuarioDTO objU){
        boolean rta = false;
        if(objU!=null){
            UsuarioDAO dao = new UsuarioDAO();
            rta = dao.Create(objU);
        }
        return rta;
    }
    
    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioDTO> lst = null;
        UsuarioDAO dao = new UsuarioDAO();
        lst = dao.readAll();
        return lst;
    }
    
    public UsuarioDTO verUsuario(UsuarioDTO item){
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioDTO obj;
        obj=dao.read(item);
        return obj;
    }
    
    public boolean ActualizarUsuario(UsuarioDTO obju){
        boolean rta=false;
        if(obju!=null){
           UsuarioDAO dao = new UsuarioDAO();
           rta=dao.update(obju);
        }
        return rta;
    }
    
    public boolean EliminarUsuario(UsuarioDTO Obju){
        boolean rta= false;
        if(Obju!=null){
            UsuarioDAO dao = new UsuarioDAO();
            rta=dao.delete(Obju);
        }
        return rta;
    }
    
}
