package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad4 {



    public JFrame getventana4(){
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana con multiples botones");
        ventana.setSize(400, 300); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel(); // Crear un panel para agregar el botón
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el campo de texto
        JTextField campoNombre = new JTextField(20);
        campoNombre.setBounds(100, 50, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoNombre); // Agregar el campo de texto al panel

        // Crear el campo de texto
        JTextField campoApellido = new JTextField(20);
        campoApellido.setBounds(100, 100, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoApellido); // Agregar el campo de texto al panel

        // Crear el botón
        JButton saludo = new JButton("Saludar");
        saludo.setBounds(100, 140, 200, 30); // Posición y tamaño del botón
        panel.add(saludo); // Agregar el botón al panel



        // Añadir ActionListener al botón "Cancelar"
        saludo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= campoNombre.getText();
                String apellido=campoApellido.getText();
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Saludos Terrícola "+nombre+apellido+"!!");
            }
        });


        // Hacer visible la ventana
        ventana.setVisible(true);


        return ventana;
    }

    public static void main(String[] args) {
        Actividad4 ac4= new Actividad4();

        ac4.getventana4();
    }
}
