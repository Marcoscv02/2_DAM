package org.example.readNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class PrincipalProgram {
    public static void main(String[] args) throws IOException {

        // Lanzar el primer proceso: SumaCuadrado (Program1)
        Process proceso1 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program1").start();

        // Inicializamos un objeto Scanner para leer desde la entrada estándar (teclado)
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de números que se van a procesar
        int n = scanner.nextInt();

        // Crear un StringBuilder para construir una cadena con la entrada del usuario
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append(n).append("\n");  // Añadir el número de valores que serán leídos

        // Leer los n números del usuario y agregarlos al StringBuilder
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            inputBuilder.append(num).append("\n");  // Cada número se añade a la cadena seguido de un salto de línea
        }

        // Convertir el contenido del StringBuilder en un String para enviar como entrada a otros programas
        String input = inputBuilder.toString();


        // Obtener el OutputStream del proceso1 para enviarle la entrada (los números) desde este programa principal
        OutputStream outputStream1 = proceso1.getOutputStream();
        outputStream1.write(input.getBytes());  // Escribir los números en el proceso
        outputStream1.flush();  // Asegurarse de que los datos sean enviados
        outputStream1.close();  // Cerrar el OutputStream porque ya no enviaremos más datos

        // Leer el resultado que devuelve el proceso1 (Program1) usando un BufferedReader
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
        String resultado1 = reader1.readLine();  // Leer la primera línea de la salida del proceso1 (el resultado)

        // Lanzar el segundo proceso: CuadradoYSuma (Program2)
        Process proceso2 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program2").start();

        // Obtener el OutputStream del proceso2 para enviarle los números
        OutputStream outputStream2 = proceso2.getOutputStream();
        outputStream2.write(input.getBytes());  // Escribir los mismos números que antes
        outputStream2.flush();  // Asegurarse de que los datos sean enviados
        outputStream2.close();  // Cerrar el OutputStream cuando terminamos de enviar los datos

        // Leer el resultado que devuelve el proceso2 (Program2) usando un BufferedReader
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
        String resultado2 = reader2.readLine();  // Leer la primera línea de la salida del proceso2 (el resultado)

        // Mostrar los resultados de ambos programas en la salida estándar
        System.out.println("Resultado de SumaCuadrado: " + resultado1);
        System.out.println("Resultado de CuadradoYSuma: " + resultado2);
    }
}

