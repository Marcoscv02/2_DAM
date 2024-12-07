package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class numProcesadores {
    public static void main(String[] args) throws IOException {
        Runtime runtime= Runtime.getRuntime();
        int process= runtime.availableProcessors();
        System.out.println(process);
    }
}