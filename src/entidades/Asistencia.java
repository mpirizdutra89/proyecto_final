package entidades;

import java.time.LocalDate;

/**
 *
 * @author Martin
 */
public class Asistencia {
   private int idAsistencia;
   private int intSocio;
   private int idClase;
   private LocalDate fecha_asitencia;
   
    public Asistencia() {
    }

    public Asistencia(int idAsistencia, int intSocio, int idClase, LocalDate fecha_asitencia) {
        this.idAsistencia = idAsistencia;
        this.intSocio = intSocio;
        this.idClase = idClase;
        this.fecha_asitencia = fecha_asitencia;
    }
    
     public Asistencia(int intSocio, int idClase, LocalDate fecha_asitencia) {
     
        this.intSocio = intSocio;
        this.idClase = idClase;
        this.fecha_asitencia = fecha_asitencia;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIntSocio() {
        return intSocio;
    }

    public void setIntSocio(int intSocio) {
        this.intSocio = intSocio;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public LocalDate getFecha_asitencia() {
        return fecha_asitencia;
    }

    public void setFecha_asitencia(LocalDate fecha_asitencia) {
        this.fecha_asitencia = fecha_asitencia;
    }

   
   

   
     public enum  CabeceraAsistencia{
       Clase,Horario,Cupo
     }
     
      public enum  CabeceraAsistencia2{
       Codigo,Clase,Socio,Fecha
     }
   
   
   
}
