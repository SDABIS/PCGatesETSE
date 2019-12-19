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
public class DiscoDuro extends Componente {
    private String tipo;
    private double velocidad;
    private int capacidad;

    public DiscoDuro(String tipo, double velocidad, int capacidad,String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    

    @Override
    public String toString() {
        String string = "DiscoDuro{\n\t" + " tipo=" + tipo + "\n\t velocidad=" + velocidad + "\n\t capacidad= " + capacidad + "\n}";
        return string;
    }
    
    
    
    
}
