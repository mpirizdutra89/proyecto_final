package entidades;

import java.time.LocalDate;

/**
 *
 * @author Carlos
 */
public class Clase {
    
    private int idClases;
    private int idEntrenadores;
    private String nombre;
    private LocalDate horario;
    private int capacidad;
    
    /*Constructores*/
    public Clase() {
    }

    public Clase(String nombre, LocalDate horario, int capacidad) {
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
    }

    public Clase(int idEntrenadores, String nombre, LocalDate horario, int capacidad) {
        this.idEntrenadores = idEntrenadores;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
    }

    public Clase(int idClases, int idEntrenadores, String nombre, LocalDate horario, int capacidad) {
        this.idClases = idClases;
        this.idEntrenadores = idEntrenadores;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
    }

    public int getIdClases() {
        return idClases;
    }

    public void setIdClases(int idClases) {
        this.idClases = idClases;
    }

    public int getIdEntrenadores() {
        return idEntrenadores;
    }

    public void setIdEntrenadores(int idEntrenadores) {
        this.idEntrenadores = idEntrenadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "idClases: " + idClases + ", idEntrenadores: " + idEntrenadores + ", nombre: " + nombre + ", horario: " + horario + ", capacidad: " + capacidad;
    }
    
    
    
    
            
    
}
