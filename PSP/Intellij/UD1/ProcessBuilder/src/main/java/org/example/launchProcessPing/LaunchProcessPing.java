package org.example.launchProcessPing;

import java.io.IOException;
import java.util.Arrays;

public class LaunchProcessPing {
    public static void main(String[] args) {

        // Verifica si el usuario ha pasado algún argumento (comando a ejecutar).
        if (args.length <= 0) {
            System.out.println("You must indicate the command to execute");
            System.exit(1); // Termina el programa con el código de salida 1
        }

        ProcessBuilder pb = new ProcessBuilder(args); //Creación instancia ProcessBuilder

        /*La función inheritIO() asegura que la entrada, salida y error estándar del proceso que
         se va a ejecutar se muestren directamente en la consola de Java, como si el comando se
         hubiera ejecutado manualmente en la terminal.*/
        pb.inheritIO();

        try {
            // Inicia el proceso, ejecutando el comando que se ha especificado.
            Process p = pb.start();

            /*La función waitFor() bloquea la ejecución del programa Java hasta que el proceso externo termine.
            El código de retorno de ese proceso indica si la ejecución fue exitosa (0) o fallida (un valor diferente de 0).*/
            int codRet = p.waitFor();

            System.out.println("The execution of " + Arrays.toString(args)
                    + " returns " + codRet
                    + " " + (codRet == 0 ? "(OK)" : "(ERROR)")
            );//Se imprime mensaje mostrando si la ejecución del programa ha dado fallo o no

        } catch (IOException e) { //Captura excepción 1
            System.err.println("Error during the execution of the process");
            System.err.println("Detailed information");
            System.err.println("---------------------");
            e.printStackTrace(); // Imprime la pila de llamadas (stack trace) para detalles del error
            System.err.println("---------------------");
            System.exit(2); //Codigo salida 2

        } catch (InterruptedException e) { //Captura excepcion 2
            System.err.println("Interrupted process");
            System.exit(3); //Código salida 3
        }
    }
}