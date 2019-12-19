/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class PCReparar {
    
    private int id;
    private String descripcion;
    private double precio;
    private LocalDate fechaIngreso;
    private LocalDate fechaReparacion;
    private LocalDate fechaRetirada;
    private Cliente cliente;
    private Componente componente;
    private Empleado asistenteIngreso;
    private Empleado reparador;
    private Empleado asistenteRetirada;

    public PCReparar(int id, String descripcion, LocalDate fechaIngreso, Cliente cliente, Empleado asistenteIngreso) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.cliente = cliente;
        this.asistenteIngreso = asistenteIngreso;
    }
    
    public PCReparar(int id, String descripcion, Cliente cliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaReparacion() {
        return fechaReparacion;
    }

    public void setFechaReparacion(LocalDate fechaReparacion) {
        this.fechaReparacion = fechaReparacion;
    }

    public LocalDate getFechaRetirada() {
        return fechaRetirada;
    }

    public void setFechaRetirada(LocalDate fechaRetirada) {
        this.fechaRetirada = fechaRetirada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getAsistenteIngreso() {
        return asistenteIngreso;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public void setAsistenteIngreso(Empleado asistenteIngreso) {
        this.asistenteIngreso = asistenteIngreso;
    }

    public Empleado getReparador() {
        return reparador;
    }

    public void setReparador(Empleado reparador) {
        this.reparador = reparador;
    }

    public Empleado getAsistenteRetirada() {
        return asistenteRetirada;
    }

    public void setAsistenteRetirada(Empleado asistenteRetirada) {
        this.asistenteRetirada = asistenteRetirada;
    }
    
    
}
