package Test;

import accesoADatos.Conexion;
import accesoADatos.EntrenadorData;
import entidades.Socio;
import entidades.Entrenador;
import java.util.ArrayList;
import entidades.Clase;
import java.time.LocalTime;
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
        pruebaClases();
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
        //Entrenador e = new Entrenador("12345678", "Juan", "Lucero", "Atletismo");
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
    }

    private static void pruebaClases() {
        accesoADatos.ClaseData claseData = new accesoADatos.ClaseData();
        //Entrenador e1 = new Entrenador(2, "12345678", "Juan", "Lucero", "Atletismo", true);
        //Clase c1 = new Clase(e1, "Atletismo", LocalTime.of(10, 00), 10, true);
        //claseData.guardarClase(c1);
        ArrayList<Clase> lista = new ArrayList<Clase>();
        lista = claseData.listarClasesDisponibles();
        for (Clase clase : lista) {
            System.out.println(clase);
        }
    }

}
