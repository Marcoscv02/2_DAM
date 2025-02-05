package org.example.REPASO2.encryptProgram;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Encryptation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String word= sc.nextLine();

        char [] caracteres= word.toCharArray();
        StringBuilder sb= new StringBuilder();

        for (char c: caracteres){ //Avanzar las letrs 3 posiciones a la derecha
            int charNum= c;
            charNum+=3;
            sb.append((char) charNum);
        }

        String reverse= String.valueOf(sb.reverse());

        char [] caracteres2= reverse.toCharArray();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < caracteres2.length; i++) {

            char c = caracteres2[i];

            if ( c > caracteres2.length/2){
                int charNum2 = c;
                charNum2-=1;
                sb2.append((char) charNum2);

            }else sb2.append(c);
        }

        System.out.println(sb2);
    }
}
