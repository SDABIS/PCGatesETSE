/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
/**
 *
 * @author alumnogreibd
 */
public class GestionAsistentes {
    FachadaGui fgui;  
    FachadaBaseDatos fbd;
    
    public GestionAsistentes(FachadaGui fgui, FachadaBaseDatos fbd){  
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public java.util.List<Cliente> consultarClientes(String nombre, String id){
        return fbd.consultarClientes(nombre, id);
    }
    
    public java.util.List<Cliente> consultarTodosClientes(){
        return fbd.consultarTodosClientes();
    }
    
    public void visualizarDespachar(Cliente c, Empleado e){
        fgui.visualizarDespachar(c, e);
    }
}
