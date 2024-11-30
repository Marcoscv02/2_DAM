package org.example.smokers;

public class BufferTobacco {
    private String ingrediente1; // Primer ingrediente colocado en la mesa.
    private String ingrediente2; // Segundo ingrediente colocado en la mesa.
    private boolean disponible = false; // Indica si hay ingredientes disponibles en la mesa.

    // Metodo sincronizado para que un fumador consuma los ingredientes de la mesa.
    synchronized public String[] consumir(String ingredienteFumador) throws InterruptedException {
        // Mientras no haya ingredientes o los disponibles no sean los correctos para el fumador actual.
        while (!disponible || ingredienteFumador.equals(ingrediente1) || ingredienteFumador.equals(ingrediente2)) {
            wait(); // El fumador espera hasta que los ingredientes correctos estén disponibles.
        }

        // Si los ingredientes están disponibles y son los correctos, los toma.
        String[] ingredientes = {ingrediente1, ingrediente2};

        // Vacía la mesa para la próxima ronda.
        disponible = false;
        ingrediente1 = null;
        ingrediente2 = null;

        notifyAll(); // Notifica al tabaquero que la mesa está libre.
        return ingredientes; // Devuelve los ingredientes tomados.
    }

    // Metodo sincronizado para que el tabaquero coloque ingredientes en la mesa.
    synchronized public void producir(String ing1, String ing2) throws InterruptedException {
        // Mientras haya ingredientes en la mesa, el tabaquero espera a que la mesa esté vacía.
        while (disponible) {
            wait();
        }

        // Coloca los nuevos ingredientes en la mesa.
        this.ingrediente1 = ing1;
        this.ingrediente2 = ing2;
        disponible = true; // Marca la mesa como ocupada.

        notifyAll(); // Notifica a los fumadores que hay nuevos ingredientes.
    }
}
