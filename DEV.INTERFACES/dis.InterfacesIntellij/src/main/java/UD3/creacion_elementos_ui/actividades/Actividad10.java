package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad10 {
    public JFrame getVentana10 (){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Menú de Barra");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setLayout(null);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear los menús principales
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuEdicion = new JMenu("Edición");

        // Crear los submenús de "Archivo"
        JMenuItem menuAbrir = new JMenuItem("Abrir");
        JMenuItem menuGuardar = new JMenuItem("Guardar");

        // Agregar submenús al menú "Archivo"
        menuArchivo.add(menuAbrir);
        menuArchivo.add(menuGuardar);

        // Agregar menús principales a la barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(menuEdicion);

        // Agregar la barra de menú al marco
        ventana.setJMenuBar(menuBar);

        // Acción para "Abrir"
        menuAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seleccionaste la opción: Abrir");
            }
        });

        // Acción para "Guardar"
        menuGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seleccionaste la opción: Guardar");
            }
        });

        // Mostrar el marco
        ventana.setVisible(true);
        return ventana;
    }

    public static void main(String[] args) {
        Actividad10 ac10= new Actividad10();

        ac10.getVentana10();
    }
}
