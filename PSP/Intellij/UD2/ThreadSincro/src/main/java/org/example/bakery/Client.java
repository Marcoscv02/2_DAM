package org.example.bakery;

import static java.lang.Thread.sleep;

public class Client implements Runnable{
    int idCliente;
    TakeaNumber tk;

    public Client(int idCliente, TakeaNumber tk) {
        this.idCliente = idCliente;
        this.tk = tk;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente "+idCliente+ " ha llegado a la tienda");
            sleep((long) ((Math.random()*2000)+2000));
            tk.sacarNumero(idCliente);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
