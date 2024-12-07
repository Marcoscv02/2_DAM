package org.example.REPASO.encryptProgram;

import java.util.Scanner;

public class encryptProgram {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String word= sc.nextLine();

        char[] caracteres1 =word.toCharArray();
        StringBuilder sb= new StringBuilder();

        //se desplazan todos los caracteres 3 posiciones hacia la derecha
        for (char c:caracteres1){

            int caracterNum= (int)c;
            caracterNum+=3;
            sb.append((char) caracterNum);

        }

        //Se invierte la palabra
        String reverseWord = String.valueOf(sb.reverse());

        //Desde la mitad truncada hacia adelante, desplazar 1 posición a la izquierda en ASCII.
        char [] caracteres2= reverseWord.toCharArray();
        StringBuilder sbFinal=new StringBuilder();
        for (int index = 0; index < caracteres2.length; index++) {
            char c= caracteres2[index];

            if (caracteres2[index] >= (caracteres2.length/2)){
                int caracterNum2= (int)c;
                caracterNum2-=1;
                sbFinal.append((char)caracterNum2);
            }else {
                sb.append(c);
            }

        }

        //Salida de la palabra encriptada
        System.out.println(sbFinal.toString());
    }
}
