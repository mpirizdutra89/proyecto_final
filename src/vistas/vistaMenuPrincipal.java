/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;
import accesoADatos.Conexion;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import libs.Escritorio;
/**
 *
 * @author Nicolas
 */
public class vistaMenuPrincipal extends javax.swing.JFrame {
    
   private static vistaMenuPrincipal vmp;
   private static final libs.Escritorio deskpto=new Escritorio();
    /**
     * Creates new form vistaMenuPrincipal
     */
    public vistaMenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMsocio = new javax.swing.JMenuItem();
        jMentrenador = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMmembresia = new javax.swing.JMenuItem();
        jMclases = new javax.swing.JMenuItem();
        jMasistencia = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Gestion");

        jMsocio.setText("Socios");
        jMsocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMsocioActionPerformed(evt);
            }
        });
        jMenu1.add(jMsocio);

        jMentrenador.setText("Entrenadores");
        jMentrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMentrenadorActionPerformed(evt);
            }
        });
        jMenu1.add(jMentrenador);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Administracion");

        jMmembresia.setText("Membresias");
        jMmembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMmembresiaActionPerformed(evt);
            }
        });
        jMenu2.add(jMmembresia);

        jMclases.setText("Clases");
        jMclases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMclasesActionPerformed(evt);
            }
        });
        jMenu2.add(jMclases);

        jMenuBar1.add(jMenu2);

        jMasistencia.setText("Asistencias");
        jMasistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMasistenciaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMasistencia);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMclasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMclasesActionPerformed
        vistaClase vc=new vistaClase();
        cargarVistasInternas(vc);
        
    }//GEN-LAST:event_jMclasesActionPerformed

    private void jMasistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMasistenciaMouseClicked
        // VISTA asistencia
        vistaAsistencia va=new vistaAsistencia();
        cargarVistasInternas(va);
    }//GEN-LAST:event_jMasistenciaMouseClicked

    private void jMmembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMmembresiaActionPerformed
        // Vista membresia:
    }//GEN-LAST:event_jMmembresiaActionPerformed

    private void jMsocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMsocioActionPerformed
        // vistaSocio:
        vistaSocio vs=new vistaSocio();
        cargarVistasInternas(vs);
    }//GEN-LAST:event_jMsocioActionPerformed

    private void jMentrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMentrenadorActionPerformed
        vistaEntrenador ve = new vistaEntrenador();
        cargarVistasInternas(ve);
    }//GEN-LAST:event_jMentrenadorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(Conexion.VerificarConexion()){
                    vmp=new vistaMenuPrincipal();
                    vmp.setContentPane(deskpto);
                    vmp.setLocationRelativeTo(null);
                    vmp.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    vmp.setVisible(true);
                    vmp.setVisible(true);
                    
                }else{
                    libs.FuncionesComunes.vistaDialogo("No se pudo establecer una conexion.", 0);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMasistencia;
    private javax.swing.JMenuItem jMclases;
    private javax.swing.JMenuItem jMentrenador;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMmembresia;
    private javax.swing.JMenuItem jMsocio;
    // End of variables declaration//GEN-END:variables
    
     private void cargarVistasInternas(JInternalFrame view) {
        deskpto.removeAll();
        deskpto.repaint();
        view.setVisible(true);
        int w = deskpto.getWidth();
        int h = deskpto.getHeight();
        int x = (w - view.getWidth()) / 2;
        int y = (h - view.getHeight()) / 2;
        view.setLocation(x, y);

        deskpto.add(view);

        deskpto.moveToFront(view);
        

    }

}
