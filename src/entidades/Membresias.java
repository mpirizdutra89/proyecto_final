package entidades;

import java.util.Date;

/**
 *
 * @author Ariel
 */
public class Membresias {
    private int idMembresia;
    private Socio socio;
    private int cantidadPases;
    private double costo;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;

    public Membresias() {
    }

    public Membresias(int idMembresia, Socio socio, int cantidadPases, double costo, Date fechaInicio, Date fechaFin, boolean estado) {
        this.idMembresia = idMembresia;
        this.socio = socio;
        this.cantidadPases = cantidadPases;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Membresias(Socio socio, int cantidadPases, double costo, Date fechaInicio, Date fechaFin, boolean estado) {
        this.socio = socio;
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

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
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
        return "Membresias{" + "idMembresia=" + idMembresia + ", socio=" + socio + ", cantidadPases=" + cantidadPases + ", costo=" + costo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + '}';
    }
    
    

    

    

    
}
