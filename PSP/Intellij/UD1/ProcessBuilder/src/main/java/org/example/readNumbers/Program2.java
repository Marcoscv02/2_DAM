package org.example.readNumbers;

import java.util.Scanner;

/**
 * Programa que calcula la suma de los cuadrados de una lista de números enteros ingresados por el usuario.
 * La cantidad de números a procesar se especifica primero.
 */
public class Program2 {
    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de la línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double suma = 0;

        // Leer la cantidad de números a procesar
        int nums = sc.nextInt();

        // Procesar cada número, calcular su cuadrado y sumarlo
        for (int i = 0; i < nums; i++) {
            int num = sc.nextInt();
            int num2 = (int) Math.pow(num, 2);
            suma += num2;
        }

        // Imprimir la suma de los cuadrados
        System.out.println(suma);
    }
}
