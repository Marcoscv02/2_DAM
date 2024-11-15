package UD3.creacion_elementos_ui.actividades;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad1 {

    public JFrame getVentana1(){

        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana Básica");
        ventana.setSize(400, 200); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel();
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el botón
        JButton boton = new JButton("Presióname");
        boton.setBounds(150, 70, 100, 30); // Posición y tamaño del botón
        panel.add(boton); // Agregar el botón al panel

        // Añadir ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("¡Botón presionado!"); // Mensaje en la consola
            }
        });

        // Hacer visible la ventana
        ventana.setVisible(true);

        return ventana;
    }

    public static void main(String[] args) {
        Actividad1 ac1= new Actividad1();
        ac1.getVentana1();
    }
}

