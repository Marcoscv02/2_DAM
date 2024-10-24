package org.example.createThreads;

public class PrintingThreads extends Thread{
    /*
    Non é recomendafle crear fios de esta forma xa que si se necesita herdar de outra
    clase non se podería debido a que xa se está herdaddo da clase Thread
    */
    @Override
    public void run(){
        System.out.println("A thread from PrintingThreads");
    }
}
