package org.example.REPASO.intentoExamen1;

import java.io.*;
import java.util.concurrent.Executors;

public class CheckParallel {
    public static void main(String[] args) throws IOException, InterruptedException {


        for (int i = 0; i < 10; i++) {
            StringBuilder sb= new StringBuilder();

            Process process= new ProcessBuilder("java", "-cp","target/classes", "org.example.REPASO.intentoExamen1.CheckNumbers")
                    .redirectErrorStream(true)
                    .start();

            PrintWriter writter= new PrintWriter(process.getOutputStream(), true);

            sb.append("curious").append(i).append(".txt").append("\n").append(i*100);
            System.out.println("salida: \n"+sb);
            writter.write(sb.toString());
            writter.flush();

        }

    }
}
