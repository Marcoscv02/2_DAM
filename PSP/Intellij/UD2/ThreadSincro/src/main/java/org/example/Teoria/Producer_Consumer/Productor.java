package org.example.Teoria.Producer_Consumer;

public class Productor extends Thread{
    public static final String letras="abcdefghijklmnopqrstuvwxyz";
    private Buffer buffer;

    public Productor (Buffer b){
        this.buffer=b;
    }

    public void run(){
        while (true){
            try {
                char c= letras.charAt((int) (Math.random()*letras.length()));
                buffer.producir(c);
                System.out.println("Depositado el caracter "+c+ " del buffer");
                sleep((int) (Math.random()*4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
