/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.*;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 *
 * @author alumnogreibd
 */
public class VDespachar extends javax.swing.JDialog {

    private aplicacion.FachadaAplicacion fa;
    private Cliente c;
    private VAsistente padre;
    private Empleado e;
    /**
     * Creates new form VDespachar
     */
    public VDespachar(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Cliente c, Empleado e) {
        super(parent, modal);
        initComponents();
        this.fa=fa;
        this.c=c;
        this.e = e;
        ModeloListaStrings s = (ModeloListaStrings) listaPersonalizados.getModel();
        java.util.List<Personalizado> pers = new java.util.ArrayList<>();
        pers = fa.obtenerPersonalizados(c);
        java.util.ArrayList<String> nombre = new java.util.ArrayList<>();
        for(Personalizado p: pers){
            nombre.add(p.getNombre());
        }
        s.setElementos(nombre);
        padre = (VAsistente) parent; 
        this.e = new Empleado("09890981V", "Miguel Ventoso", "mv", "miguel.ventoso@rai.usc.es", null, 2000, null, true, true, false);
        
        //Venta Componentes
        
        ModeloTablaComponentes tablaComponentesGpu;
        ModeloTablaComponentes tablaComponentesCpu;
        ModeloTablaComponentes tablaComponentesRam;
        ModeloTablaComponentes tablaComponentesPerifericos;
        ModeloTablaComponentes tablaComponentesRefrigeracion;
        ModeloTablaComponentes tablaComponentesAlimentacion;
        ModeloTablaComponentes tablaComponentesDiscosDuros;
        ModeloTablaComponentes tablaComponentesPlacasBase;
        
        tablaComponentesGpu = (ModeloTablaComponentes) tablaGPUs.getModel();
        tablaComponentesCpu = (ModeloTablaComponentes) tablaCPUs.getModel();
        tablaComponentesRam = (ModeloTablaComponentes) tablaRAMs.getModel();
        tablaComponentesPerifericos = (ModeloTablaComponentes) tablaPerifericos.getModel();
        tablaComponentesRefrigeracion = (ModeloTablaComponentes) tablaRefrigeracion.getModel();
        tablaComponentesAlimentacion = (ModeloTablaComponentes) tablaAlimentacion.getModel();
        tablaComponentesDiscosDuros = (ModeloTablaComponentes) tablaDiscosDuros.getModel();
        tablaComponentesPlacasBase = (ModeloTablaComponentes) tablaPlacasBase.getModel();
        
        tablaComponentesGpu.setFilas(fa.obtenerComponentes("gpus"));
        if(tablaGPUs.getRowCount() > 0)tablaGPUs.setRowSelectionInterval(0, 0);
        descripcionGpu.setText(fa.caracteristicasComponente((String)tablaGPUs.getValueAt((tablaGPUs.getSelectedRow()), 0), "gpu"));
        tablaComponentesCpu.setFilas(fa.obtenerComponentes("cpus"));
        tablaComponentesRam.setFilas(fa.obtenerComponentes("rams"));
        tablaComponentesPerifericos.setFilas(fa.obtenerComponentes("perifericos"));
        tablaComponentesRefrigeracion.setFilas(fa.obtenerComponentes("refrigeracion"));
        tablaComponentesAlimentacion.setFilas(fa.obtenerComponentes("alimentacion"));
        tablaComponentesDiscosDuros.setFilas(fa.obtenerComponentes("discosduros"));
        tablaComponentesPlacasBase.setFilas(fa.obtenerComponentes("placasbase"));
        
        botonVenderComponente.setEnabled(false);
        botonSalirVenderComponente.setEnabled(true);
        if((Integer)tablaGPUs.getValueAt(0, 1) > 0) botonVenderComponente.setEnabled(true);
        
        //Venta PCs
        
        ModeloTablaVentaPcs tablaVentaPcs = new ModeloTablaVentaPcs(fa);
        tablaVenderPc.setModel(tablaVentaPcs);
        tablaVentaPcs.setFilas(fa.obtenerPcsVenta());
        if(tablaVentaPcs.getRowCount() > 0) tablaVenderPc.setRowSelectionInterval(0, 0);
        botonVenderPc.setEnabled(false);
        botonSalirPc.setEnabled(true);
        if(tablaVentaPcs.getRowCount() > 0) botonVenderPc.setEnabled(true);
        tablaVenderPc.getColumnModel().getColumn(0).setPreferredWidth(500);
        
        //Reparaciones
        
        ModeloTablaReparacionesAsistentes tablaReparacionesAsistentes = new ModeloTablaReparacionesAsistentes(fa);
        tablaReparar.setModel(tablaReparacionesAsistentes);
        tablaReparacionesAsistentes.setFilas(fa.obtenerPcsReparados(this.c));
        if(tablaReparar.getRowCount() > 0) tablaReparar.setRowSelectionInterval(0, 0);
        botonNuevaReparacion.setEnabled(true);
        botonSalirReparar.setEnabled(true);
        botonDevolver.setEnabled(false);
        if(tablaReparar.getRowCount() > 0 && ((String)tablaReparar.getValueAt(0, 4)).equals("-----------------------------------")) {
            botonDevolver.setEnabled(true);
        }
        tablaReparar.getColumnModel().getColumn(0).setPreferredWidth(300);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        MenuDespachar = new javax.swing.JTabbedPane();
        PanelPc = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tablaVenderPc = new javax.swing.JTable();
        botonSalirPc = new javax.swing.JButton();
        botonVenderPc = new javax.swing.JButton();
        PanelComponentes = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaGPUs = new javax.swing.JTable();
        jScrollPane29 = new javax.swing.JScrollPane();
        descripcionGpu = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaRAMs = new javax.swing.JTable();
        jScrollPane30 = new javax.swing.JScrollPane();
        descripcionRam = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablaDiscosDuros = new javax.swing.JTable();
        jScrollPane31 = new javax.swing.JScrollPane();
        descripcionDiscoDuro = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tablaPlacasBase = new javax.swing.JTable();
        jScrollPane32 = new javax.swing.JScrollPane();
        descripcionPlacaBase = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tablaAlimentacion = new javax.swing.JTable();
        jScrollPane33 = new javax.swing.JScrollPane();
        descripcionAlimentacion = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tablaRefrigeracion = new javax.swing.JTable();
        jScrollPane34 = new javax.swing.JScrollPane();
        descripcionRefrigeracion = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tablaPerifericos = new javax.swing.JTable();
        jScrollPane35 = new javax.swing.JScrollPane();
        descripcionPerifericos = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaCPUs = new javax.swing.JTable();
        jScrollPane28 = new javax.swing.JScrollPane();
        descripcionCpu = new javax.swing.JTextArea();
        botonSalirVenderComponente = new javax.swing.JButton();
        botonVenderComponente = new javax.swing.JButton();
        PanelReparar = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tablaReparar = new javax.swing.JTable();
        botonNuevaReparacion = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        botonSalirReparar = new javax.swing.JButton();
        botonDevolver = new javax.swing.JButton();
        PanelPcPersonalizado = new javax.swing.JPanel();
        botonVenderPersonalizado = new javax.swing.JButton();
        btnSalirPersonalizados = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPersonalizados = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCompPers = new javax.swing.JTable();
        textoVentas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTextField5.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaVenderPc.setModel(new ModeloTablaVentaPcs(fa));
        jScrollPane19.setViewportView(tablaVenderPc);

        botonSalirPc.setText("Salir");
        botonSalirPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirPcActionPerformed(evt);
            }
        });

        botonVenderPc.setText("Vender");
        botonVenderPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVenderPcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPcLayout = new javax.swing.GroupLayout(PanelPc);
        PanelPc.setLayout(PanelPcLayout);
        PanelPcLayout.setHorizontalGroup(
            PanelPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPcLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addGroup(PanelPcLayout.createSequentialGroup()
                        .addComponent(botonVenderPc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonSalirPc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelPcLayout.setVerticalGroup(
            PanelPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVenderPc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalirPc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        MenuDespachar.addTab("Vender Pc", PanelPc);

        tablaGPUs.setModel(new ModeloTablaComponentes());
        tablaGPUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGPUsMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tablaGPUs);

        descripcionGpu.setColumns(20);
        descripcionGpu.setRows(5);
        jScrollPane29.setViewportView(descripcionGpu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane29))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("GPUs", jPanel2);

        tablaRAMs.setModel(new ModeloTablaComponentes());
        tablaRAMs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRAMsMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tablaRAMs);

        descripcionRam.setColumns(20);
        descripcionRam.setRows(5);
        jScrollPane30.setViewportView(descripcionRam);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane30))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("RAMs", jPanel3);

        tablaDiscosDuros.setModel(new ModeloTablaComponentes());
        tablaDiscosDuros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDiscosDurosMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tablaDiscosDuros);

        descripcionDiscoDuro.setColumns(20);
        descripcionDiscoDuro.setRows(5);
        jScrollPane31.setViewportView(descripcionDiscoDuro);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane31))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Discos Duros", jPanel4);

        tablaPlacasBase.setModel(new ModeloTablaComponentes());
        tablaPlacasBase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlacasBaseMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tablaPlacasBase);

        descripcionPlacaBase.setColumns(20);
        descripcionPlacaBase.setRows(5);
        jScrollPane32.setViewportView(descripcionPlacaBase);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Placas Base", jPanel5);

        tablaAlimentacion.setModel(new ModeloTablaComponentes());
        tablaAlimentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlimentacionMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tablaAlimentacion);

        descripcionAlimentacion.setColumns(20);
        descripcionAlimentacion.setRows(5);
        jScrollPane33.setViewportView(descripcionAlimentacion);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane33))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Alimentacion", jPanel6);

        tablaRefrigeracion.setModel(new ModeloTablaComponentes());
        tablaRefrigeracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRefrigeracionMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tablaRefrigeracion);

        descripcionRefrigeracion.setColumns(20);
        descripcionRefrigeracion.setRows(5);
        jScrollPane34.setViewportView(descripcionRefrigeracion);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane34))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Refrigeracion", jPanel7);

        tablaPerifericos.setModel(new ModeloTablaComponentes());
        tablaPerifericos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPerifericosMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tablaPerifericos);

        descripcionPerifericos.setColumns(20);
        descripcionPerifericos.setRows(5);
        jScrollPane35.setViewportView(descripcionPerifericos);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Perifericos", jPanel8);

        tablaCPUs.setModel(new ModeloTablaComponentes());
        tablaCPUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCPUsMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tablaCPUs);

        descripcionCpu.setColumns(20);
        descripcionCpu.setRows(5);
        jScrollPane28.setViewportView(descripcionCpu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane28))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CPUs", jPanel1);

        botonSalirVenderComponente.setText("Salir");
        botonSalirVenderComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirVenderComponenteActionPerformed(evt);
            }
        });

        botonVenderComponente.setText("Vender");
        botonVenderComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVenderComponenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelComponentesLayout = new javax.swing.GroupLayout(PanelComponentes);
        PanelComponentes.setLayout(PanelComponentesLayout);
        PanelComponentesLayout.setHorizontalGroup(
            PanelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonVenderComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonSalirVenderComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        PanelComponentesLayout.setVerticalGroup(
            PanelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComponentesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonVenderComponente, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(botonSalirVenderComponente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        MenuDespachar.addTab("Vender Componente", PanelComponentes);

        tablaReparar.setModel(new ModeloTablaReparacionesAsistentes(fa));
        jScrollPane18.setViewportView(tablaReparar);

        botonNuevaReparacion.setText("Nuevo");
        botonNuevaReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaReparacionActionPerformed(evt);
            }
        });

        textoDescripcion.setColumns(20);
        textoDescripcion.setRows(5);
        jScrollPane20.setViewportView(textoDescripcion);

        jLabel9.setText("Descripcion");

        botonSalirReparar.setText("Salir");
        botonSalirReparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirRepararActionPerformed(evt);
            }
        });

        botonDevolver.setText("Devolver");
        botonDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRepararLayout = new javax.swing.GroupLayout(PanelReparar);
        PanelReparar.setLayout(PanelRepararLayout);
        PanelRepararLayout.setHorizontalGroup(
            PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRepararLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18)
                    .addGroup(PanelRepararLayout.createSequentialGroup()
                        .addGroup(PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonNuevaReparacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonSalirReparar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRepararLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        PanelRepararLayout.setVerticalGroup(
            PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRepararLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRepararLayout.createSequentialGroup()
                        .addGroup(PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonNuevaReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRepararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalirReparar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        MenuDespachar.addTab("Reparar", PanelReparar);

        botonVenderPersonalizado.setText("Vender");
        botonVenderPersonalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVenderPersonalizadoActionPerformed(evt);
            }
        });

        btnSalirPersonalizados.setText("Salir");
        btnSalirPersonalizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPersonalizadosActionPerformed(evt);
            }
        });

        listaPersonalizados.setModel(new ModeloListaStrings());
        listaPersonalizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPersonalizadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaPersonalizados);

        tablaCompPers.setModel(new ModeloTablaVentaPersonalizados());
        jScrollPane3.setViewportView(tablaCompPers);

        textoVentas.setEditable(false);

        jLabel1.setText("Numero de ventas");

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        lblTotal.setText("Total:");

        jLabel2.setText("€");

        javax.swing.GroupLayout PanelPcPersonalizadoLayout = new javax.swing.GroupLayout(PanelPcPersonalizado);
        PanelPcPersonalizado.setLayout(PanelPcPersonalizadoLayout);
        PanelPcPersonalizadoLayout.setHorizontalGroup(
            PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPcPersonalizadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPcPersonalizadoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoVentas)
                            .addGroup(PanelPcPersonalizadoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPcPersonalizadoLayout.createSequentialGroup()
                        .addComponent(botonVenderPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirPersonalizados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPcPersonalizadoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        PanelPcPersonalizadoLayout.setVerticalGroup(
            PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPcPersonalizadoLayout.createSequentialGroup()
                .addGroup(PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPcPersonalizadoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(PanelPcPersonalizadoLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTotal))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalirPersonalizados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPcPersonalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonVenderPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        MenuDespachar.addTab("Vender PC Personalizado", PanelPcPersonalizado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuDespachar, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuDespachar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirPersonalizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPersonalizadosActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirPersonalizadosActionPerformed

    private void listaPersonalizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPersonalizadosMouseClicked
        // TODO add your handling code here:
        if(listaPersonalizados.getVisibleRowCount() == 0) {
            return;
        }
        
        ModeloListaStrings s = (ModeloListaStrings) listaPersonalizados.getModel();
        ModeloTablaVentaPersonalizados vp = (ModeloTablaVentaPersonalizados) tablaCompPers.getModel();
        Personalizado per = fa.obtenerPersonalizado(s.getElementos().get(listaPersonalizados.getSelectedIndex()), c);
        if(per==null)
            fa.muestraExcepcion("No se ha encontrado el PC personalizado a partir de ese nombre");
        else{
            vp.setFilasPcs(per);
            java.util.List<Componente> comp = new java.util.ArrayList<>();
            comp = fa.listaComponentes(per);
            vp.setFilasComponentes(comp);
            textoVentas.setText(Integer.toString(per.getNumVentas()));
            int filas = vp.getRowCount(),num=0;
            double valor=0, precio = 0;
            for(int i=0; i<filas; i++){
                valor = (Double)vp.getValueAt(i, 3);
                num = (Integer)vp.getValueAt(i, 2);
                precio += (valor*num);
            }
            DecimalFormat df = new DecimalFormat("#.00");
            txtTotal.setText(df.format(precio));
        }
    }//GEN-LAST:event_listaPersonalizadosMouseClicked

    private void botonVenderPersonalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVenderPersonalizadoActionPerformed
        // TODO add your handling code here:
        ModeloListaStrings s = (ModeloListaStrings) listaPersonalizados.getModel();
        Personalizado ps = fa.obtenerPersonalizado(s.getElementos().get(listaPersonalizados.getSelectedIndex()),c);
        fa.venderPcPersonalizado(ps);
        ps = fa.obtenerPersonalizado(s.getElementos().get(listaPersonalizados.getSelectedIndex()),c);
        ModeloTablaVentaPersonalizados vp = (ModeloTablaVentaPersonalizados) tablaCompPers.getModel();
        vp.setFilasPcs(ps);
        java.util.List<Componente> comp = new java.util.ArrayList<>();
        comp = fa.listaComponentes(ps);
        vp.setFilasComponentes(comp);
        textoVentas.setText(Integer.toString(ps.getNumVentas()));
        int filas = vp.getRowCount(),num=0;
        double valor=0, precio = 0;
        for(int i=0; i<filas; i++){
            valor = (Double)vp.getValueAt(i, 3);
            num = (Integer)vp.getValueAt(i, 2);
            precio += (valor*num);
        }
        DecimalFormat df = new DecimalFormat("#.00");
        txtTotal.setText(df.format(precio));
    }//GEN-LAST:event_botonVenderPersonalizadoActionPerformed

    private void tablaGPUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGPUsMouseClicked
        if(tablaGPUs.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaCPUs.getSelectionModel().clearSelection();
        tablaRAMs.getSelectionModel().clearSelection();
        tablaPerifericos.getSelectionModel().clearSelection();
        tablaRefrigeracion.getSelectionModel().clearSelection();
        tablaAlimentacion.getSelectionModel().clearSelection();
        tablaDiscosDuros.getSelectionModel().clearSelection();
        tablaPlacasBase.getSelectionModel().clearSelection();
        if((Integer)tablaGPUs.getValueAt(tablaGPUs.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionGpu.setText(fa.caracteristicasComponente((String)tablaGPUs.getValueAt((tablaGPUs.getSelectedRow()), 0), "gpu"));
    }//GEN-LAST:event_tablaGPUsMouseClicked

    private void tablaRAMsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRAMsMouseClicked
        if(tablaRAMs.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaCPUs.getSelectionModel().clearSelection();
        tablaGPUs.getSelectionModel().clearSelection();
        tablaPerifericos.getSelectionModel().clearSelection();
        tablaRefrigeracion.getSelectionModel().clearSelection();
        tablaAlimentacion.getSelectionModel().clearSelection();
        tablaDiscosDuros.getSelectionModel().clearSelection();
        tablaPlacasBase.getSelectionModel().clearSelection();
        if((Integer)tablaRAMs.getValueAt(tablaRAMs.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionRam.setText(fa.caracteristicasComponente((String)tablaRAMs.getValueAt((tablaRAMs.getSelectedRow()), 0), "ram"));
    }//GEN-LAST:event_tablaRAMsMouseClicked

    private void tablaDiscosDurosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDiscosDurosMouseClicked
        if(tablaDiscosDuros.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaCPUs.getSelectionModel().clearSelection();
        tablaRAMs.getSelectionModel().clearSelection();
        tablaPerifericos.getSelectionModel().clearSelection();
        tablaRefrigeracion.getSelectionModel().clearSelection();
        tablaAlimentacion.getSelectionModel().clearSelection();
        tablaGPUs.getSelectionModel().clearSelection();
        tablaPlacasBase.getSelectionModel().clearSelection();
        if((Integer)tablaDiscosDuros.getValueAt(tablaDiscosDuros.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionDiscoDuro.setText(fa.caracteristicasComponente((String)tablaDiscosDuros.getValueAt((tablaDiscosDuros.getSelectedRow()), 0), "discoduro"));
    }//GEN-LAST:event_tablaDiscosDurosMouseClicked

    private void tablaPlacasBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlacasBaseMouseClicked
        if(tablaPlacasBase.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaCPUs.getSelectionModel().clearSelection();
        tablaRAMs.getSelectionModel().clearSelection();
        tablaPerifericos.getSelectionModel().clearSelection();
        tablaRefrigeracion.getSelectionModel().clearSelection();
        tablaAlimentacion.getSelectionModel().clearSelection();
        tablaDiscosDuros.getSelectionModel().clearSelection();
        tablaGPUs.getSelectionModel().clearSelection();
        if((Integer)tablaPlacasBase.getValueAt(tablaPlacasBase.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionPlacaBase.setText(fa.caracteristicasComponente((String)tablaPlacasBase.getValueAt((tablaPlacasBase.getSelectedRow()), 0), "placabase"));
    }//GEN-LAST:event_tablaPlacasBaseMouseClicked

    private void tablaAlimentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlimentacionMouseClicked
        if(tablaAlimentacion.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaCPUs.getSelectionModel().clearSelection();
        tablaRAMs.getSelectionModel().clearSelection();
        tablaPerifericos.getSelectionModel().clearSelection();
        tablaRefrigeracion.getSelectionModel().clearSelection();
        tablaGPUs.getSelectionModel().clearSelection();
        tablaDiscosDuros.getSelectionModel().clearSelection();
        tablaPlacasBase.getSelectionModel().clearSelection();
        if((Integer)tablaAlimentacion.getValueAt(tablaAlimentacion.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionAlimentacion.setText(fa.caracteristicasComponente((String)tablaAlimentacion.getValueAt((tablaAlimentacion.getSelectedRow()), 0), "alimentacion"));
    }//GEN-LAST:event_tablaAlimentacionMouseClicked

    private void tablaRefrigeracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRefrigeracionMouseClicked
        if(tablaRefrigeracion.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaCPUs.getSelectionModel().clearSelection();
        tablaRAMs.getSelectionModel().clearSelection();
        tablaPerifericos.getSelectionModel().clearSelection();
        tablaGPUs.getSelectionModel().clearSelection();
        tablaAlimentacion.getSelectionModel().clearSelection();
        tablaDiscosDuros.getSelectionModel().clearSelection();
        tablaPlacasBase.getSelectionModel().clearSelection();
        if((Integer)tablaRefrigeracion.getValueAt(tablaRefrigeracion.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionRefrigeracion.setText(fa.caracteristicasComponente((String)tablaRefrigeracion.getValueAt((tablaRefrigeracion.getSelectedRow()), 0), "refrigeracion"));
    }//GEN-LAST:event_tablaRefrigeracionMouseClicked

    private void tablaPerifericosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPerifericosMouseClicked
        if(tablaPerifericos.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaCPUs.getSelectionModel().clearSelection();
        tablaRAMs.getSelectionModel().clearSelection();
        tablaGPUs.getSelectionModel().clearSelection();
        tablaRefrigeracion.getSelectionModel().clearSelection();
        tablaAlimentacion.getSelectionModel().clearSelection();
        tablaDiscosDuros.getSelectionModel().clearSelection();
        tablaPlacasBase.getSelectionModel().clearSelection();
        if((Integer)tablaPerifericos.getValueAt(tablaPerifericos.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionPerifericos.setText(fa.caracteristicasComponente((String)tablaPerifericos.getValueAt((tablaPerifericos.getSelectedRow()), 0), "periferico"));
    }//GEN-LAST:event_tablaPerifericosMouseClicked

    private void tablaCPUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCPUsMouseClicked
        if(tablaCPUs.getRowCount() == 0) {
            return;
        }
        borrarTablas();
        tablaGPUs.getSelectionModel().clearSelection();
        tablaRAMs.getSelectionModel().clearSelection();
        tablaPerifericos.getSelectionModel().clearSelection();
        tablaRefrigeracion.getSelectionModel().clearSelection();
        tablaAlimentacion.getSelectionModel().clearSelection();
        tablaDiscosDuros.getSelectionModel().clearSelection();
        tablaPlacasBase.getSelectionModel().clearSelection();
        if((Integer)tablaCPUs.getValueAt(tablaCPUs.getSelectedRow(), 1) > 0) botonVenderComponente.setEnabled(true);
        else botonVenderComponente.setEnabled(false);
        descripcionCpu.setText(fa.caracteristicasComponente((String)tablaCPUs.getValueAt((tablaCPUs.getSelectedRow()), 0), "cpu"));
    }//GEN-LAST:event_tablaCPUsMouseClicked

 private void botonSalirVenderComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirVenderComponenteActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirVenderComponenteActionPerformed

    private void botonVenderComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVenderComponenteActionPerformed
        
        if(tablaGPUs.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaGPUs.getValueAt(tablaGPUs.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesGpu;
            tablaComponentesGpu = (ModeloTablaComponentes) tablaGPUs.getModel();
            tablaComponentesGpu.setFilas(fa.obtenerComponentes("gpus"));
        }
        else if(tablaRAMs.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaRAMs.getValueAt(tablaRAMs.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesRam;
            tablaComponentesRam = (ModeloTablaComponentes) tablaRAMs.getModel();
            tablaComponentesRam.setFilas(fa.obtenerComponentes("rams"));
        }
        else if(tablaPerifericos.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaPerifericos.getValueAt(tablaPerifericos.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesPerifericos;
            tablaComponentesPerifericos = (ModeloTablaComponentes) tablaPerifericos.getModel();
            tablaComponentesPerifericos.setFilas(fa.obtenerComponentes("perifericos"));
        }
        else if(tablaRefrigeracion.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaRefrigeracion.getValueAt(tablaRefrigeracion.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesRefrigeracion;
            tablaComponentesRefrigeracion = (ModeloTablaComponentes) tablaRefrigeracion.getModel();
            tablaComponentesRefrigeracion.setFilas(fa.obtenerComponentes("refrigeracion"));
        }
        else if(tablaAlimentacion.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaAlimentacion.getValueAt(tablaAlimentacion.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesAlimentacion;
            tablaComponentesAlimentacion = (ModeloTablaComponentes) tablaAlimentacion.getModel();
            tablaComponentesAlimentacion.setFilas(fa.obtenerComponentes("alimentacion"));
        }
        else if(tablaDiscosDuros.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaDiscosDuros.getValueAt(tablaDiscosDuros.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesDiscosDuros;
            tablaComponentesDiscosDuros = (ModeloTablaComponentes) tablaDiscosDuros.getModel();
            tablaComponentesDiscosDuros.setFilas(fa.obtenerComponentes("discosduros"));
        }
        else if(tablaPlacasBase.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaPlacasBase.getValueAt(tablaPlacasBase.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesPlacasBase;
            tablaComponentesPlacasBase = (ModeloTablaComponentes) tablaPlacasBase.getModel();
            tablaComponentesPlacasBase.setFilas(fa.obtenerComponentes("placasbase"));
        }
        else if(tablaCPUs.getSelectedRow() >= 0) {
            fa.venderComponente((String)tablaCPUs.getValueAt(tablaCPUs.getSelectedRow(), 0), c, e);
            ModeloTablaComponentes tablaComponentesCpu;
            tablaComponentesCpu = (ModeloTablaComponentes) tablaCPUs.getModel();
            tablaComponentesCpu.setFilas(fa.obtenerComponentes("cpus"));
        }
    }//GEN-LAST:event_botonVenderComponenteActionPerformed

    private void botonSalirPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirPcActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirPcActionPerformed

    private void botonVenderPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVenderPcActionPerformed
        
        if(tablaVenderPc.getRowCount() == 0) {
            return;
        }
        if(tablaVenderPc.getSelectedRow() == -1) {
            return;
        }
        int filaSeleccionada = tablaVenderPc.getSelectedRow();
        int numFilas = tablaVenderPc.getRowCount();
        fa.venderEjemplarPc((String)tablaVenderPc.getValueAt(filaSeleccionada, 0), c, e);
        ModeloTablaVentaPcs tablaVentaPcs = new ModeloTablaVentaPcs(fa);
        tablaVenderPc.setModel(tablaVentaPcs);
        tablaVentaPcs.setFilas(fa.obtenerPcsVenta());
        if((tablaVenderPc.getRowCount() != numFilas) && (tablaVenderPc.getRowCount() > 0)) {
            if(filaSeleccionada != 0) tablaVenderPc.setRowSelectionInterval(filaSeleccionada-1, filaSeleccionada-1);
            else tablaVenderPc.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
        }
        else if(tablaVenderPc.getRowCount() != 0) tablaVenderPc.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
        else tablaVenderPc.getSelectionModel().clearSelection();
        tablaVenderPc.getColumnModel().getColumn(0).setPreferredWidth(500);
        
        
    }//GEN-LAST:event_botonVenderPcActionPerformed

    private void botonSalirRepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirRepararActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirRepararActionPerformed

    private void tablaRepararMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRepararMouseClicked
        if(tablaReparar.getRowCount() == 0) {
            return;
        }
        
        if(((String)tablaReparar.getValueAt(tablaReparar.getSelectedRow(), 4)).equals("-----------------------------------")) {
            botonDevolver.setEnabled(true);
        }
        else{
            botonDevolver.setEnabled(false);
        }
    }//GEN-LAST:event_tablaRepararMouseClicked

    private void botonDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDevolverActionPerformed
        int filas = tablaReparar.getRowCount();
        ModeloTablaReparacionesAsistentes mTablaRA = (ModeloTablaReparacionesAsistentes)tablaReparar.getModel();
        fa.devolverReparacion(c, e, mTablaRA.obtenerReparacion(tablaReparar.getSelectedRow()).getId());
        ModeloTablaReparacionesAsistentes tablaReparacionesAsistentes = new ModeloTablaReparacionesAsistentes(fa);
        tablaReparar.setModel(tablaReparacionesAsistentes);
        tablaReparacionesAsistentes.setFilas(fa.obtenerPcsReparados(this.c));
        tablaReparar.getColumnModel().getColumn(0).setPreferredWidth(300);
        tablaReparar.setRowSelectionInterval(filas-1, filas-1);
    }//GEN-LAST:event_botonDevolverActionPerformed

    private void botonNuevaReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaReparacionActionPerformed

        if(textoDescripcion.getText().equals("")) {
            fa.muestraExcepcion("Debe insertar una descripcion para la reparacion");
        }
        else{
            fa.nuevaReparacion(textoDescripcion.getText(), c, e);
            textoDescripcion.setText(null);
        }
    }//GEN-LAST:event_botonNuevaReparacionActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        ModeloListaStrings s = (ModeloListaStrings) listaPersonalizados.getModel();
        ModeloTablaVentaPersonalizados vp = (ModeloTablaVentaPersonalizados) tablaCompPers.getModel();
        fa.borrarPcPersonalizado(s.getElementos().get(listaPersonalizados.getSelectedIndex()), c);
        s.borrarElemento(listaPersonalizados.getSelectedIndex());
        vp.borraTabla();
        txtTotal.setText(" ");
        textoVentas.setText(" ");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void borrarTablas() {
        descripcionCpu.setText("");
        descripcionAlimentacion.setText("");
        descripcionDiscoDuro.setText("");
        descripcionGpu.setText("");
        descripcionPerifericos.setText("");
        descripcionPlacaBase.setText("");
        descripcionRam.setText("");
        descripcionRefrigeracion.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane MenuDespachar;
    private javax.swing.JPanel PanelComponentes;
    private javax.swing.JPanel PanelPc;
    private javax.swing.JPanel PanelPcPersonalizado;
    private javax.swing.JPanel PanelReparar;
    private javax.swing.JButton botonDevolver;
    private javax.swing.JButton botonNuevaReparacion;
    private javax.swing.JButton botonSalirPc;
    private javax.swing.JButton botonSalirReparar;
    private javax.swing.JButton botonSalirVenderComponente;
    private javax.swing.JButton botonVenderComponente;
    private javax.swing.JButton botonVenderPc;
    private javax.swing.JButton botonVenderPersonalizado;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSalirPersonalizados;
    private javax.swing.JTextArea descripcionAlimentacion;
    private javax.swing.JTextArea descripcionCpu;
    private javax.swing.JTextArea descripcionDiscoDuro;
    private javax.swing.JTextArea descripcionGpu;
    private javax.swing.JTextArea descripcionPerifericos;
    private javax.swing.JTextArea descripcionPlacaBase;
    private javax.swing.JTextArea descripcionRam;
    private javax.swing.JTextArea descripcionRefrigeracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList listaPersonalizados;
    private javax.swing.JTable tablaAlimentacion;
    private javax.swing.JTable tablaCPUs;
    private javax.swing.JTable tablaCompPers;
    private javax.swing.JTable tablaDiscosDuros;
    private javax.swing.JTable tablaGPUs;
    private javax.swing.JTable tablaPerifericos;
    private javax.swing.JTable tablaPlacasBase;
    private javax.swing.JTable tablaRAMs;
    private javax.swing.JTable tablaRefrigeracion;
    private javax.swing.JTable tablaReparar;
    private javax.swing.JTable tablaVenderPc;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoVentas;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
