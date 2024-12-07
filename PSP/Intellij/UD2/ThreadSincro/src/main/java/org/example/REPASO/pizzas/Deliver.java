package org.example.REPASO.pizzas;

import static java.lang.Thread.sleep;

//Consumidor
public class Deliver implements Runnable{
    public static final int NUMTOTAL=100;
    Tray t;
    Pizza p;
    int idDeliver;

    public Deliver(int idDeliver,Tray t) {
        this.idDeliver=idDeliver;
        this.t = t;
    }

    @Override
    public void run() {
        while (t.getTotalPizzas()<=NUMTOTAL){
            try {
                p = t.recogerPizza();
                System.out.println("Repartidor "+idDeliver+" ha recogido y entregado la pizza: "+p.getId());
                sleep((long) ((Math.random()*1000)+1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
