package org.example.REPASO.pizzas;

public class Pizza {
    private int id;
    private double precio;

    public Pizza() {
    }

    public Pizza(int id, double precio) {
        this.id = id;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
