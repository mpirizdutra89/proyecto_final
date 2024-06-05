package entidades;

import java.util.Date;

/**
 *
 * @author Ariel
 */
public class Membresias {
    private int idMembresia;
    private int idSocio;
    private int cantidadPases;
    private double costo;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;

    public Membresias() {
    }
    
    

    public Membresias(int idMembresia, int idSocio, int cantidadPases, double costo, Date fechaInicio, Date fechaFin, boolean estado) {
        this.idMembresia = idMembresia;
        this.idSocio = idSocio;
        this.cantidadPases = cantidadPases;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getCantidadPases() {
        return cantidadPases;
    }

    public void setCantidadPases(int cantidadPases) {
        this.cantidadPases = cantidadPases;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Membresias{" + "idMembresia=" + idMembresia + ", idSocio=" + idSocio + ", cantidadPases=" + cantidadPases + ", costo=" + costo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + '}';
    }

    
}
   