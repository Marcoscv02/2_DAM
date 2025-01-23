package marcos.ad;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAManagerUtil {
    public static final String UNIDAD_PERSISTENCIA="biblioteca-hibernate-h2";

    public static EntityManagerFactory instance;

    public static boolean isentityManagerClosed (){
        if (instance==null||!instance.isOpen()){
            return true;
        }

        return false;
    }

    public static EntityManagerFactory getInstance(String udPersistencia){
        if (isentityManagerClosed()){
            synchronized (JPAManagerUtil.class){
                if (isentityManagerClosed()){
                    instance= Persistence.createEntityManagerFactory(udPersistencia);
                }
            }
        }
        return null;
    }
}
