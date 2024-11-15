package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad5 {
    public JFrame getactividad5(){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Actividad 5: Uso de JOptionPane");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setLayout(null);

        // Crear el botón
        JButton boton = new JButton("Ingresar Edad");
        boton.setBounds(80, 70, 140, 30);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar cuadro de diálogo para ingresar edad
                String edadIngresada = JOptionPane.showInputDialog(ventana, "Ingrese su edad:");

                // Validar si se ingresó algo
                if (edadIngresada != null) {
                    // Mostrar cuadro de diálogo con la edad ingresada
                    JOptionPane.showMessageDialog(ventana, "La edad ingresada es: " + edadIngresada);
                } else {
                    // Mensaje si no se ingresó nada
                    JOptionPane.showMessageDialog(ventana, "No ingresaste ninguna edad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        ventana.add(boton);
        ventana.setVisible(true);

        return ventana;
    }


    public static void main(String[] args) {
        Actividad5 ac5= new Actividad5();
        ac5.getactividad5();
    }
}
