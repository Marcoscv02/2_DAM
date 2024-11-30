package org.example.mailBox;

public class MailBox {
    private String mensaje; //guarda el mensaje compartido entre productor y consumidor
    private boolean disponible = true; //indica si el buffer intermedio está disponible


    synchronized public String consumir () throws InterruptedException {
        //Si el buffer está disponible (lo que significa que no tiene ninguna frase) espera a que haya alguna frase
        while (disponible){
            wait();
        }
        disponible=true;
        notifyAll();
        return this.mensaje;
    }


     synchronized public void producir (String mensaje) throws InterruptedException {
        //Mientras el buffer no este disponible (poque ya tiene una fase) espera
        while (!disponible){
            wait();
        }
        disponible=false;
        notifyAll();
        this.mensaje=mensaje;
    }
}
