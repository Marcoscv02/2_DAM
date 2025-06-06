package org.example.bakery;

public class TakeaNumber {
    private int numTicket = 1;
    private int numBaker = 1;


    public TakeaNumber() {
    }

    synchronized public int sacarNumero(int idCliente) throws InterruptedException {
        System.out.println("Cliente "+idCliente+ " toma ticket "+ numTicket);
        notifyAll();
        numTicket++;
        return numTicket;
    }
    synchronized  public int  consumirNum() throws InterruptedException {
        while (numTicket==1){
            System.out.println("Empleado en espera (no hay clientes a los que atender)");
            wait();
        }
        numBaker++;
        notifyAll();
        return numBaker;
    }

    public int getNumBaker (){ return numBaker;}

}
