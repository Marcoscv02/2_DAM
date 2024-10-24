package org.example.departments;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class Suma {
    public static void main(String[] args) {
        Path f = Paths.get(args[0]);
        double suma = 0;

        try (BufferedReader br = Files.newBufferedReader(f)) {
            String c;
            while ((c = br.readLine()) != null) {
                double num=Double.parseDouble(c);
                suma += num;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.printf(Locale.US,"%.2f",suma);
    }
        
}

