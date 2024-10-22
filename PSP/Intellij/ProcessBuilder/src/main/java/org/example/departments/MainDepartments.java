package org.example.departments;

import java.io.IOException;

public class MainDepartments {
    public static void main(String[] args) throws IOException {
        System.out.println("Programa para recorrer el Directorio \"Departments\" y sumar" +
                " los números registrados en cada uno de los archivos:");

        int numArchivo=0;
        for (int i = 0; i < 8; i++) {

            //CREACION DEL PROCESO
            Process proceso= new ProcessBuilder("java", "-cp", "target/classes", "org.example.departments.Suma").start();

        }
    }
}
