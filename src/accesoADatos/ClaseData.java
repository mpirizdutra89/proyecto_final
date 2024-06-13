package accesoADatos;

import entidades.Asistencia;
import entidades.Entrenador;
import entidades.Clase;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
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
        clase = null;
    }

    /*MÉTODOS*/
    public boolean guardarClase(Clase clase) {
        //Consulta SQL para insertar una nueva clase
        String query = "INSERT INTO clases(idEntrenador, nombre, horario, capacidad, estado) "
                + "VALUES(?,?,?,?,?)";
        boolean flag = false;
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
                //JOptionPane.showMessageDialog(null, "Clase guardada exitosamente!!.");
                flag = true;
            }
            //Se cierran el PreparedStatement y el ResultSet.
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            //JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!.");
            Conexion.msjError.add("Clase: guardarClase -> " + ex.getMessage());
        }

        return flag;
    }

    public ArrayList<Clase> listarClasesDisponibles() {
        this.clase = null;
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
                int idEntrenador = rs.getInt("idEntrenador"); // Guarda el ID del entrenador
                Entrenador el = EntrenadorData.buscarEntrenadorPorId(rs.getInt("idEntrenador"));
                clase.setIdEntrenador(idEntrenador);
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);
                //Se añade la clase a la lista
                clase.setEntrenador(el);
                listaClases.add(clase);
            }
            //Se cierran el PreparedStatement y el ResultSet.
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Clase: ClasesDisponibles -> " + ex.getMessage());
        }
        //Se retorna la lista de clases disponibles
        return listaClases;
    }

    public ArrayList<Clase> buscarClasePorNombre(String nombre) {
        this.clase = null;
        ArrayList<Clase> listaNombres = new ArrayList<Clase>();
        //Consulta SQL
        String query = "SELECT idClase,idEntrenador,nombre,horario,capacidad,estado "
                + "FROM clases "
                + "WHERE nombre = ? and estado = 1 ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clase = new Clase();//Nueva instancia de clase
                //Se establecen los datos de la clase 
                clase.setIdClase(rs.getInt("idClase"));
                int idEntrenador = rs.getInt("idEntrenador"); // Guarda el ID del entrenador
                Entrenador el = EntrenadorData.buscarEntrenadorPorId(rs.getInt("idEntrenador"));
                clase.setIdEntrenador(idEntrenador);
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);
                //Se añade la clase a la lista
                clase.setEntrenador(el);
                listaNombres.add(clase);
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Clase: buscarClasePorNommbre -> " + ex.getMessage());
        }

        return listaNombres;
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
                int idEntrenador = rs.getInt("idEntrenador"); // Guarda el ID del entrenador
                //Entrenador el = EntrenadorData.buscarEntrenadorPorId(rs.getInt("idEntrenador"));
                this.clase.setIdEntrenador(idEntrenador);
                this.clase.setNombre(rs.getString("nombre"));
                this.clase.setHorario(rs.getTime("horario").toLocalTime());
                this.clase.setCapacidad(rs.getInt("capacidad"));
                this.clase.setEstado(true);
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Clase: buscarEntrenador -> " + ex.getMessage());
        }
        return clase;
    }

    public ArrayList<Clase> buscarHorario(LocalTime horario) {
        this.clase = null;
        ArrayList<Clase> listaHorarios = new ArrayList<Clase>();
        
        String query = "SELECT idClase,idEntrenador,nombre,horario,capacidad,estado "
                + "FROM clases "
                + "WHERE horario = ? and estado = 1 ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setTime(1, Time.valueOf(horario));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clase = new Clase();//Nueva instancia de clase
                //Se establecen los datos de la clase 
                clase.setIdClase(rs.getInt("idClase"));
                int idEntrenador = rs.getInt("idEntrenador"); // Guarda el ID del entrenador
                Entrenador el = EntrenadorData.buscarEntrenadorPorId(rs.getInt("idEntrenador"));
                clase.setIdEntrenador(idEntrenador);
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);
                //Se añade la clase a la lista
                clase.setEntrenador(el);
                listaHorarios.add(clase);
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Clase: buscarHorario -> " + ex.getMessage());
        }
        return listaHorarios;
    }

    public boolean bajaClase(int id) {
        boolean flag = false;
        String query = "UPDATE clases SET estado = 0 WHERE idClase = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int baja = ps.executeUpdate();

            if (baja == 1) {
                flag = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Conexion.msjError.add("Clase: bajaClase -> " + ex.getMessage());
        }
        return flag;
    }

    public ArrayList<Clase> CuposClases(String nombreClase) {
        ArrayList<Clase> listaCupo = new ArrayList<Clase>();

        String query = "SELECT c.idClase, "
                + "       c.nombre AS clase_nombre, "
                + "       c.horario, "
                + "       c.capacidad - IFNULL(a.asistentes, 0) AS cupos_disponibles, "
                + "       e.nombre AS entrenador_nombre, "
                + "       e.apellido AS entrenador_apellido "
                + " FROM clases c "
                + " LEFT JOIN ( "
                + "    SELECT idClase, "
                + "           COUNT(*) AS asistentes "
                + "    FROM asistencias "
                + " WHERE fecha_asistencia = CURDATE() "
                + "    GROUP BY idClase "
                + " ) a ON c.idClase = a.idClase "
                + " INNER JOIN entrenadores e ON c.idEntrenador = e.idEntrenador "
                + " WHERE c.nombre = ?; ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombreClase);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("idClase");
                String name = rs.getString("clase_nombre");
                LocalTime time = rs.getTime("horario").toLocalTime();
                int capasidad = rs.getInt("cupos_disponibles");
                boolean estado = true;

                Clase claseCupo = new Clase(id, name, time, capasidad, estado);
                //  System.out.println(claseCupo.getNombre()+" - "+claseCupo.getIdClase()+" - "+claseCupo.getCapacidad());
                listaCupo.add(claseCupo);
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {

            Conexion.msjError.add("Clase: CuposClases -> " + ex.getMessage());
        }

        return listaCupo;
    }
    

    public ArrayList<Clase> listarClaseAsistencia() {
        //Lista para almacenar las clases disponibles
        ArrayList<Clase> listaClases = new ArrayList<>();
        //Consulta SQL
        String query = "SELECT DISTINCT nombre,horario,capacidad,idClase FROM clases WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            //Se itera sobre los resultados de la consulta
            while (rs.next()) {

                int id = rs.getInt("idClase");
                String name = rs.getString("nombre");
                LocalTime time = rs.getTime("horario").toLocalTime();
                int capasidad = rs.getInt("capacidad");
                boolean estado = true;
                 //holas
                Clase clase2 = new Clase(id, name, time, capasidad, estado);

                listaClases.add(clase2);
            }
            //Se cierran el PreparedStatement y el ResultSet.
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            //JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: ClasesDisponibles -> " + ex.getMessage());
        }

        return listaClases;
    }

    public boolean guardarAsistencias(Asistencia asistencia) {
        //Consulta SQL para insertar una nueva clase
        String query = "INSERT INTO asistencias (idSocio, idClase,fecha_asistencia)  VALUES(?,?,CURDATE())";
                
        boolean flag = false;
        try {

            PreparedStatement ps = con.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, asistencia.getidSocio());
            ps.setInt(2, asistencia.getIdClase());
            ps.executeUpdate();
             
            ResultSet rs = ps.getGeneratedKeys();
            //Si hay claves son asignadas a la clase
            if (rs.next()) {
                asistencia.setIdAsistencia(rs.getInt(1));
                
                flag = true;
            }
            ps.close();

        } catch (SQLException | NullPointerException ex) {

            Conexion.msjError.add("Clase: guardarClase -> " + ex.getMessage());
        }

        return flag;
    }
    
    
      public boolean descontarPases(int idSocio) {
        //Consulta SQL para insertar una nueva clase
         String query = "UPDATE membresias "
                      + "SET cantidadPases = cantidadPases - 1 "
                      + "WHERE idSocio = ? AND cantidadPases > 0 AND estado = 1";
                
        boolean flag = false;
        try {

            PreparedStatement ps = con.prepareStatement( query);

            ps.setInt(1, idSocio);
           
            int res=ps.executeUpdate();
             
           
            //Si hay claves son asignadas a la clase
            if (res>0) {
                flag = true;
            }
            ps.close();

        } catch (SQLException | NullPointerException ex) {

            Conexion.msjError.add("Clase: guardarClase -> " + ex.getMessage());
        }

        return flag;
    }

    public boolean quitarAsistenciaSocio(int idSocio, int idClase) {
        
        String query = "DELETE FROM asistencias "
                + " WHERE idClase = ? "
                + " AND idSocio = ? "
                + " AND fecha_asistencia = CURDATE(); ";

        boolean flag = false;
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, idClase);
            ps.setInt(2, idSocio);

            int res = ps.executeUpdate();

            //Si hay claves son asignadas a la clase
            if (res > 0) {
                flag = true;
            }
            ps.close();

        } catch (SQLException | NullPointerException ex) {

            Conexion.msjError.add("Clase: quitarAsistenciaSocio -> " + ex.getMessage());
        }

        return flag;
    }
      
}
