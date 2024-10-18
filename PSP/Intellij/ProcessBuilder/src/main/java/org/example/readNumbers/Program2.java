package org.example.readNumbers;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double suma=0;

        //Primer parámetro
        int nums= sc.nextInt();

        for (int i = 0; i < nums; i++) {
            //Parámetros restantes
            int num = sc.nextInt();
            int num2= (int) Math.pow(num,2);
            System.out.println();//Salto de linea
            suma+=num2;
        }
        //Salida resultado de la operación
        System.out.println(suma);
    }
}
