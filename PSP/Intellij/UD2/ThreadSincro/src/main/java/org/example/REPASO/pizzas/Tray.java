package org.example.REPASO.pizzas;


import java.text.DecimalFormat;
import java.util.LinkedList;

public class Tray {
    LinkedList<Pizza> bandeja= new LinkedList<>();
    public static final int CAPACIDAD = 5;
    int pizzasCocinadas=1;
    DecimalFormat df= new DecimalFormat("#.00");



    synchronized public Pizza recogerPizza () throws InterruptedException {
        while (bandeja.isEmpty()){
            wait();
            System.out.println("Todavía no hay pizzas para entregar");
        }
        Pizza p = bandeja.poll();
        notifyAll();
        return p;
    }

    synchronized public void cocinarPizza(Pizza p) throws InterruptedException {
        while (bandeja.size()==CAPACIDAD){
            wait();
            System.out.println("Barra llena, cocinero debe esperar");
        }
        pizzasCocinadas++;
        bandeja.add(p);
        notifyAll();
        System.out.println("Cocinero ha puesto pizza "+p.getId()+" que vale "+df.format(p.getPrecio())+"€");
    }

    public int getTotalPizzas(){
        return pizzasCocinadas;
    }
}
