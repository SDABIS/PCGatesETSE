/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import aplicacion.Componente;
import aplicacion.PCReparar;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaReparadores extends AbstractTableModel{
    private java.util.List<PCReparar> reparaciones;

    public ModeloTablaReparadores(){
        this.reparaciones = new java.util.ArrayList<>();
    }

    public int getColumnCount (){
        return 3;
    }

    public int getRowCount(){
        return reparaciones.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "ID Usuario"; break;
            case 1: nombre= "Descripcion"; break;
            case 2: nombre="Componente"; break;
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
            case 0: resultado= reparaciones.get(row).getCliente().getId(); break;
            case 1: resultado= reparaciones.get(row).getDescripcion(); break;
            case 2:
                Componente comp = reparaciones.get(row).getComponente();
                if(comp == null) {
                    resultado = null;
                }
                else {
                    resultado = comp.getNombre();
                }
        }
        return resultado;
    }

    public void setFilas(java.util.List<PCReparar> reparaciones){
        this.reparaciones=reparaciones;
        fireTableDataChanged();
    }

    public PCReparar obtenerReparacion(int i){
        return this.reparaciones.get(i);
    }

}
