package org.example.smokers;

import static java.lang.Thread.sleep;

public class Tobacconist implements Runnable {
    private final String[] INGREDIENTS = {"tabaco", "papel", "cerilla"}; // Ingredientes posibles.
    private final BufferTobacco bfTobacco; // Referencia al buffer compartido (mesa).

    // Constructor que recibe el buffer compartido.
    public Tobacconist(BufferTobacco bfTobacco) {
        this.bfTobacco = bfTobacco;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Genera dos ingredientes aleatorios diferentes.
                int index1 = (int) (Math.random() * INGREDIENTS.length);
                int index2;
                do {
                    index2 = (int) (Math.random() * INGREDIENTS.length);
                } while (index1 == index2); // Asegurarse de que los dos ingredientes sean distintos.

                String ing1 = INGREDIENTS[index1];
                String ing2 = INGREDIENTS[index2];

                // Coloca los ingredientes en la mesa.
                bfTobacco.producir(ing1, ing2);
                System.out.println("Tabaquero coloca: " + ing1 + " y " + ing2);

                sleep(1000); // Simula el tiempo necesario para preparar los ingredientes.
            } catch (InterruptedException e) {
                throw new RuntimeException(e); // Manejo de errores en caso de interrupción.
            }
        }
    }
}
