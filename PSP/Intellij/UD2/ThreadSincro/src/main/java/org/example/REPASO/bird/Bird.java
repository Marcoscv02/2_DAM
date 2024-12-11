package org.example.REPASO.bird;

import static java.lang.Thread.sleep;

public class Bird implements Runnable{
    int id;
    Jaula jaula;

    public Bird(int id, Jaula jaula) {
        this.id = id;
        this.jaula = jaula;
    }

    @Override
    public void run() {
        while (true){
            try {
                //Comer
                jaula.startComer(id);
                sleep((long) (Math.random()*500+500));
                jaula.stopComer(id);

                //Columpio
                jaula.startColumpio(id);
                sleep((long) (Math.random()*1500+500));
                jaula.stopColumpio(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
