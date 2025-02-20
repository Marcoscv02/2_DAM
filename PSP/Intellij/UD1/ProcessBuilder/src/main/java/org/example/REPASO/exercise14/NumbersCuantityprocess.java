package org.example.REPASO.exercise14;

import java.util.Scanner;

public class NumbersCuantityprocess {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String number= sc.nextLine();



        char[]digits= number.toCharArray();

        System.out.println(digits.length);
    }
}
