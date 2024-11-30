package org.example.pizzeria;

import org.example.Teoria.Producer_Consumer.Pizza;

import java.util.LinkedList;
import java.util.Queue;

public class Table {
    private Queue<Pizza> bandeja= new LinkedList<>(); //Se utiliza la interfaz Queue para poder utilizar posteriormente el metodo poll()
    Pizza pizza= new Pizza();
    private int capacidadMaxima=5;
    private int pizzasCocinadas=0;

    //Metodo para añadir Pizza a ala bandeja
    synchronized public void producir(Pizza p) throws InterruptedException {
        //Si la bandeja esá en su capacidad máxima esperar
        while (bandeja.size() == capacidadMaxima){
            wait();
        }
        bandeja.add(p);
        pizzasCocinadas++;
        notifyAll();

    }

    //Metodo para consumir pizza de la bandeja
    synchronized public Pizza consumir() throws InterruptedException {
        //Esperar si la bandeja está vacía
        while (bandeja.isEmpty()){
            wait();
        }
        Pizza p= bandeja.poll();
        notifyAll();

        return p;
    }

    public int getPizzadCocinadas(){
        return pizzasCocinadas;
    }


}
