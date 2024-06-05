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
    
    //SELECT `idSocio`, `dni`, `nombre`, `apellido`, `edad`, `correo`, `telefono`, `estado` FROM `socios`
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
    
    
    public ArrayList<Socio> listarSocio() {
        this.socio=null;
        String sql = "SELECT * FROM socios WHERE estado = 1";

        ArrayList<Socio> lista = new ArrayList<>();

        try {
            PreparedStatement ps = conec.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                 this.socio = new Socio();

                this.socio.setIdSocio(rs.getInt("idSocio"));
                this.socio.setDni(rs.getString("dni"));
                this.socio.setApellido(rs.getString("apellido"));
                this.socio.setNombre(rs.getString("nombre"));
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
    
    
    
      public Socio buscarSocioPorId(int id) {
        this.socio = null;
        PreparedStatement ps = null;
        String consulta = "SELECT * FROM socios WHERE  idSocio= ? and estado=1";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                this.socio = new Socio();
                this.socio.setIdSocio(id);
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
            Conexion.msjError.add("Alumnos: BuscarAlumno ->" + ex.getMessage());
        }

        return this.socio;
    }
    
    
}
