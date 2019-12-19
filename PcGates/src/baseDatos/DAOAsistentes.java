/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.*;
import java.sql.*;
/**
 *
 * @author alumnogreibd
 */
public class DAOAsistentes extends AbstractDAO{
    
    public DAOAsistentes(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Cliente> buscaTodosClientes(){
        java.util.List<Cliente> resultado = new java.util.ArrayList<Cliente>();
        Connection con;
        PreparedStatement stmCliente = null;
        ResultSet rsCliente;
        
        con = super.getConexion();
        try{
            String consulta = "select id, nombre, clave, direccion, email, telefono" +" from clientes";
            stmCliente = con.prepareStatement(consulta);
            rsCliente = stmCliente.executeQuery();
            while(rsCliente.next()){
                resultado.add(new Cliente(rsCliente.getString("id"), rsCliente.getString("nombre"),
                                                  rsCliente.getString("clave"),rsCliente.getString("email"), rsCliente.getString("direccion"),
                                          rsCliente.getString("telefono")));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmCliente.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }
    
    public java.util.List<Cliente> buscaClientes(String nombre, String id){
        java.util.List<Cliente> resultado = new java.util.ArrayList<Cliente>();
        Connection con;
        PreparedStatement stmCliente = null;
        ResultSet rsCliente;
        
        con = super.getConexion();
        try{
            String consulta = "select id, nombre, clave, direccion, email, telefono" +" from clientes";
            if(!id.isEmpty()){
                consulta = consulta + " where id like '%"+id+"%'";
                if(!nombre.isEmpty()){
                    consulta = consulta + " and nombre like '%"+nombre+"%'";
                }
            }
            else if(!nombre.isEmpty())
                consulta = consulta + " where nombre like '%"+nombre+"%'";
            stmCliente = con.prepareStatement(consulta);
            rsCliente = stmCliente.executeQuery();
            while(rsCliente.next()){
                resultado.add(new Cliente(rsCliente.getString("id"), rsCliente.getString("nombre"),
                                                  rsCliente.getString("clave"),rsCliente.getString("email"), rsCliente.getString("direccion"),
                                          rsCliente.getString("telefono")));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmCliente.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }
    
    public boolean insertaCliente(Cliente c){
        Connection con;
        PreparedStatement stmCliente = null;
        boolean ins = false;
        con = super.getConexion();
        
        try{
        stmCliente=con.prepareStatement("insert into clientes(id, nombre, clave, direccion, email, telefono) "+
                                      "values (?,?,?,?,?,?)");
        
            stmCliente.setString(1, c.getId()); 
            stmCliente.setString(2, c.getNombre());
            stmCliente.setString(3, c.getContrasena());
            stmCliente.setString(4, c.getDireccion());
            stmCliente.setString(5, c.getEmail());
            stmCliente.setString(6, c.getTelefono());
            stmCliente.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage()); 
        }finally{
          try {stmCliente.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
          ins = true;
        }
        return ins;
    }
    

    Empleado validarReparador(String nombre, String contrasena) {
        Empleado resultado = null;
        Connection con;
        PreparedStatement stmEmpleado = null;
        ResultSet rsEmpleado;
        
        con = super.getConexion();
        try{
            String consulta = "select *" +" from empleados "
                    + "where dni = ? and clave = ? and reparador is true";
            stmEmpleado = con.prepareStatement(consulta);
            stmEmpleado.setString(1, nombre);
            stmEmpleado.setString(2, contrasena);
            
            rsEmpleado = stmEmpleado.executeQuery();
            if(rsEmpleado.next()){
                resultado = new Empleado(rsEmpleado.getString("dni"), rsEmpleado.getString("nombre"),
                rsEmpleado.getString("clave"), rsEmpleado.getString("email"), rsEmpleado.getString("direccion"),
                rsEmpleado.getDouble("sueldo"), rsEmpleado.getString("telefono"), rsEmpleado.getBoolean("asistente"),
                rsEmpleado.getBoolean("reparador"), rsEmpleado.getBoolean("jefe"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }

    Empleado validarAsistente(String nombre, String contrasena) {
        Empleado resultado = null;
        Connection con;
        PreparedStatement stmEmpleado = null;
        ResultSet rsEmpleado;
        
        con = super.getConexion();
        try{
            String consulta = "select *" +" from empleados "
                    + "where dni = ? and clave = ? and asistente is true";
            stmEmpleado = con.prepareStatement(consulta);
            stmEmpleado.setString(1, nombre);
            stmEmpleado.setString(2, contrasena);
            
            rsEmpleado = stmEmpleado.executeQuery();
            if(rsEmpleado.next()){
                resultado = new Empleado(rsEmpleado.getString("dni"), rsEmpleado.getString("nombre"),
                rsEmpleado.getString("clave"), rsEmpleado.getString("email"), rsEmpleado.getString("direccion"),
                rsEmpleado.getDouble("sueldo"), rsEmpleado.getString("telefono"), rsEmpleado.getBoolean("asistente"),
                rsEmpleado.getBoolean("reparador"), rsEmpleado.getBoolean("jefe"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }
    
    
    public void actualizarCliente(Cliente c, Cliente origen){
        Connection con;
        PreparedStatement pSt = null;
        
        con=super.getConexion();
        
        try{
            pSt=con.prepareStatement("update clientes "
                    + "set id = ?, "
                    + "nombre = ?, "
                    + "clave = ?, "
                    + "direccion = ?, "
                    + "email = ?, "
                    + "telefono = ?"
                    + "where id like ?");
            pSt.setString(1, c.getId());
            pSt.setString(2, c.getNombre());
            pSt.setString(3, c.getContrasena());
            pSt.setString(4, c.getDireccion());
            pSt.setString(5, c.getEmail());
            pSt.setString(6, c.getTelefono());
            pSt.setString(7, origen.getId());
            
            pSt.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage()); 
        }finally{
          try {pSt.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public double obtenerDineroGastadoClienteComponentes(String id) {
        double resultado = 0;
        Connection con;
        PreparedStatement stmEmpleado = null;
        ResultSet rsEmpleado;
        
        con = super.getConexion();
        try{
            String consulta = "select sum(c.precio) as dinerogastado from componentes c, ejemplarescomponente e "
                    + "where e.componente = c.nombre and e.cliente = ? ";
            stmEmpleado = con.prepareStatement(consulta);
            stmEmpleado.setString(1, id);
            
            rsEmpleado = stmEmpleado.executeQuery();
            while(rsEmpleado.next()){
                resultado += rsEmpleado.getDouble("dinerogastado");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmEmpleado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }
    
}
