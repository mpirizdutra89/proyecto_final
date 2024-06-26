package accesoADatos;

import entidades.Entrenador;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author agus1
 */
public class EntrenadorData {
    
    private Entrenador entrenador;
    private static Connection conec = null;
    
    
    public EntrenadorData(){
        conec = Conexion.getConexion();
    }
    
    
    public boolean guardarEntrenador(Entrenador entrenador){
        String sql = "INSERT INTO entrenadores (dni, nombre, apellido, especialidad) VALUES (?,?,?,?)";
        
        boolean res = false;
        
        
        try {
            PreparedStatement ps = conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                entrenador.setIdEntrenador(rs.getInt(1));
                res = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Entrenador: guardarEntrenador() ->" + ex.getMessage());
        }
        return res;
    }
    
    
    public List<Entrenador> listarEntrenadores(){
    
        String sql = "SELECT * FROM entrenadores WHERE estado = 1";
        
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        
        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Entrenador entrenador = new Entrenador();
                
                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
                entrenador.setDni(rs.getString("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);
                
                entrenadores.add(entrenador);
            
            }
            ps.close();
            rs.close();
            
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Entrenador: listarEntrenadores() ->" + ex.getMessage());
        }
        return entrenadores;
    }
    
    public List<Entrenador> listarEntrenadoresInactivos(){
    
        String sql = "SELECT * FROM entrenadores WHERE estado = 0";
        
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        
        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Entrenador entrenador = new Entrenador();
                
                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
                entrenador.setDni(rs.getString("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);
                
                entrenadores.add(entrenador);
            
            }
            ps.close();
            rs.close();
            
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Entrenador: listarEntrenadores() ->" + ex.getMessage());
        }
        return entrenadores;
    }
    
    
    
    //Metodo buscarEntrenadores() a considerar cambios y mejoras en el codigo luego de probar funcionalidad en la vista
    public List<Entrenador> buscarEntrenadores(String nombre,String apellido,String especialidad){
        String sql = "SELECT * FROM entrenadores WHERE estado = 1";
        
        //Consulta dinamica, segun lo q se pase por parametro se va modificando
        if(nombre != null && !nombre.isEmpty()){
            sql += " AND nombre LIKE ?";
        }
        if(apellido != null && !apellido.isEmpty()){
            sql += " AND apellido LIKE ?";
        }
        if(especialidad != null && !especialidad.isEmpty()){
            sql += " AND especialidad LIKE ?";
        }
        
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        
        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            
        //El indice se acomoda a la cantidad de parametros que se ingresan para buscar
        int i = 1;
        if (nombre != null && !nombre.isEmpty()) {
            ps.setString(i++, nombre + "%");
        }
        if (apellido != null && !apellido.isEmpty()) {
            ps.setString(i++, apellido + "%");
        }
        if (especialidad != null && !especialidad.isEmpty()) {
            ps.setString(i++, especialidad + "%");
        }
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            entrenador = new Entrenador();
            
            entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
            entrenador.setDni(rs.getString("dni"));
            entrenador.setNombre(rs.getString("nombre"));
            entrenador.setApellido(rs.getString("apellido"));
            entrenador.setEspecialidad(rs.getString("especialidad"));
            entrenador.setEstado(rs.getBoolean("estado"));
            
            entrenadores.add(entrenador);
        }
        ps.close();
        rs.close();
        
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Entrenador: buscarEntrenadores() ->" + ex.getMessage());
        }
        return entrenadores;
    }
    
//        Metodo buscarEntrenadores() a considerar cambios y mejoras en el codigo luego de probar funcionalidad en la vista
//    public List<Entrenador> buscarEntrenadoresInactivos(String nombre,String apellido,String especialidad){
//        String sql = "SELECT * FROM entrenadores WHERE estado = 0";
//        
//        Consulta dinamica, segun lo q se pase por parametro se va modificando
//        if(nombre != null && !nombre.isEmpty()){
//            sql += " AND nombre LIKE ?";
//        }
//        if(apellido != null && !apellido.isEmpty()){
//            sql += " AND apellido LIKE ?";
//        }
//        if(especialidad != null && !especialidad.isEmpty()){
//            sql += " AND especialidad LIKE ?";
//        }
//        
//        ArrayList<Entrenador> entrenadores = new ArrayList<>();
//        
//        try {
//            PreparedStatement ps = conec.prepareStatement(sql);
//            
//        El indice se acomoda a la cantidad de parametros que se ingresan para buscar
//        int i = 1;
//        if (nombre != null && !nombre.isEmpty()) {
//            ps.setString(i++, nombre + "%");
//        }
//        if (apellido != null && !apellido.isEmpty()) {
//            ps.setString(i++, apellido + "%");
//        }
//        if (especialidad != null && !especialidad.isEmpty()) {
//            ps.setString(i++, especialidad + "%");
//        }
//        
//        ResultSet rs = ps.executeQuery();
//        
//        while(rs.next()){
//            entrenador = new Entrenador();
//            
//            entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
//            entrenador.setDni(rs.getString("dni"));
//            entrenador.setNombre(rs.getString("nombre"));
//            entrenador.setApellido(rs.getString("apellido"));
//            entrenador.setEspecialidad(rs.getString("especialidad"));
//            entrenador.setEstado(rs.getBoolean("estado"));
//            
//            entrenadores.add(entrenador);
//        }
//        ps.close();
//        rs.close();
//        
//        if (entrenadores.isEmpty()) {
//            System.out.println("No se encontraron entrenadores inactivos con los datos proporcionados.");
//        }
//        } catch (SQLException | NullPointerException ex) {
//            Conexion.msjError.add("Entrenador: buscarEntrenadores() ->" + ex.getMessage());
//        }
//        return entrenadores;
//    }
    
    
    public static Entrenador buscarEntrenadorPorId(int idEntrenador) {
    String query = "SELECT * FROM entrenadores WHERE idEntrenador = ? AND estado = 1";
    Entrenador entrenador = null;
    try {
        PreparedStatement ps = conec.prepareStatement(query);
        ps.setInt(1, idEntrenador);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entrenador = new Entrenador();
            entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
            entrenador.setDni(rs.getString("dni"));
            entrenador.setNombre(rs.getString("nombre"));
            entrenador.setApellido(rs.getString("apellido"));
            entrenador.setEspecialidad(rs.getString("especialidad"));
            entrenador.setEstado(rs.getBoolean("estado"));
        }
        ps.close();
        rs.close();
    } catch (SQLException | NullPointerException ex) {
        Conexion.msjError.add("Entrenador: buscarEntrenadorPorId() ->" + ex.getMessage());
    }
    return entrenador;
}
    
    
    public static Entrenador buscarEntrenadorPorDNI(String dni) {
    String query = "SELECT * FROM entrenadores WHERE dni = ? AND estado = 1";
    Entrenador entrenador = null;
    try {
        PreparedStatement ps = conec.prepareStatement(query);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entrenador = new Entrenador();
            entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
            entrenador.setDni(rs.getString("dni"));
            entrenador.setNombre(rs.getString("nombre"));
            entrenador.setApellido(rs.getString("apellido"));
            entrenador.setEspecialidad(rs.getString("especialidad"));
            entrenador.setEstado(rs.getBoolean("estado"));
        }
        ps.close();
        rs.close();
    } catch (SQLException | NullPointerException ex) {
        Conexion.msjError.add("Entrenador: buscarEntrenadorPorDNI() ->" + ex.getMessage());
    }
    return entrenador;
}
    
    
    
    //Baja logica por id
    public boolean bajaEntrenador(String dni) {
        String sql = "UPDATE entrenadores SET estado = 0 WHERE dni = ?";

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setString(1, dni);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Entrenador: eliminarEntrenador() ->" + ex.getMessage());
            return false;
        }
    }
    
    public boolean altaEntrenador(String dni) {
        String sql = "UPDATE entrenadores SET estado = 1 WHERE dni = ?";
        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setString(1, dni);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Entrenador: darDeAltaEntrenador() ->" + ex.getMessage());
            return false;
        }
    }
    
    
    public void modificarEntrenador(Entrenador entrenador){
        String sql = "UPDATE entrenadores SET  dni = ?, nombre = ?, apellido = ?, especialidad = ?, estado = ? WHERE idEntrenador = ?";
    
        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setString(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            ps.setInt(6, entrenador.getIdEntrenador());
            
            int resultado = ps.executeUpdate();
            if(resultado == 1){
            }
            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Entrenador: modificarEntrenador() ->" + ex.getMessage());
        }
    }
    
    public boolean estaDadoDeAlta(String dni) {
        String sql = "SELECT estado FROM entrenadores WHERE dni = ?";
        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int estado = rs.getInt("estado");
                return estado == 1;
            }
        } catch (SQLException ex) {
            Conexion.msjError.add("Error al verificar el estado del entrenador: " + ex.getMessage());
        }
        return false;
    }
    
        public boolean estaDadoDeBaja(String dni) {
        String sql = "SELECT estado FROM entrenadores WHERE dni = ?";
        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int estado = rs.getInt("estado");
                return estado == 0;
            }
        } catch (SQLException ex) {
            Conexion.msjError.add("Error al verificar el estado del entrenador: " + ex.getMessage());
        }
        return false;
    }
    
    

}
