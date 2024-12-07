package org.example.REPASO.readNumbers;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        //Se recojen numero de operandos
        int numOperandos= sc.nextInt();
        //se crea la variable del resultado
        int sumaNums=0;

        for (int i = 1; i <= numOperandos; i++) {
            //Se insertan todos los operandos
            int num= sc.nextInt();

            //Se realiza la suma del cuadrado
            int numCuadrado= (int) Math.pow(num,2);
            sumaNums+=numCuadrado;
        }

        //resultado
        System.out.println(sumaNums);
    }
}
