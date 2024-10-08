package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Clasificacion implements Serializable {
    //Variables de la clase
    private Set<Equipo> equipos;
    String competicion;

    //Constructor por defecto
    public Clasificacion() {
        this.equipos =  new TreeSet<>();
        this.competicion = "Liga ACB";
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

    public void addequipo(Equipo equipo){
        equipos.add(equipo);
    }

    public void removeEquipo(Equipo equipo){
        equipos.remove(equipo);
    }

    @Override
    public String toString() {
        return "Clasificacion{" +
                "equipos=" + equipos +
                ", competicion='" + competicion + '\'' +
                '}';
    }
}
