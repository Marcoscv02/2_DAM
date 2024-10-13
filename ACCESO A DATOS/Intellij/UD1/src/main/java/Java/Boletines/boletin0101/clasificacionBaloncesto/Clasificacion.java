package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Clasificacion implements Serializable {
    //Variables de la clase
    private Set<Equipo> equipos;
    String competicion;

    public Clasificacion() {
    }

    //Constructor con nombre de competicion
    public Clasificacion(String competicion) {
        this.equipos =  new  TreeSet<>();
        this.competicion = competicion;
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public String getCompeticion() {
        return competicion;
    }

    public Equipo addEquipo(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce nombre del equipo");
        String eName= sc.nextLine();
        System.out.println("Introduce la ciudad a la que pertenece el equipo");
        String eCity= sc.nextLine();
        System.out.println("Introduce número de victorias del equipo");
        int numVic= sc.nextInt();
        System.out.println("introduce número de derrotas del equipo");
        int numDerr= sc.nextInt();
        System.out.println("Introduce puntos a favor");
        int puntFavor=sc.nextInt();
        System.out.println("Introduce los puntos en contra");
        int puntContra=sc.nextInt();

        Equipo equipo= new Equipo(eName,eCity,numVic,numDerr,puntFavor,puntContra);
        return equipo;
    }

    public void removeEquipo(String id){
        for (Equipo e:equipos){
            if (e.getNombre().equalsIgnoreCase(id)){
                equipos.remove(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Clasificacion{" +
                "equipos=" + equipos +
                ", competicion='" + competicion + '\'' +
                '}';
    }
}
