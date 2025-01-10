package marcos.Biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    public static EntityManagerUtil instance;
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY=
            Persistence.createEntityManagerFactory("jpa-biblioteca-h2");


        private EntityManagerUtil() {
            EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static EntityManagerUtil getInstance(){
        if (instance==null){
            instance= new EntityManagerUtil();
        }else {
            System.out.println("Ya existe una instancia de esta clase");
        }
        return instance;
    }
}
