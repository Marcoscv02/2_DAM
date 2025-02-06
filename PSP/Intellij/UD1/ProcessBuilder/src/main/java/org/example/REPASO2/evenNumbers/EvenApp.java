package org.example.REPASO2.evenNumbers;

import java.io.*;
import java.util.Scanner;

public class EvenApp {
    public static final String RESULT_PATH= "src/main/resources/EvenNumbers/output.txt";
    public static final String ERROR_PATH= "src/main/resources/EvenNumbers/errors.txt";


    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);

        System.out.println("Introduzca primer número");
        String num1= sc.nextLine();
        System.out.println("Introduzca segundo número");
        String num2 = sc.nextLine();

        Process process= new ProcessBuilder("java", "-cp", "target/classes","org.example.REPASO.evenNumbers.SumEvenNumbers", num1,num2)
                .redirectErrorStream(true)
                .start();


        try (
                //Recibe datos de la clase
                var br= new BufferedReader(new InputStreamReader(process.getInputStream()));
                //Escribe resultados en el fichero de resultados
                var bw= new BufferedWriter(new FileWriter(RESULT_PATH));
                ) {
            int resultado= Integer.parseInt(br.readLine());
            System.out.println("Resultado de la suma: "+resultado);

            bw.write(resultado);
        }


        try (
                //Recibe errores de la clase
                var readError= new BufferedReader(new InputStreamReader(process.getErrorStream()));
                //Escribe en el fichero de errores
                var bError= new BufferedWriter(new FileWriter(ERROR_PATH));
                ){
            StringBuilder sb= new StringBuilder();

            sb.append(readError.read());
            bError.write(sb.toString());

        }

    }
}
