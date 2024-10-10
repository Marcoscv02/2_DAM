package org.example;

import java.io.FileReader;
import java.io.IOException;

public class CountVowels {
    public static void main(String[] args) throws IOException {
        int contA = 0;
        int contE = 0;
        int contI = 0;
        int contO = 0;
        int contU = 0;
        int contTotal = 0;

        FileReader fr = new FileReader("FileData.txt");

// Leer cada carácter del archivo
        int ch;
        while ((ch = fr.read()) != -1) {
            char a = Character.toLowerCase((char) ch); // Convertir el carácter a minúscula para facilitar la comparación

            // Contar las vocales
            switch (a) {
                case 'a':
                    contA++;
                    contTotal++;
                    break;
                case 'e':
                    contE++;
                    contTotal++;
                    break;
                case 'i':
                    contI++;
                    contTotal++;
                    break;
                case 'o':
                    contO++;
                    contTotal++;
                    break;
                case 'u':
                    contU++;
                    contTotal++;
                    break;
                default:
                    // No hacer nada para otros caracteres
            }
        }
        System.out.println("Number of A:"+contA);
        System.out.println("Number of E:"+contE);
        System.out.println("Number of I:"+contI);
        System.out.println("Number of O:"+contO);
        System.out.println("Number of E:"+contU);
        System.out.println("otal number: of vowels:"+contTotal);
    }
}
