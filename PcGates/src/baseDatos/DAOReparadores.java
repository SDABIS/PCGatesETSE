/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Cliente;
import aplicacion.Empleado;
import aplicacion.PCReparar;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
public class DAOReparadores extends AbstractDAO {
    
    public DAOReparadores(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    ArrayList<PCReparar> obtenerReparaciones() {
        java.util.ArrayList<PCReparar> resultado = new java.util.ArrayList();
        Connection con;
        PreparedStatement stmRep = null;
        ResultSet rsRep;
        
        con = super.getConexion();
        try{
            String consulta = "select pc, cliente, descripcion" +" from areparar "
                    + "where fecharetirada is null "
                    + "and pc not in (select pc from reparar)";
            stmRep = con.prepareStatement(consulta);
            rsRep = stmRep.executeQuery();
            while(rsRep.next()){
                Cliente cliente = new Cliente(rsRep.getString("cliente"), null, null, null, null, null);
                resultado.add(new PCReparar(rsRep.getInt("pc"), rsRep.getString("descripcion"), cliente));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmRep.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }

    ArrayList<String> consultarComponentes(String comp) {
        java.util.ArrayList<String> resultado = new java.util.ArrayList();
        Connection con;
        PreparedStatement stmRep = null;
        ResultSet rsRep;
        
        con = super.getConexion();
        try{
            String consulta = "select componente from " + comp;
            stmRep = con.prepareStatement(consulta);
            rsRep = stmRep.executeQuery();
            while(rsRep.next()){
                resultado.add(rsRep.getString("componente"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmRep.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }

    double obtenerPrecio(String comp) {
        double resultado = 0;
        Connection con;
        PreparedStatement stmRep = null;
        ResultSet rsRep;
        
        con = super.getConexion();
        try{
            String consulta = "select precio from componentes where nombre = ?";
            stmRep = con.prepareStatement(consulta);
            stmRep.setString(1, comp);
            rsRep = stmRep.executeQuery();
            while(rsRep.next()){
                resultado = rsRep.getDouble("precio");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmRep.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }

    void repararPC(PCReparar pc, Empleado rep) {
        Connection con;
        PreparedStatement stmRep = null;
        
        con = super.getConexion();
        try{
            String consulta = "insert into reparar values(?, ?, ?, now(), ?)";
            stmRep = con.prepareStatement(consulta);
            stmRep.setInt(1, pc.getId());
            stmRep.setString(2, rep.getDni());
            stmRep.setString(3, pc.getComponente().getNombre());
            stmRep.setDouble(4, pc.getPrecio());
            stmRep.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmRep.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}
