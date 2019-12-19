/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Componente;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaComponentes extends AbstractTableModel{
    private java.util.List<Componente> componentes;

    public ModeloTablaComponentes(){
        this.componentes = new java.util.ArrayList<>();
    }

    public int getColumnCount (){
        return 3;
    }

    public int getRowCount(){
        return componentes.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Componente"; break;
            case 1: nombre= "Cantidad"; break;
            case 2: nombre="Precio"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Integer.class; break;
            case 2: clase=java.lang.Double.class; break;
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
            case 0: resultado= componentes.get(row).getNombre(); break;
            case 1: resultado= componentes.get(row).getCantidadEjemplares(); break;
            case 2: resultado=componentes.get(row).getPrecio();break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Componente> componentes){
        this.componentes=componentes;
        fireTableDataChanged();
    }

    public Componente obtenerComponente(int i){
        return this.componentes.get(i);
    }

}
