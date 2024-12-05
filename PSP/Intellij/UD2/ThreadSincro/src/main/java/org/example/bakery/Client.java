package org.example.bakery;

import static java.lang.Thread.sleep;

public class Client implements Runnable{
    TakeaNumber tk;

    public Client(TakeaNumber tk) {
        this.tk = tk;
    }

    @Override
    public void run() {
        while (tk.getNumeroCliente()<101){
            try {
                int numero =tk.getNumeroCliente();
                System.out.println("cliente "+numero+" entra a la tienda");
                sleep((long) ((Math.random()*2000)+2000));
                tk.sacarNumero();
                System.out.println("Cliente ha sacado nuevo número "+numero);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
