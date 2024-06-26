package libs;

import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
/**
 *
 * @author Nicolas
 */
public class FuncionesComunes {
    
      // Tablas
    public static DefaultTableModel modeloTable;
    private static DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    private static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    
    
    public static String fechaActual(){
           LocalDate fechaActual = LocalDate.now();
        
        
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        
        
        String fechaFormateada = fechaActual.format(formateador);
         
         return fechaFormateada.toString();
    }
    //armado generico, para cualquier enum, deve psar por paramento nombre del enu y un valor ejemplo EncabezadoMateria.año
    public static <E extends Enum<E>> DefaultTableModel ArmadoEncabezados(E enumValue) {
       
        Class<E> enumClass = enumValue.getDeclaringClass();

        E[] enumConstants = enumClass.getEnumConstants();

        modeloTable = new DefaultTableModel() {
            public boolean isCellEditable(int f, int c) {
                return false;
            }
        };

        for (E constant : enumConstants) {

            modeloTable.addColumn(constant.name());
        }
        return modeloTable;
    }

    public static void resetColumn(JTable tablet) {
        for (int i = tablet.getColumnCount() - 1; i >= 0; i--) {
            tablet.removeColumn(tablet.getColumnModel().getColumn(i));
        }
    }
    
    
    
    public static void eliminarFilas(JTable table) {
        int rowCount = table.getRowCount()-1;
       // System.out.println(rowCount);
        
            for (int i = rowCount; i >= 0; i--) {
                modeloTable.removeRow(i);
            }
       
        
    }
  
      
      public static void eliminarFilas(DefaultTableModel modeloTable) {
            if(modeloTable.getRowCount()>0){  modeloTable.setRowCount(0); }
        }
    
    
    public static void alinearCabeceras(int indiceColumna, String dir, JTable tablet) {
        // columnAlign.setHorizontalAlignment(SwingConstants.RIGHT);
        // jTblDatos.getColumnModel().getColumn(1).setCellRenderer(columnAlign);
        switch (dir) {
            case "center":
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                tablet.getColumnModel().getColumn(indiceColumna).setCellRenderer(centerRenderer);
                break;
            case "right":
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                tablet.getColumnModel().getColumn(indiceColumna).setCellRenderer(rightRenderer);
                break;

            default:
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                tablet.getColumnModel().getColumn(indiceColumna).setCellRenderer(centerRenderer);
                break;
        }

    }
    
    //ejemplo de uso
        //armarEncabesados(); este deveria ser para el suyo
        //MiTaBLA.setModel(modeloTable);
        //alinearCabeceras(2, "right", MiTaBLA); el primer parametro es el indice de la columna
        //alinearCabeceras(3, "center", MiTaBLA;
    //fin tablas
    
    
    
    
    public static void textPrompt(JTextField textField, String titulo) {
         TextPrompt oldPrompt = (TextPrompt)textField.getClientProperty(TextPrompt.class);
        if (oldPrompt != null) {
            textField.remove(oldPrompt);
        }
        libs.TextPrompt placeholder = new libs.TextPrompt(titulo, textField);
       
        placeholder.changeAlpha(0.50f);
        placeholder.changeStyle(Font.ITALIC);
        textField.putClientProperty(TextPrompt.class, placeholder);

    }
    
    
    //reseteal loscomponentes dentro del panel
    public static void resetFormContentPanel(JPanel jpnl) {
        Component[] components = jpnl.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textField.setText("");
            }
            if (component instanceof JCheckBox) {
                JCheckBox chb = (JCheckBox) component;
                chb.setSelected(false);
            }
        }
    }
    
    public static boolean ValidarVacio(JPanel jpnl) {
        
        Component[] components = jpnl.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                if(textField.getText().trim().isEmpty()){
                    return false;
                }
                
            }
            
        }
        return true;
    }

    public static boolean validarNumericos(String cadena) {
        return cadena.matches("^[0-9]+$");
    }
    
    public static boolean validarCorreo(String correo) {
    
        String regex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$";
        return correo.matches(regex);
    }
    public static boolean validarDoubles(String cadena) {
        return cadena.matches("^[0-9]+\\.[0-9]{2}$");
    }
    
    public static boolean validarVacio(String text){
       
         return !text.isEmpty();
    }
    private static final String NOMBRE_REGEX = "^[a-zA-Z\\s'-]+$"; 
    private static final Pattern PATRON = Pattern.compile(NOMBRE_REGEX);
    public static boolean validarNombre(String nombre){
        Matcher matcher = PATRON.matcher(nombre);
        return matcher.matches();
    }
    
    //tipo es el logito para error o informacion 0 o 1 creo 
     public static void vistaDialogo(String msj, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, msj, titulo, tipo);
    }
      public static void vistaDialogo(String msj, String titulo, int tipo,JInternalFrame view) {
//        JOptionPane.showMessageDialog(jif, msj, titulo, tipo);
            new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                JOptionPane.showMessageDialog(view, msj, titulo, tipo);
                return null;
            }
        }.execute();
    }

    public static void vistaDialogo(String msj, int tipo) {
        JOptionPane.showMessageDialog(null, msj, "", tipo);
    }
     public static void vistaDialogo(String msj, int tipo,JInternalFrame view) {
        //JOptionPane.showMessageDialog(jif, msj, "", tipo);
            new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
               JOptionPane.showMessageDialog(view, msj, "", tipo);
                return null;
            }
        }.execute();
    }
//devuelve true si acepta
    public static boolean vistaDialogoSiNo() {
        return JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

    }
    
  
    
    public static boolean validaFecha(String date) {
        // Expresión regular para el formato dd-MM-yyyy
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
    
    public static void closeAll(){
        System.exit(0);
    }
    
     

}
