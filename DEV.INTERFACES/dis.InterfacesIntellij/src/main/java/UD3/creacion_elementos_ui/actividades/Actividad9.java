package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad9 {
    public JFrame getActividad9(){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Ordenar Pizza");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLayout(null);

        // Crear una etiqueta
        JLabel etiqueta = new JLabel("Seleccione los toppings para su pizza:");
        etiqueta.setBounds(30, 20, 250, 20);

        // Crear casillas de verificación (checkboxes)
        JCheckBox quesoExtra = new JCheckBox("Queso Extra");
        quesoExtra.setBounds(30, 60, 150, 20);

        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        pepperoni.setBounds(30, 100, 150, 20);

        JCheckBox aceitunas = new JCheckBox("Aceitunas");
        aceitunas.setBounds(30, 140, 150, 20);

        // Crear botón "Ordenar"
        JButton ordenar = new JButton("Ordenar");
        ordenar.setBounds(30, 200, 120, 30);

        // Agregar funcionalidad al botón "Ordenar"
        ordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder toppingsSeleccionados = new StringBuilder("Toppings seleccionados: ");

                if (quesoExtra.isSelected()) {
                    toppingsSeleccionados.append("Queso Extra, ");
                }
                if (pepperoni.isSelected()) {
                    toppingsSeleccionados.append("Pepperoni, ");
                }
                if (aceitunas.isSelected()) {
                    toppingsSeleccionados.append("Aceitunas, ");
                }

                if (toppingsSeleccionados.toString().endsWith(", ")) {
                    // Quitar la última coma y espacio
                    toppingsSeleccionados.setLength(toppingsSeleccionados.length() - 2);
                } else {
                    toppingsSeleccionados.append("Ninguno");
                }

                // Mostrar los toppings seleccionados en la consola
                System.out.println(toppingsSeleccionados);
            }
        });

        // Agregar componentes al marco
        ventana.add(etiqueta);
        ventana.add(quesoExtra);
        ventana.add(pepperoni);
        ventana.add(aceitunas);
        ventana.add(ordenar);

        // Hacer visible la ventana
        ventana.setVisible(true);

        return  ventana;
    }

    public static void main(String[] args) {
        Actividad9 ac9= new Actividad9();
        ac9.getActividad9();
    }
}
