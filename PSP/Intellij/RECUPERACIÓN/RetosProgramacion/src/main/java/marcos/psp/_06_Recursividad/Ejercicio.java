package marcos.psp._06_Recursividad;
/*
 * EJERCICIO:
 * Entiende el concepto de recursividad creando una función recursiva que imprima
 * números del 100 al 0.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utiliza el concepto de recursividad para:
 * - Calcular el factorial de un número concreto (la función recibe ese número).
 * - Calcular el valor de un elemento concreto (según su posición) en la
 *   sucesión de Fibonacci (la función recibe la posición).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número:");
        int num = sc.nextInt();
        int factorial;

        System.out.println("___CALCULAR FACTORIAL DE "+num+"___");
        if (num<=0)
            throw new IllegalArgumentException();
        else
            factorial= calculateFactorial(num);

        System.out.println(factorial);

        System.out.println("___SUCESIÓN DE FIBONACCI___");
        System.out.println("Introduce el numero de cifras de la sucesión que deseas que se muestren");
        int cifras = sc.nextInt();
        int firstNumber = 0;
        int secondNumber = 1;
        int fibonacci;

        System.out.println(firstNumber);
        System.out.println(secondNumber);
        for (int i = 2; i < cifras; i++) {
            fibonacci = firstNumber+secondNumber;
            System.out.println(fibonacci);

            firstNumber=secondNumber;
            secondNumber=fibonacci;
        }

        System.out.println("ENCONTRAR POSICION EN LA SUCESIÓN");
        System.out.println("introduce un número que se encuentre entre la primeras 100 posiciones de la sucesión de Fibonacci para hallar su posición");
        int numero = sc.nextInt();
        int index = calculatePosition(numero);

        if (index>=0)
            System.out.println(index);
        else
            System.out.println("número no encontrado");

    }

    private static int calculateFactorial(int num){
        int factorial = 1;

        for (int i = num; i > 0 ; i--) {
           factorial*=i;
        }

        return factorial;
    }

    private  static int calculatePosition(int num){
        List<Integer> numbersFibonnaci= new ArrayList<>();
        int firstNumber = 0;
        numbersFibonnaci.add(firstNumber); // firstNumber
        int secondNumber = 1;
        numbersFibonnaci.add(1); //secondPosition
        int fibonacci;

        for (int i = 2; i < 100; i++) {
            fibonacci= firstNumber+secondNumber;
            numbersFibonnaci.add(fibonacci);

            firstNumber=secondNumber;
            secondNumber=fibonacci;
        }
        System.out.println(numbersFibonnaci);

        for (int i = 0; i < numbersFibonnaci.size(); i++) {
            if (num==numbersFibonnaci.get(i))
                return i+1;
        }

        return -1;
    }


}
