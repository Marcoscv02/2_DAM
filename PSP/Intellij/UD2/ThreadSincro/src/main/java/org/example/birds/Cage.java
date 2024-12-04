package org.example.birds;

public class Cage {
    private  int birdsOnPlato; //cuenta el número de pájaros en el plato
    private boolean columpioAvaible=true; //define si el columpio está disponible


    /**
     * Pájaro empieza a comer
     * @param idBird
     * @throws InterruptedException
     */
    synchronized public void startEating (int idBird) throws InterruptedException {
        while (birdsOnPlato>=3){
            wait();
        }
        birdsOnPlato++;
        System.out.println("canario "+idBird+" empieza a comer");
    }

    /**
     * Pájaro acaba de comer
     * @param idBird
     */
    synchronized public void stopEating (int idBird){
        birdsOnPlato--;
        System.out.println("canario "+idBird+" acaba de comer");
        notifyAll();
    }

    /**
     * Pájaro empieza a columpiarse
     * @param idBird
     * @throws InterruptedException
     */
    synchronized public void startColumpio (int idBird) throws InterruptedException {
        while (columpioAvaible == false){
            wait();
        }
        columpioAvaible=false;
        System.out.println("canario "+idBird+" empieza a columpiarse");
    }

    /**
     * Pájaro acaba de columpiarse
     * @param idBird
     */
    synchronized public void  stopColumpio (int idBird){
        columpioAvaible=true;
        System.out.println("canario "+idBird+" acaba de columpiarse");
        notifyAll();
    }
}
