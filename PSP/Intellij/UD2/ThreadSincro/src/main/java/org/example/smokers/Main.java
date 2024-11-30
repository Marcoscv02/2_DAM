package org.example.smokers;

public class Main {
    public static void main(String[] args) {
        BufferTobacco mesa = new BufferTobacco(); // Instancia del buffer compartido.

        // Crear hilos para el tabaquero y los fumadores.
        Thread tabaquero = new Thread(new Tobacconist(mesa));
        Thread fumador1 = new Thread(new Smoker("fumador1",mesa, "tabaco")); // Fumador que tiene tabaco.
        Thread fumador2 = new Thread(new Smoker("fumador2",mesa, "papel")); // Fumador que tiene papel.
        Thread fumador3 = new Thread(new Smoker("fumador3",mesa, "cerilla")); // Fumador que tiene cerillas.

        // Iniciar los hilos.
        tabaquero.start();
        fumador1.start();
        fumador2.start();
        fumador3.start();
    }
}
