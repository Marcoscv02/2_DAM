package org.example.REPASO.examenRecu;

import java.io.IOException;
import java.io.PrintWriter;

public class ProcessFiles {
    public static final String PATH = "src/main/resources/examenRecu/targets";
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            Process process= new ProcessBuilder("java", "-cp", "target/classes", "org.example.REPASO.examenRecu.ProcessFile")
                    .redirectErrorStream(true)
                    .start();

            PrintWriter writter= new PrintWriter(process.getOutputStream());

            writter.write(PATH+i+".txt \n"+i+"\n");
            writter.flush();

        }
    }
}
