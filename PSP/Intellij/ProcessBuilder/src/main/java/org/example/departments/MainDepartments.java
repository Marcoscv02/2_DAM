package org.example.departments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainDepartments {
    public static void main(String[] args) throws IOException {
        System.out.println("Programa para recorrer el Directorio \"Departments\" y sumar" +
                " los números registrados en cada uno de los archivos:");
        System.out.println("--------------------------------------------------------------------");

        int numArchivo=0;
        for (int i = 0; i < 8; i++) {
            //Se crea un archivo en cada iteración del bucle
            Path f= Paths.get("src/main/resources/Departments/department10"+(numArchivo+1)+".txt");

            //CREACION DEL PROCESO
            Process proceso= new ProcessBuilder("java", "-cp", "target/classes", "org.example.departments.Suma",f.toString()).start();
            //Se lee la salida del priceso y se imprime por consola
            try (BufferedReader br= new BufferedReader(new InputStreamReader(proceso.getInputStream()))){
                String valor =br.readLine();

                System.out.println("department10"+(numArchivo+1)+".txt");
                System.out.println(valor);
                System.out.println("--------------------------------------------------------------------");
            }
            //Se suma contador
            numArchivo++;
        }
    }
}
