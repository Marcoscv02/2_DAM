package Java.Boletines.boletin0101.ClasificacionEjemplo;

public class AlumnoDaoFactory {

    public static final Dao<Alumno, String> getAlumnoDao(String tipo) {

        if(tipo.equals("file")) {
            return new AlumnoDaoFromFile("alumnos.dat");
        } else if(tipo.equals("memory")) {
            return new AlumnoDao();
        }

        return null;
    }
}