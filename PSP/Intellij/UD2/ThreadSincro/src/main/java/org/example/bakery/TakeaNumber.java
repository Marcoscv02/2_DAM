package org.example.bakery;

public class TakeaNumber {
    private boolean disponible= true;
    private int numero;


    public TakeaNumber() {
    }

    synchronized public int sacarNumero() throws InterruptedException {
        while (disponible==false){
            wait();
        }
        disponible=false;
        numero++;
        notifyAll();
        return numero;
    }
    synchronized  public int  consumirNum() throws InterruptedException {
        while (disponible==true){
            wait();
        }
        disponible=true;
        notifyAll();
        return numero;
    }

    public int getNumeroCliente (){
        return numero;
    }
}
