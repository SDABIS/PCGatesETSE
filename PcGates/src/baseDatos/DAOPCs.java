/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Alimentacion;
import aplicacion.CPU;
import aplicacion.Cliente;
import aplicacion.Componente;
import aplicacion.DiscoDuro;
import aplicacion.EjemplarPC;
import aplicacion.Empleado;
import aplicacion.FachadaAplicacion;
import aplicacion.GPU;
import aplicacion.PCReparar;
import aplicacion.Periferico;
import aplicacion.Personalizado;
import aplicacion.PlacaBase;
import aplicacion.RAM;
import aplicacion.Refrigeracion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
public class DAOPCs extends AbstractDAO{
    
    private FachadaAplicacion fa;

    public DAOPCs (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
        this.fa = fa;
        
    }
    
    public int cantidadPcsVentaNombre(String nombre) {
       
        int resultado = -1;
        Connection con;
        PreparedStatement statement=null;
        ResultSet rs;

        con=this.getConexion();
        
        try {
            
            statement=con.prepareStatement("select count(*) as numero " + 
                                           "from ejemplaresventa " + 
                                           "where cliente is null " + 
                                           "and nombre = ?");
            statement.setString(1, nombre);
            rs=statement.executeQuery();
            if(rs.next()) resultado = rs.getInt("numero");
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
            try {statement.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public ArrayList<EjemplarPC> obtenerPcsVenta() {
        
        ArrayList<EjemplarPC> resultado=new ArrayList<>();
        Connection con;
        PreparedStatement statement=null;
        ResultSet rs;

        con=this.getConexion();
        
        
        try {
            
            statement=con.prepareStatement("select min(pc) as pc, nombre, precio " +
                                           "from ejemplaresventa " +
                                           "where cliente is null " +
                                           "group by nombre, precio");

            rs=statement.executeQuery();
            while (rs.next())
            {
                resultado.add(new EjemplarPC(rs.getInt("pc"), rs.getString("nombre"), rs.getDouble("precio")));

            }
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
            try {statement.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
        
    }
    
    public void venderEjemplarPc(String nombre, Cliente c, Empleado em) {
        
        Connection con;
        PreparedStatement statement=null;
        con=this.getConexion();
        
        
        try {
            
            statement=con.prepareStatement("update ejemplaresventa " +
                                           "set cliente = ?, empleado = ?, fechacomprapc = ? " + 
                                           "where nombre = ? " + 
                                           "and pc = (select min(pc) from ejemplaresventa where nombre = ? and cliente is null)");
            statement.setString(1, c.getId());
            statement.setString(2, em.getDni());
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            statement.setString(4, nombre);
            statement.setString(5, nombre);
            statement.executeUpdate();
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
          try {statement.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public ArrayList<PCReparar> obtenerPcsReparados(Cliente c) {
        
        ArrayList<PCReparar> resultado=new ArrayList<>();
        Connection con;
        PreparedStatement statement1=null;
        ResultSet rs1;
        con=this.getConexion(); 
        PCReparar pc = null;
        
        try {
            statement1=con.prepareStatement("select a.pc, a.descripcion, a.fechaingreso, a.fecharetirada, r.fecha " +
                                            "from areparar a, reparar r " +
                                            "where a.pc in (select pc from reparar where cliente = ?) " +  
                                            "and a.pc = r.pc ");
            statement1.setString(1, c.getId());
            rs1=statement1.executeQuery(); 
               
            while (rs1.next())
            {
                pc = new PCReparar(rs1.getInt("pc"), rs1.getString("descripcion"), rs1.getDate("fechaingreso").toLocalDate(), c, null);
                pc.setFechaReparacion(rs1.getDate("fecha").toLocalDate());
                if(rs1.getDate("fecharetirada") != null) {
                    pc.setFechaRetirada(rs1.getDate("fecharetirada").toLocalDate());
                }
                resultado.add(pc);
            }                
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
            try {
                statement1.close(); 
            } 
            catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
        
    }
    
    public double obtenerPrecioReparacion(PCReparar pc) {
        
        double resultado = -1;
        Connection con;
        PreparedStatement statement=null;
        ResultSet rs;
        con=this.getConexion(); 
        
        try {
            statement=con.prepareStatement("select precio " +
                                           "from reparar " +
                                           "where pc = ?");
            statement.setInt(1, pc.getId());
            rs=statement.executeQuery();          
               
            if (rs.next())
            {
                resultado = rs.getDouble("precio");
            }                
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
            try {
                statement.close(); 
            } 
            catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public void devolverReparacion(Cliente c, Empleado em, int id) {
        
        
        Connection con;
        PreparedStatement statement2=null;
        ResultSet rs;
        con=this.getConexion();
        

        try {
            
            statement2=con.prepareStatement("update areparar " +
                                            "set fecharetirada = ?, empleadoretirada = ? " + 
                                            "where pc = ? ");
            statement2.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            statement2.setString(2, em.getDni());
            statement2.setInt(3, id);
            statement2.executeUpdate();
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            if(con != null) {
                try{
                    con.rollback();
                }catch(SQLException ex){
                    System.out.println("Problema con el rollback");
                }
            }
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
          try {statement2.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
    }
    
    public void nuevaReparacion(String descripcion, Cliente c, Empleado em) {
        
         Connection con;
        PreparedStatement statement1=null;
        PreparedStatement statement3 = null;
        PreparedStatement statement2=null;
        con=this.getConexion();
        int id = -1;

        try {
            con.setAutoCommit(false);
            statement1 = con.prepareStatement("insert into pcs " + 
                                              "values (DEFAULT)");
            statement1.executeUpdate();
            
            statement3 = con.prepareStatement("select id from pcs order by id desc limit 1");
            ResultSet rs3 = statement3.executeQuery();
            
            if(rs3.next()) {
                id = rs3.getInt("id");
            }
            
            statement2=con.prepareStatement("insert into areparar (pc, descripcion, cliente, fechaingreso, empleadoingreso) " +
                                            "values(?, ?,?,?,?)");
            statement2.setInt(1, id);
            statement2.setString(2, descripcion);
            statement2.setString(3, c.getId());
            statement2.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            statement2.setString(5, em.getDni());
            statement2.executeUpdate();
            con.commit();
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            if(con != null) {
                try{
                    con.rollback();
                }catch(SQLException ex){
                    System.out.println("Problema con el rollback");
                }
            }
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
          try {statement1.close(); statement2.close(); con.setAutoCommit(true);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
    }
    
    public java.util.List<Personalizado> obtenerPersonalizados(Cliente c){
        Connection con;
        PreparedStatement stmPer = null;
        ResultSet rsPer;
        java.util.List<Personalizado> resultado = new java.util.ArrayList<>();
        
        con=super.getConexion();
        
        try{
        stmPer=con.prepareStatement("select pc,nombre, placabase, cpu, gpu, numgpus, ram, numrams, discoduro1, numdiscoduro1, "
                + "discoduro2, numdiscoduro2, alimentacion, refrigeracion1, refrigeracion2, periferico1, "
                + "periferico2, periferico3, periferico4" + " from personalizados " + "where cliente like ?");
        stmPer.setString(1, c.getId());
        rsPer = stmPer.executeQuery();
        while(rsPer.next()){
            PlacaBase pb = null;
            if(rsPer.getString("placabase")!=null)
                pb = new PlacaBase(null, 0,rsPer.getString("placabase"), 0, null, null);
            CPU cpu = null;
            if(rsPer.getString("cpu")!=null)
                cpu = new CPU(null, 0, 0, 0, 0, null, rsPer.getString("cpu"), 0, null, null);
            GPU gpu = null;
            if(rsPer.getString("gpu")!=null)
                gpu = new GPU(0, 0, 0, rsPer.getString("gpu"), 0, null, null);
            RAM ram = null;
            if(rsPer.getString("ram")!=null)
                ram = new RAM(null, 0, 0, null, rsPer.getString("ram"), 0, null, null);
            DiscoDuro d1 = null;
            if(rsPer.getString("discoduro1")!=null)
                d1 = new DiscoDuro(null, 0, 0, rsPer.getString("discoduro1"), 0, null, null);
            DiscoDuro d2 = null;
            if(rsPer.getString("discoduro2")!=null)
                d2 = new DiscoDuro(null, 0, 0, rsPer.getString("discoduro2"), 0, null, null);
            Alimentacion al = null;
            if(rsPer.getString("alimentacion")!=null)
                al = new Alimentacion(0, false, rsPer.getString("alimentacion"), 0, null, null);
            Refrigeracion ref = null;
            if(rsPer.getString("refrigeracion1")!=null)
                ref = new Refrigeracion(null, 0, rsPer.getString("refrigeracion1"), 0, null, null);
            Refrigeracion ref2 = null;
            if(rsPer.getString("refrigeracion2")!=null)
                ref2 = new Refrigeracion(null, 0, rsPer.getString("refrigeracion2"), 0, null, null);
            Periferico per1 = null;
            if(rsPer.getString("periferico1")!=null)
                per1 = new Periferico(null, rsPer.getString("periferico1"), 0, null, null);
            Periferico per2 = null;
            if(rsPer.getString("periferico2")!=null)
                per2 = new Periferico(null, rsPer.getString("periferico2"), 0, null, null);
            Periferico per3 = null;
            if(rsPer.getString("periferico3")!=null)
                per3 = new Periferico(null, rsPer.getString("periferico3"), 0, null, null);
            Periferico per4 = null;
            if(rsPer.getString("periferico4")!=null)
                per4 = new Periferico(null, rsPer.getString("periferico4"), 0, null, null);
            resultado.add(new Personalizado(rsPer.getInt("pc"), rsPer.getString("nombre"), c, pb, cpu, gpu, rsPer.getInt("numgpus"), ram, rsPer.getInt("numrams"), 
                            d1, rsPer.getInt("numdiscoduro1"), d2, rsPer.getInt("numdiscoduro2"), 
                            al, ref, ref2, per1, per2, per3, per4));
        }
        
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage()); 
        }finally{
          try {stmPer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Personalizado obtenerPersonalizado(int id){
        Connection con;
        PreparedStatement stmPer = null;
        ResultSet rsPer;
        Personalizado resultado = null;
        
        con=super.getConexion();
        
        try{
        stmPer=con.prepareStatement("select pc,nombre, placabase, cpu, gpu, numgpus, ram, numrams, discoduro1, numdiscoduro1, "
                + "discoduro2, numdiscoduro2, alimentacion, refrigeracion1, refrigeracion2, periferico1, "
                + "periferico2, periferico3, periferico4" + " from personalizados " + "where pc=?");
        stmPer.setInt(1, id);
        rsPer = stmPer.executeQuery();
        while(rsPer.next()){
            PlacaBase pb = null;
            if(rsPer.getString("placabase")!=null)
                pb = new PlacaBase(null, 0,rsPer.getString("placabase"), 0, null, null);
            CPU cpu = null;
            if(rsPer.getString("cpu")!=null)
                cpu = new CPU(null, 0, 0, 0, 0, null, rsPer.getString("cpu"), 0, null, null);
            GPU gpu = null;
            if(rsPer.getString("gpu")!=null)
                gpu = new GPU(0, 0, 0, rsPer.getString("gpu"), 0, null, null);
            RAM ram = null;
            if(rsPer.getString("ram")!=null)
                ram = new RAM(null, 0, 0, null, rsPer.getString("ram"), 0, null, null);
            DiscoDuro d1 = null;
            if(rsPer.getString("discoduro1")!=null)
                d1 = new DiscoDuro(null, 0, 0, rsPer.getString("discoduro1"), 0, null, null);
            DiscoDuro d2 = null;
            if(rsPer.getString("discoduro2")!=null)
                d2 = new DiscoDuro(null, 0, 0, rsPer.getString("discoduro2"), 0, null, null);
            Alimentacion al = null;
            if(rsPer.getString("alimentacion")!=null)
                al = new Alimentacion(0, false, rsPer.getString("alimentacion"), 0, null, null);
            Refrigeracion ref = null;
            if(rsPer.getString("refrigeracion1")!=null)
                ref = new Refrigeracion(null, 0, rsPer.getString("refrigeracion1"), 0, null, null);
            Refrigeracion ref2 = null;
            if(rsPer.getString("refrigeracion2")!=null)
                ref2 = new Refrigeracion(null, 0, rsPer.getString("refrigeracion2"), 0, null, null);
            Periferico per1 = null;
            if(rsPer.getString("periferico1")!=null)
                per1 = new Periferico(null, rsPer.getString("periferico1"), 0, null, null);
            Periferico per2 = null;
            if(rsPer.getString("periferico2")!=null)
                per2 = new Periferico(null, rsPer.getString("periferico2"), 0, null, null);
            Periferico per3 = null;
            if(rsPer.getString("periferico3")!=null)
                per3 = new Periferico(null, rsPer.getString("periferico3"), 0, null, null);
            Periferico per4 = null;
            if(rsPer.getString("periferico4")!=null)
                per4 = new Periferico(null, rsPer.getString("periferico4"), 0, null, null);
            resultado = new Personalizado(rsPer.getInt("pc"), rsPer.getString("nombre"), null, pb, cpu, gpu, rsPer.getInt("numgpus"), ram, rsPer.getInt("numrams"), 
                            d1, rsPer.getInt("numdiscoduro1"), d2, rsPer.getInt("numdiscoduro2"), 
                            al, ref, ref2, per1, per2, per3, per4);
        }
        
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage()); 
        }finally{
          try {stmPer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    void anadirPc(String nombre, int precio) {
        Connection con;
        PreparedStatement stmPc1 = null, stmPc2 = null, stmPc3 = null;
        ResultSet rs2;
        con=this.getConexion();
        
        try {
            con.setAutoCommit(false);
            
            stmPc1=con.prepareStatement("insert into pcs values(DEFAULT)");
            stmPc1.executeUpdate();
            
            stmPc2 = con.prepareStatement("select id from pcs order by id desc limit 1");
            rs2 = stmPc2.executeQuery();
            
            int id = 0;
            if(rs2.next()) {
                id = rs2.getInt("id");
            }
            
            stmPc3=con.prepareStatement("insert into ejemplaresventa(pc, nombre, precio, fechacreacion)"
                    + " values(?, ?, ?, now())");
            stmPc3.setInt(1, id);
            stmPc3.setString(2, nombre);
            stmPc3.setInt(3, precio);
            stmPc3.executeUpdate();
            
            con.commit();
            
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
            try {con.setAutoCommit(true); } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public Personalizado obtenerPersonalizado(String nombre, Cliente c){
        Connection con;
        PreparedStatement stmPer = null;
        ResultSet rsPer;
        Personalizado resultado = null;
        
        con=super.getConexion();
        
        try{
        stmPer=con.prepareStatement("select pc,nombre, numventas, placabase, cpu, gpu, numgpus, ram, numrams, discoduro1, numdiscoduro1, "
                + "discoduro2, numdiscoduro2, alimentacion, refrigeracion1, refrigeracion2, periferico1, "
                + "periferico2, periferico3, periferico4" + " from personalizados " + "where nombre like ? and cliente like ?");
        stmPer.setString(1, nombre);
        stmPer.setString(2, c.getId());
        rsPer = stmPer.executeQuery();
        while(rsPer.next()){
            PlacaBase pb = null;
            if(rsPer.getString("placabase")!=null)
                pb = new PlacaBase(null, 0,rsPer.getString("placabase"), 0, null, null);
            CPU cpu = null;
            if(rsPer.getString("cpu")!=null)
                cpu = new CPU(null, 0, 0, 0, 0, null, rsPer.getString("cpu"), 0, null, null);
            GPU gpu = null;
            if(rsPer.getString("gpu")!=null)
                gpu = new GPU(0, 0, 0, rsPer.getString("gpu"), 0, null, null);
            RAM ram = null;
            if(rsPer.getString("ram")!=null)
                ram = new RAM(null, 0, 0, null, rsPer.getString("ram"), 0, null, null);
            DiscoDuro d1 = null;
            if(rsPer.getString("discoduro1")!=null)
                d1 = new DiscoDuro(null, 0, 0, rsPer.getString("discoduro1"), 0, null, null);
            DiscoDuro d2 = null;
            if(rsPer.getString("discoduro2")!=null)
                d2 = new DiscoDuro(null, 0, 0, rsPer.getString("discoduro2"), 0, null, null);
            Alimentacion al = null;
            if(rsPer.getString("alimentacion")!=null)
                al = new Alimentacion(0, false, rsPer.getString("alimentacion"), 0, null, null);
            Refrigeracion ref = null;
            if(rsPer.getString("refrigeracion1")!=null)
                ref = new Refrigeracion(null, 0, rsPer.getString("refrigeracion1"), 0, null, null);
            Refrigeracion ref2 = null;
            if(rsPer.getString("refrigeracion2")!=null)
                ref2 = new Refrigeracion(null, 0, rsPer.getString("refrigeracion2"), 0, null, null);
            Periferico per1 = null;
            if(rsPer.getString("periferico1")!=null)
                per1 = new Periferico(null, rsPer.getString("periferico1"), 0, null, null);
            Periferico per2 = null;
            if(rsPer.getString("periferico2")!=null)
                per2 = new Periferico(null, rsPer.getString("periferico2"), 0, null, null);
            Periferico per3 = null;
            if(rsPer.getString("periferico3")!=null)
                per3 = new Periferico(null, rsPer.getString("periferico3"), 0, null, null);
            Periferico per4 = null;
            if(rsPer.getString("periferico4")!=null)
                per4 = new Periferico(null, rsPer.getString("periferico4"), 0, null, null);
            resultado = new Personalizado(rsPer.getInt("pc"), rsPer.getString("nombre"), rsPer.getInt("numventas"),null, pb, cpu, gpu, rsPer.getInt("numgpus"), ram, rsPer.getInt("numrams"), 
                            d1, rsPer.getInt("numdiscoduro1"), d2, rsPer.getInt("numdiscoduro2"), 
                            al, ref, ref2, per1, per2, per3, per4);
        }
        
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage()); 
        }finally{
          try {stmPer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    public void borrarPcPersonalizado(String nombre, Cliente c){
        Connection con;
        PreparedStatement pSt = null;
        
        con = super.getConexion();
        
        try {
            pSt = con.prepareStatement("delete from personalizados where nombre like ? and cliente like ?");
            pSt.setString(1, nombre);
            pSt.setString(2, c.getId());
            pSt.executeUpdate();
            
        } 
        catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            
        }
        finally{
          try {pSt.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
    }
    
    public float precioTotalPersonalizado(Personalizado p){
        Connection con;
        PreparedStatement stPer = null;
        ResultSet rsPer;
        float resultado = 0;
        
        con=super.getConexion();
        
        try{
            String consulta = "select sum(c.precio) as precio "+
                    "from componentes as c "
                    + "where c.nombre in (select  placaBase from personalizados where pc="+p.getId()+")";
            if(p.getCpu()!=null)
                consulta = consulta + " or c.nombre in (select  cpu from personalizados where pc="+p.getId()+")";
            if(p.getGpu()!=null)
                consulta = consulta + " or c.nombre in (select  gpu from personalizados where pc="+p.getId()+")";
            if(p.getRam()!=null)
                consulta = consulta + " or c.nombre in (select  ram from personalizados where pc="+p.getId()+")";
            if(p.getDiscoDuro1()!=null)
                consulta = consulta + " or c.nombre in (select  discoduro1 from personalizados where pc="+p.getId()+")";
            if(p.getDiscoDuro2()!=null)
                consulta = consulta + " or c.nombre in (select  discoduro2 from personalizados where pc="+p.getId()+")";
            if(p.getAlimentacion()!=null)
                consulta = consulta + " or c.nombre in (select  alimentacion from personalizados where pc="+p.getId()+")";
            if(p.getRefrigeracion1()!=null)
                consulta = consulta + " or c.nombre in (select  refrigeracion1 from personalizados where pc="+p.getId()+")";
            if(p.getRefrigeracion2()!=null)
                consulta = consulta + " or c.nombre in (select  refrigeracion2 from personalizados where pc="+p.getId()+")";
            if(p.getPeriferico1()!=null)
                consulta = consulta + " or c.nombre in (select  periferico1 from personalizados where pc="+p.getId()+")";
            if(p.getPeriferico2()!=null)
                consulta = consulta + " or c.nombre in (select  periferico2 from personalizados where pc="+p.getId()+")";
            if(p.getPeriferico3()!=null)
                consulta = consulta + " or c.nombre in (select  periferico3 from personalizados where pc="+p.getId()+")";
            if(p.getPeriferico4()!=null)
                consulta = consulta + " or c.nombre in (select  periferico4 from personalizados where pc="+p.getId()+")";
            stPer = con.prepareStatement(consulta);
            rsPer = stPer.executeQuery();
            
            while(rsPer.next()){
                resultado = rsPer.getFloat("precio");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stPer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }
    
    public void venderPcPersonalizado(Personalizado ps){
        Connection con;
        PreparedStatement psP = null;
        PreparedStatement psP2 = null;
        ResultSet rsT;
        int numVentas = 0;
        con=super.getConexion();
         try{
            con.setAutoCommit(false);
            psP=con.prepareStatement("select numventas from personalizados where pc=?");
            psP.setInt(1, ps.getId());
        
            rsT = psP.executeQuery(); 
            if(rsT.next()){
                numVentas = rsT.getInt("numventas");
                numVentas+=1;
                psP2=con.prepareStatement("update personalizados "+
                                            "set numventas=? "+
                                            "where pc=?");
                psP2.setInt(1, numVentas);
                psP2.setInt(2, ps.getId());
                psP2.executeUpdate();
                con.commit();
            }
        } catch (SQLException e){
        System.out.println(e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage()); 
        }finally{
          try {psP.close();con.setAutoCommit(true);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
    
    
