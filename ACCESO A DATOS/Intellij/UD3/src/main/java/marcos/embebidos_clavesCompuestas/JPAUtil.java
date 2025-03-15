package marcos.embebidos_clavesCompuestas;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    public static final String PESISTENCE_H2 = "jpa-embebidos-h2";

    public static EntityManagerFactory instance;

    public JPAUtil(EntityManagerFactory instance) {
        this.instance = instance;
    }

    public static Boolean isEntityManagerClosed(){
        return instance==null || !instance.isOpen();
    }

    public static EntityManagerFactory getInstance (String udPersistencia){
        if (isEntityManagerClosed()){
            synchronized (JPAUtil.class){
                if (isEntityManagerClosed()) {
                    return instance = Persistence.createEntityManagerFactory(udPersistencia);
                }
            }
        }
        System.out.println("There is an instance already open");
        return null;
    }
}
