package org.example.REPASO.examenRecu;

import java.io.*;
import java.util.Scanner;

public class ProcessFile {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        String inputPath= sc.nextLine();
        int index= sc.nextInt();

        File inputFile= new File(inputPath);

        BufferedReader reader= new BufferedReader(new FileReader(inputFile));

        String profitText;
        while ((profitText= reader.readLine()) != null){

            int profit= Integer.parseInt(profitText);
            int dias=0;
            int profitCalculate=0;


        }
    }
}
