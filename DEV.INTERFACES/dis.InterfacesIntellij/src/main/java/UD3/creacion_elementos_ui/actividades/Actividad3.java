package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad3 {

    public  JFrame getVentana3(){

        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana con campo de texto");
        ventana.setSize(400, 200); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel();
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el campo de texto
        JTextField campoTexto = new JTextField(20);
        campoTexto.setBounds(100, 50, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoTexto); // Agregar el campo de texto al panel

        // Crear el botón
        JButton nombre = new JButton("Mostrar nombre");
        nombre.setBounds(100, 110, 200, 30); // Posición y tamaño del botón
        panel.add(nombre); // Agregar el botón al panel



        // Añadir ActionListener al botón "Cancelar"
        nombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= campoTexto.getText();
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Nombre: "+nombre);
            }
        });
        // Hacer visible la ventana
        ventana.setVisible(true);

        return ventana;
    }

    public static void main(String[] args) {
        Actividad3 ac3= new Actividad3();

        ac3.getVentana3();
    }

}
