package marcos.Vehiculos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class APP {
    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.getInstance(JPAUtil.VEHICULOS_H2);

        EntityManager em = emf.createEntityManager();
    }
}
