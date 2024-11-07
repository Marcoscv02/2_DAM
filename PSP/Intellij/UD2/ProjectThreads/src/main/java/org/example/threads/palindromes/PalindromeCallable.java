package org.example.threads.palindromes;

import java.util.concurrent.Callable;

public class PalindromeCallable implements Callable {
    String palabra;

    public PalindromeCallable(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public Object call() throws Exception {
        String invertida = new StringBuilder(palabra).reverse().toString();
        if (palabra.equalsIgnoreCase(invertida)) return "La palabra "+palabra+" es palíndromo";
        return "La palabra "+palabra+" no es palíndromo";
    }
}
