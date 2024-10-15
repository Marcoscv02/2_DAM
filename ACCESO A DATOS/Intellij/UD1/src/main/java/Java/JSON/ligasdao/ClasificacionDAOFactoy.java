package Java.JSON.ligasdao;

public class ClasificacionDAOFactoy {

    public static Dao<Clasificacion, String> getClasificacionDAO(String tipo) {
        if (tipo.equalsIgnoreCase("file")) {
            //return ClasificacionFileDAO.getInstance();
        } else {
            return null;
        }
        return null;
    }

}
