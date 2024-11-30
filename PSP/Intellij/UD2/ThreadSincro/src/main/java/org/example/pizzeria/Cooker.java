package org.example.pizzeria;

import org.example.Teoria.Producer_Consumer.Pizza;

import java.text.DecimalFormat;

import static java.lang.Thread.sleep;

public class Cooker implements Runnable{
    private int idPizza=0;
    Table table= new Table();
    DecimalFormat df= new DecimalFormat("#.00");//formato para dos decimales

    public Cooker(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (table.getPizzadCocinadas()<=100){
            try {

                //el precio es un número random entre 10 y 50
                double precio= Math.random()*(40)+10;
                Pizza p= new Pizza(idPizza,precio);
                table.producir(p);
                System.out.println("Cocinero cocina pizza; "+idPizza+" con precio; "+ df.format(precio));
                sleep((long) ((Math.random()*500)+500));
                idPizza++;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
