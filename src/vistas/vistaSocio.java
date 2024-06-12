/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import accesoADatos.SocioData;
import entidades.Socio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin
 */
public class vistaSocio extends javax.swing.JInternalFrame {

    private int TipoRadio = 0;
    private String buscar = "";
    private DefaultTableModel modeloTable;
    private ArrayList<Socio> listaSocio = new ArrayList<Socio>();
    private SocioData socioData;
    private Socio BuscarSocio;

    /**
     * Creates new form vistaSocio
     */
    public vistaSocio() {
        initComponents();
        disableButtonInicio();
        BuscarSocio = null;
        socioData = new SocioData();
        armarEncabezado();
        textModificado();

        enlazarListenerRadio();
        TipoRadio = Filtro();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrup = new javax.swing.ButtonGroup();
        jtbpContenedor = new javax.swing.JTabbedPane();
        jPnlSocios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblDatos = new javax.swing.JTable();
        jTxtBuscar = new javax.swing.JTextField();
        jRbCodigo = new javax.swing.JRadioButton();
        jRbNombreApellido = new javax.swing.JRadioButton();
        jBtnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRbTodos = new javax.swing.JRadioButton();
        jRbDni = new javax.swing.JRadioButton();
        jCbBaja = new javax.swing.JCheckBox();
        jPnlEdicion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jlbliDsocio = new javax.swing.JLabel();
        jPnlContnedorGestion = new javax.swing.JPanel();
        jTxtDni = new javax.swing.JTextField();
        jTxtEdad = new javax.swing.JTextField();
        jTxtCorreo = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        jTxtTelefono = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestion de socios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/socios.png"))); // NOI18N

        jtbpContenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbpContenedorMouseClicked(evt);
            }
        });

        jPnlSocios.setBackground(new java.awt.Color(51, 153, 255));

        jTblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblDatos);

        jTxtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtBuscar.setEnabled(false);

        btnGrup.add(jRbCodigo);
        jRbCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jRbCodigo.setText("Codigo");

        btnGrup.add(jRbNombreApellido);
        jRbNombreApellido.setForeground(new java.awt.Color(255, 255, 255));
        jRbNombreApellido.setText("Nombre y apellido");

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.setEnabled(false);
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("# Seleccione  la fila para gestionar al socio");

        btnGrup.add(jRbTodos);
        jRbTodos.setForeground(new java.awt.Color(255, 255, 255));
        jRbTodos.setText("Todos");

        btnGrup.add(jRbDni);
        jRbDni.setForeground(new java.awt.Color(255, 255, 255));
        jRbDni.setText("Dni");

        jCbBaja.setBackground(new java.awt.Color(255, 102, 102));
        jCbBaja.setForeground(new java.awt.Color(255, 255, 255));
        jCbBaja.setText("Baja");
        jCbBaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        jCbBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlSociosLayout = new javax.swing.GroupLayout(jPnlSocios);
        jPnlSocios.setLayout(jPnlSociosLayout);
        jPnlSociosLayout.setHorizontalGroup(
            jPnlSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlSociosLayout.createSequentialGroup()
                .addGroup(jPnlSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlSociosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPnlSociosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPnlSociosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPnlSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlSociosLayout.createSequentialGroup()
                                .addComponent(jRbTodos)
                                .addGap(18, 18, 18)
                                .addComponent(jRbDni)
                                .addGap(18, 18, 18)
                                .addComponent(jRbCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(jRbNombreApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(jCbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtBuscar))
                        .addGap(35, 35, 35)
                        .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPnlSociosLayout.setVerticalGroup(
            jPnlSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlSociosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPnlSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlSociosLayout.createSequentialGroup()
                        .addGroup(jPnlSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRbCodigo)
                            .addComponent(jRbNombreApellido)
                            .addComponent(jRbTodos)
                            .addComponent(jRbDni)
                            .addComponent(jCbBaja))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jBtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jtbpContenedor.addTab("Busqueda", jPnlSocios);

        jPnlEdicion.setBackground(new java.awt.Color(51, 153, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestion de socios");

        jBtnNuevo.setText("Nuevo");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnEliminar.setText("Baja");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jlbliDsocio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlbliDsocio.setForeground(new java.awt.Color(255, 255, 255));
        jlbliDsocio.setText(" # ");

        jPnlContnedorGestion.setBackground(new java.awt.Color(51, 153, 255));

        jTxtDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtDni.setNextFocusableComponent(jTxtNombre);

        jTxtEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtEdad.setNextFocusableComponent(jTxtCorreo);

        jTxtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtCorreo.setNextFocusableComponent(jTxtTelefono);

        jTxtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtNombre.setNextFocusableComponent(jTxtApellido);

        jTxtApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtApellido.setNextFocusableComponent(jTxtEdad);

        jTxtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPnlContnedorGestionLayout = new javax.swing.GroupLayout(jPnlContnedorGestion);
        jPnlContnedorGestion.setLayout(jPnlContnedorGestionLayout);
        jPnlContnedorGestionLayout.setHorizontalGroup(
            jPnlContnedorGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContnedorGestionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPnlContnedorGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtApellido)
                    .addComponent(jTxtNombre)
                    .addComponent(jTxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(jPnlContnedorGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTxtEdad)
                    .addComponent(jTxtCorreo)
                    .addComponent(jTxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPnlContnedorGestionLayout.setVerticalGroup(
            jPnlContnedorGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContnedorGestionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPnlContnedorGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnlContnedorGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnlContnedorGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnlEdicionLayout = new javax.swing.GroupLayout(jPnlEdicion);
        jPnlEdicion.setLayout(jPnlEdicionLayout);
        jPnlEdicionLayout.setHorizontalGroup(
            jPnlEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlEdicionLayout.createSequentialGroup()
                .addGroup(jPnlEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlEdicionLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jlbliDsocio))
                    .addGroup(jPnlEdicionLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel2))
                    .addGroup(jPnlEdicionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPnlContnedorGestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(jPnlEdicionLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPnlEdicionLayout.setVerticalGroup(
            jPnlEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlEdicionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jlbliDsocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnlContnedorGestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPnlEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(228, 228, 228))
        );

        jtbpContenedor.addTab("Gestion", jPnlEdicion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtbpContenedor)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtbpContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbpContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbpContenedorMouseClicked
        //jTxtBuscar.requestFocusInWindow();
        // jPnlSocios.getV
        int selectedIndex = jtbpContenedor.getSelectedIndex();

        if (selectedIndex == 1) {
            jTxtDni.requestFocus();

        }
    }//GEN-LAST:event_jtbpContenedorMouseClicked

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        if (validarBuscar()) {
            if (TipoRadio == 3) {
                BuscarPorCodigo();
            }
            if (TipoRadio == 2) {
                BuscarPorDni();
            }
            if(TipoRadio==4){
                BuscarPorNombre();
            }

        } else {
            if (TipoRadio <= 0) {
                libs.FuncionesComunes.vistaDialogo("Seleccione un filtro", 0,this);
            }

        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
       libs.FuncionesComunes.resetFormContentPanel(jPnlContnedorGestion);
       BuscarSocio=null;
       jlbliDsocio.setText("#");
       disableButtonInicio();
    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
       guardar();
    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        baja();
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jTblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblDatosMouseClicked
         int selectedRow = jTblDatos.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener el valor de la columna "Nombre" (columna 1)
                    int idSocio =Integer.valueOf(jTblDatos.getValueAt(selectedRow, 0).toString());
                    disableButtonEditar();
                    jtbpContenedor.setSelectedIndex(1);
                    cargarDatos(idSocio);
                }
    }//GEN-LAST:event_jTblDatosMouseClicked

    private void jCbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbBajaActionPerformed
        if(TipoRadio==1){
             listarTodos();
        }
    }//GEN-LAST:event_jCbBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrup;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JCheckBox jCbBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPnlContnedorGestion;
    private javax.swing.JPanel jPnlEdicion;
    private javax.swing.JPanel jPnlSocios;
    private javax.swing.JRadioButton jRbCodigo;
    private javax.swing.JRadioButton jRbDni;
    private javax.swing.JRadioButton jRbNombreApellido;
    private javax.swing.JRadioButton jRbTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblDatos;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtBuscar;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtDni;
    private javax.swing.JTextField jTxtEdad;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtTelefono;
    private javax.swing.JLabel jlbliDsocio;
    private javax.swing.JTabbedPane jtbpContenedor;
    // End of variables declaration//GEN-END:variables

    private void textModificado() {
        libs.FuncionesComunes.textPrompt(jTxtDni, "D.N.I (numerico)");
        libs.FuncionesComunes.textPrompt(jTxtNombre, "Nombre");
        libs.FuncionesComunes.textPrompt(jTxtApellido, "Apellido");
        libs.FuncionesComunes.textPrompt(jTxtCorreo, "Correo (name@dominio.com)");
        libs.FuncionesComunes.textPrompt(jTxtTelefono, "Telefono (numerico)");
        libs.FuncionesComunes.textPrompt(jTxtEdad, "Edad (numerico)");

    }

    private void disableButtonInicio() {
        jBtnBuscar.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        jBtnNuevo.setEnabled(false);
        
    }

    private void disableButtonEditar() {
        jBtnEliminar.setEnabled(true);
        jBtnNuevo.setEnabled(true);
        
         
    }

    private void BuscarPorCodigo() {
        try {

            int id = Integer.valueOf(buscar);
            BuscarSocio = null;
            BuscarSocio = socioData.buscarSocioPorId(id, CheckBaja());
             libs.FuncionesComunes.eliminarFilas(jTblDatos);
            if (BuscarSocio != null) {
               
                modeloTable.addRow(new Object[]{
                    BuscarSocio.getIdSocio(),
                    BuscarSocio.getDni(),
                    BuscarSocio.getNombre(),
                    BuscarSocio.getApellido(),
                    BuscarSocio.getEdad(),
                    BuscarSocio.getTelefono()
                });
            } else {
                libs.FuncionesComunes.vistaDialogo("No hay resultados", 1, this);
            }

        } catch (NullPointerException e) {
            libs.FuncionesComunes.vistaDialogo("EL codigo es numerico", 1, this);
        }

    }

    private void BuscarPorDni() {
        try {

            String dni = buscar;
            BuscarSocio = null;
            BuscarSocio = socioData.buscarSocioPorDni(dni, CheckBaja());
            libs.FuncionesComunes.eliminarFilas(jTblDatos);
            if (BuscarSocio != null) {
                
                modeloTable.addRow(new Object[]{
                    BuscarSocio.getIdSocio(),
                    BuscarSocio.getDni(),
                    BuscarSocio.getNombre(),
                    BuscarSocio.getApellido(),
                    BuscarSocio.getEdad(),
                    BuscarSocio.getTelefono()
                });
            } else {
                libs.FuncionesComunes.vistaDialogo("No hay resultados", 1, this);
            }

        } catch (Exception e) {
            //libs.FuncionesComunes.vistaDialogo("EL codigo es numerico", 1);
        }

    }

    private void BuscarPorNombre() {
        try {

            listaSocio = socioData.buscarSocioPorNombre(buscar, CheckBaja());
             libs.FuncionesComunes.eliminarFilas(jTblDatos);
            if (listaSocio.size() > 0) {
               
                for (Socio socio : listaSocio) {
                    modeloTable.addRow(new Object[]{
                        socio.getIdSocio(),
                        socio.getDni(),
                        socio.getNombre(),
                        socio.getApellido(),
                        socio.getEdad(),
                        socio.getTelefono()
                    });
                }
            } else {
                libs.FuncionesComunes.vistaDialogo("No hay resultados", 1, this);
            }

        } catch (Exception e) {
            //libs.FuncionesComunes.vistaDialogo("EL codigo es numerico", 1);
        }

    }

    private void listarTodos() {
        if (validarBuscar()) {

            listaSocio = socioData.listarSocio(CheckBaja());
            libs.FuncionesComunes.eliminarFilas(jTblDatos);
            if (listaSocio.size() > 0) {
                
                for (Socio socio : listaSocio) {
                    modeloTable.addRow(new Object[]{
                        socio.getIdSocio(),
                        socio.getDni(),
                        socio.getNombre(),
                        socio.getApellido(),
                        socio.getEdad(),
                        socio.getTelefono()
                    });
                }
            }

        }
    }

    private boolean validarBuscar() {
        boolean res = false;
        buscar = jTxtBuscar.getText().trim();

        if (TipoRadio != 0 && !buscar.isEmpty()) {

            if (TipoRadio == 2 || TipoRadio == 3) {
                if (libs.FuncionesComunes.validarNumericos(buscar)) {
                    res = true;
                } else {
                    libs.FuncionesComunes.vistaDialogo("Para codigo o Dni los campos son numericos.", 0,this);
                }
            } else {
                if (TipoRadio == 4 || TipoRadio == 1) {
                    res = true;
                }
            }
        } else {
            res = false;

            if (TipoRadio == 1) {
                res = true;
            }
        }

        return res;
    }

    private int Filtro() {
        int radio = 0;
        ButtonModel selectedModel = btnGrup.getSelection();
        jTxtBuscar.setEnabled(true);
        jBtnBuscar.setEnabled(true);
        if (selectedModel != null) {
            libs.FuncionesComunes.eliminarFilas(jTblDatos);
            jTxtBuscar.requestFocus();
            libs.FuncionesComunes.textPrompt(jTxtBuscar, " ");
            if (selectedModel == jRbDni.getModel()) {
                libs.FuncionesComunes.textPrompt(jTxtBuscar, "D.N.I - 34877112");
                radio = 2;
            } else if (selectedModel == jRbCodigo.getModel()) {
                libs.FuncionesComunes.textPrompt(jTxtBuscar, "Codigo - 100");
                radio = 3;
            } else if (selectedModel == jRbNombreApellido.getModel()) {
                libs.FuncionesComunes.textPrompt(jTxtBuscar, "Nombre o Apellido");
                radio = 4;
            } else if (selectedModel == jRbTodos.getModel()) {
                radio = 1;
                jTxtBuscar.setEnabled(false);
                jBtnBuscar.setEnabled(false);
            }

        } else {
            radio = 0;
        }

        return radio;
    }
    //

    private void enlazarListenerRadio() {
        jRbTodos.addActionListener(radioButtonListener);
        jRbDni.addActionListener(radioButtonListener);
        jRbCodigo.addActionListener(radioButtonListener);
        jRbNombreApellido.addActionListener(radioButtonListener);
    }

    ActionListener radioButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TipoRadio = Filtro();

            if (TipoRadio == 1) {
                listarTodos();
            }
        }
    };

    private void armarEncabezado() {
        modeloTable = libs.FuncionesComunes.ArmadoEncabezados(entidades.Socio.CabeceraSocio.Codigo);
        jTblDatos.setModel(modeloTable);
        //libs.FuncionesComunes.alinearCabeceras(1, "right", jTblDatos);

    }

    private int CheckBaja() {
        int res;
        if (jCbBaja.isSelected()) {
            res = 0;
        } else {
            res = 1;
        }

        return res;
    }

    
    private void guardar() {
        if (validarCampos()) {
            if (BuscarSocio == null) {

                Socio socio = new Socio(
                        jTxtDni.getText().trim(),
                        jTxtNombre.getText().trim(),
                        jTxtApellido.getText().trim(),
                        Integer.valueOf(jTxtEdad.getText().trim()),
                        jTxtCorreo.getText().trim(),
                        jTxtTelefono.getText().trim()
                );
                if (socioData.guardarSocio(socio)) {
                    BuscarSocio=null;
                    BuscarSocio=socio;
                    libs.FuncionesComunes.vistaDialogo("Socio guardado Correctamente", 1, this);
                    jlbliDsocio.setText("# " + BuscarSocio.getIdSocio());
                    disableButtonEditar();
                }
            }else{
                
                 Socio socio = new Socio(
                         BuscarSocio.getIdSocio(),
                        jTxtDni.getText().trim(),
                        jTxtNombre.getText().trim(),
                        jTxtApellido.getText().trim(),
                        Integer.valueOf(jTxtEdad.getText().trim()),
                        jTxtCorreo.getText().trim(),
                        jTxtTelefono.getText().trim()
                );
                BuscarSocio=null;
                BuscarSocio=socio;
                if(socioData.modificarSocios(BuscarSocio)){
                   
                     libs.FuncionesComunes.vistaDialogo("Socio editado Correctamente", 1, this);
                     disableButtonEditar();
                }
            }
        }

    }
    
   private void cargarDatos(int id){
      
            BuscarSocio = null;
            BuscarSocio = socioData.buscarSocioPorId(id);
            if(BuscarSocio!=null){
                jlbliDsocio.setText("# "+String.valueOf(BuscarSocio.getIdSocio()));
                jTxtDni.setText(BuscarSocio.getDni());
                jTxtNombre.setText(BuscarSocio.getNombre());
                jTxtApellido.setText(BuscarSocio.getApellido());
                
                jTxtEdad.setText(String.valueOf(BuscarSocio.getEdad()));
                jTxtCorreo.setText(BuscarSocio.getCorreo());
                jTxtTelefono.setText(BuscarSocio.getTelefono());
                if(!BuscarSocio.getEstado()){
                   
                    jBtnEliminar.setText("Alta");
                    disableButtonEditar();
                }else{
                    jBtnEliminar.setText("Baja");
                }
            }else{
                libs.FuncionesComunes.vistaDialogo("No se puede cargar el socio intenete mas tarde", 0,this);
                disableButtonInicio();
                libs.FuncionesComunes.resetFormContentPanel(jPnlContnedorGestion);
                 jtbpContenedor.setSelectedIndex(0);
                 jTxtBuscar.setText("");
                  libs.FuncionesComunes.eliminarFilas(jTblDatos);
                
                
            }
            
   }
    
    private boolean validarCampos(){
        if(libs.FuncionesComunes.ValidarVacio(jPnlContnedorGestion)){
            if(!libs.FuncionesComunes.validarNumericos(jTxtDni.getText().trim()) || 
                    !libs.FuncionesComunes.validarNumericos(jTxtEdad.getText().trim()) ||
                    !libs.FuncionesComunes.validarNumericos(jTxtTelefono.getText().trim()) || 
                    !libs.FuncionesComunes.validarCorreo(jTxtCorreo.getText().trim())){
                
                libs.FuncionesComunes.vistaDialogo("Porfavor verifique los campos, tiene que tener el formato valido.", 0,this);
                return false;
            }
            
        }else{
            libs.FuncionesComunes.vistaDialogo("Todo los campos son obligatorios", 1,this);
            return false;
        }
        return true;
    }
    
    private void baja(){
        if(BuscarSocio!=null){
           if(BuscarSocio.getEstado()){
             if(socioData.bajaSocio(BuscarSocio.getIdSocio(),0)){
                 libs.FuncionesComunes.vistaDialogo("Se dio de baja al socio", 1,this);
                 disableButtonInicio();
                 libs.FuncionesComunes.resetFormContentPanel(jPnlContnedorGestion);
                 jlbliDsocio.setText("#");
                 
            }
             }
               else {
                   //alta
                   if (socioData.bajaSocio(BuscarSocio.getIdSocio(), 1)) {
                       libs.FuncionesComunes.vistaDialogo("Se dio de Alta al socio", 1,this);
                       disableButtonInicio();
                       libs.FuncionesComunes.resetFormContentPanel(jPnlContnedorGestion);
                       jlbliDsocio.setText("#");
                       jBtnEliminar.setName("Baja");

                   }

               }
        
           
        }
    }
    
}
