package org.example.readNumbers;

import java.util.Scanner;

/**
 * Programa que calcula el cuadrado de la suma de una lista de números enteros ingresados por el usuario.
 * La cantidad de números a procesar se especifica primero.
 */
public class Program1 {
    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de la línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;

        // Leer la cantidad de números a procesar
        int nums = sc.nextInt();

        // Procesar cada número y acumular su valor
        for (int i = 0; i < nums; i++) {
            int num = sc.nextInt();
            suma += num;
        }

        // Calcular e imprimir el cuadrado de la suma
        System.out.println(Math.pow(suma, 2));
    }
}
