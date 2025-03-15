package marcos.playlist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    public static final String PERSISTENCE_H2 = "jpa-playlist-h2";

    private static EntityManagerFactory instance= null;

    public JPAUtil() {
    }

    public static boolean isEntityManagerclosed (){
        return instance!=null||instance.isOpen();
    }

    public static EntityManagerFactory getInstance (String udPesistencia){
        if (isEntityManagerclosed()){
            synchronized (JPAUtil.class){
                if (isEntityManagerclosed()){
                    instance= Persistence.createEntityManagerFactory(udPesistencia);
                }
            }
        }
        System.out.println("Ya hay una instancia abierta de EntityManager");
        return null;
    }
}
