package marcos.mapeoJokes;

public class App {
    public static void main(String[] args) {


        var emf = ChisteJPAManager.getEntityManagerFactory(ChisteJPAManager.CHISTES_SQLITE);
        var em= emf.createEntityManager();

        var emf2 = ChisteJPAManager.getEntityManagerFactory(ChisteJPAManager.CHISTES_H2);
        var em2= emf2.createEntityManager();

    }
}
