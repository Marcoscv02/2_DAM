package org.example.mailBox;

public class Main {
    public static void main(String[] args) {
        MailBox mb= new MailBox();

        Producer productor= new Producer(mb);
        Consumer consumidor= new Consumer(mb);

        Thread tProducer= new Thread(productor);
        Thread tConsumer= new Thread(consumidor);

        tProducer.start();
        tConsumer.start();


        try {
            tProducer.join();
            tConsumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
