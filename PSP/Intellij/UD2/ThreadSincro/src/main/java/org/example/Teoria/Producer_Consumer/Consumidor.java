package org.example.Teoria.Producer_Consumer;

public class Consumidor extends Thread {
    private Buffer buffer; // Referencia al buffer compartido.

    // Constructor que recibe el buffer como argumento.
    public Consumidor(Buffer b) {
        this.buffer = b;
    }

    // Método que ejecuta el hilo del consumidor.
    public void run() {
        while (true) { // Bucle infinito para consumir caracteres continuamente.
            try {
                // Consume un carácter del buffer.
                char c = this.buffer.consumir();
                System.out.println("Recojido el caracter " + c + " del buffer");

                // Simula un tiempo aleatorio de procesamiento (0-4 segundos).
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
