package accesoADatos;

import entidades.Socio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author Martin Piriz
 */
public class SocioData {
    
    private Socio socio;
    private static Connection conec = null;

    public SocioData() {
        conec=null;
        conec = Conexion.getConexion();
    }
    
    //estado se guardar solo en la base de datos, su valor por default es true (1)
    public boolean guardarSocio(Socio socio) {
        String query = "INSERT INTO socios (dni,nombre,apellido,edad,correo,telefono) VALUES (?,?,?,?,?,?)";

        boolean res = false;

        try {
            PreparedStatement ps = conec.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4,socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                socio.setIdSocio(rs.getInt(1));
                
                res = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Socio: guardarSocio() ->" + ex.getMessage());
        }

       
        return res;
    }
    
        public boolean modificarSocios(Socio socio) {
            boolean res=false;
            String sql = "UPDATE socios SET dni=?,nombre=?,apellido=?,edad=?,correo=?,telefono=? WHERE idSocio=?";
            


            try {
                PreparedStatement ps = conec.prepareStatement(sql);
                ps.setString(1, socio.getDni());
                ps.setString(2, socio.getNombre());
                ps.setString(3, socio.getApellido());
                ps.setInt(4, socio.getEdad());
                ps.setString(5, socio.getCorreo());
                ps.setString(6, socio.getTelefono());
               
                ps.setInt(7, socio.getIdSocio());
               // System.out.println(""+ps.toString());
                int resultado = ps.executeUpdate();
                if (resultado == 1) {
                   res=true;
                }
                ps.close();
            } catch (SQLException | NullPointerException ex) {
                Conexion.msjError.add("Socios: modificarSocios ->" + ex.getMessage());
            }
            return res;

    }
    
    
    public ArrayList<Socio> listarSocio(int estado) {
        this.socio=null;
        String sql = "SELECT * FROM socios WHERE estado = ?";

        ArrayList<Socio> lista = new ArrayList<>();

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, estado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                 this.socio = new Socio();

                this.socio.setIdSocio(rs.getInt("idSocio"));
                this.socio.setDni(rs.getString("dni"));
                this.socio.setApellido(rs.getString("apellido"));
                this.socio.setNombre(rs.getString("nombre"));
                this.socio.setEdad(rs.getInt("edad"));
                this.socio.setCorreo(rs.getString("correo"));
                this.socio.setTelefono(rs.getString("telefono"));
               
                this.socio.setEstado(true);
                lista.add(this.socio);
            }
            ps.close();
            rs.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Socios: listarSocio ->" + ex.getMessage());
        }
        return lista;
    }
    
    
    
      public Socio buscarSocioPorId(int id,int estado) {
        this.socio = null;
        PreparedStatement ps = null;
        String consulta = "SELECT * FROM socios WHERE  idSocio= ? AND estado=?";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, id);
            ps.setInt(2, estado);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                this.socio = new Socio();
                this.socio.setIdSocio(res.getInt("idSocio"));
                this.socio.setDni(res.getString("dni"));
                this.socio.setApellido(res.getString("apellido"));
                this.socio.setNombre(res.getString("nombre"));
                this.socio.setEdad(res.getInt("edad"));
                this.socio.setCorreo(res.getString("correo"));
                this.socio.setTelefono(res.getString("telefono"));
                this.socio.setEstado(res.getBoolean("estado"));
            }
            ps.close();
            res.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Socio: BuscarSocioPorId ->" + ex.getMessage());
        }

        return this.socio;
    }
      public Socio buscarSocioPorId(int id) {
        this.socio = null;
        PreparedStatement ps = null;
        String consulta = "SELECT * FROM socios WHERE  idSocio= ?";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, id);
           
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                this.socio = new Socio();
                this.socio.setIdSocio(res.getInt("idSocio"));
                this.socio.setDni(res.getString("dni"));
                this.socio.setApellido(res.getString("apellido"));
                this.socio.setNombre(res.getString("nombre"));
                this.socio.setEdad(res.getInt("edad"));
                this.socio.setCorreo(res.getString("correo"));
                this.socio.setTelefono(res.getString("telefono"));
                this.socio.setEstado(res.getBoolean("estado"));
            }
            ps.close();
            res.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Socio: BuscarSocioPorId ->" + ex.getMessage());
        }

        return this.socio;
    }
      
       public Socio buscarSocioPorDni(String dni,int estado) {
        this.socio = null;
        PreparedStatement ps = null;
        String consulta = "SELECT * FROM socios WHERE  dni= ? AND estado=?";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setString(1, dni);
            ps.setInt(2, estado);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                this.socio = new Socio();
                this.socio.setIdSocio(res.getInt("idSocio"));
                this.socio.setDni(res.getString("dni"));
                this.socio.setApellido(res.getString("apellido"));
                this.socio.setNombre(res.getString("nombre"));
                this.socio.setEdad(res.getInt("edad"));
                this.socio.setCorreo(res.getString("correo"));
                this.socio.setTelefono(res.getString("telefono"));
                this.socio.setEstado(res.getBoolean("estado"));
            }
            ps.close();
            res.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Socio: BuscarSocioPorId ->" + ex.getMessage());
        }

        return this.socio;
    }
      //buscar por conisidencia, devulve el listado
      public ArrayList<Socio> buscarSocioPorNombre(String nombre,int estado) {
        this.socio = null;
        PreparedStatement ps = null;
        ArrayList<Socio> lista = new ArrayList<>();
        String consulta = "SELECT * FROM socios WHERE  (nombre LIKE ? or apellido LIKE ?)  AND estado=?";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setString(1, "%"+nombre+"%");
             ps.setString(2, "%"+nombre+"%");
             ps.setInt(3, estado);
            // System.out.println(ps.toString());
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                this.socio = new Socio();
                this.socio.setIdSocio(res.getInt("idSocio"));
                this.socio.setDni(res.getString("dni"));
                this.socio.setApellido(res.getString("apellido"));
                this.socio.setNombre(res.getString("nombre"));
                this.socio.setEdad(res.getInt("edad"));
                this.socio.setCorreo(res.getString("correo"));
                this.socio.setTelefono(res.getString("telefono"));
                this.socio.setEstado(res.getBoolean("estado"));
                lista.add(this.socio);
            }
            ps.close();
            res.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Socio: BuscarSocioPorNombre ->" + ex.getMessage());
        }

        return lista;
    }
    
      //si es true se borra;
    public boolean bajaSocio(int id,int estado) {
        boolean res=false;
        PreparedStatement ps;
        String consulta = "UPDATE socios SET estado = ? WHERE idSocio = ?";

        try {
            ps = conec.prepareStatement(consulta);
             ps.setInt(1, estado);
            ps.setInt(2, id);
            int borrado = ps.executeUpdate();
            if (borrado == 1) {
                res=true;
            }
            ps.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Socios: bajaSocio() ->" + ex.getMessage());
        }
        return res;
    }
    
    
     public int[] verificarSocioHabilitadoAsistencia(int idSocio) {
        int[] verificar = new int[2];
        String query = "SELECT "
                + "    IF(m.fecha_inicio <= CURDATE() AND CURDATE() <= m.fecha_fin, 1, 0) AS membresia_vigente,"
                + "    IF(m.cantidadPases > 0, 1, 0) AS pases_disponibles "
                + " FROM "
                + "    membresias m "
                + " WHERE "
                + "    m.idSocio = ?;";
        try {
             PreparedStatement ps = conec.prepareStatement(query);
             ps.setInt(1, idSocio);
             ResultSet rs = ps.executeQuery();
            //Se itera sobre los resultados de la consulta
            if (rs.next()) {
                verificar[0]=rs.getInt("membresia_vigente");
                verificar[1]=rs.getInt("pases_disponibles");
              
            }
            //Se cierran el PreparedStatement y el ResultSet.
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            //JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: ClasesDisponibles -> " + ex.getMessage());
        }

        return verificar;
    }
     
    
     public int verificarSocioAsistenciaRepetida(int idSocio,int idClase) {
        int verificar = 1;
        String query = "SELECT count(idSocio) as cant FROM asistencias WHERE fecha_asistencia = CURDATE() and idSocio=? and idClase=? ;";
        try {
             PreparedStatement ps = conec.prepareStatement(query);
             ps.setInt(1, idSocio);
              ps.setInt(2, idClase);
             ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                verificar=rs.getInt("cant");
            }
            
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            //JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: ClasesDisponibles -> " + ex.getMessage());
        }

        return verificar;
    }
     
      public int verificarClasesHorario(int idSocio,String horario) {
        int verificar = 1;
          String query = "SELECT COUNT(*) as cant "
                  + " FROM asistencias a "
                  + " JOIN clases c ON a.idClase = c.idClase "
                  + " WHERE a.idSocio = ? "
                  + "  AND c.horario = ? "
                  + "  AND a.fecha_asistencia = CURDATE() ";
        try {
             PreparedStatement ps = conec.prepareStatement(query);
             ps.setInt(1, idSocio);
             ps.setString(2, horario);
             ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                verificar=rs.getInt("cant");
            }
            
            ps.close();
            rs.close();
            //Captura de excepciones y se añade el error a una lista de errores 
        } catch (SQLException | NullPointerException ex) {
            //JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases!!.");
            Conexion.msjError.add("Clase: ClasesDisponibles -> " + ex.getMessage());
        }

        return verificar;
    }
      
      
        public ArrayList<Socio> listarSocioClase(String nombreClase) {
        ArrayList<Socio> lista = new ArrayList<Socio>();

            String query = "SELECT s.idSocio, s.dni, s.nombre, s.apellido,s.edad,s.telefono "
                    + " FROM socios s "
                    + " JOIN asistencias a ON s.idSocio = a.idSocio "
                    + " JOIN clases c ON a.idClase = c.idClase "
                    + " WHERE c.nombre = ? and fecha_asistencia=CURDATE(); ";

        try {
            PreparedStatement ps = conec.prepareStatement(query);
            ps.setString(1, nombreClase);
           // System.out.println(""+ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int idSocio = rs.getInt("idSocio");
                String dni = rs.getString("dni");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                int edad=rs.getInt("edad");
                String telefono=     rs.getString("telefono");   
//int idSocio, String dni, String nombre, String apellido, int edad, String correo, String telefono
                Socio socio = new Socio(idSocio, dni, nombre, apellido,edad,"b",telefono);
                //  System.out.println(claseCupo.getNombre()+" - "+claseCupo.getIdClase()+" - "+claseCupo.getCapacidad());
                lista.add(socio);
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {

            Conexion.msjError.add("Clase: listarSocioClase -> " + ex.getMessage());
        }

        return lista;
    }
      
      
      
}
