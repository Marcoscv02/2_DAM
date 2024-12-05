package org.example.bakery;

import static java.lang.Thread.sleep;

public class Baker implements Runnable{
    TakeaNumber tk;

    public Baker(TakeaNumber tk) {
        this.tk = tk;
    }

    @Override
    public void run() {
        while (tk.getNumBaker()<100){
            try {
                sleep((long) (Math.random()*1000));
                tk.consumirNum();
                System.out.println("El panadero está atendiendo al cliente "+tk.getNumBaker());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Panadero ha acabado su turno");
    }
}
