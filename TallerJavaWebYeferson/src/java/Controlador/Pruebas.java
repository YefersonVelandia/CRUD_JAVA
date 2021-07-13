    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.util.List;
import Modelo.dto.ProductoDTO;

/*
@author yeferson Reinel Velandia Arias 20171578037

 */
public class Pruebas {
    public static void main(String[] args) {
        Facade obj = new Facade();
        List<ProductoDTO> lst = null;
        lst=obj.listarProductos();
        if(lst != null){
            for(ProductoDTO producto : lst){
                System.out.println(producto);
            }
        }else{
            System.out.println("No hay productos");
        }
    }
}
