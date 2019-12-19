/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import aplicacion.FachadaAplicacion;
import aplicacion.PCReparar;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaReparacionesAsistentes extends AbstractTableModel{
    private java.util.List<PCReparar> reparaciones;
    private FachadaAplicacion fa;

    public ModeloTablaReparacionesAsistentes(FachadaAplicacion fa){
        this.reparaciones = new java.util.ArrayList<>();
        this.fa = fa;
    }

    public int getColumnCount (){
        return 5;
    }

    public int getRowCount(){
        return reparaciones.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Descripcion"; break;
            case 1: nombre= "Precio"; break;
            case 2: nombre="Fecha Llegada"; break;
            case 3: nombre= "Fecha Reparacion"; break;
            case 4: nombre="Fecha Salida"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Double.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase= java.lang.String.class; break;
            case 4: clase=java.lang.String.class; break;
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
            case 0: resultado= reparaciones.get(row).getDescripcion(); break;
            case 1: resultado= fa.obtenerPrecioReparacion(reparaciones.get(row));break;
            case 2: resultado=reparaciones.get(row).getFechaIngreso().toString();break;
            case 3: resultado = reparaciones.get(row).getFechaReparacion().toString();break;
            case 4: if(reparaciones.get(row).getFechaRetirada() != null) {
                    resultado = reparaciones.get(row).getFechaRetirada().toString();
                } 
                else{
                    resultado = "-----------------------------------";
                }
            break;
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