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
public class Refrigeracion extends Componente {
    private String tipo;
    private int tamano;

    public Refrigeracion(String tipo, int tamano, String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.tipo = tipo;
        this.tamano = tamano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        String string = "Refrigeracion{\n\t" + " tipo=" + tipo + "\n\t tamano=" + tamano + "\n}";
        return string;
    }
    
    
    
}
