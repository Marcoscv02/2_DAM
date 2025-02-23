package marcos.embebidos_clavesCompuestas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf= JPAUtil.getInstance(JPAUtil.PESISTENCE_H2);
        EntityManager em= emf.createEntityManager();
    }
}
