package org.example;

import java.io.IOException;

public class Youtube {
    public static void main(String[] args) throws IOException {
        Runtime runtime= Runtime.getRuntime();
        String [] command={"cmd","start","https://www.youtube.com/"};
        Process process= runtime.exec(command);
    }
}