package marcos.acdatos.ejer5_03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import marcos.acdatos.ejer5_03.model.Persona;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = PersonaJPAManager.getEntityManagerFactory(PersonaJPAManager.PERSONA_H2);

        EntityManager em= emf.createEntityManager();

    }
}