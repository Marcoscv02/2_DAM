package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class cmdDate2 {
    public static void main(String[] args) {
        Runtime runtime= Runtime.getRuntime();
        String [] command={"cmd","/C","date"};
        try {
            Process process= runtime.exec(command);
            var writer= new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write("27-10-24");


            Scanner sc= new Scanner(process.getInputStream());
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
            int exitStatus= process.waitFor();
            System.out.println("Exit status process data");

            if (exitStatus!=0){
                Scanner scerror= new Scanner( process.getErrorStream());
                while (scerror.hasNextLine()){
                    System.out.println(scerror.nextLine());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}