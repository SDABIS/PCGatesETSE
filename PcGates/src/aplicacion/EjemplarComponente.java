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
public class EjemplarComponente {
    private Componente componente;
    private int id;
    private LocalDate fechaTiendaCompraEjemplar;
    private LocalDate fechaClienteCompraEjemplar;

    public EjemplarComponente(Componente componente, int id) {
        this.componente = componente;
        this.id = id;
    }

    public Componente getComponente() {
        return componente;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaTiendaCompraEjemplar() {
        return fechaTiendaCompraEjemplar;
    }

    public LocalDate getFechaClienteCompraEjemplar() {
        return fechaClienteCompraEjemplar;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaTiendaCompraEjemplar(LocalDate fechaTiendaCompraEjemplar) {
        this.fechaTiendaCompraEjemplar = fechaTiendaCompraEjemplar;
    }

    public void setFechaClienteCompraEjemplar(LocalDate fechaClienteCompraEjemplar) {
        this.fechaClienteCompraEjemplar = fechaClienteCompraEjemplar;
    }
    
    
}
