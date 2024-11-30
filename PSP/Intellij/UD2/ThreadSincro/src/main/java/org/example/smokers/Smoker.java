package org.example.smokers;

public class Smoker implements Runnable {
    private final String nombre;
    private final String ingredienteFijo; // Ingrediente propio del fumador (siempre lo tiene).
    private final BufferTobacco bfTobacco; // Referencia al buffer compartido (mesa).

    // Constructor que recibe el buffer compartido y el ingrediente fijo del fumador.
    public Smoker(String nombre, BufferTobacco bfTobacco, String ingredienteFijo) {
        this.nombre = nombre;
        this.bfTobacco = bfTobacco;
        this.ingredienteFijo = ingredienteFijo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Espera y toma los ingredientes que necesita de la mesa.
                String[] ingredientes = bfTobacco.consumir(ingredienteFijo);
                System.out.println("Fumador "+nombre+" con " + ingredienteFijo + " toma: " + ingredientes[0] + " y " + ingredientes[1]);

                // Simula el proceso de fumar.
                System.out.println("Fumador "+nombre+"  con " + ingredienteFijo + " está fumando.");
                Thread.sleep(2000); // Tiempo que tarda en fumar.
                System.out.println("Fumador "+nombre+" con " + ingredienteFijo + " terminó de fumar.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e); // Manejo de errores en caso de interrupción.
            }
        }
    }
}
