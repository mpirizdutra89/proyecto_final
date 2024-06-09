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
        //ruebasSocios();
//        pruebaClases();
        pruebaMembresias();
        Conexion.mostrarErrores();

//    public static void pruebasSocios(){
//        accesoADatos.SocioData socioDat=new accesoADatos.SocioData();
//        //guardarSocio
//        socioDat.guardarSocio(new Socio("34877112","martin","piriz",32,"mpirizdutra@ulp.edu.ar","2664859913"));
//        socioDat.guardarSocio(new Socio("18762864","Walter","piriz",32,"wepo56@gmail.com","2664855569"));
//        socioDat.guardarSocio(new Socio("52909515","Silvia","Dutra",32,"dialviacaetano63@gmail.com","2664761074"));
//        socioDat.guardarSocio(new Socio("28173863","Carlos","Ferrando",44,"cferrando2015@gmail.com","2664235019"));
//        
//        socioDat.listarSocio();
//        ArrayList<Socio> lista=new ArrayList<Socio>();
//        lista=socioDat.listarSocio();
//        for (Socio socio : lista) {
//            System.out.println(socio);
//        } 
        // EntrenadorData eData = new EntrenadorData();
        Entrenador e = new Entrenador(1);
        //boolean ok = eData.guardarEntrenador(e);
//    List<Entrenador> entrenadores = eData.listarEntrenadores();
//    
//    for (Entrenador entrenador : entrenadores){
//        System.out.println(entrenador);
//    }
        //La busqueda de parametros (null,null,null) devuelve todos los entrenadores activos
        //Prueba buscarEntrenador por nombre y especialidad juntos
//        List<Entrenador> res1 = eData.buscarEntrenadores("Juan", null, "Atletis");
//        System.out.println("Resultados de la busqueda:");
//        for (Entrenador entrenador : res1) {
//        System.out.println(entrenador);
//    }
        //Prueba buscarEntrenador solo por apellido
        //List<Entrenador> res2 = eData.buscarEntrenadores(null, "L", null);
        //System.out.println("Resultados de la busqueda solo con apellido:");
        //for (Entrenador entrenador : res2) {
        //System.out.println(entrenador);
        //Prueba modificarEntrenador()
//        entrenador.setEstado(true);
//        eData.modificarEntrenador(entrenador);//

//      PRUEBAS CLASEDATA
//
//        ClaseData claseD = new ClaseData();
//        Clase clase = new Clase(e, "Natacion", LocalTime.now(), 20, true);
//        
//        //GUARDAR CLASE
////        claseD.guardarClase(clase);
//
////      LISTAR CLASES
//
//        ArrayList<Clase> clasesActivas = claseD.listarClasesDisponibles();
//           for (Clase clases : clasesActivas) {
//            System.out.println(clases);
//           }
        //  }
//    private static void pruebaClases() {
//        accesoADatos.ClaseData claseData = new accesoADatos.ClaseData();
//        //Entrenador e1 = new Entrenador(2, "12345678", "Juan", "Lucero", "Atletismo", true);
//        //Clase c1 = new Clase(e1, "Atletismo", LocalTime.of(10, 00), 10, true);
//        //claseData.guardarClase(c1);
//        ArrayList<Clase> lista = new ArrayList<Clase>();
//        lista = claseData.listarClasesDisponibles();
//        for (Clase clase : lista) {
//            System.out.println(clase);
//        }
//    }
//}
//    private static void pruebaMembresias() {
//    MembresiasData membresiaD = new MembresiasData();
//    Socio socio = new Socio("34877112","martin","piriz",32,"mpirizdutra@ulp.edu.ar","2664859913");
//    Membresias membresia = new Membresias(socio,3,34,new Date(),new Date(),true);
//    
//    
    }

    private static void pruebaMembresias() {
        // Crear una instancia de MembresiasData
        accesoADatos.MembresiasData membresiasData = new MembresiasData();
        accesoADatos.SocioData socioDat = new accesoADatos.SocioData();
        Socio sc1 = socioDat.buscarSocioPorId(1);
        Date fechaIn = new Date();
        Calendar fechafin = Calendar.getInstance();
        fechafin.setTime(fechaIn);
        fechafin.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println( fechaIn+ "------- "+fechafin.getTime() );
        membresiasData.guardarMembresia(new Membresias(1, sc1, 10, 50.0, fechaIn, fechafin.getTime(), true));

        // Crear un socio de ejemplo
        //Socio socio = new Socio();
        //socio.getIdSocio(); // Asegúrate de que este socio exista en la base de datos
        // Crear una membresía de ejemplo
        //Membresias membresia = new Membresias();
        //membresia.setSocio(socio);
        //membresia.setCantidadPases(10);
        //membresia.setCosto(50.0);
        //membresia.setFechaInicio(new Date());
        //membresia.setFechaFin(new Date(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000))); // 30 días más tarde
        //membresia.setEstado(true);
        // Guardar la membresía en la base de datos
        // Verificar si se guardó correctamente
        /* if (membresia.getIdMembresia() > 0) {
            System.out.println("Membresía guardada con ID: " + membresia.getIdMembresia());
        } else {
            System.out.println("No se pudo guardar la membresía.");
        }*/
    }
}
