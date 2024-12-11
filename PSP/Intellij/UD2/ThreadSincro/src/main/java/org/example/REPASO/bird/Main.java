package org.example.REPASO.bird;

public class Main {
    public static void main(String[] args) {
        Jaula jaula= new Jaula();

        for (int i = 0; i < 15; i++) {

            Thread t= new Thread(new Bird(i,jaula));

            t.start();

        }
    }
}
