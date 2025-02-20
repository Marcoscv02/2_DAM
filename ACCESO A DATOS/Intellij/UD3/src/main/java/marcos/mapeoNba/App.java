package marcos.mapeoNba;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf= JPAUtilManager.getInstance(JPAUtilManager.PERSISTENCIA_H2);

        EntityManager em= emf.createEntityManager();
    }
}
