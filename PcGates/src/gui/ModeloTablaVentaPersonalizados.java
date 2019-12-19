/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Componente;
import aplicacion.Personalizado;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaVentaPersonalizados extends AbstractTableModel{
    private Personalizado pcs;
    private java.util.List<Componente> comp;

    public ModeloTablaVentaPersonalizados(){
        this.pcs = new Personalizado();
        this.comp = new java.util.ArrayList<Componente>();
    }

    @Override
    public int getColumnCount (){
        return 4;
    }

    @Override
    public int getRowCount(){
        return comp.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Componente"; break;
            case 2: nombre= "Numero"; break;
            case 3: nombre= "Precio"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase= java.lang.Integer.class; break;
            case 3: clase= java.lang.Double.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= pcs.getNombre(); break;
            case 1: resultado= comp.get(row).getNombre(); break;
            case 2: 
                    if(pcs.getCpu()!=null && comp.get(row).getNombre().equals(pcs.getCpu().getNombre())){
                        resultado=1;
                    }
                    else if(pcs.getDiscoDuro1()!=null && comp.get(row).getNombre().equals(pcs.getDiscoDuro1().getNombre()))
                        resultado=pcs.getNumeroDiscosDuros1();
                    else if(pcs.getDiscoDuro2()!=null && comp.get(row).getNombre().equals(pcs.getDiscoDuro2().getNombre()))
                        resultado=pcs.getNumeroDiscosDuros2();
                    else if(pcs.getGpu()!=null && comp.get(row).getNombre().equals(pcs.getGpu().getNombre()))
                        resultado=pcs.getNumeroGPUs();
                    else if(pcs.getPeriferico1()!=null && comp.get(row).getNombre().equals(pcs.getPeriferico1().getNombre()))
                        resultado=1;
                    else if(pcs.getPeriferico2()!=null && comp.get(row).getNombre().equals(pcs.getPeriferico2().getNombre()))
                        resultado=1;
                    else if(pcs.getPeriferico3()!=null && comp.get(row).getNombre().equals(pcs.getPeriferico3().getNombre()))
                        resultado=1;
                    else if(pcs.getPeriferico4()!=null && comp.get(row).getNombre().equals(pcs.getPeriferico4().getNombre()))
                        resultado=1;
                    else if(pcs.getRam()!=null && comp.get(row).getNombre().equals(pcs.getRam().getNombre()))
                        resultado=pcs.getNumeroRAMs();
                    else if(pcs.getRefrigeracion1()!=null && comp.get(row).getNombre().equals(pcs.getRefrigeracion1().getNombre()))
                        resultado=1;
                    else if(pcs.getRefrigeracion2()!=null && comp.get(row).getNombre().equals(pcs.getRefrigeracion2().getNombre()))
                        resultado=1;
                    else if(pcs.getAlimentacion()!=null && comp.get(row).getNombre().equals(pcs.getAlimentacion().getNombre()))
                        resultado=1;
                    else if(pcs.getPlacabase()!=null && comp.get(row).getNombre().equals(pcs.getPlacabase().getNombre())){
                        resultado=1;
                    }
                break;
            case 3: resultado=comp.get(row).getPrecio();break;
        }
        return resultado;
    }

    public void setFilasPcs(Personalizado pcs){
        this.pcs=pcs;
        fireTableDataChanged();
    }
    
    public void setFilasComponentes(java.util.List<Componente> comp){
        this.comp=comp;
        fireTableDataChanged();
    }

    public Personalizado obtenerPersonalizado(){
        return this.pcs;
    }
    
    public Componente obtenerComponente(int i){
        return this.comp.get(i);
    }
    
    public void borrarTabla(){
        int row = this.getRowCount();
        for(int i=0;i<row;i++){
            comp.remove(0);
            for(int j=0;j<this.getColumnCount();j++){
                fireTableRowsDeleted(i, j);
            }
        }
        pcs=null;
    }
    
    public void borraTabla(){
        int size = this.getRowCount();
        for(int i=0;i<size;i++){
            comp.remove(0);
            for(int j=0;j<this.getColumnCount();j++){
                 fireTableRowsDeleted(i, j);
            }
        } 
        
        pcs=null;
    }
}