package org.example.REPASO.readNumbers;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        //Se recojen numero de operandos
        int numOperandos= sc.nextInt();
        //se crea la variable del resultado
        int sumaNums=0;

        for (int i = 1; i <= numOperandos; i++) {
            //Se insertan todos los operandos
            int num= sc.nextInt();
            sumaNums+=num;
        }

        //se realiza el cuadrado de la suma
        int cuadradoSuma = (int) Math.sqrt(sumaNums);

        //resultado
        System.out.println(cuadradoSuma);
    }
}
