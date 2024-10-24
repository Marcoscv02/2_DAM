package org.example;

import java.io.IOException;

public class NotepadPlusPlus {
    public static void main(String[] args) {
        Runtime runtime= Runtime.getRuntime();
        String [] command={"C:\\Program Files\\Notepad++\\notepad++.exe"};
        try {
            Process process= runtime.exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}