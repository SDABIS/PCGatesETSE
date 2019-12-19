/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import aplicacion.Cliente;
import aplicacion.Componente;
import aplicacion.FachadaAplicacion;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaAsistente extends AbstractTableModel{
    private java.util.List<Cliente> clientes;
    private FachadaAplicacion fa;

    public ModeloTablaAsistente(FachadaAplicacion fa){
        this.clientes = new java.util.ArrayList<>();
        this.fa = fa;
    }

    public int getColumnCount (){
        return 6;
    }

    public int getRowCount(){
        return clientes.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "ID"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre="Correo"; break;
            case 3: nombre="Telefono"; break;
            case 4: nombre="Direccion"; break;
            case 5: nombre = "Cantidad Gastada"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase= java.lang.String.class; break;
            case 4: clase=java.lang.String.class; break;
            case 5: clase=java.lang.Double.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    public Object getValueAt(int row, int col){
        Object resultado=null;
        switch (col){
            case 0: resultado= clientes.get(row).getId(); break;
            case 1: resultado= clientes.get(row).getNombre(); break;
            case 2: resultado=clientes.get(row).getEmail();break;
            case 3: resultado=clientes.get(row).getTelefono();break;
            case 4: resultado=clientes.get(row).getDireccion();break;
            case 5: resultado=fa.obtenerDineroGastadoClienteComponentes(clientes.get(row).getId());break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Cliente> clientes){
        this.clientes=clientes;
        fireTableDataChanged();
    }

    public Cliente obtenerCliente(int i){
        return this.clientes.get(i);
    }

}
