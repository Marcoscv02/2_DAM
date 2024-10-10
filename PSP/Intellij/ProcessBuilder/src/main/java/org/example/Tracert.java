package org.example;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tracert {
    public static void main(String[] args) {
        // Crear el ProcessBuilder para ejecutar el comando tracert
        ProcessBuilder pb= new ProcessBuilder("cmd","/c","tracert","www.iessanclemente.net");

        // Redirigir la salida estándar al archivo outputTracert.txt
        pb.redirectOutput(new File("outputTracert.txt."));

        try {
            //Iniciar el proceso
            Process p = pb.start();

            //se crea una variable boobleana que se ponga a true si el proceso ha superado los 500 milisegundos
            boolean finished= p.waitFor(500, TimeUnit.MILLISECONDS);

            //Cuando la variable booleana se pone a true el proceso es destruido
            if (finished!=false){
                p.destroyForcibly();
                throw new InterruptedException("Process interrupted by limit time");
            }else System.out.println("Process finished success");

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
