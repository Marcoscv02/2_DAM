package org.example.REPASO.bakery;

public class TakeANumber {
    public static final int NUMTOTAL=100;
    private int numTicket=1;
    private int numCliente=0;

    synchronized public int producirTicket(int idCliente) throws InterruptedException {
        while (numTicket==NUMTOTAL) {
            wait();
        }
        System.out.println("Cliente "+idCliente+" toma el ticket "+numTicket);
        numTicket++;
        notifyAll();
        return numTicket;
    }

    synchronized public int consumirTicket() throws InterruptedException {
        while (numTicket==1){
            wait();
            System.out.println("Panadero esperando, todavía no hay clientes");
        }
        System.out.println("Panadero atendiendo a cliente "+numCliente);
        numCliente++;
        notifyAll();
        return numCliente;
    }

    public int getNumCliente(){
        return numCliente;
    }
}
