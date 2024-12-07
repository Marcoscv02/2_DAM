package org.example.REPASO.bakery;

import static java.lang.Thread.sleep;

public class Customer implements Runnable{
    TakeANumber tk= new TakeANumber();
    private int idCliente;

    public Customer(int idCliente, TakeANumber tk) {
        this.idCliente = idCliente;
        this.tk = tk;
    }

    @Override
    public void run() {

        try {
            System.out.println("Cliente "+idCliente+" entra a la tienda");
            sleep((long) (Math.random()*2000+2000));
            tk.producirTicket(idCliente);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
