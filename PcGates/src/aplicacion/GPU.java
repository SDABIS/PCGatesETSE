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
public class GPU extends Componente {
    private int nucleos;
    private double frecuencia;
    private int procesoFabricacion;

    public GPU(int nucleos, double frecuencia, int procesoFabricacion, String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.nucleos = nucleos;
        this.frecuencia = frecuencia;
        this.procesoFabricacion = procesoFabricacion;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getProcesoFabricacion() {
        return procesoFabricacion;
    }

    public void setProcesoFabricacion(int procesoFabricacion) {
        this.procesoFabricacion = procesoFabricacion;
    }

    @Override
    public String toString() {
        String string = "GPU{\n\t nucleos=" + nucleos + "\n\t frecuencia=" + frecuencia + "\n\t tprocesoFabricacion=" + procesoFabricacion + "\n}";
        return string;
    }
    
    
    
    
}
