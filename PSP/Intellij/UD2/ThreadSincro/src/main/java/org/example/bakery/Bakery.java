package org.example.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    public static void main(String[] args) {
        //Se crea objeto de clase comun
        TakeaNumber tk= new TakeaNumber();

        //Se crea consumidor
        Thread panadero= new Thread(new Baker(tk));
        panadero.start();

        //se crea lista de clientes

        int i=tk.getNumeroCliente();

        while (i<100){
            Thread t= new Thread(new Client(tk));

            t.start();
        }

    }
}
