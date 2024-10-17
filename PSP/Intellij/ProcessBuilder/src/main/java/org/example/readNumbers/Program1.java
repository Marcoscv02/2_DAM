package org.example.readNumbers;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int suma=0;

        System.out.println("Cantidad de numeros que se desea realizar suma y cuadrado");
        int nums= sc.nextInt();
        for (int i = 0; i < nums; i++) {
            System.out.print("introduzca número "+(i+1)+":");
            int num = sc.nextInt();
            System.out.println();//Salto de linea
            suma+=num;
        }
        System.out.println("El cuadrado de la suma de los números introducidos es: "+Math.pow(suma,2));
    }
}
