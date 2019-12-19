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
public class Periferico extends Componente {
    private String tipo;

    public Periferico(String tipo, String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String string = "Periferico{\n\t" + " tipo=" + tipo + "\n}";
        return string;
    }
    
    
    
}
