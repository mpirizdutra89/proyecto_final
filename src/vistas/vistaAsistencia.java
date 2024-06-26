package vistas;

import accesoADatos.ClaseData;
import accesoADatos.SocioData;
import entidades.Asistencia;
import entidades.Clase;
import entidades.Socio;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin
 */
public class vistaAsistencia extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTable;
    private DefaultTableModel modeloTable2;
    private SocioData socioData;
    private ClaseData claseData;
    private  ArrayList<Clase> listaClase;
    private  ArrayList<Clase> ListaCupos;
    private  ArrayList<Socio> ListaSociosInscriptos;
    private Clase claseActual;
    private Clase claseActualLista;
    private Socio socioBuscado;
   
    
    /**
     * Creates new form vistaAsistencia
     */
    public vistaAsistencia() {
        initComponents();
       //conexion
        
        claseData = new ClaseData();
        socioData=new SocioData();
        listaClase = new ArrayList<>();
        ListaCupos=new ArrayList<>();
        ListaSociosInscriptos=new ArrayList<>();
        
       
        listaClase=claseData.listarClaseAsistencia();
        if (listaClase.size() > 0) {
            cargarClases();
            fecha();
            modificarDni();
            armarEncabezado();
            armarEncabezadoListaSocio();
             CargarClaseCuposDisponibles();
           
           
        }else{
            
            libs.FuncionesComunes.vistaDialogo("No hay clases para poder operar.", 0,this);
            
        }
        
         
        
       
       
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
        jTxtDni = new javax.swing.JTextField();
        jLblSocioSeleccionado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jbtnBuscarSocio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbtnGuardarAsistencia = new javax.swing.JButton();
        jPnlLista = new javax.swing.JPanel();
        jPnlSubcontenedorListar = new javax.swing.JPanel();
        jCbClaseListar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblListado = new javax.swing.JTable();
        jbtnEliminarSocio = new javax.swing.JButton();

        setBackground(new java.awt.Color(16, 41, 64));
        setClosable(true);
        setIconifiable(true);
        setTitle("Asistencia");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/asistencias.png"))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(16, 41, 64));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPnlGestion.setBackground(new java.awt.Color(16, 42, 64));

        jPnlContendor.setBackground(new java.awt.Color(16, 41, 64));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/clases.png"))); // NOI18N
        jLabel3.setText("Selecione una clase:");

        jCbClase.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jCbClase.setForeground(new java.awt.Color(0, 1, 13));
        jCbClase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCbClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbClaseActionPerformed(evt);
            }
        });

        jTblDatos.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jTblDatos.setForeground(new java.awt.Color(0, 1, 13));
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

        jLFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/date.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(16, 42, 64));

        jTxtDni.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N

        jLblSocioSeleccionado.setForeground(new java.awt.Color(255, 255, 255));
        jLblSocioSeleccionado.setText("#");
        jLblSocioSeleccionado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("# El sistema le avisara si no hay cupo.");

        jPanel2.setBackground(new java.awt.Color(16, 41, 64));

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("# Busque un socio.");

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("# Seleccione una clase.");

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("# Seleccione una horario en la tabla.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jLabel9.setFont(new java.awt.Font("Gill Sans MT", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("Asistencia para el socio:");

        jbtnBuscarSocio.setBackground(new java.awt.Color(153, 177, 39));
        jbtnBuscarSocio.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jbtnBuscarSocio.setForeground(new java.awt.Color(0, 1, 13));
        jbtnBuscarSocio.setText("Buscar");
        jbtnBuscarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarSocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jbtnBuscarSocio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblSocioSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnBuscarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblSocioSeleccionado)
                .addGap(156, 156, 156)
                .addComponent(jLabel5))
        );

        jPanel3.setBackground(new java.awt.Color(16, 41, 64));

        jbtnGuardarAsistencia.setBackground(new java.awt.Color(153, 177, 39));
        jbtnGuardarAsistencia.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jbtnGuardarAsistencia.setForeground(new java.awt.Color(0, 1, 13));
        jbtnGuardarAsistencia.setText("Guardar");
        jbtnGuardarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarAsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jbtnGuardarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jbtnGuardarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPnlContendorLayout = new javax.swing.GroupLayout(jPnlContendor);
        jPnlContendor.setLayout(jPnlContendorLayout);
        jPnlContendorLayout.setHorizontalGroup(
            jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPnlContendorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPnlContendorLayout.createSequentialGroup()
                        .addGroup(jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbClase, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 347, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlContendorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPnlContendorLayout.setVerticalGroup(
            jPnlContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContendorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCbClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnlGestionLayout = new javax.swing.GroupLayout(jPnlGestion);
        jPnlGestion.setLayout(jPnlGestionLayout);
        jPnlGestionLayout.setHorizontalGroup(
            jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
            .addGroup(jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnlGestionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPnlContendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPnlGestionLayout.setVerticalGroup(
            jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
            .addGroup(jPnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPnlGestionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPnlContendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Gestion", jPnlGestion);

        jPnlLista.setBackground(new java.awt.Color(16, 41, 64));

        jPnlSubcontenedorListar.setBackground(new java.awt.Color(16, 41, 64));

        jCbClaseListar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jCbClaseListar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCbClaseListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbClaseListarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/clases.png"))); // NOI18N
        jLabel7.setText("Lista de socios por clase:");

        jTblListado.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jTblListado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTblListado);

        jbtnEliminarSocio.setBackground(new java.awt.Color(166, 46, 68));
        jbtnEliminarSocio.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jbtnEliminarSocio.setText("Eliminar");
        jbtnEliminarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarSocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlSubcontenedorListarLayout = new javax.swing.GroupLayout(jPnlSubcontenedorListar);
        jPnlSubcontenedorListar.setLayout(jPnlSubcontenedorListarLayout);
        jPnlSubcontenedorListarLayout.setHorizontalGroup(
            jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                .addGroup(jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCbClaseListar, 0, 237, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnEliminarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPnlSubcontenedorListarLayout.setVerticalGroup(
            jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlSubcontenedorListarLayout.createSequentialGroup()
                .addGroup(jPnlSubcontenedorListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCbClaseListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnlSubcontenedorListarLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jbtnEliminarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
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

        jTabbedPane1.addTab("Lista de Asistencias", jPnlLista);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jCbClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbClaseActionPerformed
            claseActual=null;
           
            CargarClaseCuposDisponibles();
           
    }//GEN-LAST:event_jCbClaseActionPerformed

    private void jCbClaseListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbClaseListarActionPerformed
        claseActualLista=null;
        cargarSocioClases();
    }//GEN-LAST:event_jCbClaseListarActionPerformed

    private void jbtnBuscarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarSocioActionPerformed
         BuscarSocio();
    }//GEN-LAST:event_jbtnBuscarSocioActionPerformed

    private void jbtnGuardarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarAsistenciaActionPerformed
       /*
         Falta el guardar:
        verificar que alla socios Seleccionado (Esta echo) if
        verificar que selecione una clase (ok) if
        
        verificar si ese socio ya esta en la clase
        
        Final
        DEpues de guardar haya  decontar un pasde de membresia de ese socio 
        Borrar socio seleccionado (limpiar label y el objeto interno)
        Falta el listar
         que lista los socio por clase
        */
       int idClase=devulveIdclaseSeleccionadoTabla();
       String hora=devulveHoraSeleccionadoTabla();
       if(socioBuscado!=null){
            if(idClase>0){
                
                if(socioData.verificarSocioAsistenciaRepetida(socioBuscado.getIdSocio(),idClase)<1){
                    if(socioData.verificarClasesHorario(socioBuscado.getIdSocio(),hora)<1){
                        if(claseData.guardarAsistencias(new Asistencia(socioBuscado.getIdSocio(),idClase))){
                                 claseData.descontarPases(socioBuscado.getIdSocio());
                                 resetAsistencia();
                                 CargarClaseCuposDisponibles();
                                 libs.FuncionesComunes.vistaDialogo("Asistencia para el socio, guardada.", 1,this);
                                
                    
                        }else{
                                libs.FuncionesComunes.vistaDialogo("Asistencia fallida: ", 1,this);
                    
                        }
                        
                    }else{
                        libs.FuncionesComunes.vistaDialogo("EL socio esta inscripto en una clase que tiene el mismo horario: "+hora+"hs", 1,this);
                    }
                    
                }else{
                     libs.FuncionesComunes.vistaDialogo("EL socio ya esta en esta clase. No se puede repetir", 1,this);
                }
               
            }else{
                 libs.FuncionesComunes.vistaDialogo("Seleccione una clase disponible en la tabla, haga click en una de las filas", 1,this);
            }
       }else{
           libs.FuncionesComunes.vistaDialogo("No hay un socio para la asistencia.", 0,this);
       }
       
    }//GEN-LAST:event_jbtnGuardarAsistenciaActionPerformed

    private void jbtnEliminarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarSocioActionPerformed
         int selectedRow = jTblListado.getSelectedRow();
                if (selectedRow != -1) {
                    
                    int idSocio =Integer.valueOf(jTblListado.getValueAt(selectedRow, 0).toString());
                    eliminarAsistencia(idSocio);
                }
    }//GEN-LAST:event_jbtnEliminarSocioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Clase> jCbClase;
    private javax.swing.JComboBox<Clase> jCbClaseListar;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblSocioSeleccionado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPnlContendor;
    private javax.swing.JPanel jPnlGestion;
    private javax.swing.JPanel jPnlLista;
    private javax.swing.JPanel jPnlSubcontenedorListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTblDatos;
    private javax.swing.JTable jTblListado;
    private javax.swing.JTextField jTxtDni;
    private javax.swing.JButton jbtnBuscarSocio;
    private javax.swing.JButton jbtnEliminarSocio;
    private javax.swing.JButton jbtnGuardarAsistencia;
    // End of variables declaration//GEN-END:variables

    private void fecha(){
        jLFecha.setText(libs.FuncionesComunes.fechaActual());
    }
    
    private void modificarDni(){
        libs.FuncionesComunes.textPrompt(jTxtDni, "Buscar por dni");
    }
    
      private void armarEncabezado() {
        modeloTable = libs.FuncionesComunes.ArmadoEncabezados(entidades.Asistencia.CabeceraAsistencia.Clase);
        jTblDatos.setModel(modeloTable);
        //libs.FuncionesComunes.alinearCabeceras(1, "right", jTblDatos);

    }
    private void armarEncabezadoListaSocio() {
        modeloTable2 = libs.FuncionesComunes.ArmadoEncabezados(entidades.Socio.CabeceraSocio2.Nombre);
        jTblListado.setModel(modeloTable2);
        //libs.FuncionesComunes.alinearCabeceras(1, "right", jTblDatos);

    }
 
    
      
     private void agregarElemento(Socio socio) {
         String nombre=socio.getNombre();
         String apellido=socio.getApellido();
         String dni=socio.getDni();
         jLblSocioSeleccionado.setText(" "+dni+", "+nombre+", "+apellido);
         resetDni();
         
    } 
     
     
//    private void cargarClases(){
//       jCbClase.addItem(new Clase());
//        for (Clase clase : listaClase) {
//            
//            
//             if (!jCbClase.contains(clase)) {
//                jCbClase.addItem(clase);
//               
//            }
//        }
//    }
    private void cargarClases() {
        jCbClase.addItem(new Clase()); // Agregar un elemento vacío si es necesario
        jCbClaseListar.addItem(new Clase());
        Set<Clase> clasesUnicas = new HashSet<>(listaClase);
        for (Clase clase : clasesUnicas) {
            if(buscarRepetidos(clase)){
                 jCbClase.addItem(clase);
                 jCbClaseListar.addItem(clase);
            }
           
        }
    }
    
    
    
    private boolean buscarRepetidos(Clase clase1) {
        if (clase1 == null) {
            return false; // Si el nombre de clase1 es null, no podemos compararlo con otros nombres
        }
        for (int i = 0; i < jCbClase.getItemCount(); i++) {
            Clase clase = (Clase) jCbClase.getItemAt(i);
            String nombre = clase.getNombre();
            if (nombre != null && nombre.equals(clase1.getNombre())) {
                return false;
            }
        }
         return true;
    }
   
    
    
    
//     private void armadoComboBox() {
//        for (Alumno alumno : listaAlumno) {
//            jCbAlumnos.addItem(alumno);
//
//        }
//    }
     
     //buscar Socio y agregar a la lista
     
    
     
     private void BuscarSocio(){
         String buscar =jTxtDni.getText().trim();
         socioBuscado=null;
         
         if(libs.FuncionesComunes.validarNumericos(buscar) && libs.FuncionesComunes.validarVacio(buscar)){
             
             socioBuscado=socioData.buscarSocioPorDni(buscar,1);
             if(socioBuscado!=null){
               int[] verificar= socioData.verificarSocioHabilitadoAsistencia(socioBuscado.getIdSocio());
                 if(verificar.length>0){
                     if(verificar[0]==1 && verificar[1]==1){
                         agregarElemento(socioBuscado);
                     }else{
                          libs.FuncionesComunes.vistaDialogo("La membresia esta vencida o agoto sus pases.", 1,this);
                         
                     }
                      
                 }else{
                      libs.FuncionesComunes.vistaDialogo("El socio no tiene ninguna membresia..", 1,this);
                     
                 }
                   
             }else{
                 libs.FuncionesComunes.vistaDialogo("El socio no exite.", 1,this);
                
             }
             
             
         }else{
             libs.FuncionesComunes.vistaDialogo("EL campo dni deve ser numerico y no puede estar vacio", 1,this);
         }
          resetDni();
     }
     
     private void resetDni(){
         jTxtDni.setText("");
                 jTxtDni.requestFocus();
     }
     
    
    private void cargarSocioClases() {
        ListaSociosInscriptos = null;
        SeleccionarClaseActualLista();
        
        jbtnEliminarSocio.setEnabled(false);
        try {

            if (claseActualLista != null && claseActualLista.getNombre() != null) {
               

                ListaSociosInscriptos = socioData.listarSocioClase(claseActualLista.getNombre());
                 libs.FuncionesComunes.eliminarFilas(modeloTable2);
                if (ListaSociosInscriptos.size() > 0) {
                    jbtnEliminarSocio.setEnabled(true);
                   
                    for (Socio socio : ListaSociosInscriptos) {
                            String nombre=socio.getApellido()+", "+socio.getNombre();
                            modeloTable2.addRow(new Object[]{
                                socio.getIdSocio(),
                                socio.getDni(),
                                nombre,
                                socio.getTelefono()
                            });
                        

                    }

                } else {
                    libs.FuncionesComunes.vistaDialogo("No hay socios para esta clase.", 0, this);
                }

            }
        } catch (NullPointerException e) {
            libs.FuncionesComunes.vistaDialogo("Ocurrio un fallo inesperado" + e.toString(), 0, this);
            System.out.println(e.toString());
        } catch (Exception e) {
            libs.FuncionesComunes.vistaDialogo("Ocurrio un fallo inesperado" + e.toString(), 0, this);
            System.out.println(e.toString());
        }
    }
     
     
    private void CargarClaseCuposDisponibles() {
        ListaCupos=null;
        SeleccionarClaseActual();
        try {

            if (claseActual != null && claseActual.getNombre() != null) {
                ListaCupos=new ArrayList<Clase>();
                
                ListaCupos = claseData.CuposClases(claseActual.getNombre());
               
                if (ListaCupos.size() > 0) {
                  libs.FuncionesComunes.eliminarFilas(modeloTable);
                    for (Clase clase1 : ListaCupos) {
                       if(clase1.getCapacidad()>0){
                           modeloTable.addRow(new Object[]{
                            clase1.getIdClase(),
                            clase1.getNombre(),
                            clase1.getHorario(),
                            clase1.getCapacidad()
                        });
                       }
                        

                    }

                } else {
                    libs.FuncionesComunes.vistaDialogo("No hay datos que mostrar, para la clase", 0, this);
                }

            }
        } catch ( NullPointerException e) {
            libs.FuncionesComunes.vistaDialogo("Ocurrio un fallo inesperado", 0, this);
            System.out.println(e.toString());
        }
        catch(Exception e){
            libs.FuncionesComunes.vistaDialogo("Ocurrio un fallo inesperado", 0, this);
            System.out.println(e.toString());
        }
    }
    
    
    private void eliminarAsistencia(int idSocio){
        claseActualLista=null;
        SeleccionarClaseActualLista();
        if(claseActualLista!=null && idSocio!=0){
            if(claseData.quitarAsistenciaSocio(idSocio, claseActualLista.getIdClase())){
                cargarSocioClases();
            }else{
                libs.FuncionesComunes.vistaDialogo("No se pudo quitar de la lista.", 1, this);
            }
        }else{
            libs.FuncionesComunes.vistaDialogo("Falta informacion", 1, this);
        }
        
    }
    
     private void SeleccionarClaseActual(){
          claseActual = (Clase) jCbClase.getSelectedItem();
     }
     
     private void SeleccionarClaseActualLista(){
          claseActualLista = (Clase) jCbClaseListar.getSelectedItem();
     }
    
    private int devulveIdclaseSeleccionadoTabla(){
        int row=jTblDatos.getSelectedRow();
        int idClase=0;
        if(row!=-1){
            idClase= Integer.parseInt(jTblDatos.getValueAt(row, 0).toString());
        }
        
        return idClase;
    }
    
    private String devulveHoraSeleccionadoTabla(){
        int row=jTblDatos.getSelectedRow();
        String hora="00:00";
        if(row!=-1){
            hora= jTblDatos.getValueAt(row, 2).toString();
        }
        
        return hora;
    }
     
     public void resetAsistencia(){
         socioBuscado=null;
        jLblSocioSeleccionado.setText("#");
     }
}
