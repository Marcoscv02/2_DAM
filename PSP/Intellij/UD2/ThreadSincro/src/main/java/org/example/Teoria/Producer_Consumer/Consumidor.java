package org.example.Teoria.Producer_Consumer;

public class Consumidor extends Thread{
    private Buffer buffer;

    public Consumidor (Buffer b){
        this.buffer=b;
    }

    public void run(){
        while (true){
            try {
                char c= this.buffer.consumir();
                System.out.println("Recojido el caracter "+c+ " del buffer");
                sleep((int) (Math.random()*4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
