/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import gui.ModeloTablaAsistente;

/**
 *
 * @author alumnogreibd
 */
public class GestionCliente {
    FachadaGui fgui;  
    FachadaBaseDatos fbd;
    
    public GestionCliente(FachadaGui fgui, FachadaBaseDatos fbd){  
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public void visualizarCrearUsuario(ModeloTablaAsistente m){
        fgui.visualizarCrearUsuario(m);
    }
    
    public boolean insertaCliente(Cliente c){
        return fbd.insertaCliente(c);
    }
    
    public void actualizarCliente(Cliente c, Cliente origen){
        fbd.actualizarCliente(c, origen);
    }
}
