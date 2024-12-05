package org.example.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    public static final int NUM_CLIENTES=100;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Se inicia la simulacion");

        //Se crea objeto de clase comun
        TakeaNumber tk= new TakeaNumber();

        //Se crea consumidor
        Thread panadero= new Thread(new Baker(tk));
        panadero.start();


        for (int i = 0; i < NUM_CLIENTES; i++) {
            Thread t= new Thread(new Client(i,tk));
            t.start();
        }

    }
}
