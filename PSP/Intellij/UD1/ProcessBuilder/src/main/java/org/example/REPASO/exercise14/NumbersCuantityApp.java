package org.example.REPASO.exercise14;

import java.io.*;
import java.util.Scanner;

public class NumbersCuantityApp {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Input a number to determinate how much digits it have");
        int number= sc.nextInt();


        Process process= new ProcessBuilder("java", "-cp", "target/classes", "org.example.REPASO.exercise14.NumbersCuantityprocess")
                .redirectErrorStream(true)
                .start();


        PrintWriter writter= new PrintWriter(process.getOutputStream(), true);
        BufferedReader reader= new BufferedReader(new InputStreamReader(process.getInputStream()));



        writter.write(number+"\n");
        writter.flush();

        String numDigits= reader.readLine();

        writter.close();
        reader.close();

        System.out.println("Number: "+number+" have "+numDigits+" digits");

    }
}
