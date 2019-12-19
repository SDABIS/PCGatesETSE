package baseDatos;


import aplicacion.Cliente;
import aplicacion.Componente;
import aplicacion.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOAsistentes daoAsistentes;
    private DAOComponentes daoComponentes;
    private DAOPCs daoPcs;
    private DAOReparadores daoReparadores;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);

            daoAsistentes = new DAOAsistentes(conexion, fa);
            daoComponentes = new DAOComponentes(conexion, fa);
            daoPcs = new DAOPCs(conexion, fa);
            daoReparadores = new DAOReparadores(conexion, fa);

        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }
        
    }
    
    public java.util.List<Cliente> consultarClientes(String nombre, String id){
        return daoAsistentes.buscaClientes(nombre, id);
    }
    
    public java.util.List<Cliente> consultarTodosClientes(){
        return daoAsistentes.buscaTodosClientes();
    }
    
    public boolean insertaCliente(Cliente c){
        return daoAsistentes.insertaCliente(c);
    }
    
    public java.util.List<Personalizado> obtenerPersonalizados(Cliente c){
        return daoPcs.obtenerPersonalizados(c);
    }
    
    public java.util.List<Componente> listaComponentes(Personalizado p){
        return daoComponentes.listaComponentes(p);
    }
    
    public Personalizado obtenerPersonalizado(int id){
        return daoPcs.obtenerPersonalizado(id);
    }
    
    public void venderPcPersonalizado(Personalizado ps){
        daoPcs.venderPcPersonalizado(ps);
    }

 public ArrayList<Componente> obtenerComponentes(String componente) {
        return daoComponentes.obtenerComponentes(componente);
    }
    
    public void venderComponente(String componente, Cliente c, Empleado e) {
        daoComponentes.venderComponente(componente, c, e);
    }
    
    public int cantidadPcsVentaNombre(String nombre) {
        return daoPcs.cantidadPcsVentaNombre(nombre);
    }
    
    public ArrayList<EjemplarPC> obtenerPcsVenta() {
        return daoPcs.obtenerPcsVenta();
    }
    
    public void venderEjemplarPc(String nombre, Cliente c, Empleado e) {
        daoPcs.venderEjemplarPc(nombre, c ,e);
    }
    
    public ArrayList<PCReparar> obtenerPcsReparados(Cliente c) {
        return daoPcs.obtenerPcsReparados(c);
    }
    
    public double obtenerPrecioReparacion(PCReparar pc) {
        return daoPcs.obtenerPrecioReparacion(pc);
    }
    
    public void devolverReparacion(Cliente c, Empleado e, int id) {
        daoPcs.devolverReparacion(c, e, id);
    }
    
    public void nuevaReparacion(String descripcion, Cliente c, Empleado e) {
        daoPcs.nuevaReparacion(descripcion, c, e);
    }

    public void anadirPc(String nombre, int precio) {
        daoPcs.anadirPc(nombre, precio);
    }
    
    public ArrayList<PCReparar> obtenerReparaciones() {
        return daoReparadores.obtenerReparaciones();
    }

    public ArrayList<String> consultarComponentes(String comp) {
        return daoReparadores.consultarComponentes(comp);
    }

    public double obtenerPrecio(String comp) {
        return daoReparadores.obtenerPrecio(comp);
    }

    public void repararPC(PCReparar pc, Empleado rep) {
        daoReparadores.repararPC(pc, rep);
    }
    
    public Personalizado obtenerPersonalizado(String nombre, Cliente c) {
        return daoPcs.obtenerPersonalizado(nombre, c);
    }

    public Empleado validarAsistente(String nombre, String contrasena) {
        return daoAsistentes.validarAsistente(nombre, contrasena);
    }

    public Empleado validarReparador(String nombre, String contrasena) {
        return daoAsistentes.validarReparador(nombre, contrasena);
    }

    public void borrarPcPersonalizado(String nombre, Cliente c){
        daoPcs.borrarPcPersonalizado(nombre, c);
    }
    
    public String caracteristicasComponente(String nombre, String tipo) {
        return daoComponentes.caracteristicasComponente(nombre, tipo);
    }
    
    public float precioTotalPersonalizado(Personalizado p){
        return daoPcs.precioTotalPersonalizado(p);
    }
    
    public void anadirComponente(String nombre, Componente comp) {
        daoComponentes.anadirComponente(nombre, comp);
    }

    public void anadirEjemplar(String nombre) {
        daoComponentes.anadirEjemplar(nombre);
    }
    
    public void actualizarCliente(Cliente c, Cliente origen){
        daoAsistentes.actualizarCliente(c, origen);
    }
    
    public double obtenerDineroGastadoClienteComponentes(String id) {
        return daoAsistentes.obtenerDineroGastadoClienteComponentes(id);
    }
        
}