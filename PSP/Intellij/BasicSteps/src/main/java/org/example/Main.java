package org.example;

/**
 * Clase principal que contiene el método main para calcular el número mínimo de saltos
 * necesarios para subir escaleras en carreras verticales.
 */
public class Main {

    /**
     * Método principal que procesa los argumentos de línea de comandos y calcula los saltos mínimos.
     *
     * @param args Argumentos de línea de comandos. El primer argumento debe ser el número de casos,
     *             seguido por pares de números que representan los escalones y los pasos por salto.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("have to put one or more args");
        } else {
            int numCases = Integer.parseInt(args[0]);
            if (numCases*2+1 == args.length ) {
                int cases = 1;
                while (cases <= numCases) {
                    int escalones = Integer.parseInt(args[cases]);
                    int pasos = Integer.parseInt(args[cases + 1]);

                    // Calcula el número mínimo de saltos
                    int div = escalones / pasos;
                    if ((escalones % pasos) >= 1) {
                        div++;
                    }
                    System.out.println(div);
                    cases = cases + 2;
                }
            }
        }
    }
}