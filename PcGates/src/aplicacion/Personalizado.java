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
public class Personalizado {
    private int id;
    private String nombre;
    private int numVentas;
    private Cliente cliente;
    private CPU cpu;
    private GPU gpu;
    private int numeroGPUs;
    private RAM ram;
    private int numeroRAMs;
    private DiscoDuro discoDuro1;
    private int numeroDiscosDuros1;
    private DiscoDuro discoDuro2;
    private int numeroDiscosDuros2;
    private Alimentacion alimentacion;
    private Refrigeracion refrigeracion1;
    private Refrigeracion refrigeracion2;
    private PlacaBase placabase;
    private Periferico periferico1;
    private Periferico periferico2;
    private Periferico periferico3;
    private Periferico periferico4;

   

    public Personalizado(int id, String nombre, Cliente cliente, PlacaBase placabase, CPU cpu, GPU gpu, int numeroGPUs, RAM ram, int numeroRAMs, DiscoDuro discoDuro1, int numeroDiscosDuros1, DiscoDuro discoDuro2, int numeroDiscosDuros2, Alimentacion alimentacion, Refrigeracion refrigeracion1, Refrigeracion refrigeracion2, Periferico periferico1, Periferico periferico2, Periferico periferico3, Periferico periferico4) {
        this.id = id;
        this.nombre = nombre;
        this.placabase=placabase;
        this.cliente = cliente;
        this.cpu = cpu;
        this.gpu = gpu;
        this.numeroGPUs = numeroGPUs;
        this.ram = ram;
        this.numeroRAMs = numeroRAMs;
        this.discoDuro1 = discoDuro1;
        this.numeroDiscosDuros1 = numeroDiscosDuros1;
        this.discoDuro2 = discoDuro2;
        this.numeroDiscosDuros2 = numeroDiscosDuros2;
        this.alimentacion = alimentacion;
        this.refrigeracion1 = refrigeracion1;
        this.refrigeracion2 = refrigeracion2;
        this.periferico1 = periferico1;
        this.periferico2 = periferico2;
        this.periferico3 = periferico3;
        this.periferico4 = periferico4;
    }
    
    public Personalizado(int id, String nombre, int numVentas, Cliente cliente, PlacaBase placabase, CPU cpu, GPU gpu, int numeroGPUs, RAM ram, int numeroRAMs, DiscoDuro discoDuro1, int numeroDiscosDuros1, DiscoDuro discoDuro2, int numeroDiscosDuros2, Alimentacion alimentacion, Refrigeracion refrigeracion1, Refrigeracion refrigeracion2, Periferico periferico1, Periferico periferico2, Periferico periferico3, Periferico periferico4) {
        this.id = id;
        this.nombre = nombre;
        this.numVentas=numVentas;
        this.placabase=placabase;
        this.cliente = cliente;
        this.cpu = cpu;
        this.gpu = gpu;
        this.numeroGPUs = numeroGPUs;
        this.ram = ram;
        this.numeroRAMs = numeroRAMs;
        this.discoDuro1 = discoDuro1;
        this.numeroDiscosDuros1 = numeroDiscosDuros1;
        this.discoDuro2 = discoDuro2;
        this.numeroDiscosDuros2 = numeroDiscosDuros2;
        this.alimentacion = alimentacion;
        this.refrigeracion1 = refrigeracion1;
        this.refrigeracion2 = refrigeracion2;
        this.periferico1 = periferico1;
        this.periferico2 = periferico2;
        this.periferico3 = periferico3;
        this.periferico4 = periferico4;
    }

    public Personalizado() {
        this.id = 0;
        this.nombre = null;
        this.placabase=null;
        this.cliente = null;
        this.cpu = null;
        this.gpu = null;
        this.numeroGPUs = 0;
        this.ram = null;
        this.numeroRAMs = 0;
        this.discoDuro1 = null;
        this.numeroDiscosDuros1 =0;
        this.discoDuro2 =null;
        this.numeroDiscosDuros2 = 0;
        this.alimentacion = null;
        this.refrigeracion1 = null;
        this.refrigeracion2 = null;
        this.periferico1 = null;
        this.periferico2 = null;
        this.periferico3 = null;
        this.periferico4 = null;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public int getNumeroGPUs() {
        return numeroGPUs;
    }

    public void setNumeroGPUs(int numeroGPUs) {
        this.numeroGPUs = numeroGPUs;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public int getNumeroRAMs() {
        return numeroRAMs;
    }

    public void setNumeroRAMs(int numeroRAMs) {
        this.numeroRAMs = numeroRAMs;
    }

    public DiscoDuro getDiscoDuro1() {
        return discoDuro1;
    }

    public void setDiscoDuro1(DiscoDuro discoDuro1) {
        this.discoDuro1 = discoDuro1;
    }

    public int getNumeroDiscosDuros1() {
        return numeroDiscosDuros1;
    }

    public void setNumeroDiscosDuros1(int numeroDiscosDuros1) {
        this.numeroDiscosDuros1 = numeroDiscosDuros1;
    }

    public DiscoDuro getDiscoDuro2() {
        return discoDuro2;
    }

    public void setDiscoDuro2(DiscoDuro discoDuro2) {
        this.discoDuro2 = discoDuro2;
    }

    public int getNumeroDiscosDuros2() {
        return numeroDiscosDuros2;
    }

    public void setNumeroDiscosDuros2(int numeroDiscosDuros2) {
        this.numeroDiscosDuros2 = numeroDiscosDuros2;
    }

    public Alimentacion getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(Alimentacion alimentacion) {
        this.alimentacion = alimentacion;
    }

    public Refrigeracion getRefrigeracion1() {
        return refrigeracion1;
    }

    public void setRefrigeracion1(Refrigeracion refrigeracion1) {
        this.refrigeracion1 = refrigeracion1;
    }

    public Refrigeracion getRefrigeracion2() {
        return refrigeracion2;
    }

    public void setRefrigeracion2(Refrigeracion refrigeracion2) {
        this.refrigeracion2 = refrigeracion2;
    }

    public Periferico getPeriferico1() {
        return periferico1;
    }

    public void setPeriferico1(Periferico periferico1) {
        this.periferico1 = periferico1;
    }

    public Periferico getPeriferico2() {
        return periferico2;
    }

    public void setPeriferico2(Periferico periferico2) {
        this.periferico2 = periferico2;
    }

    public Periferico getPeriferico3() {
        return periferico3;
    }

    public void setPeriferico3(Periferico periferico3) {
        this.periferico3 = periferico3;
    }

    public Periferico getPeriferico4() {
        return periferico4;
    }

    public void setPeriferico4(Periferico periferico4) {
        this.periferico4 = periferico4;
    }
    
     public void setPlacabase(PlacaBase placabase) {
        this.placabase = placabase;
    }

    public PlacaBase getPlacabase() {
        return placabase;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }
    
}
