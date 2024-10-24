package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class googleCrome {
    public static void main(String[] args) throws IOException {
        Runtime runtime= Runtime.getRuntime();
        String [] command={"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};
        Process process= runtime.exec(command);
    }
}