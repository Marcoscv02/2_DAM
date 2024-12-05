package org.example.pizzeria;

import org.example.Teoria.Producer_Consumer.Pizza;

import java.text.DecimalFormat;

import static java.lang.Thread.sleep;

public class Deliver implements Runnable{
    private String name;
    Table table= new Table();
    private int contadorTotal=0;
    DecimalFormat df= new DecimalFormat("#.00");//formato para dos decimales

    public Deliver(String name, Table table) {
        this.name= name;
        this.table = table;
    }

    @Override
    public void run() {
      while (table.getPizzadCocinadas()<=100){
          try {
              Pizza p= table.consumir();
              System.out.println("Repaertidor"+name+" recoje pizza "+p.getId()+" con un precio de "+df.format(p.getPrecio())+" y la entrega");
              sleep((long) ((Math.random()*1000)+1000));
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }
      System.exit(0);
    }

}
