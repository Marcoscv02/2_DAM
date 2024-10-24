package org.example.createThreads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InfoRunable ir= new InfoRunable();


        Thread t1= new Thread(ir);
        Thread t2= new Thread(ir);
        Thread t3= new Thread(ir, "T3"); //Asignar un nombre distinto ao fio
        Thread t4= new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Runable Anonymous");
                    }
                }
        );

        Runnable runnable=()->{
            System.out.println("Runnable with Lambda");
        };

        Thread t5= new Thread(runnable);
        Thread t6= new PrintingThreads();


        System.out.println("***FORMAS DE CREAR THREADS***");
        System.out.println("---------------------------------");
        /*Non se debe confundir o método start co método run, o método run nunca debe ser chamado*/
        t1.start();//Inicia el proceso
        t2.setPriority(2); //Asignar una prioridad al proceso
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        while (t5.isAlive()){ //De esta forma pregunta continuamente si el proceso esta activo pero consume recursos(NON Recomendado)
            Thread.sleep(5L); //Provoca espera activa, más tiempo de carga
        }
        t6.start();
        t6.join();//Pone el proceso en una espera activa sin consumir recursos

    }
}
