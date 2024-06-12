/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import accesoADatos.MembresiasData;
import entidades.Membresias;
import entidades.Socio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel Zurita
 */
public class vistaMembresias extends javax.swing.JInternalFrame {

   private MembresiasData mData;
   private Membresias membre;
   private Socio socio;
   private ArrayList<Membresias> listaM;
   private DefaultTableModel tablaM;
    public vistaMembresias() {
        initComponents();
        mData = new MembresiasData();
        membre = new Membresias();
        socio = new Socio();
        listaM = new ArrayList<>();
        tablaM = new DefaultTableModel();
        jTMembresias.setDefaultEditor(Object.class, null);
        Calendar cal = Calendar.getInstance();
        Date fechaActual = cal.getTime();
        jdcFechaInicio.setDate(fechaActual);
        
        armarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jtbpContenedor = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtIdSocio = new javax.swing.JTextField();
        txtCantidadPases = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        chkEstado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblIdSocio = new javax.swing.JLabel();
        lblCantidadPases = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMembresias = new javax.swing.JTable();
        txtIdSocio2 = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        lblHistorial = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBAlta = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        jBMembresiasCanceladas = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        txtIdSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdSocioActionPerformed(evt);
            }
        });

        chkEstado.setText("Activo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");

        lblIdSocio.setText("ID Socio:");

        lblCantidadPases.setText("Cantidad de Pases:");

        lblCosto.setText("Costo:");

        lblFechaInicio.setText("Fecha de Inicio:");

        lblFechaFin.setText("Fecha de Fin:");

        lblEstado.setText("Estado:");

        jLabel1.setText("Inscripcion de Membresias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdSocio)
                            .addComponent(lblCantidadPases)
                            .addComponent(lblCosto)
                            .addComponent(lblFechaInicio)
                            .addComponent(lblFechaFin)
                            .addComponent(lblEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(276, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(47, 47, 47)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCantidadPases, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(txtIdSocio)
                                .addComponent(txtCosto))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkEstado))))
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtIdSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblIdSocio))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCantidadPases, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblCantidadPases))
                                .addGap(30, 30, 30)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCosto))
                        .addGap(38, 38, 38)
                        .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFechaInicio))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaFin)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEstado)
                    .addComponent(lblEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jtbpContenedor.addTab("tab1", jPanel1);

        jTMembresias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTMembresias);

        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        lblHistorial.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblHistorial.setText("Membresias");
        lblHistorial.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("ID del socio:");

        jBAlta.setText("Alta");
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jBBaja.setText("Baja");
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jBMembresiasCanceladas.setText("Membresias Canceladas");
        jBMembresiasCanceladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMembresiasCanceladasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(txtIdSocio2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(lblHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jBAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jBBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBMembresiasCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdSocio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(lblHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAlta)
                    .addComponent(jBBaja)
                    .addComponent(jBMembresiasCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jtbpContenedor.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpContenedor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdSocioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
        int idSocio = Integer.parseInt(txtIdSocio.getText());
        int cantidadPases = Integer.parseInt(txtCantidadPases.getText());
        int costo = Integer.parseInt(txtCosto.getText());
        Date fechaInicio = jdcFechaInicio.getDate();
        Date fechaFin = jdcFechaFin.getDate();

        if (fechaInicio == null || fechaFin == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona las fechas de inicio y fin.");
            return;
        }


        Socio socio = new Socio();
        socio.setIdSocio(idSocio);


        
        membre.setSocio(socio);
        membre.setCantidadPases(cantidadPases);
        membre.setCosto (costo);
        membre.setFechaInicio(fechaInicio);
        membre.setFechaFin(fechaFin);
        membre.setEstado(true);


        mData.guardarMembresia(membre);


        JOptionPane.showMessageDialog(this, "Membresía registrada exitosamente.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa valores válidos para ID de Socio y Cantidad de Pases.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al registrar la membresía: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        int idSocio = Integer.parseInt(txtIdSocio2.getText());
           listaM = mData.historialMembresias(idSocio);
            cargarMembresiasTabla();
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
    int filaSeleccionada = jTMembresias.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this,"Seleccione una membresía para dar de baja.");
    } else {
        int idMembresia = (int) jTMembresias.getValueAt(filaSeleccionada, 0);
        
        boolean exito = mData.removerMembresias(idMembresia);
        
        if (exito) {
            JOptionPane.showMessageDialog(this, "La membresía se ha dado de baja correctamente.");
            cargarMembresiasTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al dar de baja la membresía.");
        }
    }
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
    int filaSeleccionada = jTMembresias.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una membresía para dar de alta.");
    } else {
        int idMembresia = (int) jTMembresias.getValueAt(filaSeleccionada, 0); 

        boolean exito = mData.altaMembresia(idMembresia);

        if (exito) {
            JOptionPane.showMessageDialog(this, "La membresía se ha dado de alta correctamente.");
            cargarMembresiasTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al dar de alta la membresía.");
        }
    }
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBMembresiasCanceladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMembresiasCanceladasActionPerformed
        cargarMembresiasCanceladas();
    }//GEN-LAST:event_jBMembresiasCanceladasActionPerformed

    private void armarTabla() {
        tablaM.addColumn("ID Membresia");
        tablaM.addColumn("Socio nombre");
        tablaM.addColumn("Cant. Pases");
        tablaM.addColumn("Costo");
        tablaM.addColumn("Fecha Inicio");
        tablaM.addColumn("Fecha Fin");
        jTMembresias.setModel(tablaM);
    }

    private void borrarFilas() {
        DefaultTableModel modeloTabla = (DefaultTableModel) jTMembresias.getModel();
        modeloTabla.setRowCount(0);
    }

    private void cargarMembresiasTabla() {
        borrarFilas();

        for (Membresias membresia : listaM) {
            tablaM.addRow(new Object[]{
                membresia.getIdMembresia(),
                membresia.getSocio().getNombre() + " " + membresia.getSocio().getApellido(),
                membresia.getCantidadPases(),
                membresia.getCosto(),
                membresia.getFechaInicio(),
                membresia.getFechaFin()
            });
        }
    }
    
    private void cargarMembresiasCanceladas() {
    DefaultTableModel modeloTabla = (DefaultTableModel) jTMembresias.getModel();
    modeloTabla.setRowCount(0);
    
    ArrayList<Membresias> membresiasCanceladas = mData.obtenerMembresiasCanceladas();
    
    for (Membresias membresia : membresiasCanceladas) {
        // Agregar cada membresía cancelada a la tabla
        modeloTabla.addRow(new Object[]{
            membresia.getIdMembresia(),
            membresia.getSocio().getNombre() + " " + membresia.getSocio().getApellido(),
            membresia.getCantidadPases(),
            membresia.getCosto(),
            membresia.getFechaInicio(),
            membresia.getFechaFin()
        });
    }
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBMembresiasCanceladas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMembresias;
    private javax.swing.JToggleButton jToggleButton1;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTabbedPane jtbpContenedor;
    private javax.swing.JLabel lblCantidadPases;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblIdSocio;
    private javax.swing.JTextField txtCantidadPases;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtIdSocio;
    private javax.swing.JTextField txtIdSocio2;
    // End of variables declaration//GEN-END:variables
}
