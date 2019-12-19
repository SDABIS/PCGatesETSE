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
import aplicacion.Empleado;
import aplicacion.FachadaAplicacion;
import aplicacion.GPU;
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
public class DAOComponentes extends AbstractDAO{
    
    private FachadaAplicacion fa;

    public DAOComponentes (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
        this.fa = fa;
    }
    
    public ArrayList<Componente> obtenerComponentes(String componente) {
        
        ArrayList<Componente> resultado=new ArrayList<>();
        Connection con;
        PreparedStatement statement=null;
        ResultSet rs;

        con=this.getConexion();
        
        
        try {
            
            statement=con.prepareStatement("select c.nombre, c.marca, c.precio, c.descripcion, count(e.componente) as cantidad "+
                                            "from componentes as c "+
                                            "inner join " + componente + " as x " +
                                            "left join ejemplarescomponente as e "+
                                            "on e.componente = x.componente " +
                                            "on c.nombre = x.componente " +
                                            "group by c.nombre, c.marca, c.precio, c.descripcion, e.cliente " + 
                                            "having e.cliente is null");

            rs=statement.executeQuery();
            while (rs.next())
            {
                resultado.add(new Componente(rs.getString("nombre"), rs.getDouble("precio"),
                                             rs.getString("marca"), rs.getString("descripcion"), rs.getInt("cantidad")));

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
    
    public void venderComponente(String componente, Cliente c, Empleado em) {
        
        Connection con;
        PreparedStatement statement=null;
        ResultSet rs;
        con=this.getConexion();
        
        try {
            statement=con.prepareStatement("update ejemplarescomponente " +
                                           "set cliente = ?, empleado = ?, fechaclientecompraejemplar = ? " + 
                                           "where componente = ? " + 
                                           "and id = (select min(id) from ejemplarescomponente where componente = ? and cliente is null)");
            statement.setString(1, c.getId());
            statement.setString(2, em.getDni());
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            statement.setString(4, componente);
            statement.setString(5, componente);
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
    
    public java.util.List<Componente> listaComponentes(Personalizado p){
        Connection con;
        PreparedStatement stPer = null;
        ResultSet rsPer;
        java.util.List<Componente> resultado = new java.util.ArrayList<>();
        
        con=super.getConexion();
        
        try{
            String consulta = "select c.nombre, c.precio, c.marca, c.descripcion "+
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
                resultado.add(new Componente(rsPer.getString("nombre"), rsPer.getDouble("precio"), rsPer.getString("marca"),rsPer.getString("descripcion")));
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stPer.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }   
        return resultado;
    }
    
    public String caracteristicasComponente(String nombre, String tipo) {
        
        String resultado=null;
        Connection con;
        PreparedStatement statement=null;
        ResultSet rs;

        con=this.getConexion();
        
        
        try {
            
            if(tipo.equals("gpu")) {
                statement=con.prepareStatement("select * from gpus where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    GPU gpu = new GPU(rs.getInt("nucleos"), rs.getDouble("frecuencia"), rs.getInt("procesofabricacion"), rs.getString("componente"), 0, null, null);
                    resultado = gpu.toString();
                }
                
            }
            
            else if(tipo.equals("cpu")) {
                statement=con.prepareStatement("select * from cpus where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    CPU cpu = new CPU(rs.getString("sockets"), rs.getInt("cores"), rs.getInt("threads"), rs.getDouble("frecuencia"), rs.getDouble("tdp"), rs.getString("microarquitectura"), null, 0, null, null);
                    resultado = cpu.toString();
                } 
            }
            
            else if(tipo.equals("ram")) {
                statement=con.prepareStatement("select * from rams where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    RAM ram = new RAM(rs.getString("tipoddr"),rs.getDouble("memoria"), rs.getDouble("frecuencia"), rs.getString("formato"), null, 0, null, null);
                    resultado = ram.toString();
                } 
            }
            
            else if(tipo.equals("discoduro")) {
                statement=con.prepareStatement("select * from discosduros where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    DiscoDuro disco = new DiscoDuro(rs.getString("tipo"), rs.getDouble("velocidad"), rs.getInt("capacidad"), null, 0, null, null);
                    resultado = disco.toString();
                } 
            }
            else if(tipo.equals("alimentacion")) {
                statement=con.prepareStatement("select * from alimentacion where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    Alimentacion alim = new Alimentacion(rs.getDouble("potencia"), rs.getBoolean("modular"), null, 0, null, null);
                    resultado = alim.toString();
                } 
            }
            
            else if(tipo.equals("refrigeracion")) {
                statement=con.prepareStatement("select * from refrigeracion where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    Refrigeracion refrig = new Refrigeracion(rs.getString("tipo"), rs.getInt("tamano"), null, 0, null, null);
                    resultado = refrig.toString();
                } 
            }
            
            else if(tipo.equals("placabase")) {
                statement=con.prepareStatement("select * from placasbase where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    PlacaBase placa = new PlacaBase(rs.getString("chipset"), rs.getDouble("tamano"), null, 0, null, null);
                    resultado = placa.toString();
                } 
            }
            
            else if(tipo.equals("periferico")) {
                statement=con.prepareStatement("select * from perifericos where componente = ?");
                statement.setString(1, nombre);
                rs = statement.executeQuery();
                if(rs.next()){
                    Periferico perif = new Periferico(rs.getString("tipo"), null, 0, null, null);
                    resultado = perif.toString();
                } 
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
    
    void anadirComponente(String tipo, Componente comp) {
        Connection con;
        PreparedStatement stmComp1 = null, stmComp2 = null, stmComp3 = null, stmComp4 = null;
        ResultSet rs1;
        con=this.getConexion();
        boolean existe = true;
        
        String nombre = comp.getNombre();
        String marca = comp.getMarca();
        double precio = comp.getPrecio();
        String descripcion = comp.getDescripcion();
        try {
            con.setAutoCommit(false);
            
            stmComp1=con.prepareStatement("select nombre from componentes where nombre = ?");
            stmComp1.setString(1, nombre);
            rs1 = stmComp1.executeQuery();
            
            if(!rs1.next()) {
           
                existe = false;
                stmComp2 = con.prepareStatement("insert into componentes values(?, ?, ?, ?)");
                stmComp2.setString(1, nombre);
                stmComp2.setString(2, marca);
                stmComp2.setDouble(3, precio);
                stmComp2.setString(4, descripcion);
                
                stmComp2.executeUpdate();
                
                /*stmComp4 = con.prepareStatement("insert into " + componente + "(componente) values(?)");
                stmComp4.setString(1, nombre);
                
                stmComp4.executeUpdate();*/
            }
            else {
                existe = true;
                stmComp2 = con.prepareStatement("update componentes "
                        + "set marca = ?, precio = ?, descripcion = ?"
                        + "where nombre = ?");
                stmComp2.setString(1, marca);
                stmComp2.setDouble(2, precio);
                stmComp2.setString(3, descripcion);
                stmComp2.setString(4, nombre);
            }
            
            switch(tipo) {
                case "cpus":
                    CPU cpu = (CPU)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into cpus "
                                + "values(?, ?, ?, ?, ?, ?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setString(2, cpu.getSockets());
                        stmComp3.setInt(3, cpu.getCores());
                        stmComp3.setInt(4, cpu.getThreads());
                        stmComp3.setDouble(5, cpu.getFrecuencia());
                        stmComp3.setDouble(6, cpu.getTdp());
                        stmComp3.setString(7, cpu.getMicroarquitectura());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update cpus "
                                + "set sockets = ?, cores = ?, threads = ?, frecuencia = ?, tdp = ?, microarquitectura = ? "
                                + "where componente = ?");

                        stmComp3.setString(1, cpu.getSockets());
                        stmComp3.setInt(2, cpu.getCores());
                        stmComp3.setInt(3, cpu.getThreads());
                        stmComp3.setDouble(4, cpu.getFrecuencia());
                        stmComp3.setDouble(5, cpu.getTdp());
                        stmComp3.setString(6, cpu.getMicroarquitectura());
                        stmComp3.setString(7, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
                case "alimentacion":
                    Alimentacion alimentacion = (Alimentacion)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into alimentacion "
                                + "values(?, ?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setDouble(2, alimentacion.getPotencia());
                        stmComp3.setBoolean(3, alimentacion.getModular());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update alimentacion "
                                + "set potencia = ?, modular = ? "
                                + "where componente = ?");
                        
                        stmComp3.setDouble(1, alimentacion.getPotencia());
                        stmComp3.setBoolean(2, alimentacion.getModular());
                        stmComp3.setString(3, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
                case "discosduros":
                    DiscoDuro discoduro = (DiscoDuro)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into discosduros "
                                + "values(?, ?, ?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setString(2, discoduro.getTipo());
                        stmComp3.setInt(3, discoduro.getCapacidad());
                        stmComp3.setDouble(4, discoduro.getVelocidad());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update discosduros "
                                + "set tipo = ?, capacidad = ?, velocidad = ? "
                                + "where componente = ?");
                        stmComp3.setString(1, discoduro.getTipo());
                        stmComp3.setInt(2, discoduro.getCapacidad());
                        stmComp3.setDouble(3, discoduro.getVelocidad());
                        stmComp3.setString(4, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
                case "gpus":
                    GPU gpu = (GPU)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into gpus "
                                + "values(?, ?, ?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setInt(2, gpu.getNucleos());
                        stmComp3.setDouble(3, gpu.getFrecuencia());
                        stmComp3.setInt(4, gpu.getProcesoFabricacion());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update gpus "
                                + "set nucleos = ?, frecuencia = ?, procesofabricacion = ? "
                                + "where componente = ?");
                        
                        stmComp3.setInt(1, gpu.getNucleos());
                        stmComp3.setDouble(2, gpu.getFrecuencia());
                        stmComp3.setInt(3, gpu.getProcesoFabricacion());
                        stmComp3.setString(4, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
                   case "perifericos":
                    Periferico periferico = (Periferico)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into perifericos "
                                + "values(?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setString(2, periferico.getTipo());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update perifericos "
                                + "set tipo = ? "
                                + "where componente = ?");
                        
                        stmComp3.setString(1, periferico.getTipo());
                        stmComp3.setString(2, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
                case "placasbase":
                    PlacaBase placabase = (PlacaBase)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into placasbase "
                                + "values(?, ?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setString(2, placabase.getChipset());
                        stmComp3.setDouble(3, placabase.getTamano());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update placasbase "
                                + "set chipset = ?, tamano = ? "
                                + "where componente = ?");
                        
                        stmComp3.setString(1, placabase.getChipset());
                        stmComp3.setDouble(2, placabase.getTamano());
                        stmComp3.setString(3, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
                case "rams":
                    RAM ram = (RAM)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into rams "
                                + "values(?, ?, ?, ?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setString(2, ram.getTipoddr());
                        stmComp3.setDouble(3, ram.getMemoria());
                        stmComp3.setDouble(4, ram.getFrecuencia());
                        stmComp3.setString(5, ram.getFormato());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update rams "
                                + "set tipoddr = ?, memoria = ?, frecuencia= ?, formato = ? "
                                + "where nombre = ?");
                        
                        stmComp3.setString(1, ram.getTipoddr());
                        stmComp3.setDouble(2, ram.getMemoria());
                        stmComp3.setDouble(3, ram.getFrecuencia());
                        stmComp3.setString(4, ram.getFormato());
                        stmComp3.setString(5, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
                case "refrigeracion":
                    Refrigeracion refrigeracion = (Refrigeracion)comp;
                    if(!existe) {
                        stmComp3 = con.prepareStatement("insert into refrigeracion "
                                + "values(?, ?, ?)");
                        stmComp3.setString(1, nombre);
                        stmComp3.setString(2, refrigeracion.getTipo());
                        stmComp3.setInt(3, refrigeracion.getTamano());
                        
                        stmComp3.executeUpdate();
                    }

                    else {
                        stmComp3 = con.prepareStatement("update refrigeracion "
                                + "set tipo = ?, tamano = ? "
                                + "where componente = ?");
                        stmComp3.setString(1, refrigeracion.getTipo());
                        stmComp3.setInt(2, refrigeracion.getTamano());
                        stmComp3.setString(3, nombre);
                        
                        stmComp3.executeUpdate();
                    }
                break;
            }
            
            stmComp4 = con.prepareStatement("insert into ejemplarescomponente(componente, fechatiendacompraejemplar)"
                    + " values(?, now())");
            stmComp4.setString(1, nombre);
            
            stmComp4.executeUpdate();
            
            con.commit();
            
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            
            try {
                con.rollback();
            }
            catch(SQLException se) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(se.getMessage());
            }
        }
        finally{
            try {con.setAutoCommit(true); } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    void anadirEjemplar(String nombre) {
        Connection con;
        PreparedStatement stmComp1 = null;
        con=this.getConexion();
        
        try {
            
            stmComp1=con.prepareStatement("insert into ejemplarescomponente(id, componente, fechatiendacompraejemplar) "
                    + "values(DEFAULT, ?, now())");
            stmComp1.setString(1, nombre);
            stmComp1.executeUpdate();
            
            
        } 
            catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            
        }
        finally{
            try {stmComp1.close(); } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
}
