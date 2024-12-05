package org.example.bakery;

import static java.lang.Thread.sleep;

public class Baker implements Runnable{
    TakeaNumber tk;

    public Baker(TakeaNumber tk) {
        this.tk = tk;
    }

    @Override
    public void run() {
        while (tk.getNumeroCliente()<101){
            try {
                int cliente= tk.consumirNum();
                System.out.println("El panadero está atendiendo al cliente "+cliente);
                sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
