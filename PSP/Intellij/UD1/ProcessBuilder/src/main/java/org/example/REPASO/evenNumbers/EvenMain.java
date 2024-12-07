package org.example.REPASO.evenNumbers;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EvenMain {
    public static void main(String[] args) throws IOException {
        Path outputF= Paths.get("src/main/resources/EvenNumbers/output.txt");
        File output=outputF.toFile();
        Path errorsF=Paths.get("src/main/resources/EvenNumbers/errors.txt");
        File error=errorsF.toFile();
        Scanner sc= new Scanner(System.in);

        //Introducir variables
        System.out.println("Introduce primer número");
        String firstNumber=sc.nextLine();
        System.out.println("Introduce segundo número");
        String secondNumber=sc.nextLine();

        System.out.println("Vamos a realizar la suma de todos los números pares que hay entre "+firstNumber+" y "+secondNumber+" ambos incluidos");


        Process p= new ProcessBuilder("java","-cp","target/classes","org.example.REPASO.evenNumbers.SumEvenNumbers", firstNumber,secondNumber).start();

        //Capturar resultado del proceso
        int resultado;
        try(var br= new BufferedReader(new InputStreamReader(p.getInputStream()));
            var bw= new BufferedWriter(new FileWriter(output))){
            resultado= Integer.parseInt(br.readLine());
            bw.write(String.valueOf(resultado));
            System.out.println("Proceso completado con éxito, el resultado la suma de todos los números pares entre "+firstNumber+" y "
            +secondNumber+" esta guardado en "+output.getName());
        }

        //Capturar errores del proceso
        StringBuilder errorProcess= new StringBuilder();
        try(var errorreader= new BufferedReader(new InputStreamReader(p.getErrorStream()));
            var errorWritter= new BufferedWriter(new FileWriter(error))){
            errorProcess.append(errorreader.readLine());
            errorWritter.write(errorProcess.toString());

        }
        System.out.println("compruebe en el archivo "+error.getName()+" para comprobar si se han producido errores");

    }
}
