package org.example.countVowels;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountVowels {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Uso: java VowelCounterProcess <archivo> <vocal> <resultFile>");
            return;
        }

        String inputFile = args[0];
        char vocal = args[1].charAt(0);  // Vocal en Recibida del archivo
        char vocalMayus = Character.toUpperCase(vocal); // Se transforman todas las vocales a MAYÚSCULA
        String resultFile = args[2];

        //Contar ocurrencias de la vocal
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                if (c == vocalMayus) {
                    count++;
                }
            }
        }
        System.out.println("Cantidad de la vocal '" + vocalMayus + "' encontrada: " + count);  // Depuración
        // Escribir el resultado en el archivo de salida
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write(Integer.toString(count));
            System.out.println("Resultado escrito en: " + resultFile);  // Depuración
        }
    }
}
