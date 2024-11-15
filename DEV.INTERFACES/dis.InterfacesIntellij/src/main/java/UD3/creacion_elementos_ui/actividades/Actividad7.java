package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad7 {

    public JFrame getventana7(){
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana log in");
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
        JPasswordField campoContraseña = new JPasswordField(20);
        campoContraseña.setBounds(100, 100, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoContraseña); // Agregar el campo de texto al panel

        // Crear el botón
        JButton saludo = new JButton("Insertar");
        saludo.setBounds(100, 140, 200, 30); // Posición y tamaño del botón
        panel.add(saludo); // Agregar el botón al panel



        // Añadir ActionListener al botón "Cancelar"
        saludo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= campoNombre.getText();
                String apellido=campoContraseña.getText();
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Nombre: "+nombre+" \nContraseña: "+apellido);
            }
        });


        // Hacer visible la ventana
        ventana.setVisible(true);


        return ventana;
    }

    public static void main(String[] args) {
        Actividad7 ac7= new Actividad7();

        ac7.getventana7();
    }
}
