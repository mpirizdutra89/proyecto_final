
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
            ps.setDate(3, Date.valueOf(clase.getHorario()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }
}
