package marcos.Peliculas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import marcos.Peliculas.model.claves.ClavePeliculaActor;
import marcos.Peliculas.model.claves.PeliculaActor;
import marcos.Peliculas.model.entities.Actor;
import marcos.Peliculas.model.entities.Pelicula;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static EntityManagerFactory emf = JPAUtil.getInstance(JPAUtil.PERSISTENCE_H2);
    public static EntityManager em = emf.createEntityManager();
    public static EntityTransaction transaction = em.getTransaction();

    public static void main(String[] args) {
        //createInitialData();

        //Consultas
        System.out.println("___Películas con duracion mayor a 120 minutos___");
        Query q = em.createQuery("SELECT p FROM Pelicula p WHERE p.duracion >= :duracion", Pelicula.class);
        q.setParameter("duracion",120);
        List<Pelicula> resultQuery1 = q.getResultList();
        for (Pelicula p:resultQuery1)
            System.out.println(p+"\n");


        System.out.println("___Películas de género 'Drama'___");
        Query a = em.createQuery("SELECT p FROM Pelicula p WHERE p.xenero = :xenero", Pelicula.class);
        a.setParameter("xenero", "Drama");
        List<Pelicula> resultQuery2 = a.getResultList();
        for (Pelicula p: resultQuery2)
            System.out.println(p+"\n");


        System.out.println("___Películas de mas de 120 minutos con genero 'Drama'___");
        Query b = em.createQuery("SELECT p FROM Pelicula p WHERE p.xenero = :xenero AND p.duracion >= :duracion", Pelicula.class);
        b.setParameter("xenero", "Drama");
        b.setParameter("duracion", 120);
        List<Pelicula> resultQuery3 = b.getResultList();
        for (Pelicula p: resultQuery3)
            System.out.println(p+"\n");


        System.out.println("___Peliculas en las que sale Javier Bardem___");
        Query c = em.createQuery(
                "SELECT p FROM Pelicula p " +
                        "JOIN p.personaxes pp " +      // Relación Pelicula -> PeliculaPersonaxe
                        "JOIN pp.actor a " +          // Relación PeliculaPersonaxe -> Actor
                        "WHERE a.nome = :nome", Pelicula.class);
        c.setParameter("nome", "Javier Bardem");
        List<Pelicula> resultQuery4=c.getResultList();
        for (Pelicula p:resultQuery4)
            System.out.println(p+"\n");


        System.out.println("___Solicitar nombre d una pelicula por id___");
        Query d = em.createQuery("SELECT p.nome FROM Pelicula p WHERE id = :id", String.class);
        d.setParameter("id",4);
        String result = d.getSingleResult().toString();
        System.out.println(result);


        System.out.println("___Solicitar todas las peliculas en las que Ricardo Darín fue protagonista");
        Query e = em.createQuery(
                "SELECT p FROM Pelicula p " +
                        "JOIN p.personaxes pp " +   //Accediendo a PeliculaPersonaxe
                        "JOIN pp.actor a " +        //Accediendo a Actor
                        "WHERE pp.importancia = :importancia " +
                        "AND  a.nome = :nome"
        , Pelicula.class);
        e.setParameter("importancia", "protagonista");
        e.setParameter("nome", "Ricardo Darín");
        List<Pelicula>resultQuery6 = e.getResultList();
        for (Pelicula p: resultQuery6)
            System.out.println(p+"\n");

    }


    /**
     * Método estático y de tipo void encargado de generar valores iniciales en la base de datos
     */
    public static void createInitialData(){
        try {
            transaction.begin();

            // ===== 1. Crear Actores =====
            Actor actor1 = new Actor(
                    "Ivana Baquero",
                    "Femenino",
                    LocalDate.of(1994,6,11),
                    "Actriz conocida por 'El laberinto del fauno'",
                    "El laberinto del fauno, The Shannara Chronicles",
                    "España"
            );

            Actor actor2 = new Actor(
                    "Javier Bardem",
                    "Masculino",
                    LocalDate.of(1969,3,1),
                    "Ganador de un Óscar por 'No es país para viejos'",
                    "Los lunes al sol, Biutiful",
                    "España"
            );

            Actor actor3 = new Actor(
                    "Penélope Cruz",
                    "Femenino",
                    LocalDate.of(1974, 4, 28),
                    "Ganadora de un Óscar por 'Vicky Cristina Barcelona'",
                    "Volver, Todo sobre mi madre",
                    "España"
            );

            Actor actor4 = new Actor(
                    "Willem Dafoe",
                    "Masculino",
                    LocalDate.of(1955, 7, 22),
                    "Cuatro veces nominado al Óscar",
                    "El faro, Spider-Man",
                    "Estados Unidos"
            );

            Actor actor5 = new Actor(
                    "Marion Cotillard",
                    "Femenino",
                    LocalDate.of(1975, 9, 30),
                    "Ganadora del Óscar por 'La Vie en Rose'",
                    "Inception, Dos días una noche",
                    "Francia"
            );

            Actor actor6 = new Actor(
                    "Ricardo Darín",
                    "Masculino",
                    LocalDate.of(1957, 1, 16),
                    "Premio Goya al Mejor Actor",
                    "El secreto de sus ojos, Relatos salvajes",
                    "Argentina"
            );

            Actor actor7 = new Actor(
                    "Lupita Nyong'o",
                    "Femenino",
                    LocalDate.of(1983, 3, 1),
                    "Ganadora del Óscar por '12 años de esclavitud'",
                    "Black Panther, Us",
                    "Kenia"
            );

            // Persistir actores
            em.persist(actor1);
            em.persist(actor2);
            em.persist(actor3);
            em.persist(actor4);
            em.persist(actor5);
            em.persist(actor6);
            em.persist(actor7);


            // ===== 2. Crear Películas =====
            Pelicula pelicula1 = new Pelicula(
                    "El laberinto del fauno",
                    "Fantasía oscura",
                    "México",
                    LocalDate.of(2006, 10, 11),
                    118
            );

            Pelicula pelicula2 = new Pelicula(
                    "Los lunes al sol",
                    "Drama social",
                    "España",
                    LocalDate.of(2002, 9, 27),
                    113
            );

            Pelicula pelicula3 = new Pelicula(
                    "Volver",
                    "Drama",
                    "España",
                    LocalDate.of(2006, 3, 17),
                    121
            );

            Pelicula pelicula4 = new Pelicula(
                    "El faro",
                    "Psicológico",
                    "Estados Unidos",
                    LocalDate.of(2019, 10, 18),
                    109
            );

            Pelicula pelicula5 = new Pelicula(
                    "La Vie en Rose",
                    "Biográfico",
                    "Francia",
                    LocalDate.of(2007, 2, 14),
                    140
            );

            Pelicula pelicula6 = new Pelicula(
                    "El secreto de sus ojos",
                    "Thriller",
                    "Argentina",
                    LocalDate.of(2009, 8, 13),
                    129
            );

            Pelicula pelicula7 = new Pelicula(
                    "Black Panther",
                    "Superhéroes",
                    "Estados Unidos",
                    LocalDate.of(2018, 2, 16),
                    134
            );


            // Persistir películas
            em.persist(pelicula1);
            em.persist(pelicula2);
            em.persist(pelicula3);
            em.persist(pelicula4);
            em.persist(pelicula5);
            em.persist(pelicula6);
            em.persist(pelicula7);


            // ===== 3. Crear relaciones =====
            PeliculaActor relacion1 = new PeliculaActor(
                    new ClavePeliculaActor(pelicula1.getIdPelicula(), actor1.getIdActor()),
                    "Ofelia",  // Papel real de Ivana Baquero
                    "protagonista",
                    pelicula1,
                    actor1
            );

            PeliculaActor relacion2 = new PeliculaActor(
                    new ClavePeliculaActor(pelicula2.getIdPelicula(), actor2.getIdActor()),
                    "Santa",  // Papel real de Javier Bardem
                    "protagonista",
                    pelicula2,
                    actor2
            );
            PeliculaActor relacion3 = new PeliculaActor(
                    new ClavePeliculaActor(pelicula3.getIdPelicula(), actor3.getIdActor()),
                    "Raimunda",
                    "protagonista",
                    pelicula3,
                    actor3
            );

            PeliculaActor relacion4 = new PeliculaActor(
                    new ClavePeliculaActor(pelicula4.getIdPelicula(), actor4.getIdActor()),
                    "Thomas Wake",
                    "protagonista",
                    pelicula4,
                    actor4
            );

            PeliculaActor relacion5 = new PeliculaActor(
                    new ClavePeliculaActor(pelicula5.getIdPelicula(), actor5.getIdActor()),
                    "Édith Piaf",
                    "protagonista",
                    pelicula5,
                    actor5
            );

            PeliculaActor relacion6 = new PeliculaActor(
                    new ClavePeliculaActor(pelicula6.getIdPelicula(), actor6.getIdActor()),
                    "Benjamín Espósito",
                    "protagonista",
                    pelicula6,
                    actor6
            );

            PeliculaActor relacion7 = new PeliculaActor(
                    new ClavePeliculaActor(pelicula7.getIdPelicula(), actor7.getIdActor()),
                    "Nakia",
                    "secundario",
                    pelicula7,
                    actor7
            );

            // Persistir relaciones
            em.persist(relacion1);
            em.persist(relacion2);
            em.persist(relacion3);
            em.persist(relacion4);
            em.persist(relacion5);
            em.persist(relacion6);
            em.persist(relacion7);

            transaction.commit();

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
