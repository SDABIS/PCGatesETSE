/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Componente {
    private String nombre;
    private double precio;
    private String marca;
    private String descripcion;
    private ArrayList<EjemplarComponente> ejemplares;
    public int cantidadEjemplares;

    public Componente(String nombre, double precio, String marca, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        ejemplares = new ArrayList<>();
        cantidadEjemplares = 0;
    }
    
    public Componente(String nombre) {
        this.nombre = nombre;
    }
    
    public Componente(String nombre, double precio, String marca, String descripcion, int cantidadEjemplares) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        ejemplares = new ArrayList<>();
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<EjemplarComponente> getEjemplares() {
        return ejemplares;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEjemplares(ArrayList<EjemplarComponente> ejemplares) {
        this.ejemplares = ejemplares;
        this.cantidadEjemplares = this.ejemplares.size();
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }
    
    
}
