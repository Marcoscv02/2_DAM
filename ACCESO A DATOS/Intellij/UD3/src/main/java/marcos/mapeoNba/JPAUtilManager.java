package marcos.mapeoNba;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtilManager {
    public static final String PERSISTENCIA_H2= "jpa-equipos-h2";

    private static EntityManagerFactory instance;

    public JPAUtilManager() {
    }

    private static boolean isJPAManagerUtilClosed(){
        return instance==null||!instance.isOpen();
    }

    public static EntityManagerFactory getInstance(String udPersistencia) {
        if(isJPAManagerUtilClosed()){
            synchronized (JPAUtilManager.class){
                if(isJPAManagerUtilClosed()){
                    instance= Persistence.createEntityManagerFactory(udPersistencia);
                }
            }
        }

        return instance;
    }
}
