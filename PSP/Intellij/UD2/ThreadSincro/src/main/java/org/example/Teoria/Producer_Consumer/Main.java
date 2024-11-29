package org.example.Teoria.Producer_Consumer;

public class Main {
    public static void main(String[] args) {
        Buffer b= new Buffer(10);
        Productor p= new Productor(b);
        Consumidor c= new Consumidor(b);

        c.start();
        p.start();


    }

}
