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
public class GestionPersonalizados {
    FachadaGui fgui;  
    FachadaBaseDatos fbd;
    
    public GestionPersonalizados(FachadaGui fgui, FachadaBaseDatos fbd){  
     this.fgui=fgui;
     this.fbd=fbd;
    } 
    
    public java.util.List<Personalizado> obtenerPersonalizados(Cliente c){
        return fbd.obtenerPersonalizados(c);
    }
    
    public java.util.List<Componente> listaComponentes(Personalizado p){
        return fbd.listaComponentes(p);
    }
    
    public Personalizado obtenerPersonalizado(int id){
        return fbd.obtenerPersonalizado(id);
    }
    
    public void venderPcPersonalizado(Personalizado ps){
        fbd.venderPcPersonalizado(ps);
    }
    
    public Personalizado obtenerPersonalizado(String nombre, Cliente c) {
        return fbd.obtenerPersonalizado(nombre, c);
    }
    
    public void borraPcPersonalizado(String nombre, Cliente c){
        fbd.borrarPcPersonalizado(nombre, c);
    }
    
    public float precioTotalPersonalizado(Personalizado p){
        return fbd.precioTotalPersonalizado(p);
    }
}
