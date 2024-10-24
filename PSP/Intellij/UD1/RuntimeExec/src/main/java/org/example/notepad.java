package org.example;

import java.io.IOException;

public class notepad {
    public static void main(String[] args) throws IOException {
        Runtime runtime= Runtime.getRuntime();
        String [] command={"C:\\Program Files\\Notepad++\\notepad++.exe"};
        Process process= runtime.exec(command);
    }
}
