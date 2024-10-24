package org.example;

import java.io.IOException;
import java.util.Scanner;

public class NotepadPlusPlusFile {
    public static void main(String[] args) {
        Runtime runtime= Runtime.getRuntime();
        String [] command={"cmd","/C","data","/T"};
        try {
            Process process= runtime.exec(command);
            Scanner sc= new Scanner(process.getInputStream());
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}