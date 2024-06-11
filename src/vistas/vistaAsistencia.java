package vistas;

import entidades.Clase;
import entidades.Socio;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin
 */
public class vistaAsistencia extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTable;
    /**
     * Creates new form vistaAsistencia
     */
    public vistaAsistencia() {
        initComponents();
        fecha();
        modificarDni();
        armarEncabezado();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPnlGestion = new javax.swing.JPanel();
        jPnlContendor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCbClase = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblDatos = new javax.swing.JTable();
        jLFecha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTDni = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSocios = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnBuscar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbtnListar = new javax.swing.JLabel();
        jbtnLimpiar = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JLabel();
        jPnlLista = new javax.swing.JPanel();
        jPnlSubcontenedorListar = new javax.swing.JPanel();
        jCbClaseListar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jbtnEliminar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Asistencia");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/asistencias.png"))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPnlGestion.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/clases.png"))); // NOI18N
        jLabel3.setText("Selecione una clase:");

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
        jScrollPane1.setViewportView(jTblDatos);

        jLFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/date.png"))); // NOI18N

        jTDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDniActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jListSocios);

        jLabel1.setText("# Ingrese los socios a la lista.");

        jLabel2.setText("# Seleccione una clase.");

        jLabel4.setText("# Seleccione una horario en la tabla.");

        jLabel5.setText("# El sistema le avisara si no hay cupo.");

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/buscar.png"))); // NOI18N
        jbtnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setText("Lista de Socios:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnBuscar)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jbtnBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jbtnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/tareas.png"))); // NOI18N
        jbtnListar.setToolTipText("Listar socios por clase");
        jbtnListar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnListarMouseClicked(evt);
            }
        });

        jbtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/reiniciar.png"))); // NOI18N
        jbtnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnLimpiarMouseClicked(evt);
            }
        });

        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/guardar.png"))); // NOI18N
        jbtnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPnlContendorLayout = new javax.swing.GroupLayout(jPnlContendor);
        jPnlContendor.setLayout(jPnlContendorLayout);
        jPnlContendorLayout.setHorizontalGroup(
            jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPnlContendorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jbtnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnGuardar)
                .addGap(29, 29, 29)
                .addComponent(jbtnLimpiar)
                .addGap(16, 16, 16))
            .addGroup(jPnlContendorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPnlContendorLayout.createSequentialGroup()
                        .addGroup(jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbClase, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPnlContendorLayout.setVerticalGroup(
            jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContendorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCbClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnGuardar)
                    .addComponent(jbtnLimpiar)
                    .addComponent(jbtnListar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnlGestionLayout = new javax.swing.GroupLayout(jPnlGestion);
        jPnlGestion.setLayout(jPnlGestionLayout);
        jPnlGestionLayout.setHorizontalGroup(
            jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
            .addGroup(jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnlGestionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPnlContendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPnlGestionLayout.setVerticalGroup(
            jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnlGestionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPnlContendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Gestion", jPnlGestion);

        jPnlLista.setBackground(new java.awt.Color(51, 51, 51));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/clases.png"))); // NOI18N
        jLabel7.setText("Lista de socios por clase:");

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/quitarlista.png"))); // NOI18N
        jbtnEliminar.setToolTipText("Listar socios por clase");
        jbtnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEliminarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPnlSubcontenedorListarLayout = new javax.swing.GroupLayout(jPnlSubcontenedorListar);
        jPnlSubcontenedorListar.setLayout(jPnlSubcontenedorListarLayout);
        jPnlSubcontenedorListarLayout.setHorizontalGroup(
            jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCbClaseListar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnEliminar)
                .addGap(37, 37, 37))
            .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPnlSubcontenedorListarLayout.setVerticalGroup(
            jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlSubcontenedorListarLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCbClaseListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnlListaLayout = new javax.swing.GroupLayout(jPnlLista);
        jPnlLista.setLayout(jPnlListaLayout);
        jPnlListaLayout.setHorizontalGroup(
            jPnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnlSubcontenedorListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPnlListaLayout.setVerticalGroup(
            jPnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnlSubcontenedorListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista", jPnlLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDniActionPerformed

    private void jbtnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnListarMouseClicked
        
    }//GEN-LAST:event_jbtnListarMouseClicked

    private void jbtnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnLimpiarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnLimpiarMouseClicked

    private void jbtnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnGuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnGuardarMouseClicked

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Clase> jCbClase;
    private javax.swing.JComboBox<Clase> jCbClaseListar;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<Socio> jListSocios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPnlContendor;
    private javax.swing.JPanel jPnlGestion;
    private javax.swing.JPanel jPnlLista;
    private javax.swing.JPanel jPnlSubcontenedorListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTblDatos;
    private javax.swing.JLabel jbtnBuscar;
    private javax.swing.JLabel jbtnEliminar;
    private javax.swing.JLabel jbtnGuardar;
    private javax.swing.JLabel jbtnLimpiar;
    private javax.swing.JLabel jbtnListar;
    // End of variables declaration//GEN-END:variables

    private void fecha(){
        jLFecha.setText(libs.FuncionesComunes.fechaActual());
    }
    
    private void modificarDni(){
        libs.FuncionesComunes.textPrompt(jTDni, "Buscar por dni");
    }
    
      private void armarEncabezado() {
        modeloTable = libs.FuncionesComunes.ArmadoEncabezados(entidades.Asistencia.CabeceraAsistencia.Clase);
        jTblDatos.setModel(modeloTable);
        //libs.FuncionesComunes.alinearCabeceras(1, "right", jTblDatos);

    }
 
      
      
}
