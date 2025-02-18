package marcos.videojuegos;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtilManager {
    public static final String PERSISTENCIA_H2="jpa-videoJuegos-h2";

    private static EntityManagerFactory instance;

    public JPAUtilManager() {
    }

    public static boolean isPersistenciaClosed (){
        return instance==null||!instance.isOpen();
    }

    public static EntityManagerFactory getInstance(String udPersistencia){
        if (isPersistenciaClosed()){
            synchronized (JPAUtilManager.class){
                if (isPersistenciaClosed()){
                    return instance= Persistence.createEntityManagerFactory(udPersistencia);
                }
            }
        }
        return null;
    }
}
