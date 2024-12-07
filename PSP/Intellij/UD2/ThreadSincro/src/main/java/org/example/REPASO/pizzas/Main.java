package org.example.REPASO.pizzas;

public class Main {
    public static void main(String[] args) {
        Tray t= new Tray();

        //Se crea cocinero
        Thread cooker = new Thread(new Cooker(t));

        //Se crean 3 repartidores
        Thread deliver1 = new Thread(new Deliver(1,t));
        Thread deliver2 = new Thread(new Deliver(2,t));
        Thread deliver3 = new Thread(new Deliver(3,t));


        deliver1.start();
        deliver2.start();
        deliver3.start();

        cooker.start();


    }
}
