package Test;

import entidades.Socio;
import entidades.Entrenador;
import java.util.ArrayList;
import entidades.Clase;
import java.time.LocalTime;
/**
 *
 * @author Nicolas
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Martin Pruebas SocioData
        pruebasSocios();
        //pruebaClases();
    }
    
    public static void pruebasSocios(){

        accesoADatos.SocioData socioDat=new accesoADatos.SocioData();
        //guardarSocio
        socioDat.guardarSocio(new Socio("34877112","martin","piriz",32,"mpirizdutra@ulp.edu.ar","2664859913"));
        socioDat.guardarSocio(new Socio("18762864","Walter","piriz",32,"wepo56@gmail.com","2664855569"));
        socioDat.guardarSocio(new Socio("52909515","Silvia","Dutra",32,"dialviacaetano63@gmail.com","2664761074"));
        socioDat.guardarSocio(new Socio("28173863","Carlos","Ferrando",44,"cferrando2015@gmail.com","2664235019"));
        
        socioDat.listarSocio();
        ArrayList<Socio> lista=new ArrayList<Socio>();
        lista=socioDat.listarSocio();
        for (Socio socio : lista) {
            System.out.println(socio);
        }
       
        
        
        
        
        
    }

    private static void pruebaClases() {
        accesoADatos.ClaseData claseData = new accesoADatos.ClaseData();
        Entrenador e1 = new Entrenador(1,"23456987", "Juan Pablo", "Robledo", "Zumba", true);
        Clase c1 = new Clase(e1,"Zumba", LocalTime.of(17, 00), 20, true);
        claseData.guardarClase(c1);
      //  claseData.clasesDisponibles()
    }
    
    
    
    
}
