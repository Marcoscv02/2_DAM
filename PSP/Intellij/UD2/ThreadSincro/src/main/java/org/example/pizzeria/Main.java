package org.example.pizzeria;

public class Main {
    public static void main(String[] args) {
        Table table= new Table();

        Thread cooker= new Thread(new Cooker(table));

        Thread deliver1= new Thread(new Deliver("1",table));
        Thread deliver2= new Thread(new Deliver("2",table));
        Thread deliver3= new Thread(new Deliver("3",table));

        cooker.start();

        deliver1.start();
        deliver2.start();
        deliver3.start();

    }
}
