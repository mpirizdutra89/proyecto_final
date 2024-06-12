package accesoADatos;

import entidades.Membresias;
import entidades.Socio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariel Zurita
 */
public class MembresiasData {
//    private static Connection conec = null;
//
//    public MembresiasData() {
//        conec = Conexion.getConexion();
//     }
//  
//   public int guardarMembresias(Membresias membresia) {
//    String sql = "INSERT INTO membresias (idSocio, cantidadPases, costo, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?, ?)";
//    int idMembresiaGenerada = -1; // A esto no le des bola porque lo declaraste de otra forma
//
//    try {
//        PreparedStatement ps = conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        ps.setInt(1, membresia.getSocio().getIdSocio());
//        ps.setInt(2, membresia.getCantidadPases());
//        ps.setDouble(3, membresia.getCosto());
//        ps.setDate(4, new Date(membresia.getFechaInicio().getTime()));
//        ps.setDate(5, new Date(membresia.getFechaFin().getTime()));
//        ps.setBoolean(6, membresia.isEstado());
//
//        ps.executeUpdate();
//        
//        // Obtener las claves generadas automáticamente
//        ResultSet rs = ps.getGeneratedKeys();
//        if (rs.next()) {
//            idMembresiaGenerada = rs.getInt(1); // Obtener el valor de la clave generada
//        }
//        
//        ps.close();
//    } catch (SQLException ex) {
//        Conexion.msjError.add("MembresiasData: guardarMembresias() -> " + ex.getMessage());
//    }
//    
//    return idMembresiaGenerada; // Esto me parece que estaria faltando el RETURN
//  }
//   }
    private Membresias membresias;

    private static Connection conec = null;

    public MembresiasData() {
        conec = Conexion.getConexion();
    }

    /* METODOS */
    public void guardarMembresia(Membresias membresia) {
        // Consulta SQL para insertar una nueva membresía
        String query = "INSERT INTO membresias(idSocio, cantidadPases, costo, fecha_inicio, fecha_fin, estado) "
                + "VALUES(?,?,?,?,?,?)";

        try {
            // Prepara la consulta y permite obtener las claves generadas automáticamente
            PreparedStatement ps = conec.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Se establecen los valores de los parámetros
            ps.setInt(1, membresia.getSocio().getIdSocio());  // Suponiendo que Socio tiene un método getIdSocio()
            ps.setInt(2, membresia.getCantidadPases());
            ps.setDouble(3, membresia.getCosto());
            ps.setDate(4, new java.sql.Date(membresia.getFechaInicio().getTime()));
            ps.setDate(5, new java.sql.Date(membresia.getFechaFin().getTime()));
            ps.setBoolean(6, membresia.isEstado());

            // Se ejecuta la actualización en la BD
            ps.executeUpdate();

            // Se obtienen las claves generadas automáticamente
            ResultSet rs = ps.getGeneratedKeys();

            // Si hay claves, son asignadas a la membresía
            if (rs.next()) {
                membresia.setIdMembresia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Membresía guardada exitosamente!!");
            }

            // Se cierran el PreparedStatement y el ResultSet
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Membresía: guardarMembresia -> " + ex.getMessage());
        }
    }

    public ArrayList<Membresias> historialMembresias(int idSocio) {
        ArrayList<Membresias> membresiasList = new ArrayList<>();
           String query = "SELECT m.*, s.nombre AS nombreSocio, s.apellido AS apellidoSocio " +
                   "FROM membresias m " +
                   "INNER JOIN socios s ON m.idSocio = s.idSocio " +
                   "WHERE m.idSocio = ? AND m.estado = 1";


        try {

            PreparedStatement ps = conec.prepareStatement(query);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();
           

            while (rs.next()) {
                int idMembresia = rs.getInt("idMembresia");
                String nombre = rs.getString("nombreSocio");
                String apellido = rs.getString("apellidoSocio");
                int cantidadPases = rs.getInt("cantidadPases");
                double costo = rs.getDouble("costo");
                Date fechaInicio = rs.getDate("fecha_inicio");
                Date fechaFin = rs.getDate("fecha_fin");
                boolean estado = rs.getBoolean("estado");
                
                Socio socio = new Socio();
                socio.setNombre(nombre);
                socio.setApellido(apellido);

                Membresias membresia = new Membresias(idMembresia, socio, cantidadPases, costo, fechaInicio, fechaFin, estado);
                membresiasList.add(membresia);
                
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Error al obtener el historial de membresías: " + ex.getMessage());
        }
        return membresiasList;
        
    }
    
        public ArrayList<Membresias> obtenerMembresiasCanceladas() {
        ArrayList<Membresias> membresiasCanceladas = new ArrayList<>();
           String query = "SELECT m.*, s.nombre AS nombreSocio, s.apellido AS apellidoSocio " +
                   "FROM membresias m " +
                   "INNER JOIN socios s ON m.idSocio = s.idSocio " +
                    "AND m.estado = 0";


        try {

            PreparedStatement ps = conec.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
           

            while (rs.next()) {
                int idMembresia = rs.getInt("idMembresia");
                String nombre = rs.getString("nombreSocio");
                String apellido = rs.getString("apellidoSocio");
                int cantidadPases = rs.getInt("cantidadPases");
                double costo = rs.getDouble("costo");
                Date fechaInicio = rs.getDate("fecha_inicio");
                Date fechaFin = rs.getDate("fecha_fin");
                boolean estado = rs.getBoolean("estado");
                
                Socio socio = new Socio();
                socio.setNombre(nombre);
                socio.setApellido(apellido);

                Membresias membresia = new Membresias(idMembresia, socio, cantidadPases, costo, fechaInicio, fechaFin, estado);
                membresiasCanceladas.add(membresia);
                
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Error al obtener el historial de membresías canceladas: " + ex.getMessage());
        }
        return membresiasCanceladas;
        
    }
    


//
//// en este ejemplo (ArrayList<Membreias> historialMembreias()) no entiendo bien si lo tengo que hacer general
////Es decir hacer igual que Historial Membresias  solo que lo tengo que ser a si _ String query = "SELECT * FROM membresias";
////Preguntar al grupo 
//
//
//public ArrayList<Membresias> historialMembresias() {
//    ArrayList<Membresias> membresiasList = new ArrayList<>();
//    String query = "SELECT * FROM membresias";
//
//    PreparedStatement ps = null;
//    ResultSet rs = null;
//
//    try {
//        // Prepara la consulta SQL
//        ps = conec.prepareStatement(query);
//        
//        // Ejecuta la consulta y obtiene el ResultSet
//        rs = ps.executeQuery();
//        
//        // Itera sobre el ResultSet y crea objetos Membresias
//        while (rs.next()) {
//            int idMembresia = rs.getInt("idMembresia");
//            int socioId = rs.getInt("idSocio");
//            Socio socio = new Socio(); // Suponiendo que tienes un constructor vacío o un método para obtener un socio por ID
//            socio.setIdSocio(socioId);
//            
//            int cantidadPases = rs.getInt("cantidadPases");
//            double costo = rs.getDouble("costo");
//            Date fechaInicio = rs.getDate("fechaInicio");
//            Date fechaFin = rs.getDate("fechaFin");
//            boolean estado = rs.getBoolean("estado");
//
//            Membresias membresia = new Membresias(idMembresia, socio, cantidadPases, costo, fechaInicio, fechaFin, estado);
//            membresiasList.add(membresia);
//        }
//    } catch (SQLException ex) {
//        Conexion.msjError.add("Error al obtener el historial de membresías: " + ex.getMessage());
//    } finally {
//        // Cierra ResultSet y PreparedStatement
//        try {
//            if (rs != null) rs.close();
//            if (ps != null) ps.close();
//        } catch (SQLException ex) {
//            Conexion.msjError.add("Error al cerrar recursos: " + ex.getMessage());
//        }
//    }
//
//    return membresiasList;
//}
//
public Membresias buscarSocio(int idSocio) {

    String sql = "SELECT idMembresia, socio_id, cantidadPases, costo, fechaInicio, fechaFin, estado FROM membresias WHERE socio_id = ? AND estado = 1";

    Membresias membresia = null;

    try {
        PreparedStatement ps = conec.prepareStatement(sql);
        ps.setInt(1, idSocio);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            membresia = new Membresias();

            membresia.setIdMembresia(rs.getInt("idMembresia"));
            
            // Supongamos que tienes un método para buscar un socio por ID
            Socio socio = buscarSocioPorId(rs.getInt("socio_id")); 
            membresia.setSocio(socio);
            
            membresia.setCantidadPases(rs.getInt("cantidadPases"));
            membresia.setCosto(rs.getDouble("costo"));
            membresia.setFechaInicio(rs.getDate("fechaInicio"));
            membresia.setFechaFin(rs.getDate("fechaFin"));
            membresia.setEstado(rs.getBoolean("estado"));

        } else {
            JOptionPane.showMessageDialog(null, "No existe esa membresía para el socio especificado");
        }
        ps.close();
        rs.close();
    } catch (SQLException | NullPointerException ex) {
        Conexion.msjError.add("Membresias: buscarSocio ->" + ex.getMessage());
    }
    return membresia;
    
    
    
}
    public ArrayList<Membresias> buscarSocioCancelados(int idSocio) {
        ArrayList<Membresias> lista = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement ps = null;

        String consulta = "SELECT * FROM membresias WHERE socio_id = ? AND estado = 0";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, idSocio);

            res = ps.executeQuery();
            while (res.next()) {
                int idMembresia = res.getInt("idMembresia");
                int socioId = res.getInt("socio_id");
                int cantidadPases = res.getInt("cantidadPases");
                double costo = res.getDouble("costo");
                Date fechaInicio = res.getDate("fechaInicio");
                Date fechaFin = res.getDate("fechaFin");
                boolean estado = res.getBoolean("estado");

                Socio socio = buscarSocioPorId(socioId);

                Membresias membresia = new Membresias(idMembresia, socio, cantidadPases, costo, fechaInicio, fechaFin, estado);
                lista.add(membresia);
            }

            ps.close();
            res.close();

        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("MembresiasData: buscarSocioCancelados() ->" + ex.getMessage());
        }

        return lista;
    }

    // Método de ejemplo para buscar un socio por ID
    private Socio buscarSocioPorId(int id) {
        String sql = "SELECT id, nombre, apellido, dni FROM socios WHERE id = ?";
        Socio socio = null;

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                socio = new Socio();
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setDni(rs.getString("dni"));
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Socios: buscarSocioPorId() ->" + ex.getMessage());
        }
        return socio;
    }
    
    
   // Método para baja lógica de una membresía
    public boolean removerMembresias(int id) {
        String sql = "UPDATE membresias SET estado = 0 WHERE idMembresia = ?";
        boolean resultado = false;

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("MembresiasData: removerMembresias() -> " + ex.getMessage());
        }

        return resultado;
    }
    
    
    

    // Método para renovar una membresía
    public boolean renovarMembresias(int id) {
        String sql = "UPDATE membresias SET fecha_inicio = ?, fecha_fin = ?, cantidadPases = ? WHERE idMembresia = ? AND estado = 1";
        boolean resultado = false;
        Date fechaInicio = new Date(System.currentTimeMillis());
        Date fechaFin = new Date(fechaInicio.getTime() + (30L * 24 * 60 * 60 * 1000)); // 30 días

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) fechaInicio);
            ps.setDate(2, (java.sql.Date) fechaFin);
            ps.setInt(3, 30); // Suponiendo que cada mes tiene 30 pases
            ps.setInt(4, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            if(resultado){
            
            JOptionPane.showMessageDialog(null, "Membresia renovada con exito!!");
            }
            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("MembresiasData: renovarMembresias() -> " + ex.getMessage());
        }

        return resultado;
    }

    // Método para verificar si un socio existe por su DNI
    public boolean existeSocio(int dni) {
        String sql = "SELECT 1 FROM socios WHERE dni = ?";
        boolean existe = false;

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("MembresiasData: existeSocio() -> " + ex.getMessage());
        }

        return existe;
    }

    // Método para dar de alta un socio que se dio de baja y vuelve
    public boolean darAltaSocio(int idSocio) {
        String sql = "UPDATE socios SET estado = 1 WHERE idSocio = ?";
        boolean resultado = false;

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, idSocio);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("MembresiasData: darAltaSocio() -> " + ex.getMessage());
        }

        return resultado;
    }
    
    
        public boolean altaMembresia(int idMembresia) {
        String sql = "UPDATE membresias SET estado = 1 WHERE idMembresia = ?";
        boolean resultado = false;

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, idMembresia);
            int filasAfectadas =ps.executeUpdate();
            if (filasAfectadas > 0) {
            resultado = true;
        }
            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("MembresiasData: darAltaMembresia() -> " + ex.getMessage());
        }

        return resultado;
    }
}

