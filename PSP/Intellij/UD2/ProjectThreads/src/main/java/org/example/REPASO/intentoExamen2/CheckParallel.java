package org.example.REPASO.intentoExamen2;

import java.io.IOException;
import java.io.PrintWriter;

public class CheckParallel {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {

            Process process= new ProcessBuilder("java", "-cp", "target/classes", "org.example.REPASO.intentoExamen2.CheckNumbers")
                    .redirectErrorStream(true)
                    .start();

            StringBuilder sb= new StringBuilder();
            sb.append("results"+(i+1)+".txt");
            sb.append("\n");
            sb.append(i*100);



            try{
                PrintWriter writer= new PrintWriter(process.getOutputStream(), true);

                writer.write(sb.toString());

                writer.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
