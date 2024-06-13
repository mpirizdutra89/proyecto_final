package vistas;

import accesoADatos.ClaseData;
import accesoADatos.EntrenadorData;
import entidades.Clase;
import entidades.Entrenador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ferrando Carlos
 */
public class vistaClase extends javax.swing.JInternalFrame {

    //
    private ClaseData cData;
    private EntrenadorData eData;
    private Clase claseB;
    private ArrayList<Clase> ltaClases;
    private ArrayList<Entrenador> ltaEntrenadores;
    private DefaultTableModel modeloTabla;

    private int btnRadio = 0;
    private String buscar = "";

    private static final int MIN_HORA = 7;
    private static final int MAX_HORA = 22;

    public vistaClase() {

        initComponents();
        placeholders();
        btnInicioDisable();
        claseB = null;
        cData = new ClaseData();
        eData = new EntrenadorData();
        ltaClases = new ArrayList<Clase>();
        ltaEntrenadores = new ArrayList<>();
        jTFidClase.setEnabled(false);
        ltaEntrenadores = (ArrayList<Entrenador>) eData.listarEntrenadores();

        cargarEntrenador();
        armarEncabezado();
        btnRadioEnlace();
        btnRadio = fitrado();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGseleccion = new javax.swing.ButtonGroup();
        jTabPcontenedor = new javax.swing.JTabbedPane();
        jPBuscar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTData = new javax.swing.JTable();
        jBbuscar = new javax.swing.JButton();
        jRtodos = new javax.swing.JRadioButton();
        jRnombre = new javax.swing.JRadioButton();
        jRentrenador = new javax.swing.JRadioButton();
        jRHorario = new javax.swing.JRadioButton();
        jTbuscar = new javax.swing.JTextField();
        jCBentrenadorB = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPAdmin = new javax.swing.JPanel();
        jLtitulo = new javax.swing.JLabel();
        jLidClase = new javax.swing.JLabel();
        jTFidClase = new javax.swing.JTextField();
        jLidEntrenadores = new javax.swing.JLabel();
        jCBentrenadorA = new javax.swing.JComboBox<>();
        jLnombre = new javax.swing.JLabel();
        jTFnombre = new javax.swing.JTextField();
        jLhorario = new javax.swing.JLabel();
        jTFhorario = new javax.swing.JTextField();
        jLcapacidad = new javax.swing.JLabel();
        jTFcapacidad = new javax.swing.JTextField();
        jLestado = new javax.swing.JLabel();
        jCkBestado = new javax.swing.JCheckBox();
        jBnuevo = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Clases");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/clases.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName(""); // NOI18N
        setNormalBounds(new java.awt.Rectangle(0, 0, 600, 600));

        jTabPcontenedor.setBackground(new java.awt.Color(204, 204, 204));
        jTabPcontenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabPcontenedorMouseClicked(evt);
            }
        });

        jPBuscar.setBackground(new java.awt.Color(204, 204, 204));

        jTData.setModel(new javax.swing.table.DefaultTableModel(
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
        jTData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTData);

        jBbuscar.setText("Buscar");
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        btnGseleccion.add(jRtodos);
        jRtodos.setText("Todos");

        btnGseleccion.add(jRnombre);
        jRnombre.setText("Nombre");

        btnGseleccion.add(jRentrenador);
        jRentrenador.setText("Entrenador");

        btnGseleccion.add(jRHorario);
        jRHorario.setText("Horario");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Sistema de Busqueda");

        javax.swing.GroupLayout jPBuscarLayout = new javax.swing.GroupLayout(jPBuscar);
        jPBuscar.setLayout(jPBuscarLayout);
        jPBuscarLayout.setHorizontalGroup(
            jPBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBuscarLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBuscarLayout.createSequentialGroup()
                        .addGroup(jPBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRentrenador)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPBuscarLayout.createSequentialGroup()
                                .addGroup(jPBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTbuscar)
                                    .addComponent(jCBentrenadorB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBuscarLayout.createSequentialGroup()
                                        .addComponent(jRtodos)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRnombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRHorario)))
                                .addGap(120, 120, 120)
                                .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBuscarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(179, 179, 179))))
        );
        jPBuscarLayout.setVerticalGroup(
            jPBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRtodos)
                    .addComponent(jRnombre)
                    .addComponent(jRHorario))
                .addGap(18, 18, 18)
                .addComponent(jRentrenador)
                .addGap(18, 18, 18)
                .addComponent(jCBentrenadorB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jTabPcontenedor.addTab("Buscar", jPBuscar);

        jPAdmin.setBackground(new java.awt.Color(204, 204, 204));

        jLtitulo.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jLtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLtitulo.setText("Administración de Clases");

        jLidClase.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLidClase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLidClase.setText("ID Clase ");

        jTFidClase.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N

        jLidEntrenadores.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLidEntrenadores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLidEntrenadores.setText("Entrenador");

        jLnombre.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLnombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLnombre.setText("Nombre");

        jTFnombre.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N

        jLhorario.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLhorario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLhorario.setText("Horario");

        jTFhorario.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N

        jLcapacidad.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLcapacidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLcapacidad.setText("Capacidad");

        jTFcapacidad.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N

        jLestado.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLestado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLestado.setText("Estado");

        jCkBestado.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jCkBestado.setText("Activo");

        jBnuevo.setText("Nuevo");
        jBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnuevoActionPerformed(evt);
            }
        });

        jBguardar.setText("Guardar");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jBeliminar.setText("Eliminar");
        jBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarActionPerformed(evt);
            }
        });

        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAdminLayout = new javax.swing.GroupLayout(jPAdmin);
        jPAdmin.setLayout(jPAdminLayout);
        jPAdminLayout.setHorizontalGroup(
            jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAdminLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLidEntrenadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLidClase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLhorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLcapacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLestado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAdminLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCkBestado)
                            .addComponent(jTFidClase, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAdminLayout.createSequentialGroup()
                                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTFcapacidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFhorario, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addContainerGap(130, Short.MAX_VALUE))
                            .addComponent(jCBentrenadorA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPAdminLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPAdminLayout.setVerticalGroup(
            jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAdminLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFidClase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLidClase))
                .addGap(20, 20, 20)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLidEntrenadores)
                    .addComponent(jCBentrenadorA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLnombre))
                .addGap(20, 20, 20)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLhorario))
                .addGap(20, 20, 20)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFcapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLcapacidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCkBestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLestado))
                .addGap(43, 43, 43)
                .addGroup(jPAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabPcontenedor.addTab("Administracion", jPAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabPcontenedor))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPcontenedor)
        );

        jTabPcontenedor.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabPcontenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabPcontenedorMouseClicked
        int indiceTab = jTabPcontenedor.getSelectedIndex();
        if (indiceTab == 1) {
            jTFnombre.requestFocus();
        }
    }//GEN-LAST:event_jTabPcontenedorMouseClicked

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnuevoActionPerformed
        libs.FuncionesComunes.resetFormContentPanel(jPAdmin);
        claseB = null;
        btnInicioDisable();
    }//GEN-LAST:event_jBnuevoActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        guardarClase();
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        if (validarBuscar()) {
            libs.FuncionesComunes.eliminarFilas(modeloTabla);
            switch (btnRadio) {
                case 1:
                    listarTodos();
                    break;
                case 2:
                    buscarNombre();
                    break;
                case 3:
                    buscarHorario();
                    break;
                case 4:
                    buscarEntrenador();
                    break;
                default:
                    libs.FuncionesComunes.vistaDialogo("Selecione un filtro", 0, this);
            }
        }
        jTbuscar.setText("");
    }//GEN-LAST:event_jBbuscarActionPerformed

    private void jBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarActionPerformed
        bajaLogica();
    }//GEN-LAST:event_jBeliminarActionPerformed

    private void jTDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDataMouseClicked
        int sRow = jTData.getSelectedRow();

        if (sRow != -1) {
            int idClase = Integer.valueOf(jTData.getValueAt(sRow, 0).toString());

            btnEditarDisable();
            jTabPcontenedor.setSelectedIndex(1);
            cargarDatos(idClase);
        }
    }//GEN-LAST:event_jTDataMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGseleccion;
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JButton jBsalir;
    private javax.swing.JComboBox<Entrenador> jCBentrenadorA;
    private javax.swing.JComboBox<Entrenador> jCBentrenadorB;
    private javax.swing.JCheckBox jCkBestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLcapacidad;
    private javax.swing.JLabel jLestado;
    private javax.swing.JLabel jLhorario;
    private javax.swing.JLabel jLidClase;
    private javax.swing.JLabel jLidEntrenadores;
    private javax.swing.JLabel jLnombre;
    private javax.swing.JLabel jLtitulo;
    private javax.swing.JPanel jPAdmin;
    private javax.swing.JPanel jPBuscar;
    private javax.swing.JRadioButton jRHorario;
    private javax.swing.JRadioButton jRentrenador;
    private javax.swing.JRadioButton jRnombre;
    private javax.swing.JRadioButton jRtodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTData;
    private javax.swing.JTextField jTFcapacidad;
    private javax.swing.JTextField jTFhorario;
    private javax.swing.JTextField jTFidClase;
    private javax.swing.JTextField jTFnombre;
    private javax.swing.JTabbedPane jTabPcontenedor;
    private javax.swing.JTextField jTbuscar;
    // End of variables declaration//GEN-END:variables

    private void placeholders() {
        libs.FuncionesComunes.textPrompt(jTFnombre, "Nombre de la Clase");
        libs.FuncionesComunes.textPrompt(jTFhorario, "Horario Ej(10:00)");
        libs.FuncionesComunes.textPrompt(jTFcapacidad, "Capacidad (numérico)");
        libs.FuncionesComunes.textPrompt(jTFidClase, "ID Clase");
    }

    private void btnInicioDisable() {
        jBeliminar.setEnabled(false);
        jBbuscar.setEnabled(false);
        jBnuevo.setEnabled(false);
    }

    private void btnEditarDisable() {
        jBeliminar.setEnabled(true);
        jBnuevo.setEnabled(true);
    }

    private void armarEncabezado() {
        modeloTabla = libs.FuncionesComunes.ArmadoEncabezados(entidades.Clase.CabeceraClase.IDClase);
        jTData.setModel(modeloTabla);
    }

    private void btnRadioEnlace() {
        // Asigna el mismo ActionListener a todos los botones de radio
        ActionListener rBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRadio = fitrado();
            }
        };
        // Añade el ActionListener a cada botón de radio
        jRtodos.addActionListener(rBtnListener);
        jRnombre.addActionListener(rBtnListener);
        jRentrenador.addActionListener(rBtnListener);
        jRHorario.addActionListener(rBtnListener);
    }

    private void guardarClase() {

        try {
            if (!validarCampos()) {
                return;
            }
            if (claseB == null) {

                Entrenador e = (Entrenador) jCBentrenadorA.getSelectedItem();
                Clase cls = new Clase();

                jTFidClase.setText(String.valueOf(cls.getIdClase()));

                cls.setNombre(jTFnombre.getText().trim());

                cls.setIdEntrenador(e.getIdEntrenador());

                cls.setEntrenador(e);

                cls.setCapacidad(Integer.parseInt(jTFcapacidad.getText().trim()));

                int hora = Integer.parseInt(jTFhorario.getText().trim());

                if (libs.FuncionesComunes.validarNumericos(jTFhorario.getText().trim()) && setHorario(hora)) {

                    cls.setHorario(LocalTime.of(hora, 0));

                    cls.setEstado(jCkBestado.isSelected());

                    if (cData.guardarClase(cls)) {
                        claseB = cls;
                        libs.FuncionesComunes.vistaDialogo("Clase guardada correctamente", 1, this);
                        btnEditarDisable();
                    }
                }

            }
        } catch (NullPointerException | NumberFormatException e) {
            libs.FuncionesComunes.vistaDialogo("Error al cargar los datos " + e.getMessage(), 0, this);
        }
    }

    private int parseIdFromCombo(String comboDato) {
        return Integer.parseInt(comboDato.split("-")[0].trim());
    }

    private boolean validarCampos() {
        if (libs.FuncionesComunes.ValidarVacio(jPAdmin)) {
            if (!libs.FuncionesComunes.validarNombre(jTFnombre.getText().trim())
                    || !libs.FuncionesComunes.validarNumericos(jTFhorario.getText().trim())
                    || !libs.FuncionesComunes.validarNumericos(jTFcapacidad.getText().trim())) {
                libs.FuncionesComunes.vistaDialogo("Verificar los campos", 0, this);
                return false;
            } else {
                libs.FuncionesComunes.vistaDialogo("Los campos son obligatorios", 1, this);
                return false;
            }
        }
        return true;
    }

    private void cargarEntrenador() {
        ltaEntrenadores.forEach(entrenador -> {
            jCBentrenadorA.addItem(entrenador);
            jCBentrenadorB.addItem(entrenador);

        });

    }

    private int fitrado() {
        jTbuscar.setEnabled(true);
        jBbuscar.setEnabled(true);

        if (jRtodos.isSelected()) {
            libs.FuncionesComunes.eliminarFilas(modeloTabla);
            libs.FuncionesComunes.textPrompt(jTbuscar, "Todas las clases activas");
            jTbuscar.setEnabled(false);
            return 1;
        } else if (jRnombre.isSelected()) {
            libs.FuncionesComunes.eliminarFilas(modeloTabla);
            libs.FuncionesComunes.textPrompt(jTbuscar, "Nombre de la clase ej. Zumba");
            return 2;
        } else if (jRHorario.isSelected()) {
            libs.FuncionesComunes.eliminarFilas(modeloTabla);
            libs.FuncionesComunes.textPrompt(jTbuscar, "Ingrese una hora entre 7 y 22 ej. 14");
            return 3;
        } else if (jRentrenador.isSelected()) {
            libs.FuncionesComunes.eliminarFilas(modeloTabla);
            libs.FuncionesComunes.textPrompt(jTbuscar, "Seleccione un entrenador");
            jTbuscar.setEnabled(false);
            return 4;
        }
        return 0;
    }

    private boolean validarBuscar() {

        if (btnRadio == 0) {
            libs.FuncionesComunes.vistaDialogo("Debe seleccionar un filtro", 0, this);
            return false;
        }

        switch (btnRadio) {
            case 1:
                buscar = "c";
                return true;
            case 2:
                buscar = jTbuscar.getText().trim();
                if (buscar.isEmpty()) {
                    libs.FuncionesComunes.vistaDialogo("El campo de búsqueda está vació", 0, this);
                    return false;
                }
                if (!libs.FuncionesComunes.validarNombre(buscar)) {
                    libs.FuncionesComunes.vistaDialogo("Únicamente letras", 0, this);
                    return false;
                }
                break;
            case 3:
                buscar = jTbuscar.getText().trim();
                if (buscar.isEmpty()) {
                    libs.FuncionesComunes.vistaDialogo("El campo de búsqueda está vació", 0, this);
                    return false;
                }
                if (!libs.FuncionesComunes.validarNumericos(buscar)) {
                    libs.FuncionesComunes.vistaDialogo("Únicamente números", 0, this);
                    return false;
                }
                break;
            case 4:
                Entrenador entrenadorSeleccionado = (Entrenador) jCBentrenadorB.getSelectedItem();
                if (entrenadorSeleccionado == null) {
                    libs.FuncionesComunes.vistaDialogo("Seleccione un entrenador válido", 0, this);
                    return false;
                }
                buscar = String.valueOf(entrenadorSeleccionado.getIdEntrenador());
                break;
            default:
                libs.FuncionesComunes.vistaDialogo("Filtro desconocido", 0, this);
                return false;
        }
        return true;
    }

    private void buscarEntrenador() {
        Entrenador entrenadorSeleccionado = (Entrenador) jCBentrenadorB.getSelectedItem();
        if (entrenadorSeleccionado == null) {
            libs.FuncionesComunes.vistaDialogo("Seleccione un entrenador válido", 0, this);
            return;
        }
        ltaClases.clear();
        ArrayList<Clase> clasesEntrenador = cData.buscarEntrenador(entrenadorSeleccionado.getIdEntrenador());
        if (!clasesEntrenador.isEmpty()) {
            actualizarTablaConClases(clasesEntrenador);
        }
    }

    private void buscarHorario() {
        ArrayList<Clase> lista = new ArrayList<Clase>();
        try {
            int hora = Integer.parseInt(buscar);

            if (setHorario(hora)) {
                lista = cData.buscarHorario(LocalTime.of(hora, 0));
            }
            if (!lista.isEmpty()) {
                actualizarTablaConClases(lista);
            }
        } catch (NumberFormatException | NullPointerException e) {
            libs.FuncionesComunes.vistaDialogo("No se encuentra el horario " + e.getMessage(), 0, this);
        }

    }

    private void buscarNombre() {
        try {
            List<Clase> clasesFiltradas = cData.buscarClasePorNombre(buscar);

            if (!clasesFiltradas.isEmpty()) {
                actualizarTablaConClases(clasesFiltradas);
            } else {
                libs.FuncionesComunes.vistaDialogo("Lista vacia", 0, this);
            }
        } catch (NullPointerException e) {
            libs.FuncionesComunes.vistaDialogo("No se encuentra la clase " + e.getMessage(), 0, this);
        }

    }

    private void listarTodos() {

        ltaClases = cData.listarClasesDisponibles();
        actualizarTablaConClases(ltaClases);

    }

    private void bajaLogica() {
        if (claseB != null && claseB.isEstado()) {
            if (cData.bajaClase(claseB.getIdClase())) {
                libs.FuncionesComunes.vistaDialogo("Se dio de baja a la clase", 1);
                btnInicioDisable();
                libs.FuncionesComunes.resetFormContentPanel(jPAdmin);
            }
        }
    }

    private boolean setHorario(int hora) {
        if (hora >= MIN_HORA && hora <= MAX_HORA) {
            return true;
        } else if ((hora > 1 && hora < MIN_HORA) || (hora > MAX_HORA && hora < 24)) {
            libs.FuncionesComunes.vistaDialogo("Gimnasio cerrado en ese horario", 1, this);
        } else {
            libs.FuncionesComunes.vistaDialogo("Ingresar un número válido", 1, this);
        }
        return false;
    }

    private void actualizarTablaConClases(List<Clase> clases) {
        libs.FuncionesComunes.eliminarFilas(modeloTabla);
        if (!clases.isEmpty()) {
            clases.forEach(item -> {
                modeloTabla.addRow(new Object[]{
                    item.getIdClase(),
                    item.getIdEntrenador(),
                    item.getNombre(),
                    item.getHorario(),
                    item.getCapacidad(),
                    item.isEstado()
                });
            });
        }

    }

    private void cargarDatos(int id) {
        claseB = null;
        claseB = cData.buscarClasePorId(id);
        //ArrayList<Clase> e = cData.buscarEntrenador(claseB.getIdEntrenador());
        if (claseB != null) {
            jTFidClase.setText(String.valueOf(claseB.getIdClase()));
            int idEntrenador = claseB.getIdEntrenador() - 1;
            jCBentrenadorA.setSelectedIndex(idEntrenador);
            jTFnombre.setText(claseB.getNombre());
            jTFhorario.setText(String.valueOf(claseB.getHorario()));
            jTFcapacidad.setText(String.valueOf(claseB.getCapacidad()));
            jCkBestado.setSelected(claseB.isEstado());
        } else {
            libs.FuncionesComunes.vistaDialogo("No se pudo cargar la clase", 0, this);
            libs.FuncionesComunes.resetFormContentPanel(jPAdmin);
            jTabPcontenedor.setSelectedIndex(0);
            jTbuscar.setText("");
            libs.FuncionesComunes.eliminarFilas(jTData);
        }
    }

}
