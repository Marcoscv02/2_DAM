package org.example.REPASO.bakery;

import static java.lang.Thread.sleep;

public class Clerk implements Runnable{
    public static final int NUMTOTAL=100;
    TakeANumber tk= new TakeANumber();

    public Clerk(TakeANumber tk) {
        this.tk = tk;
    }

    @Override
    public void run() {
        while (tk.getNumCliente()<=NUMTOTAL){
            try {
                tk.consumirTicket();
                sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("El panadero ha acabado su turno");
    }
}
