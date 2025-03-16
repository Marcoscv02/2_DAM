package marcos.Vehiculos;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;

public class JPAUtil {
    public static final String VEHICULOS_H2 = "jpa-vehiculos-h2";
    public static final String VEHICULOS_POSTGRESS= "";

    private static HashMap<String, EntityManagerFactory> instances = new HashMap<>();

    public JPAUtil(HashMap<String, EntityManagerFactory> instances) {
        this.instances = instances;
    }

    private static boolean isEntityManagerClose(String udPersistencia){
        return !instances.containsKey(udPersistencia)||instances.get(udPersistencia)==null ||
                !instances.get(udPersistencia).isOpen();
    }

    public static EntityManagerFactory getInstance (String udPersistencia){
        if (isEntityManagerClose(udPersistencia)){
            synchronized (JPAUtil.class){
                if (isEntityManagerClose(udPersistencia)){

                    instances.put(udPersistencia, Persistence.createEntityManagerFactory(udPersistencia));
                }
            }
        }
        return instances.get(udPersistencia);
    }
}
