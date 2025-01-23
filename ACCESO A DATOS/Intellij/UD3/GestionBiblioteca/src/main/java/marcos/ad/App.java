package marcos.ad;

import marcos.ad.model.Book;

import java.util.Calendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        var emf= JPAManagerUtil.getInstance(JPAManagerUtil.UNIDAD_PERSISTENCIA);
        var em=emf.createEntityManager();

        Calendar c= Calendar.getInstance();
        c.set(1967,Calendar.FEBRUARY,1);
        Book b= new Book(" Diarios Completos","Sylvia Plath","625234567254",c);

        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();

    }
}