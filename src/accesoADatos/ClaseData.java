package accesoADatos;

import entidades.Entrenador;
import entidades.Clase;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Ferrando Carlos
 */
public class ClaseData {

    private Clase clase;//Instancia de la clase `Clase`
    private EntrenadorData entrenadorData;
    private static Connection con = null;//Conexión estática a la BD 

    /*CONSTRUCTOR*/
    public ClaseData() {
        //Se inicializa la conexión a la BD usando el método estático `getConexion` de la clase Conexión
        con = Conexion.getConexion();
    }

    /*MÉTODOS*/
    public void guardarClase(Clase clase) {
        //Consulta SQL para insertar una nueva clase
        String query = "INSERT INTO clases(idEntrenador, nombre, horario, capacidad, estado) "
                + "VALUES(?,?,?,?,?)";

        try {
            //Prepara la consulta y permite obtener las claves generadas automáticamente
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //Se establecen los valores de los parámetros 
            ps.setInt(1, clase.getEntrenador().getIdEntrenador());
            ps.setString(2, clase.getNombre());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            //Se ejecuta la actualización en la BD
            ps.executeUpdate();
            //Se obtienen las claves generadas automáticamente
            ResultSet rs = ps.getGeneratedKeys();
            //Si hay claves son asignadas a la clase
            if (rs.next()) {
                clase.setIdClase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase guardada exitosamente!!.");
            }
            //Se cierran el PreparedStatement y el ResultSet.
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!.");
            Conexion.msjError.add("Clase: guardarClase -> " + ex.getMessage());
        }
    }

    public ArrayList<Clase> listarClasesDisponibles() {
        //Lista para almacenar las clases disponibles
        ArrayList<Clase> listaClases = new ArrayList<>();

        //Consulta SQL
        String query = "SELECT * FROM clases WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            //Se itera sobre los resultados de la consulta
            while (rs.next()) {
                clase = new Clase();//Nueva instancia de clase
                //Se establecen los datos de la clase
                clase.setIdClase(rs.getInt("idClase"));
                Clase cl = buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);
                //Se añade la clase a la lista
                clase.setEntrenador(cl.getEntrenador());
                listaClases.add(clase);
            }
            //Se cierran el PreparedStatement y el ResultSet.
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: ClasesDisponibles -> " + ex.getMessage());
        }
        //Se retorna la lista de clases disponibles
        return listaClases;
    }

    public Clase buscarClasePorNombre(String nombre) {
        //Nueva instancia de clase
        this.clase = null;
        //Consulta SQL
        String query = "SELECT idClase,idEntrenador,nombre,horario,capacidad,estado "
                + "FROM clases "
                + "WHERE nombre = ? and estado = 1 ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.clase = new Clase();

                this.clase.setIdClase(rs.getInt("idClase"));
                Clase cl = buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(cl.getEntrenador());
                this.clase.setNombre(rs.getString("nombre"));
                this.clase.setHorario(rs.getTime("horario").toLocalTime());
                this.clase.setCapacidad(rs.getInt("capacidad"));
                this.clase.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "La clase no existe!!.");
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: buscarClasePorNommbre -> " + ex.getMessage());
        }

        return clase;
    }

    public Clase buscarEntrenador(int id) {
        this.clase = null;
        String query = "SELECT idClase,idEntrenador,nombre,horario,capacidad,estado "
                + "FROM clases "
                + "WHERE idEntrenador = ? and estado = 1 ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.clase = new Clase();

                this.clase.setIdClase(rs.getInt("idClase"));
                 String nombreEntrenador = rs.getString("nombre"); 
                String dniEntrenador = rs.getString("dni");
                int idEntrenador = rs.getInt("idEntrenador");
                Entrenador entrenador = new Entrenador(idEntrenador);
                clase.setEntrenador(entrenador);

                this.clase.setNombre(rs.getString("nombre"));
                this.clase.setHorario(rs.getTime("horario").toLocalTime());
                this.clase.setCapacidad(rs.getInt("capacidad"));
                this.clase.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "El entrenador id: " + id + " no existe!!.");
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: buscarEntrenador -> " + ex.getMessage());
        }
        return clase;
    }

    public Clase buscarHorario(LocalTime horario) {
        this.clase = null;
        String query = "SELECT idClase,idEntrenador,nombre,horario,capacidad,estado "
                + "FROM clases "
                + "WHERE horario = ? and estado = 1 ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setTime(1, Time.valueOf(horario));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.clase = new Clase();

                this.clase.setIdClase(rs.getInt("idClase"));
                Clase cl = buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(cl.getEntrenador());
                this.clase.setNombre(rs.getString("nombre"));
                this.clase.setHorario(rs.getTime("horario").toLocalTime());
                this.clase.setCapacidad(rs.getInt("capacidad"));
                this.clase.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "El horario: " + horario + " no existe!!.");
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: buscarHorario -> " + ex.getMessage());
        }
        return clase;
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
        }
    }
}
