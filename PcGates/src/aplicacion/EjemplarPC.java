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
public class EjemplarPC {
    private int id;
    private String nombre;
    private double precio;
    private LocalDate fechaCreacion;
    private LocalDate fechaCompraPc;
    private Cliente cliente;
    private Empleado asistente;

    public EjemplarPC(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCompraPc() {
        return fechaCompraPc;
    }

    public void setFechaCompraPc(LocalDate fechaCompraPc) {
        this.fechaCompraPc = fechaCompraPc;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getAsistente() {
        return asistente;
    }

    public void setAsistente(Empleado asistente) {
        this.asistente = asistente;
    }

    
    
}
