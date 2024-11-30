package org.example.mailBox;

public class Consumer extends Thread{
    private MailBox mailBox;

    public Consumer (MailBox mailBox){
        this.mailBox=mailBox;
    }

    public void run(){
        while (true){
            try {
                String mensaje= mailBox.consumir();
                System.out.println("Se recibe: "+mensaje);
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
