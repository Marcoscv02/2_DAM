package org.example.Teoria.Producer_Consumer;

public class Productor extends Thread {
    public static final String letras = "abcdefghijklmnopqrstuvwxyz"; // Cadena de caracteres a producir.
    private Buffer buffer; // Referencia al buffer compartido.

    // Constructor que recibe el buffer como argumento.
    public Productor(Buffer b) {
        this.buffer = b;
    }

    // Méetodo que ejecuta el hilo del productor.
    public void run() {
        while (true) { // Bucle infinito para producir caracteres continuamente.
            try {
                // Genera un carácter aleatorio de la cadena `letras`.
                char c = letras.charAt((int) (Math.random() * letras.length()));

                // Añade el carácter al buffer.
                buffer.producir(c);
                System.out.println("Depositado el caracter " + c + " en el buffer");

                // Simula un tiempo aleatorio de producción (0-4 segundos).
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
