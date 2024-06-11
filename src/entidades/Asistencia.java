package entidades;

import java.time.LocalDate;

/**
 *
 * @author Martin
 */
public class Asistencia {
   private int idAsistencia;
   private Socio socio;
   private Clase clase;
   private LocalDate fecha_asitencia;// la ide seria que la fecha se actulice automaticamente con los regitros de la base dedatos no sede la iterfaz
   //entodo caso solo mostrarlo.
   

    public Asistencia() {
    }

    public Asistencia(int idAsistencia, Socio socio, Clase clase, LocalDate fecha_asitencia) {
        this.idAsistencia = idAsistencia;
        this.socio = socio;
        this.clase = clase;
        this.fecha_asitencia = fecha_asitencia;
    }

    public Asistencia(Socio socio, Clase clase, LocalDate fecha_asitencia) {
        this.socio = socio;
        this.clase = clase;
        this.fecha_asitencia = fecha_asitencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idAsistencia=" + idAsistencia + ", socio=" + socio + ", clase=" + clase + ", fecha_asitencia=" + fecha_asitencia + '}';
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
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

    public LocalDate getFecha_asitencia() {
        return fecha_asitencia;
    }

    public void setFecha_asitencia(LocalDate fecha_asitencia) {
        this.fecha_asitencia = fecha_asitencia;
    }
   
     public enum  CabeceraAsistencia{
       Clase,Profesor,Horario,Cupo
     }
   
   
   
}
