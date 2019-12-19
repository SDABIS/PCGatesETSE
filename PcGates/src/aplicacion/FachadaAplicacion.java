/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import gui.ModeloTablaAsistente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alumnogreibd
 */
public class FachadaAplicacion {
    
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionAsistentes ga;
    GestionCliente gc;
    GestionPersonalizados gp;
    
    public FachadaAplicacion(){
        fgui=new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        ga = new GestionAsistentes(fgui, fbd);
        gc = new GestionCliente(fgui, fbd);
        gp = new GestionPersonalizados(fgui,fbd);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         FachadaAplicacion fa;
     
     fa= new FachadaAplicacion();
     fa.iniciaInterfazUsuario();
 }
 
 public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }
 
 public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }
 
 public java.util.List<Cliente> consultarClientes(String nombre, String id){
     return ga.consultarClientes(nombre, id);
 }
 
 public java.util.List<Cliente> consultarTodosClientes(){
     return ga.consultarTodosClientes();
 }
 
 public void visualizarCrearUsuario(ModeloTablaAsistente m){
     gc.visualizarCrearUsuario(m);
 }
 
 public boolean insertaCliente(Cliente c){
     return gc.insertaCliente(c);
 }
 
 public void visualizarDespachar(Cliente c, Empleado e){
     ga.visualizarDespachar(c, e);
 }
 
 public java.util.List<Personalizado> obtenerPersonalizados(Cliente c){
        return gp.obtenerPersonalizados(c);
 }
 
 public java.util.List<Componente> listaComponentes(Personalizado p){
        return gp.listaComponentes(p);
 }
 
 public Personalizado obtenerPersonalizado(int id){
        return gp.obtenerPersonalizado(id);
    }
 
 public void venderPcPersonalizado(Personalizado ps){
        gp.venderPcPersonalizado(ps);
    }

public ArrayList<Componente> obtenerComponentes(String componente) {
        return fbd.obtenerComponentes(componente);
    }
    
    public void venderComponente(String componente, Cliente c, Empleado e) {
        fbd.venderComponente(componente, c, e);
    }
    
    public int cantidadPcsVentaNombre(String nombre) {
        return fbd.cantidadPcsVentaNombre(nombre);
    }
    
    public ArrayList<EjemplarPC> obtenerPcsVenta() {
        return fbd.obtenerPcsVenta();
    }
    
    public void venderEjemplarPc(String nombre, Cliente c, Empleado e) {
        fbd.venderEjemplarPc(nombre, c, e);
    }
    
    public ArrayList<PCReparar> obtenerPcsReparados(Cliente c) {
        return fbd.obtenerPcsReparados(c);
    }
    
    public double obtenerPrecioReparacion(PCReparar pc) {
        return fbd.obtenerPrecioReparacion(pc);
    }
    
    public void devolverReparacion(Cliente c, Empleado e, int id) {
        fbd.devolverReparacion(c, e, id);
    }
    
    public void nuevaReparacion(String descripcion, Cliente c, Empleado e) {
        fbd.nuevaReparacion(descripcion, c, e);
    }

    public void abrirStock() {
        fgui.abirStock();
    }

    public void anadirPc(String nombre, int precio) {
        fbd.anadirPc(nombre, precio);
    }

    public void abrirAsistentes() {
        fgui.abrirAsistentes();
    }

    public void abrirReparadores() {
        java.util.ArrayList<PCReparar> reparaciones = new java.util.ArrayList();
        reparaciones = fbd.obtenerReparaciones();
        fgui.abrirReparadores(reparaciones);
    }
    
    public java.util.ArrayList<PCReparar> obtenerReparaciones() {
        return fbd.obtenerReparaciones();
    }

    public ArrayList<String> consultarComponentes(String comp) {
        return fbd.consultarComponentes(comp);
    }

    public double obtenerPrecio(String comp) {
        return fbd.obtenerPrecio(comp);
    }

    public void repararPC(PCReparar pc, Empleado rep) {
        fbd.repararPC(pc, rep);
    }

    public Empleado validarAsistente(String nombre, String contrasena) {
        return fbd.validarAsistente(nombre, contrasena);
    }

    public Empleado validarReparador(String nombre, String contrasena) {
        return fbd.validarReparador(nombre, contrasena);
    }

    public Personalizado obtenerPersonalizado(String nombre, Cliente c) {
        return gp.obtenerPersonalizado(nombre, c);
    }
    
    public void borrarPcPersonalizado(String nombre, Cliente c){
        gp.borraPcPersonalizado(nombre, c);
    }

    public void abrirAsistentes(Empleado as) {
        fgui.abrirAsistentes(as);
    }
    
    public void abrirReparadores(Empleado rep) {
        java.util.ArrayList<PCReparar> reparaciones = new java.util.ArrayList();
        reparaciones = fbd.obtenerReparaciones();
        fgui.abrirReparadores(reparaciones, rep);
    }
    
    public String caracteristicasComponente(String nombre, String tipo) {
        return fbd.caracteristicasComponente(nombre, tipo);
    }
    
    public void anadirComponente(String nombre, Componente comp) {
        fbd.anadirComponente(nombre, comp);
    }

    public void anadirEjemplar(String nombre) {
        fbd.anadirEjemplar(nombre);
    }
    
    public float precioTotalPersonalizado(Personalizado p){
        return gp.precioTotalPersonalizado(p);
    }
    
    public void iniciaEditarUsuario(Cliente c, ModeloTablaAsistente m){
        fgui.iniciaEditarUsuario(c, m);
    }
    
    public void actualizarCliente(Cliente c, Cliente origen){
        gc.actualizarCliente(c, origen);
    }
    
    public double obtenerDineroGastadoClienteComponentes(String id) {
        return fbd.obtenerDineroGastadoClienteComponentes(id);
    }
    
}
