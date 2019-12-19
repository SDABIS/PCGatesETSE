/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.EjemplarPC;
import aplicacion.FachadaAplicacion;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaVentaPcs extends AbstractTableModel{
    private java.util.List<EjemplarPC> pcs;
    private FachadaAplicacion fa;

    public ModeloTablaVentaPcs(FachadaAplicacion fa){
        this.pcs = new java.util.ArrayList<>();
        this.fa = fa;
    }

    public int getColumnCount (){
        return 3;
    }

    public int getRowCount(){
        return pcs.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
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
            case 0: resultado= pcs.get(row).getNombre(); break;
            case 1: resultado= fa.cantidadPcsVentaNombre(pcs.get(row).getNombre()); break;
            case 2: resultado=pcs.get(row).getPrecio();break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<EjemplarPC> pcs){
        this.pcs=pcs;
        fireTableDataChanged();
    }

    public EjemplarPC obtenerComponente(int i){
        return this.pcs.get(i);
    }

}