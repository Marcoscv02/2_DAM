package org.example;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Gson gson= new Gson();
        GregorianCalendar g= new GregorianCalendar(2024, Calendar.OCTOBER, 14,9,5);
        
        Prueba p=new Prueba("Marcos",22, LocalDate.of(2024,10,14));
        
        String json= gson.toJson(p);
        System.out.println("json = " + json);
    }
}