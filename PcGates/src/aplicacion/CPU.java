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
public class CPU extends Componente {
    private String sockets;
    private int cores;
    private int threads;
    private double frecuencia;
    private double tdp;
    private String microarquitectura;

    public CPU(String sockets, int cores, int threads, double frecuencia, double tdp, String microarquitectura, String nombre, double precio, String marca, String descripcion) {
        super(nombre, precio, marca, descripcion);
        this.sockets = sockets;
        this.cores = cores;
        this.threads = threads;
        this.frecuencia = frecuencia;
        this.tdp = tdp;
        this.microarquitectura = microarquitectura;
    }

    public String getSockets() {
        return sockets;
    }

    public void setSockets(String sockets) {
        this.sockets = sockets;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public double getTdp() {
        return tdp;
    }

    public void setTdp(double tdp) {
        this.tdp = tdp;
    }

    public String getMicroarquitectura() {
        return microarquitectura;
    }

    public void setMicroarquitectura(String microarquitectura) {
        this.microarquitectura = microarquitectura;
    }

    @Override
    public String toString() {
        String string = "CPU{\n\t" + " sockets=" + sockets + "\n\t cores=" + cores + "\n\t threads=" + threads + "\n\t frecuencia=" + frecuencia + "\n\t tdp=" + tdp + "\n\t microarquitectura=" + microarquitectura + "\n}";
        return string;
    }
    
    
    
    
}
