package org.example.REPASO2.readNumbers;

import java.util.Scanner;

public class CuadradoSuma {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int numOperandos= sc.nextInt();

        int resultado=0;
        for (int i = 0; i < numOperandos; i++) {
          int num = sc.nextInt();//recoje operandos
          resultado+=num;
        }

        resultado= (int) Math.pow(2,resultado);
        System.out.println(resultado);
    }
}
