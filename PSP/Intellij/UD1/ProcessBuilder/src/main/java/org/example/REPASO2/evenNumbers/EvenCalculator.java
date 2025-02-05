package org.example.REPASO2.evenNumbers;


public class EvenCalculator {
    public static void main(String[] args) {

        int num1= Integer.parseInt(args[0]);
        int num2= Integer.parseInt(args[1]);

        int suma=0;

        for (int i = num1; i <= num2; i++) {
            if (i%2==0){
                suma+=i;
            }
        }

        System.out.println(suma);
    }
}
