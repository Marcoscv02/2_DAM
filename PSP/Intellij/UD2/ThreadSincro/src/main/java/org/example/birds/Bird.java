package org.example.birds;

import static java.lang.Thread.sleep;

public class Bird implements Runnable{
    private int idBird;
    Cage cage= new Cage();


    public Bird(int idBird, Cage cage) {
        this.idBird = idBird;
        this.cage = cage;
    }

    /**
     * Llama a inicio de comer y espera<br/>
     *  para comer y llama a inicio de columpio<br/>
     *  termina columpio
     */
    @Override
    public void run() {
        while (true){
            try {
                cage.startEating(idBird);
                sleep((long) ((Math.random()*500)+500));
                cage.stopEating(idBird);

                cage.startColumpio(idBird);
                sleep((long) ((Math.random()*1500)+500));
                cage.stopColumpio(idBird);
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
