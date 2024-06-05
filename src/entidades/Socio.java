package entidades;

/**
 *
 * @author martin
 */
public class Socio {
    //`idSocio`, `dni`, `nombre`, `apellido`, `edad`, `correo`, `telefono` FROM `socios`
    private int idSocio;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String telefono;
    private boolean estado;

    public Socio() {
    }

    public Socio(int idSocio, String dni, String nombre, String apellido, int edad, String correo, String telefono, boolean estado) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado=estado;
    }

    //estado se guardar solo por default en la base de datos
    public Socio(String dni, String nombre, String apellido, int edad, String correo, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return dni+", "+ nombre+", "+apellido; // es para los comboBox
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}
