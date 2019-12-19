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
public class PlacaBase extends Componente {
    private String chipset;
    private double tamano;

    public PlacaBase(String chipset, double tamano, String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.chipset = chipset;
        this.tamano = tamano;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        String string = "PlacaBase{\n\t" + " chipset=" + chipset + "\n\t tamano=" + tamano + "\n}";
        return string;
    }
    
    
    
}
