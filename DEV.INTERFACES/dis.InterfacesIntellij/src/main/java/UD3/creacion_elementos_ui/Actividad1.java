package UD3.creacion_elementos_ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad1 {

    public static void main(String[] args) {
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana Básica");
        ventana.setSize(400, 200); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel();
        ventana.add(panel); // Agregar el panel a la ventana
        colocarComponentes(panel); // Método para colocar el botón en el panel

        // Hacer visible la ventana
        ventana.setVisible(true);
    }

    private static void colocarComponentes(JPanel panel) {
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
    }
}

