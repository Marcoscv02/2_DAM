package org.example.Teoria.Producer_Consumer;

public class Buffer {
    private char[] buffer; // Array que actúa como el buffer compartido.
    private int next; // Índice del próximo elemento a leer/escribir.
    private boolean vacia; // Indica si el buffer está vacío.
    private boolean lleno; // Indica si el buffer está lleno.

    // Constructor que inicializa el buffer con un tamaño específico.
    public Buffer(int tamanio) {
        this.buffer = new char[tamanio];
        this.next = 0;
        this.vacia = true;
        this.lleno = false;
    }

    // Metodo sincronizado para consumir un carácter del buffer.
    public synchronized char consumir() {
        // Si el buffer está vacío, espera a que el productor notifique.
        while (this.vacia) {
            try {
                wait(); // Libera el bloqueo hasta que otro hilo llame a notify().
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Reduce el índice del buffer al consumir un carácter.
        next--;
        this.lleno = false; // Marca el buffer como no lleno.

        // Si no hay más elementos, marca el buffer como vacío.
        if (next == 0) {
            this.vacia = true;
        }

        notifyAll(); // Notifica a otros hilos (como el productor) para que actúen.
        return this.buffer[this.next]; // Devuelve el carácter consumido.
    }

    // Metodo sincronizado para producir un carácter y añadirlo al buffer.
    public synchronized void producir(char c) {
        // Si el buffer está lleno, espera a que el consumidor notifique.
        while (this.lleno) {
            try {
                wait(); // Libera el bloqueo hasta que otro hilo llame a notify().
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Inserta el carácter en el buffer y avanza el índice.
        buffer[next] = c;
        next++;

        this.vacia = false; // Marca el buffer como no vacío.

        // Si el índice alcanza el tamaño del buffer, se marca como lleno.
        if (next == this.buffer.length) {
            this.lleno = true;
        }

        notifyAll(); // Notifica a otros hilos (como el consumidor) para que actúen.
    }
}
