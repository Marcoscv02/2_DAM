package org.example.REPASO.pizzas;

import java.text.DecimalFormat;

import static java.lang.Thread.sleep;

//Productor
public class Cooker implements Runnable{
    public static final int NUMTOTAL = 100;
    Pizza p= new Pizza();
    int idPizza=10;
    Tray t;
    DecimalFormat df= new DecimalFormat("#.00");

    public Cooker(Tray t) {
        this.t = t;
    }

    @Override
    public void run() {

        while (t.getTotalPizzas()<=NUMTOTAL){
            try {
                p.setPrecio((Math.random()*40)+10);
                p.setId(idPizza);
                t.cocinarPizza(p);

                idPizza++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
