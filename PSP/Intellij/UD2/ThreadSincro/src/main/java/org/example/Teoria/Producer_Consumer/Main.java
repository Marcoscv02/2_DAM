package org.example.Teoria.Producer_Consumer;

public class Main {
    public static void main(String[] args) {
        // Crea un buffer de tamaño 10.
        Buffer b = new Buffer(10);

        // Crea un productor y un consumidor que comparten el buffer.
        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);

        // Inicia los hilos del productor y consumidor.
        c.start();
        p.start();
    }
}
