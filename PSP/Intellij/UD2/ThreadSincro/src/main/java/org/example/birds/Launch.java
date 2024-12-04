package org.example.birds;

import java.util.ArrayList;
import java.util.List;

public class Launch {
    public static void main(String[] args) {
        /**
         * Se define elemento comun y lista de hilos
         */
        Cage cage= new Cage();
        List<Thread> canarios = new ArrayList<>();

        /**
         * Se crean todos los hilos y se añaden al array
         * @param idBird
         * @param Cage
         */
        Thread bird1= new Thread(new Bird(1,cage));
        canarios.add(bird1);
        Thread bird2= new Thread(new Bird(2,cage));
        canarios.add(bird2);
        Thread bird3= new Thread(new Bird(3,cage));
        canarios.add(bird3);
        Thread bird4= new Thread(new Bird(4,cage));
        canarios.add(bird4);
        Thread bird5= new Thread(new Bird(5,cage));
        canarios.add(bird5);
        Thread bird6= new Thread(new Bird(6,cage));
        canarios.add(bird6);
        Thread bird7= new Thread(new Bird(7,cage));
        canarios.add(bird7);
        Thread bird8= new Thread(new Bird(8,cage));
        canarios.add(bird8);
        Thread bird9= new Thread(new Bird(9,cage));
        canarios.add(bird9);
        Thread bird10= new Thread(new Bird(10,cage));
        canarios.add(bird10);

        /**
         * Se inicializan todos los hilos en bucle
         */
        for(Thread t:canarios){
            t.start();
        }
    }
}
