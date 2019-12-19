/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author Usuario
 */
public class RAM extends Componente {
    private String tipoddr;
    private double memoria;
    private double frecuencia;
    private String formato;

    public RAM(String tipoddr, double memoria, double frecuencia, String formato, String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.tipoddr = tipoddr;
        this.memoria = memoria;
        this.frecuencia = frecuencia;
        this.formato = formato;
    }

    public double getMemoria() {
        return memoria;
    }

    public void setMemoria(double memoria) {
        this.memoria = memoria;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTipoddr() {
        return tipoddr;
    }

    public void setTipoddr(String tipoddr) {
        this.tipoddr = tipoddr;
    }

    @Override
    public String toString() {
        String string = "RAM{\n\t" + " memoria=" + memoria + "\n\t frecuencia=" + frecuencia + "\n\t formato=" + formato + "\n}";
        return string;
    }
  
    
    
}
