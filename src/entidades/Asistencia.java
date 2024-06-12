package entidades;

import java.time.LocalDate;

/**
 *
 * @author Martin
 */
public class Asistencia {
   private int idAsistencia;
   private int idSocio;
   private int idClase;
   private LocalDate fecha_asitencia;
   
    public Asistencia() {
    }

    public Asistencia(int idSocio, int idClase) {
        this.idSocio = idSocio;
        this.idClase = idClase;
    }

    public Asistencia(int idAsistencia, int idSocio, int idClase, LocalDate fecha_asitencia) {
        this.idAsistencia = idAsistencia;
        this.idSocio = idSocio;
        this.idClase = idClase;
        this.fecha_asitencia = fecha_asitencia;
    }
    
     public Asistencia(int idSocio, int idClase, LocalDate fecha_asitencia) {
     
        this.idSocio = idSocio;
        this.idClase = idClase;
        this.fecha_asitencia = fecha_asitencia;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getidSocio() {
        return idSocio;
    }

    public void setidSocio(int intSocio) {
        this.idSocio = intSocio;
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
       Codigo,Clase,Horario,Cupo
     }
     
      public enum  CabeceraAsistencia2{
       Codigo,Clase,Socio,Fecha
     }
   
   
   
}
