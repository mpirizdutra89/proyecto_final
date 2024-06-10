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
import java.util.function.Consumer;

/**
 * @author Nicolas
 */
public class main {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        //Martin, Agustin, Ariel y Carlos Pruebas
//        //pruebaSocioData();
//        pruebaEntrenadorData();
//        //pruebaClaseData();
//        //pruebaMembresiasData();
//        //pruebaEntrenadorData();
//        //pruebaClaseData();
//        pruebaMembresiasData();
//        Conexion.mostrarErrores();
//
//    }

    private static void pruebaSocioData() {
        //boolean guardarSocio(Socio socio)*
        //boolean modificarSocios(Socio socio)*
        //ArrayList<Socio> listarSocio()*
        //Socio buscarSocioPorId(int id)*
        //ArrayList<Socio> buscarSocioPorNombre(String nombre)
        //boolean bajaSocio(int id)*

        accesoADatos.SocioData socioDat = new accesoADatos.SocioData();
        //guardarSocio
        //socioDat.guardarSocio(new Socio("34877112", "martin", "piriz", 32, "mpirizdutra@ulp.edu.ar", "2664859913"));
        //socioDat.guardarSocio(new Socio("18762864", "Walter", "piriz", 32, "wepo56@gmail.com", "2664855569"));
        //socioDat.guardarSocio(new Socio("52909515", "Silvia", "Dutra", 32, "dialviacaetano63@gmail.com", "2664761074"));
        //socioDat.guardarSocio(new Socio("28173863", "Carlos", "Ferrando", 44, "cferrando2015@gmail.com", "2664235019"));

        //socioDat.listarSocio();
        //ArrayList<Socio> lista = new ArrayList<Socio>();
        //lista = socioDat.listarSocio();
        /*Socio s1 = socioDat.buscarSocioPorNombre("Martin");            
            System.out.println(s1.getIdSocio());
            System.out.println(s1.getDni());
            System.out.println(s1.getNombre());
            System.out.println(s1.getApellido());
            System.out.println(s1.getEdad());
            System.out.println(s1.getCorreo());
            System.out.println(s1.getTelefono());
            System.out.println(s1.getEstado());*/

        //Socio s = socioDat.buscarSocioPorId(1);
        //if(s != null){
        //    System.out.println("ID: " + s.getIdSocio());
        //    System.out.println("DNI: " + s.getDni());
        //    System.out.println("Nombre: " + s.getNombre());
        //    System.out.println("Apellido: " + s.getApellido());
        //    System.out.println("Edad: " + s.getEdad());
        //    System.out.println("Email: " + s.getCorreo());
        //    System.out.println("Teléfono: " + s.getTelefono());
        //}
        //boolean verdad = socioDat.modificarSocios(new Socio(1, "34877112", "Martin", "piriz", 32, "mpirizdutra@ulp.edu.ar", "2664859913", true));
        //if(verdad){
        //    System.out.println("socio modificado");
        //}
        //boolean verdad =socioDat.bajaSocio(7);
        //if(verdad){
        //   System.out.println("socio eliminado");
        //}
    }

    private static void pruebaClaseData() {
        //void guardarClase(Clase clase)*
        //ArrayList<Clase> listarClasesDisponibles()*
        //Clase buscarClasePorNombre(String nombre)*
        //Clase buscarEntrenador(int id)*
        //Clase buscarHorario(LocalTime horario)*
        //void bajaClase(int id)*
        accesoADatos.ClaseData claseData = new accesoADatos.ClaseData();
        accesoADatos.EntrenadorData entData = new accesoADatos.EntrenadorData();
        //Entrenador e1 = new Entrenador(2, "12345678", "Juan", "Lucero", "Atletismo", true);
        //Entrenador e2 = new Entrenador(3, "34765098", "Jorge", "Castro", "CrossFit", true);
        //Entrenador e3 = new Entrenador(4, "25647389", "Cristina", "Paez", "Pilates", true);
        //Entrenador e4 = new Entrenador(5, "29876345", "Georgina", "Bardach", "Natación", true);
        //entData.guardarEntrenador(e4);

        //Clase c1 = new Clase(e4, "Natación", LocalTime.of(9, 00), 7, true);
        //claseData.guardarClase(c1);
        /*claseData.listarClasesDisponibles().forEach(item ->{
            System.out.println("ID clase: " + item.getIdClase());
            System.out.println("ID Entrenador: " + item.getIdEntrenador());
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Horario: " + item.getHorario());
            System.out.println("Capacidad: " + item.getCapacidad());
        });*/
        /*Clase c1 = claseData.buscarClasePorNombre("Pilates");
        System.out.println("ID clase: " + c1.getIdClase());
        System.out.println("ID Entrenador: " + c1.getIdEntrenador());
        System.out.println("Nombre: " + c1.getNombre());
        System.out.println("Horario: " + c1.getHorario());
        System.out.println("Capacidad: " + c1.getCapacidad());*/
        
        /*Clase c1 = claseData.buscarEntrenador(3);
        System.out.println("ID clase: " + c1.getIdClase());
        System.out.println("ID Entrenador: " + c1.getIdEntrenador());
        System.out.println("Nombre: " + c1.getNombre());
        System.out.println("Horario: " + c1.getHorario());
        System.out.println("Capacidad: " + c1.getCapacidad());*/
        
        /*Clase c1 = claseData.buscarHorario(LocalTime.of(10, 0));
        System.out.println("ID clase: " + c1.getIdClase());
        System.out.println("ID Entrenador: " + c1.getIdEntrenador());
        System.out.println("Nombre: " + c1.getNombre());
        System.out.println("Horario: " + c1.getHorario());
        System.out.println("Capacidad: " + c1.getCapacidad());*/
        
        /*claseData.bajaClase(15);
        claseData.listarClasesDisponibles().forEach(item ->{
            System.out.println("ID clase: " + item.getIdClase());
            System.out.println("ID Entrenador: " + item.getIdEntrenador());
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Horario: " + item.getHorario());
            System.out.println("Capacidad: " + item.getCapacidad());
        });*/
        
        //claseData.listarClasesDisponibles().forEach(item ->{
        //    System.out.println("ID clase: " + item.getIdClase());
        //    System.out.println("ID Entrenador: " + item.getIdEntrenador());
        //    System.out.println("Nombre: " + item.getNombre());
        //    System.out.println("Horario: " + item.getHorario());
        //    System.out.println("Capacidad: " + item.getCapacidad());
//        //});
//        Clase c1 = claseData.buscarClasePorNombre("Pilates");
//        System.out.println("ID clase: " + c1.getIdClase());
//        System.out.println("ID Entrenador: " + c1.getIdEntrenador());
//        System.out.println("Nombre: " + c1.getNombre());
//        System.out.println("Horario: " + c1.getHorario());
//        System.out.println("Capacidad: " + c1.getCapacidad());
    }

    private static void pruebaEntrenadorData() {
        //boolean guardarEntrenador(Entrenador entrenador)*
        //List<Entrenador> listarEntrenadores()*
        //List<Entrenador> buscarEntrenadores(String nombre,String apellido,String especialidad)*
        //List<Entrenador> buscarEntrenadoresInactivos(String nombre,String apellido,String especialidad)
        //Entrenador buscarEntrenadorPorId(int idEntrenador)*
        //void eliminarEntrenador(int id)*
        //void modificarEntrenador(Entrenador entrenador)
        EntrenadorData eData = new EntrenadorData();
        Entrenador e = new Entrenador(1);
        boolean ok = eData.guardarEntrenador(e);
//        List<Entrenador> entrenadores = eData.listarEntrenadores();
//        for (Entrenador entrenador : entrenadores) {
//            System.out.println(entrenador);
//        }
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

    private static void pruebaMembresiasData() {
        //Crear una instancia de MembresiasData
        accesoADatos.MembresiasData membresiasData = new MembresiasData();
        accesoADatos.SocioData socioDat = new accesoADatos.SocioData();
        Socio sc1 = socioDat.buscarSocioPorId(2);
        Date fechaIn = new Date();
        Calendar fechafin = Calendar.getInstance();
        fechafin.setTime(fechaIn);
        fechafin.add(Calendar.DAY_OF_MONTH, 30);
        //System.out.println( fechaIn+ "Sat Jun 08 22:02:45 ART 2024------- Mon Jul 08 22:02:45 ART 2024"+fechafin.getTime() );
        //membresiasData.guardarMembresia(new Membresias(1, sc1, 15, 300.0, fechaIn, fechafin.getTime(), true));
        //Buscar Membresias
        // ID del socio a buscar
        int idSocio = 2;
////        // Obtener el historial de membresias del socio
//        ArrayList<Membresias> historial = membresiasData.historialMembresias(idSocio);
////        // Verificar si se obtuvieron membresias y mostrar la información
//        if (historial.isEmpty()) {
//          System.out.println("No se encontraron membresias para el socio con ID: " + idSocio);
//        } else {
//            System.out.println("Historial de membresias para el socio con ID: " + idSocio);
//            for (Membresias membresia : historial) {
//                System.out.println("ID Membresia: " + membresia.getIdMembresia());
//                System.out.println("ID Socio: " + membresia.getSocio().getIdSocio());
//                System.out.println("Cantidad de Pases: " + membresia.getCantidadPases());
//                System.out.println("Costo: " + membresia.getCosto());
//                System.out.println("Fecha de Inicio: " + membresia.getFechaInicio());
//                System.out.println("Fecha de Fin: " + membresia.getFechaFin());
//                System.out.println("Estado: " + membresia.isEstado());
//                System.out.println("-----------------------");
//            }
//        }
    int idMembresia = 3;
    //membresiasData.removerMembresias(idMembresia);
    //membresiasData.renovarMembresias(idMembresia);
    //membresiasData.darAltaMembresia(idMembresia);

    }

}
