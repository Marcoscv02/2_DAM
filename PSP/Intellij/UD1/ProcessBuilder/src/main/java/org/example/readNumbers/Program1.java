package org.example.readNumbers;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int suma=0;

        //Primer parámetro
        int nums= sc.nextInt();
        for (int i = 0; i < nums; i++) {
            //Parámetros restantes
            int num = sc.nextInt();
            suma+=num;
        }

        //Salida resultado de la operación
        System.out.println(Math.pow(suma,2));
    }
}
