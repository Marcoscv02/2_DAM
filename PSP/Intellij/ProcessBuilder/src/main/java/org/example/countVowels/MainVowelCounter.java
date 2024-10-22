package org.example.countVowels;

import java.io.*;
import java.util.*;

public class MainVowelCounter {
    public static void main(String[] args) throws IOException, InterruptedException {

        String inputFile = "src/main/resources/FileData.txt";
        String[] vocales = {"a", "e", "i", "o", "u"}; //Array de vocales
        List<Process> processes = new ArrayList<>(); //Array de procesos que se van a ejecutar para cada vocal
        List<File> resultFiles = new ArrayList<>(); //Array de archivos que se generan en la clase "Countvowels"

        // Lanzar 5 procesos, uno para cada vocal
        for (String vocal : vocales) {
            File resultFile = new File("result_" + vocal + ".txt");
            if (!resultFile.exists()) resultFile.createNewFile();
            resultFiles.add(resultFile);
            ProcessBuilder pb = new ProcessBuilder("java", "-cp","target/classes","org.example.countVowels.CountVowels", inputFile, vocal, resultFile.getName());
            processes.add(pb.start()); // Lanzar el proceso y añadirlo a la lista
        }

        // Esperar a que todos los procesos terminen
        for (Process process : processes) {
            process.waitFor();
        }

        // Leer los resultados de los archivos y sumar los totales
        int totalVocales = 0;
        for (File resultFile : resultFiles) {
            try (BufferedReader br = new BufferedReader(new FileReader(resultFile))) {
                int count = Integer.parseInt(br.readLine());
                totalVocales += count;
            }
        }

        // Mostrar el total de vocales
        System.out.println("Total de vocales en el archivo: " + totalVocales);


    }
}
