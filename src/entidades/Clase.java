package entidades;

import java.time.LocalTime;

/**
 *
 * @author Carlos
 */
public class Clase {

    private int idClase;
    private int idEntrenador;
    private String nombre;
    private LocalTime horario;
    private int capacidad;
    private boolean estado;

   

    /*CONSTRUCTORES*/
    public Clase() {
        
    }
    
    public Clase(String nombre, LocalTime horario, int capacidad, boolean estado) {
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Clase(int idEntrenador, String nombre, LocalTime horario, int capacidad, boolean estado) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Clase(int idClase, int idEntrenador, String nombre, LocalTime horario, int capacidad, boolean estado) {
        this.idClase = idClase;
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    /*GETTERS AND SETTERS*/
    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /*METODO SOBREESCRITO toString*/
    @Override
    public String toString() {
        return "idClases: " + idClase + ", idEntrenadores: " + idEntrenador + ", nombre: " + nombre
                + ", horario: " + horario + ", capacidad: " + capacidad + ", estado: " + estado;
    }
}
