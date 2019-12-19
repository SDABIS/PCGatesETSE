/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Cliente;
import aplicacion.Empleado;
import aplicacion.PCReparar;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VAsistente vas;
    VStock vs;
    VReparador vr;
    VLogin vl;
    VEditarUsuario ve;
    VDespachar vd;
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
     this.vl = new VLogin(fa);
   } 
    
    
    
    public void iniciaVista(){
      this.vl.setVisible(true);
    }
    
    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
       
       va = new VAviso(vl, true, txtExcepcion);
       va.setVisible(true);
    }
    
    public void visualizarCrearUsuario(ModeloTablaAsistente m){
        VCrearUsuario vc;
        vc = new VCrearUsuario(vas, true, fa, m);
        vc.setVisible(true);
    }
    
    public void visualizarDespachar(Cliente c, Empleado e){
        vd = new VDespachar(vas, true, fa, c, e);
        vd.setVisible(true);
    }
    
    public void abrirAsistentes() {
        vas = new VAsistente(fa);
        vas.setVisible(true);
    }

    public void abirStock() {
        vs = new VStock(vas, true, fa);
        vs.setVisible(true);
    }
    
    public void abrirReparadores(java.util.List<PCReparar> reparaciones) {               
        this.vr = new VReparador(fa, reparaciones);
        this.vr.setVisible(true);
    }

    public void abrirReparadores(java.util.List<PCReparar> reparaciones,Empleado rep) {               
        this.vr = new VReparador(fa, reparaciones, rep);
        this.vr.setVisible(true);
    }

    public void abrirAsistentes(Empleado as) {
        vas = new VAsistente(fa, as);
        vas.setVisible(true);
    }
    
    public void iniciaEditarUsuario(Cliente c, ModeloTablaAsistente m){
        ve = new VEditarUsuario(vas, true, fa, c, m);
        ve.setVisible(true);
    }
}
