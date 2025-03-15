package marcos.Peliculas;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JPAUtil {
    public static final String PERSISTENCE_H2 = "jpa-nuevoPeliculas-h2";
    public static final String PERSISTENCE_MARIADB = "jpa-peliculas-mariaDB";

    private static final Map<String, EntityManagerFactory> instancies = new HashMap<>();

    public JPAUtil() {
    }

    public static boolean  isEntityManagerClosed (String udPersistencia){
        return instancies.containsKey(udPersistencia) || instancies.get(udPersistencia)==null ||
                !instancies.get(udPersistencia).isOpen();
    }

    public static EntityManagerFactory getInstance (String udPersistencia){
        if (isEntityManagerClosed(udPersistencia)){
            synchronized (JPAUtil.class) {
                if (isEntityManagerClosed(udPersistencia)) {
                    instancies.put(udPersistencia, Persistence.createEntityManagerFactory(udPersistencia));

                }
            }
        }
        return instancies.get(udPersistencia);
    }

    public static boolean close(String udPersistencia){
        if (instancies.containsKey(udPersistencia)){
            instancies.get(udPersistencia).close();
            instancies.remove(udPersistencia);
            return true;
        }else {
            System.out.println("No se ha encontrado un EntityManager con ese nombre");
            return false;
        }
    }
}
