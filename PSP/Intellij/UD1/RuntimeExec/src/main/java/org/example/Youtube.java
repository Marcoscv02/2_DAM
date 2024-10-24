package org.example;

import java.io.IOException;

public class Youtube {
    public static void main(String[] args) throws IOException {
        Runtime runtime= Runtime.getRuntime();
        String [] command={"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "https://www.youtube.com/"};
        Process process= runtime.exec(command);
    }
}