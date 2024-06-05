
package accesoADatos;

import entidades.Clase;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Ferrando Carlos
 */
public class ClaseData {
    private Clase clase;
    private static Connection con = null;
    
    /*CONSTRUCTOR*/

    public ClaseData(Clase clase) {
        con = Conexion.getConexion();
    }
    
    public void guardarClase(Clase clase){
        //Sentencia SQL
        String query = "INSERT INTO clases(idEntrenador, nombre, horario, capacidad, estado) VALUES(?,?,?,?,?)";
       
        try {
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clase.getIdEntrenador());
            ps.setString(2, clase.getNombre());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4,clase.getCapacidad());
            ps.setBoolean(5,clase.isEstado());
    
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                clase.setIdClase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase guardada exitosamente.");
            }
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Clase: guardarClase -> "+ex.getMessage());
        }
    }
}
