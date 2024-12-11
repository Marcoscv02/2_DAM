package org.example.REPASO.bird;

public class Jaula {
    private boolean columpioLibre=true;
    private int canariosPlato=0;

    synchronized public void startComer(int id) throws InterruptedException {
        while (canariosPlato>=3){
            wait();
        }
        canariosPlato++;
        System.out.println("Canario "+id+" empieza a comer");
        notifyAll();
    }
    public void stopComer(int id){
        canariosPlato --;
        System.out.println("Canario "+id+" acaba de comer");
    }
    synchronized public void startColumpio(int id) throws InterruptedException {
        while (columpioLibre!=true){
            System.out.println("Canario "+id+" esperando para columpìarse");
            wait();
        }
        columpioLibre=false;
        System.out.println("canario "+id+" empieza a columpiarse");
    }
    public void stopColumpio(int id){
        columpioLibre=true;
        System.out.println("canario "+id+" acaba de columpiarse");
    }
}
