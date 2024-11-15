package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad6 {
    public JFrame getActividad6 (){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Actividad 6: Menú Desplegable");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setLayout(null);

        // Crear etiquetas y menú desplegable
        JLabel etiqueta = new JLabel("Seleccione un color:");
        etiqueta.setBounds(30, 30, 150, 20);

        String[] colores = {"Rojo", "Verde", "Azul"};
        JComboBox<String> comboBox = new JComboBox<>(colores);
        comboBox.setBounds(30, 60, 100, 25);

        // Agregar acción al menú desplegable
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String colorSeleccionado = (String) comboBox.getSelectedItem();
                System.out.println("Color seleccionado: " + colorSeleccionado);
            }
        });

        // Agregar componentes al marco
        ventana.add(etiqueta);
        ventana.add(comboBox);

        // Hacer visible la ventana
        ventana.setVisible(true);

        return ventana;
    }

    public static void main(String[] args) {
        Actividad6 ac6= new Actividad6();

        ac6.getActividad6();
    }
}
