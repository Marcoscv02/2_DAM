package org.example.Teoria.Hilos2;

public class Main {
    public static void main(String[] args) {
        Contador c1= new Contador("contador1", 125);
        Contador c2= new Contador("contador2", 70);
        Contador c3= new Contador("contador3", 285);
        Contador c4= new Contador("contador4", 207);

        Thread t1= new Thread(c1);
        Thread t2= new Thread(c2);
        Thread t3= new Thread(c3);
        Thread t4= new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            //Indica ao fio que debe esperar a que todos os demais fios terminen para continuar coa execucion do programa
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin del programa");//Mostrarase cando todos os fios teminen
    }

}
