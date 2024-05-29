package entidades;

/**
 *
 * @author Nicolas
 */
public class inscribirseClase {
    private int idInscripcionClase;
    private Socio socio;
    private Clase clase;
   
    public inscribirseClase() {
    }
    
    public inscribirseClase(int idInscripcionClase, Socio socio, Clase clase) {
        this.idInscripcionClase = idInscripcionClase;
        this.socio = socio;
        this.clase = clase;
    }

 

    public inscribirseClase(Socio socio, Clase clase) {
        this.socio = socio;
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "inscribirseClase{" + "idInscripcionClase=" + idInscripcionClase + ", socio=" + socio + ", clase=" + clase + '}';
    }

    public int getIdInscripcionClase() {
        return idInscripcionClase;
    }

    public void setIdInscripcionClase(int idInscripcionClase) {
        this.idInscripcionClase = idInscripcionClase;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
    
    
    
    
}
