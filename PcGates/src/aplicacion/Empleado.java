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
public class Empleado {
    private String dni;
    private String nombre;
    private String contraseña;
    private String correo;
    private String direccion;
    private double sueldo;
    private String telefono;
    private boolean esAsistente;
    private boolean esReparador;
    private boolean esJefe;

    public Empleado(String dni, String nombre, String contraseña, String correo, String direccion, double sueldo, String telefono, boolean esAsistente, boolean esReparador, boolean esJefe) {
        this.dni = dni;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.direccion = direccion;
        this.sueldo = sueldo;
        this.telefono = telefono;
        this.esAsistente = esAsistente;
        this.esReparador = esReparador;
        this.esJefe = esJefe;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getEsAsistente() {
        return esAsistente;
    }

    public void setEsAsistente(boolean esAsistente) {
        this.esAsistente = esAsistente;
    }

    public boolean getEsReparador() {
        return esReparador;
    }

    public void setEsReparador(boolean esReparador) {
        this.esReparador = esReparador;
    }

    public boolean getEsJefe() {
        return esJefe;
    }

    public void setEsJefe(boolean esJefe) {
        this.esJefe = esJefe;
    }
    
    
}
