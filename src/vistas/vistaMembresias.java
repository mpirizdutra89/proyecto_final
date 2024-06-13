/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import accesoADatos.MembresiasData;
import entidades.Clase;
import entidades.Membresias;
import entidades.Socio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import libs.FuncionesComunes;
import static libs.FuncionesComunes.validarNumericos;

/**
 *
 * @author Ariel Zurita
 */
public class vistaMembresias extends javax.swing.JInternalFrame {

    private MembresiasData mData;
    private Membresias membre;
    private Socio socio;
    private Socio socioActual;
    private Socio socioActualHistorial;
    private ArrayList<Membresias> listaM;
    private DefaultTableModel tablaM;
    private ArrayList<Socio> listaSocio;
    private ArrayList<Socio> listaSocioMembresia;

    public vistaMembresias() {
        initComponents();
        mData = new MembresiasData();
        membre = new Membresias();
        socio = new Socio();
        listaM = new ArrayList<>();
        listaSocio = new ArrayList<>();
        listaSocioMembresia = new ArrayList<>();

        tablaM = new DefaultTableModel();

        jTMembresias.setDefaultEditor(Object.class, null);
        Calendar cal = Calendar.getInstance();
        Date fechaActual = cal.getTime();
        jdcFechaInicio.setDate(fechaActual);
        armarTabla();
        Limpiar();
        edicioTxt();

        listaSocio = mData.listarSocioSinMembresia();
        listaSocioMembresia = mData.listarSocioConMembresia();
        if (listaSocio.size() <= 0) {
            libs.FuncionesComunes.vistaDialogo("No hay socios o todo los socios tienen membresias.", 1, this);
            btnGuardar.setEnabled(false);

        } else {

        }
        cargarSociosCb();

        // Aplicar filtro de números al campo txtIdSocio
//        ((AbstractDocument) txtIdSocio.getDocument()).setDocumentFilter(new DocumentFilter() {
//            @Override
//            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
//                if (string.matches("[0-9]*")) {
//                    super.insertString(fb, offset, string, attr);
//                }
//            }
//
//            @Override
//            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
//                if (text.matches("[0-9]*")) {
//                    super.replace(fb, offset, length, text, attrs);
//                }
//                }
//            
//        });
        // Aplicar filtro de números al campo txtCantidadPases
        ((AbstractDocument) txtCantidadPases.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        // Aplicar filtro de números al campo txtCosto
        ((AbstractDocument) txtCosto.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbpContenedor = new javax.swing.JTabbedPane();
        jPnlInscripciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblIdSocio = new javax.swing.JLabel();
        jCbSociosLista = new javax.swing.JComboBox<>();
        txtCantidadPases = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPnlHistorial = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMembresias = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jBBaja = new javax.swing.JButton();
        jBAlta = new javax.swing.JButton();
        jBMembresiasCanceladas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblIdSocio2 = new javax.swing.JLabel();
        jCbSociosHistorial = new javax.swing.JComboBox<>();
        jLblCancelados = new javax.swing.JLabel();

        setBackground(new java.awt.Color(16, 41, 64));
        setClosable(true);
        setIconifiable(true);

        jtbpContenedor.setBackground(new java.awt.Color(16, 41, 64));
        jtbpContenedor.setForeground(new java.awt.Color(255, 255, 255));
        jtbpContenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbpContenedorMouseClicked(evt);
            }
        });

        jPnlInscripciones.setBackground(new java.awt.Color(16, 41, 64));
        jPnlInscripciones.setForeground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inscripcion de Membresias");

        jPanel1.setBackground(new java.awt.Color(16, 41, 64));
        jPanel1.setForeground(new java.awt.Color(242, 242, 242));

        lblIdSocio.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblIdSocio.setForeground(new java.awt.Color(242, 242, 242));
        lblIdSocio.setText("Seleccione un Socio:");

        jCbSociosLista.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N

        txtCantidadPases.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtCantidadPases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadPasesActionPerformed(evt);
            }
        });

        txtCosto.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N

        lblFechaInicio.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(242, 242, 242));
        lblFechaInicio.setText("Fecha de Inicio:");

        lblFechaFin.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(242, 242, 242));
        lblFechaFin.setText("Fecha de Fin:");

        btnGuardar.setBackground(new java.awt.Color(153, 177, 39));
        btnGuardar.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 1, 13));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(166, 46, 68));
        btnLimpiar.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(242, 242, 242));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFechaFin)
                    .addComponent(lblFechaInicio)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(51, 51, 51)
                        .addComponent(btnLimpiar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCantidadPases, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdSocio)
                    .addComponent(jCbSociosLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIdSocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCbSociosLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadPases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(lblFechaInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblFechaFin)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout jPnlInscripcionesLayout = new javax.swing.GroupLayout(jPnlInscripciones);
        jPnlInscripciones.setLayout(jPnlInscripcionesLayout);
        jPnlInscripcionesLayout.setHorizontalGroup(
            jPnlInscripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlInscripcionesLayout.createSequentialGroup()
                .addGroup(jPnlInscripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlInscripcionesLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1))
                    .addGroup(jPnlInscripcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnlInscripcionesLayout.setVerticalGroup(
            jPnlInscripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlInscripcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jtbpContenedor.addTab("Inscripcion", jPnlInscripciones);

        jPnlHistorial.setBackground(new java.awt.Color(16, 41, 64));
        jPnlHistorial.setForeground(new java.awt.Color(242, 242, 242));

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

        jPanel3.setBackground(new java.awt.Color(16, 41, 64));

        jBBaja.setBackground(new java.awt.Color(166, 46, 68));
        jBBaja.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jBBaja.setForeground(new java.awt.Color(242, 242, 242));
        jBBaja.setText("Cancelar");
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jBAlta.setBackground(new java.awt.Color(153, 177, 39));
        jBAlta.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jBAlta.setForeground(new java.awt.Color(0, 1, 13));
        jBAlta.setText("Renovar");
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jBMembresiasCanceladas.setBackground(new java.awt.Color(166, 46, 68));
        jBMembresiasCanceladas.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jBMembresiasCanceladas.setForeground(new java.awt.Color(242, 242, 242));
        jBMembresiasCanceladas.setText("Membresias Canceladas");
        jBMembresiasCanceladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMembresiasCanceladasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBBaja, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jBAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBMembresiasCanceladas)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBMembresiasCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBaja)))
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(16, 41, 64));

        lblIdSocio2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        lblIdSocio2.setForeground(new java.awt.Color(255, 255, 255));
        lblIdSocio2.setText("Seleccione un Socio:");

        jCbSociosHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbSociosHistorialActionPerformed(evt);
            }
        });

        jLblCancelados.setForeground(new java.awt.Color(255, 255, 255));
        jLblCancelados.setText("#");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbSociosHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdSocio2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLblCancelados, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIdSocio2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCbSociosHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCancelados)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPnlHistorialLayout = new javax.swing.GroupLayout(jPnlHistorial);
        jPnlHistorial.setLayout(jPnlHistorialLayout);
        jPnlHistorialLayout.setHorizontalGroup(
            jPnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPnlHistorialLayout.setVerticalGroup(
            jPnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtbpContenedor.addTab("Historial", jPnlHistorial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            //int idSocio = Integer.parseInt(txtIdSocio.getText());
            int cantidadPases = Integer.parseInt(txtCantidadPases.getText());
            int costo = Integer.parseInt(txtCosto.getText());
            Date fechaInicio = jdcFechaInicio.getDate();
            Date fechaFin = jdcFechaFin.getDate();

            if (fechaInicio == null || fechaFin == null) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona las fechas de inicio y fin.");
                return;
            }

            // socio.setIdSocio(idSocio);
            SeleccionarSocioActual();

            membre.setSocio(socioActual);
            membre.setCantidadPases(cantidadPases);
            membre.setCosto(costo);
            membre.setFechaInicio(fechaInicio);
            membre.setFechaFin(fechaFin);
            membre.setEstado(true);

            mData.guardarMembresia(membre);

            if (membre != null) {

                JOptionPane.showMessageDialog(this, "Membresía registrada exitosamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa valores válidos para ID de Socio y Cantidad de Pases.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la membresía: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        int filaSeleccionada = jTMembresias.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una membresía para dar de baja.");
        } else {
            int idMembresia = (int) jTMembresias.getValueAt(filaSeleccionada, 0);

            boolean exito = mData.removerMembresias(idMembresia);

            if (exito) {
                JOptionPane.showMessageDialog(this, "La membresía se ha dado de baja correctamente.");
                 borrarFilas();
                 resetCombo();
            } else {
                JOptionPane.showMessageDialog(this, "Error al dar de baja la membresía.");
            }
        }
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        int filaSeleccionada = jTMembresias.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una membresía para renovar.");
        } else {
            int idMembresia = (int) jTMembresias.getValueAt(filaSeleccionada, 0);
            //2 y 5
            //int pases=(int) jTMembresias.getValueAt(filaSeleccionada, 2);
           // String fechafin=(String) jTMembresias.getValueAt(filaSeleccionada, 5);
            //System.out.println(idMembresia+" "+pases+" "+fechafin);
            
            
            boolean exito = mData.renovarMembresias(idMembresia);

            if (exito) {
                JOptionPane.showMessageDialog(this, "La membresía  se renovo por 30 dias mas. Y se dio de alta");
                selectComboHistorial();
            } else {
                JOptionPane.showMessageDialog(this, "Error al renovar la membresía.");
            }
        }
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBMembresiasCanceladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMembresiasCanceladasActionPerformed
        cargarMembresiasCanceladas();
    }//GEN-LAST:event_jBMembresiasCanceladasActionPerformed

    private void txtCantidadPasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadPasesActionPerformed


    }//GEN-LAST:event_txtCantidadPasesActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jtbpContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbpContenedorMouseClicked
        int selectedIndex = jtbpContenedor.getSelectedIndex();

        if (selectedIndex == 2) {//historial El tab
            if (listaSocioMembresia.size() == 0) {
                libs.FuncionesComunes.vistaDialogo("No hay socios con membresias", 0, this);
            }
        }
    }//GEN-LAST:event_jtbpContenedorMouseClicked

    private void jCbSociosHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbSociosHistorialActionPerformed
        selectComboHistorial();
    }//GEN-LAST:event_jCbSociosHistorialActionPerformed

    private void cargarHistorialMembresiasTabla(int idSocio) {
        listaM = mData.historialMembresias(idSocio);
        cargarMembresiasTabla();
    }
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
        
        jCbSociosHistorial.setSelectedIndex(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBMembresiasCanceladas;
    private javax.swing.JComboBox<Socio> jCbSociosHistorial;
    private javax.swing.JComboBox<Socio> jCbSociosLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblCancelados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPnlHistorial;
    private javax.swing.JPanel jPnlInscripciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMembresias;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTabbedPane jtbpContenedor;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblIdSocio;
    private javax.swing.JLabel lblIdSocio2;
    private javax.swing.JTextField txtCantidadPases;
    private javax.swing.JTextField txtCosto;
    // End of variables declaration//GEN-END:variables

    private void resetCombo(){
        jCbSociosHistorial.removeAllItems();
        listaSocioMembresia = mData.listarSocioConMembresia();
        jCbSociosHistorial.addItem(new Socio("-", "Seleccione", "-"));
        for (Socio socio : listaSocioMembresia) {
            jCbSociosHistorial.addItem(socio);

        }
    }
    private void selectComboHistorial(){
          SeleccionarSocioActualHistorial();
        //Solo va entrar si es un objeto distinto de null 
        if (socioActualHistorial != null && socioActualHistorial.getNombre() != "Seleccione") {
            //Aca llamr un metod que filre por socio y se coloce en la tabla
            //para que depues al selecionar una fila podes dar de baja o alta etc
            //
            jLblCancelados.setText("Seleccione Socio:");
            cargarHistorialMembresiasTabla(socioActualHistorial.getIdSocio());
            //System.out.println(socioActualHistorial);
        }else{
           // jCbSociosHistorial.setSelectedIndex(0);
           jLblCancelados.setText("Lista de cancelados:");
          cargarMembresiasCanceladas();
        }
    }
    
    private void Limpiar() {
        // txtIdSocio.setText("");
        txtCantidadPases.setText("");
        txtCosto.setText("");
        jdcFechaInicio.setDate(null);
        jdcFechaFin.setDate(null);
        //chkEstado.setSelected(false);
    }

    private void cargarSociosCb() {

        for (Socio socio : listaSocio) {
            jCbSociosLista.addItem(socio);

        }
        //El socio vacio es para que puedas hacer la accione de eleguir y llamar algun metodo que liste en la tabla
        jCbSociosHistorial.addItem(new Socio("-", "Seleccione", "-"));
        for (Socio socio : listaSocioMembresia) {
            jCbSociosHistorial.addItem(socio);

        }

    }

    private void edicioTxt() {
        libs.FuncionesComunes.textPrompt(txtCantidadPases, "Cantidad de Pases (numerico)");
        libs.FuncionesComunes.textPrompt(txtCosto, "Costo o precio ($100.00)");

    }

    private void SeleccionarSocioActualHistorial() {
        socioActualHistorial = (Socio) jCbSociosHistorial.getSelectedItem();
    }

    private void SeleccionarSocioActual() {
        socioActual = (Socio) jCbSociosLista.getSelectedItem();
    }

}
