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
   private  ArrayList<Socio> listaSocio;
   private  ArrayList<Socio> listaSocioMembresia;
   
   
   
    public vistaMembresias()
    {
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
        
        listaSocio=mData.listarSocioSinMembresia();
        listaSocioMembresia=mData.listarSocioConMembresia();
        if(listaSocio.size()<=0){
            libs.FuncionesComunes.vistaDialogo("No hay socios o todo los socios tienen membresias.", 1,this);
            btnGuardar.setEnabled(false);
            
        }else{
            cargarSociosCb();
        }
        
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
        // Aplicar filtro de números al campo txtIdSocio2
//        ((AbstractDocument) txtIdSocio2.getDocument()).setDocumentFilter(new DocumentFilter() {
//            @Override
//            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
//                if (string.matches("[0-9]*")) {
//                    super.insertString(fb, offset, string, attr);
//                }
//            }

//            @Override
//            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
//                if (text.matches("[0-9]*")) {
//                    super.replace(fb, offset, length, text, attrs);
//                }
//                }
//    });

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

        setClosable(true);
        setIconifiable(true);

        jtbpContenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbpContenedorMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel1.setText("Inscripcion de Membresias");

        lblIdSocio.setText("Seleccione un Socio:");

        txtCantidadPases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadPasesActionPerformed(evt);
            }
        });

        lblFechaInicio.setText("Fecha de Inicio:");

        lblFechaFin.setText("Fecha de Fin:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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
                        .addGap(57, 57, 57)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jtbpContenedor.addTab("Inscripcion", jPnlInscripciones);

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

        jBBaja.setText("Baja");
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jBAlta.setText("Alta");
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBMembresiasCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jBAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBaja)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jBMembresiasCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        lblIdSocio2.setText("Seleccione un Socio:");

        jCbSociosHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbSociosHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdSocio2)
                    .addComponent(jCbSociosHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblIdSocio2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCbSociosHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnlHistorialLayout = new javax.swing.GroupLayout(jPnlHistorial);
        jPnlHistorial.setLayout(jPnlHistorialLayout);
        jPnlHistorialLayout.setHorizontalGroup(
            jPnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlHistorialLayout.createSequentialGroup()
                .addGroup(jPnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlHistorialLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlHistorialLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPnlHistorialLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPnlHistorialLayout.setVerticalGroup(
            jPnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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


        Socio socio = new Socio();
       // socio.setIdSocio(idSocio);


        
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

    private void txtCantidadPasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadPasesActionPerformed
        
    
    
    }//GEN-LAST:event_txtCantidadPasesActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
         
         Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jtbpContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbpContenedorMouseClicked
       int selectedIndex = jtbpContenedor.getSelectedIndex();

        if (selectedIndex == 2) {//historial El tab
           if(listaSocioMembresia.size()==0){
               libs.FuncionesComunes.vistaDialogo("No hay socios con membresias", 0, this);
           }
        }
    }//GEN-LAST:event_jtbpContenedorMouseClicked

    private void jCbSociosHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbSociosHistorialActionPerformed
       SeleccionarSocioActualHistorial();
       //Solo va entrar si es un objeto distinto de null 
       if (socioActualHistorial != null && socioActualHistorial.getNombre()!= "Seleccione") {
            //Aca llamr un metod que filre por socio y se coloce en la tabla
            //para que depues al selecionar una fila podes dar de baja o alta etc
            //
            
           System.out.println(socioActual);
        }
    }//GEN-LAST:event_jCbSociosHistorialActionPerformed

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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBMembresiasCanceladas;
    private javax.swing.JComboBox<Socio> jCbSociosHistorial;
    private javax.swing.JComboBox<Socio> jCbSociosLista;
    private javax.swing.JLabel jLabel1;
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

    private void Limpiar() {
   // txtIdSocio.setText("");
    txtCantidadPases.setText("");
    txtCosto.setText("");
    jdcFechaInicio.setDate(null);
    jdcFechaFin.setDate(null);
    //chkEstado.setSelected(false);
    }
    
    
    private void cargarSociosCb(){
        
        for (Socio socio : listaSocio) {
            jCbSociosLista.addItem(socio);
           
        }
        //El socio vacio es para que puedas hacer la accione de eleguir y llamar algun metodo que liste en la tabla
        jCbSociosHistorial.addItem(new Socio("-","Seleccione","-"));
        for (Socio socio : listaSocioMembresia) {
            jCbSociosHistorial.addItem(socio);
           
        }
        
        
    }
    private void edicioTxt(){
        libs.FuncionesComunes.textPrompt(txtCantidadPases, "Cantidad de Pases (numerico)");
        libs.FuncionesComunes.textPrompt(txtCosto, "Costo o precio ($100.00)");
        
    }
    
    
      private void SeleccionarSocioActualHistorial(){
          socioActualHistorial = (Socio) jCbSociosHistorial.getSelectedItem();
     }
      
       private void SeleccionarSocioActual(){
          socioActual = (Socio) jCbSociosLista.getSelectedItem();
     }
    
}
