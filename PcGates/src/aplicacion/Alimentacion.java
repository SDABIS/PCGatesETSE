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
public class Alimentacion extends Componente {
    private double potencia;
    private boolean modular;

    public Alimentacion(double potencia, boolean modular, String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.potencia = potencia;
        this.modular = modular;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public boolean getModular() {
        return modular;
    }

    public void setModular(boolean modular) {
        this.modular = modular;
    }

    @Override
    public String toString() {
        String string = "Alimentacion{\n\t" + " potencia=" + potencia + "\n\t modular=";
        if(modular) string += " true";
        else string += " false";
        string += "\n}";
        return string;
    }
    
    
    
}
