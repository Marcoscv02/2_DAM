package org.example.REPASO.multiples;

import java.math.BigInteger;


public class MultipleTask implements Runnable {
    private BigInteger number;

    public MultipleTask(BigInteger number) {
        this.number = number;
    }

    @Override
    public void run() {
        StringBuilder sb= new StringBuilder();
        sb.append("El numero es múltiplo de: ");

        if (isMultipleOf3(number)) sb.append(" 3 ");
        if (isMultipleOf5(number)) sb.append(" 5 ");
        if (isMultipleOf11(number)) sb.append(" 11 ");

        System.out.println(sb);
    }

    public Boolean isMultipleOf3 ( BigInteger number){
        char[] digits= String.valueOf(number).toCharArray();

        int sum=0;
        for (char d:digits){
            sum+=d;
        }

        if (sum%3==0) return true;

     return false;
    }

    public Boolean isMultipleOf5 ( BigInteger number){
        String stringNumber = String.valueOf(number);

        if (stringNumber.endsWith("0")||stringNumber.endsWith("5")) return true;


        return false;
    }


    public Boolean isMultipleOf11 ( BigInteger number){
        int pares=0;
        int impares=0;

        char[] digits= String.valueOf(number).toCharArray();
        for (char d: digits){
            if (d%2==0) {
                pares+=d;
            }else impares+=d;
        }

        int diferencia=impares-pares;

        if (diferencia%11==0) return true;

        return false;
    }

}
