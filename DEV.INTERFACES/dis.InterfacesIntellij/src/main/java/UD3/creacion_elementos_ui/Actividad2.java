package UD3.creacion_elementos_ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad2 {
    public static void main(String[] args) {
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana con multiples botones");
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
        JButton aceptar = new JButton("aceptar");
        aceptar.setBounds(100, 70, 100, 30); // Posición y tamaño del botón
        panel.add(aceptar); // Agregar el botón al panel

        // Crear el botón
        JButton cancelar = new JButton("cancelar");
        cancelar.setBounds(220, 70, 100, 30); // Posición y tamaño del botón
        panel.add(cancelar); // Agregar el botón al panel

        // Añadir ActionListener al botón "Aceptar"
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar mensaje "Aceptado"
                JOptionPane.showMessageDialog(null, "Aceptado");
            }
        });

        // Añadir ActionListener al botón "Cancelar"
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Cancelado");
            }
        });
    }


}
