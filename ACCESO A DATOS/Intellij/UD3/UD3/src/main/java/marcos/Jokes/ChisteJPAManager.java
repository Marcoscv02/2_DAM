package marcos.Jokes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;


public class ChisteJPAManager {

    public static final String CHISTES_H2 = "jpa-biblioteca-h2";
    public static final String CHISTES_POSTGRES = "chistesPostgres";
    public static final String CHISTES_SQLITE = "jpa-jokes-sqlite";


    private static final Map<String, EntityManagerFactory> instancies = new HashMap<>();

    private ChisteJPAManager() {
    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia) {
        return !instancies.containsKey(unidadPersistencia) || instancies.get(unidadPersistencia) == null ||
                !instancies.get(unidadPersistencia).isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia) {
        if (isEntityManagerFactoryClosed(unidadPersistencia)) {
            synchronized (ChisteJPAManager.class) {
                if (isEntityManagerFactoryClosed(unidadPersistencia)) {
                    try {
                        instancies.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));
                    } catch (Exception e) {
                        System.out.println("Erro ó crear a unidade de persistencia " + unidadPersistencia +
                                ": " + e.getMessage());
                    }
                }
            }
        }
        return instancies.get(unidadPersistencia);
    }


    public static void close(String persistenceUnitName) {
        if (instancies.containsKey(persistenceUnitName)) {
            instancies.get(persistenceUnitName).close();
            instancies.remove(persistenceUnitName);
        }
    }

}
