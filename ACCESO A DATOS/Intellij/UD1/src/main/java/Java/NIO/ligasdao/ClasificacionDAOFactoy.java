package Java.NIO.ligasdao;

public class ClasificacionDAOFactoy {

    public static Dao<Clasificacion, String> getClasificacionDAO(String tipo) {
        if (tipo.equalsIgnoreCase("file")) {
            return null;
        } else {
            return null;
        }
    }

}
