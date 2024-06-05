package accesoADatos;

import entidades.Clase;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void guardarClase(Clase clase) {
        //Sentencia SQL
        String query = "INSERT INTO clases(idEntrenador, nombre, horario, capacidad, estado) "
                     + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clase.getIdEntrenador());
            ps.setString(2, clase.getNombre());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                clase.setIdClase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase guardada exitosamente!!.");
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Clase: guardarClase -> " + ex.getMessage());
        }
    }

    public ArrayList<Clase> clasesDisponibles() {
        ArrayList<Clase> listaClases = new ArrayList<>();
        String query = "SELECT * FROM clases WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clas = new Clase();

                clas.setIdClase(rs.getInt("idClase"));
                clas.setIdEntrenador(rs.getInt("idEntrenador"));
                clas.setNombre(rs.getString("nombre"));
                clas.setHorario(rs.getTime("horario").toLocalTime());
                clas.setCapacidad(rs.getInt("capacidad"));
                clas.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Clase: ClasesDisponibles -> " + ex.getMessage());
        }
        return listaClases;
    }
    
    public Clase buscarClasePorNombre(String nombre){
        Clase clas = null;
        
        String query = "SELECT idClase,idEntrenador,nombre,horario,capacidad,estado "
                     + "FROM clases "
                     + "WHERE nombre = ? and estado = 1 ";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                clas = new Clase();
                
                clas.setIdClase(rs.getInt("idClase"));
                clas.setIdEntrenador(rs.getInt("idEntrenador"));
                clas.setNombre(rs.getString("nombre"));
                clas.setHorario(rs.getTime("horario").toLocalTime());
                clas.setCapacidad(rs.getInt("capacidad"));
                clas.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null,"La clase no existe!!.");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
             Conexion.msjError.add("Clase: buscarClasePorNommbre -> " + ex.getMessage());
        }
        return clas;
    }

    public void bajaClase(int id) {
        String query = "UPDATE clases SET estado = 0 WHERE idClase = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int baja = ps.executeUpdate();

            if (baja == 1) {
                JOptionPane.showMessageDialog(null, "Clase dada de baja!!.");
            }
            ps.close();
        } catch (SQLException ex) {
            Conexion.msjError.add("Clase: bajaClase -> " + ex.getMessage());
        }
    }
}
