package org.example.REPASO.bakery;

public class Bakery {
    public static final int NUMCLIENTES=100;
    public static void main(String[] args) {
        TakeANumber tk= new TakeANumber();

        System.out.println("se inicia la simulación");

        Thread panadero= new Thread(new Clerk(tk));
        panadero.start();

        for (int i = 1; i <= NUMCLIENTES ; i++) {
            Thread cliente = new Thread(new Customer(i,tk));
            cliente.start();
        }

    }
}
