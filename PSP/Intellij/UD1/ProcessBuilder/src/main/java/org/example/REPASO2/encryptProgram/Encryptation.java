package org.example.REPASO2.encryptProgram;

import java.util.Scanner;

public class Encryptation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String word= sc.nextLine();

        char [] caracteres= word.toCharArray();
        StringBuilder sb= new StringBuilder();

        for (char c: caracteres){ //Avanzar las letrs 3 posiciones a la derecha

            sb.append((char) (c+3));
        }

        String reverse= String.valueOf(sb.reverse());

        char [] caracteres2= reverse.toCharArray();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < caracteres2.length; i++) {
            char c = caracteres2[i];
            if ( i > caracteres2.length / 2){

                sb2.append((char) (c-1));
            }else sb2.append(c);
        }

        System.out.println(sb2);
    }
}
