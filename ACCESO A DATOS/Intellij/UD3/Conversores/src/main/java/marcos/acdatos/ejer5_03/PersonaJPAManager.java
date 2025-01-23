package marcos.acdatos.ejer5_03;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaJPAManager {
    public static final String PERSONA_H2="database-converters-h2";

    private static EntityManagerFactory instance;

    public PersonaJPAManager() {
    }

    private static boolean isEntityManagerFactoryClosed (){
        return instance == null || !instance.isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory (String unidadPersistencia){
        if (isEntityManagerFactoryClosed()){
            synchronized (PersonaJPAManager.class){
                if (isEntityManagerFactoryClosed()){
                     instance= Persistence.createEntityManagerFactory(unidadPersistencia);
                    return instance;
                }
                else System.out.println("Ya hay una instancia de EntityManagerFactory");
            }
        }
        return null;
    }

    public static void close(){
        instance.close();
    }

}
