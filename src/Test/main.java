package Test;

import accesoADatos.ClaseData;
import accesoADatos.Conexion;
import accesoADatos.EntrenadorData;
import accesoADatos.MembresiasData;
import entidades.Socio;
import entidades.Entrenador;
import java.util.ArrayList;
import entidades.Clase;
import entidades.Membresias;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Nicolas
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Martin Pruebas SocioData
        //pruebaSocioData();
        //pruebaEntrenadorData();
        //pruebaClaseData();
        //pruebaMembresiasData();
        Conexion.mostrarErrores();

    }

    private static void pruebaSocioData() {
        accesoADatos.SocioData socioDat = new accesoADatos.SocioData();
        //guardarSocio
        socioDat.guardarSocio(new Socio("34877112", "martin", "piriz", 32, "mpirizdutra@ulp.edu.ar", "2664859913"));
        socioDat.guardarSocio(new Socio("18762864", "Walter", "piriz", 32, "wepo56@gmail.com", "2664855569"));
        socioDat.guardarSocio(new Socio("52909515", "Silvia", "Dutra", 32, "dialviacaetano63@gmail.com", "2664761074"));
        socioDat.guardarSocio(new Socio("28173863", "Carlos", "Ferrando", 44, "cferrando2015@gmail.com", "2664235019"));

        socioDat.listarSocio();

        ArrayList<Socio> lista = new ArrayList<Socio>();
        lista = socioDat.listarSocio();
        for (Socio socio : lista) {
            System.out.println(socio);
        }
    }

    private static void pruebaClaseData() {
        accesoADatos.ClaseData claseData = new accesoADatos.ClaseData();
        Entrenador e1 = new Entrenador(2, "12345678", "Juan", "Lucero", "Atletismo", true);
        Clase c1 = new Clase(e1, "Atletismo", LocalTime.of(10, 00), 10, true);
        claseData.guardarClase(c1);
        ArrayList<Clase> lista = new ArrayList<Clase>();
        lista = claseData.listarClasesDisponibles();
        for (Clase clase : lista) {
            System.out.println(clase);
        }
        //La busqueda de parametros (null,null,null) devuelve todos los entrenadores activos
        //Prueba buscarEntrenador por nombre y especialidad juntos
        //List<Entrenador> res1 = eData.buscarEntrenadores("Juan", null, "Atletis");
        //System.out.println("Resultados de la busqueda:");
        //for (Entrenador entrenador : res1) {
        //  System.out.println(entrenador);
        //}
        //Prueba buscarEntrenador solo por apellido
        //List<Entrenador> res2 = eData.buscarEntrenadores(null, "L", null);
        //System.out.println("Resultados de la busqueda solo con apellido:");
        //for (Entrenador entrenador : res2) {
        //System.out.println(entrenador);
        //Prueba modificarEntrenador()
        //entrenador.setEstado(true);
        //eData.modificarEntrenador(entrenador);
    }

    private static void pruebaEntrenadorData() {
        EntrenadorData eData = new EntrenadorData();
        Entrenador e = new Entrenador(1);
        boolean ok = eData.guardarEntrenador(e);
        List<Entrenador> entrenadores = eData.listarEntrenadores();
        for (Entrenador entrenador : entrenadores) {
            System.out.println(entrenador);
        }
    }

    private static void pruebaMembresiasData() {
        //Crear una instancia de MembresiasData
        accesoADatos.MembresiasData membresiasData = new MembresiasData();
        accesoADatos.SocioData socioDat = new accesoADatos.SocioData();
        Socio sc1 = socioDat.buscarSocioPorId(1);
        Date fechaIn = new Date();
        Calendar fechafin = Calendar.getInstance();
        fechafin.setTime(fechaIn);
        fechafin.add(Calendar.DAY_OF_MONTH, 30);
        //System.out.println( fechaIn+ "Sat Jun 08 22:02:45 ART 2024------- Mon Jul 08 22:02:45 ART 2024"+fechafin.getTime() );
        membresiasData.guardarMembresia(new Membresias(1, sc1, 10, 50.0, fechaIn, fechafin.getTime(), true));
        //Buscar Membresias
        // ID del socio a buscar
        //int idSocio = 1;
        // Obtener el historial de membresías del socio
        //ArrayList<Membresias> historial = membresiasData.historialMembresias(idSocio);
        // Verificar si se obtuvieron membresías y mostrar la información
        //if (historial.isEmpty()) {
        //  System.out.println("No se encontraron membresías para el socio con ID: " + idSocio);
        //} else {
        //    System.out.println("Historial de membresías para el socio con ID: " + idSocio);
        //    for (Membresias membresia : historial) {
        //        System.out.println("ID Membresía: " + membresia.getIdMembresia());
        //        System.out.println("ID Socio: " + membresia.getSocio().getIdSocio());
        //        System.out.println("Cantidad de Pases: " + membresia.getCantidadPases());
        //        System.out.println("Costo: " + membresia.getCosto());
        //        System.out.println("Fecha de Inicio: " + membresia.getFechaInicio());
        //        System.out.println("Fecha de Fin: " + membresia.getFechaFin());
        //        System.out.println("Estado: " + membresia.isEstado());
        //        System.out.println("-----------------------");
        //    }
        //}
    }

}
