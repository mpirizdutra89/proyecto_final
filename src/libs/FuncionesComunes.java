package libs;

import java.awt.Component;
import java.awt.Font;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
/**
 *
 * @author Nicolas
 */
public class FuncionesComunes {
    
      // Tablas
    public static DefaultTableModel modeloTable;
    private static DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    private static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    
    

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
        librerias.TextPrompt placeholder = new librerias.TextPrompt(titulo, textField);

        placeholder.changeAlpha(0.50f);
        placeholder.changeStyle(Font.ITALIC);

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

    public static boolean validarNumericos(String cadena) {
        return cadena.matches("^[0-9]+$");
    }

    public static boolean validarDoubles(String cadena) {
        return cadena.matches("^[0-9]+\\.[0-9]{2}$");
    }
    
    public static boolean validarVacio(String text){
       
         return !text.isEmpty();
    }
    
    
    //tipo es el logito para error o informacion 0 o 1 creo 
     public static void vistaDialogo(String msj, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, msj, titulo, tipo);
    }
      public static void vistaDialogo(String msj, String titulo, int tipo,JInternalFrame jif) {
        JOptionPane.showMessageDialog(jif, msj, titulo, tipo);
    }

    public static void vistaDialogo(String msj, int tipo) {
        JOptionPane.showMessageDialog(null, msj, "", tipo);
    }
     public static void vistaDialogo(String msj, int tipo,JInternalFrame jif) {
        JOptionPane.showMessageDialog(jif, msj, "", tipo);
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
