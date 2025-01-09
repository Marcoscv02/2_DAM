package org.example.EjercPrueba;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.EjercPrueba.entities.Pelicula;


public class Main {
    public static void main(String[] args) {
        Pelicula pelicula= new Pelicula("El Padrino", (short) 1972);
        Pelicula pelicula2= new Pelicula("Gladiator", (short) 2000);
        Pelicula pelicula3= new Pelicula("Titanic", (short) 1992);

        var emf = Persistence.createEntityManagerFactory("jpa-hibernate-h2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(pelicula);
        em.persist(pelicula2);
        em.persist(pelicula3);

        em.getTransaction().commit();
    }
}