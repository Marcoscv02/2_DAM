package marcos.clavesCompartidas;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtilManager {
    public static final String PERSISTENCIA_CAVES = "jpa-clavesCompartidas-h2";

    private static EntityManagerFactory instance;

    public static Boolean isEntityManagerClosed(){
        return instance==null || !instance.isOpen() ;
    }

    public static EntityManagerFactory getInstance (String UD_PERSISTENCIA){
        if (isEntityManagerClosed()){
            synchronized (JPAUtilManager.class){
                if (isEntityManagerClosed()){
                    instance = Persistence.createEntityManagerFactory(UD_PERSISTENCIA);
                }
            }
        }
        return instance;
    }
}
