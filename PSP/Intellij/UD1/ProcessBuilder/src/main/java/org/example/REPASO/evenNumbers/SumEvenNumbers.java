package org.example.REPASO.evenNumbers;

public class SumEvenNumbers {
    public static void main(String[] args) {
        int firstNumber= Integer.parseInt(args[0]);
        int secondNumber= Integer.parseInt(args[1]);
        int counter=0;

        for (int i = firstNumber; i <= secondNumber; i++) {
            if (i%2==0){
                counter+=i;
            }
        }
        System.out.println(counter);
    }
}
