package vistas;

import accesoADatos.EntrenadorData;
import entidades.Entrenador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static libs.FuncionesComunes.validarNumericos;

/**
 *
 * @author agus1
 */

//AGREGAR PARA MODIFICAR ENTRENADORES!!

public class vistaEntrenador extends javax.swing.JInternalFrame {
       private EntrenadorData eData;
       private Entrenador eNuevo;
       private ArrayList<Entrenador> listaEntrenadores;
       private ArrayList<Entrenador> listaEntrenadoresInactivos;
       private DefaultTableModel tablaEntrenadores;
    
    public vistaEntrenador() {
        initComponents();
        
        eData = new EntrenadorData();
        eNuevo = new Entrenador();
        listaEntrenadores = new ArrayList<>();
        listaEntrenadoresInactivos = new ArrayList<>();
         tablaEntrenadores = new DefaultTableModel();
         
         jTEntrenadores.setDefaultEditor(Object.class, null);
         
         borrarFilas();
        
        listaEntrenadores.addAll(eData.listarEntrenadores());
        armarTabla();
        cargarEntrenadores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEntrenadores = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTApellido = new javax.swing.JTextField();
        jTEspecialidad = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jBAlta = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        jBListarInactivos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Getion Entrenadores");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/iconos/entrenador.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Gestion de Entrenadores");

        jTEntrenadores.setModel(new javax.swing.table.DefaultTableModel(
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
        jTEntrenadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEntrenadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEntrenadores);

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBListar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jBListar.setText("Entrenadores Activos");
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Especialidad");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTDni, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jTEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jTApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(17, 17, 17))
        );

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

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

        jBListarInactivos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jBListarInactivos.setText("Entrenadores Inactivos");
        jBListarInactivos.setMaximumSize(new java.awt.Dimension(182, 32));
        jBListarInactivos.setMinimumSize(new java.awt.Dimension(182, 32));
        jBListarInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarInactivosActionPerformed(evt);
            }
        });

        jLabel6.setText("#Para modificar seleccione en la tabla y luego edite en los campos de texto.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jBAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jBListar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBListarInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBListarInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBListar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAlta)
                    .addComponent(jBBaja))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        try {
            String dni = jTDni.getText();
            String nombre = jTNombre.getText();
            String apellido = jTApellido.getText();
            String especialidad = jTEspecialidad.getText();

            if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || especialidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos");
                return;
            }

            if (!validarNumericos(dni)) {
                JOptionPane.showMessageDialog(this, "El DNI debe ser un valor numerico");
                return;
            }
            if (validarNumericos(nombre) || validarNumericos(apellido)) {
                JOptionPane.showMessageDialog(this, "El nombre y el apellido no pueden contener numeros");
                return;
            }
            if (validarNumericos(especialidad)) {
                JOptionPane.showMessageDialog(this, "La especialidad no puede contener numeros");
                return;
            }

            Entrenador entrenadorExistente = eData.buscarEntrenadorPorDNI(dni);
            if (entrenadorExistente != null) {
                entrenadorExistente.setNombre(nombre);
                entrenadorExistente.setApellido(apellido);
                entrenadorExistente.setEspecialidad(especialidad);
                eData.modificarEntrenador(entrenadorExistente);

            } else {
                eNuevo = new Entrenador(dni, nombre, apellido, especialidad);
                eData.guardarEntrenador(eNuevo);
            }
            listaEntrenadores = (ArrayList<Entrenador>) eData.listarEntrenadores();
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error, revise los datos ingresados e intente nuevamente");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String dni = jTDni.getText();
        String nombre = jTNombre.getText();
        String apellido = jTApellido.getText();
        String especialidad = jTEspecialidad.getText();

        if (!dni.isEmpty() && nombre.isEmpty() && apellido.isEmpty() && especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se puede buscar por dni");
            return;
        }

        if (nombre.isEmpty() && apellido.isEmpty() && especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar al menos un dato para realizar la búsqueda"
                    + "\n (nombre, apellido o especialidad).");
            return;
        }

        if (validarNumericos(nombre) || validarNumericos(apellido) || validarNumericos(especialidad)) {
            JOptionPane.showMessageDialog(this, "Los campos (nombre,apellido,especialidad) no pueden contener numeros");
            return;
        }

        buscarYCargarEntrenadores(nombre, apellido, especialidad);
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
        listaEntrenadores = (ArrayList<Entrenador>) eData.listarEntrenadores();
        cargarEntrenadores();
        limpiarCampos();
    }//GEN-LAST:event_jBListarActionPerformed

    private void jTEntrenadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEntrenadoresMouseClicked
        int filaSeleccionada = jTEntrenadores.getSelectedRow();
        if (filaSeleccionada != -1) {
            
            String dni = jTEntrenadores.getValueAt(filaSeleccionada, 0).toString();
            String nombre = jTEntrenadores.getValueAt(filaSeleccionada, 1).toString();
            String apellido = jTEntrenadores.getValueAt(filaSeleccionada, 2).toString();
            String especialidad = jTEntrenadores.getValueAt(filaSeleccionada, 3).toString();

            
            jTDni.setText(dni);
            jTNombre.setText(nombre);
            jTApellido.setText(apellido);
            jTEspecialidad.setText(especialidad);
        }
    }//GEN-LAST:event_jTEntrenadoresMouseClicked

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        int filaSeleccionada = jTEntrenadores.getSelectedRow();
        if (filaSeleccionada != -1) {

            String dni = jTEntrenadores.getValueAt(filaSeleccionada, 0).toString();
            eData.bajaEntrenador(dni);
            cargarEntrenadores();
        }
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        int filaSeleccionada = jTEntrenadores.getSelectedRow();
        if (filaSeleccionada != -1) {

            String dni = jTEntrenadores.getValueAt(filaSeleccionada, 0).toString();
            eData.altaEntrenador(dni);
            cargarEntrenadores();
        }
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBListarInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarInactivosActionPerformed
        listaEntrenadoresInactivos = (ArrayList<Entrenador>) eData.listarEntrenadoresInactivos();
        cargarEntrenadoresInactivos();
        limpiarCampos();
    }//GEN-LAST:event_jBListarInactivosActionPerformed
    
    
    
    private void buscarYCargarEntrenadores(String nombre, String apellido, String especialidad) {
        ArrayList<Entrenador> entrenadoresEncontrados = (ArrayList<Entrenador>) eData.buscarEntrenadores(nombre, apellido, especialidad);

        borrarFilas();

        
        
 if (entrenadoresEncontrados.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron entrenadores que coincidan con los criterios de búsqueda.");
    } else {
        for (Entrenador entrenador : entrenadoresEncontrados) {
            tablaEntrenadores.addRow(new Object[]{
                entrenador.getDni(),
                entrenador.getNombre(),
                entrenador.getApellido(),
                entrenador.getEspecialidad()
            });
        }
    }
    }
    
        private void cargarEntrenadoresInactivos() {
        if (tablaEntrenadores.getColumnCount() == 0) {
            armarTabla();
        }
        borrarFilas();
        for (Entrenador entrenador : listaEntrenadoresInactivos) {
            tablaEntrenadores.addRow(new Object[]{
                entrenador.getDni(),
                entrenador.getNombre(),
                entrenador.getApellido(),
                entrenador.getEspecialidad()
            });
        }
    }

    private void cargarEntrenadores() {
        if (tablaEntrenadores.getColumnCount() == 0) {
            armarTabla();
        }
        borrarFilas();
        for (Entrenador entrenador : listaEntrenadores) {
            tablaEntrenadores.addRow(new Object[]{
                entrenador.getDni(),
                entrenador.getNombre(),
                entrenador.getApellido(),
                entrenador.getEspecialidad()
            });
        }
    }

    private void armarTabla() {
        tablaEntrenadores.addColumn("DNI");
        tablaEntrenadores.addColumn("Nombre");
        tablaEntrenadores.addColumn("Apellido");
        tablaEntrenadores.addColumn("Especialidad");
        jTEntrenadores.setModel(tablaEntrenadores);
    }

    private void borrarFilas() {
        tablaEntrenadores.setRowCount(0);
        int indice = tablaEntrenadores.getRowCount();
        if (indice > 0) {

            for (int i = indice - 1; i >= 0; i--) {
                tablaEntrenadores.removeRow(i);
            }
        }
    }
    
    private void limpiarCampos() {
        jTDni.setText("");
        jTNombre.setText("");
        jTApellido.setText("");
        jTEspecialidad.setText("");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBListar;
    private javax.swing.JButton jBListarInactivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTable jTEntrenadores;
    private javax.swing.JTextField jTEspecialidad;
    private javax.swing.JTextField jTNombre;
    // End of variables declaration//GEN-END:variables
}
