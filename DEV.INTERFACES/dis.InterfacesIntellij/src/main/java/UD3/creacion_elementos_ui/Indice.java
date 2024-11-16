package UD3.creacion_elementos_ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Indice {
    public static void main(String[] args) {
        Actividades ac = new Actividades();
        // Lista para almacenar las ventanas abiertas
        List<JFrame> ventanasAbiertas= new ArrayList<>();

        // Crear el marco principal (ventana índice)
        JFrame ventana = new JFrame("ventanas simples");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 300);
        ventana.setLayout(null);

        // Crear una etiqueta
        JLabel etiqueta = new JLabel("Seleccione la ventana que desea abrir:");
        etiqueta.setBounds(60, 20, 500, 20);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 24));
        ventana.add(etiqueta);

        // Crear el botón Cerrar todo
        JButton cerrarTodo = new JButton("Cerrar todas las ventanas");
        cerrarTodo.setBounds(30, 75, 200, 30); // Posición y tamaño del botón
        ventana.add(cerrarTodo);

        // Acción del botón "Cerrar todas las ventanas"
        cerrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar todas las ventanas de la lista
                for (JFrame frame : ventanasAbiertas) {
                    frame.dispose();
                }
                ventanasAbiertas.clear(); // Vaciar la lista
            }
        });

        //Accion del boton "Abrir todas las vetanas"
        JButton abrirTodo= new JButton("Abrir todas las ventanas");
        abrirTodo.setBounds(330, 75, 200, 30); // Posición y tamaño del botón
        ventana.add(abrirTodo);

        abrirTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana1=ac.getVentana1();
                ventanasAbiertas.add(ventana1);
                JFrame ventana2= ac.getventana2();
                ventanasAbiertas.add(ventana2);

                JFrame ventana3= ac.getVentana3();
                ventanasAbiertas.add(ventana3);

                JFrame ventana4=ac.getventana4();
                ventanasAbiertas.add(ventana4);

                JFrame ventana5=ac.getactividad5();
                ventanasAbiertas.add(ventana5);

                JFrame ventana6=ac.getActividad6();
                ventanasAbiertas.add(ventana6);

                JFrame ventana7=ac.getventana7();
                ventanasAbiertas.add(ventana7);

                JFrame ventana8=ac.getventana8();
                ventanasAbiertas.add(ventana8);

                JFrame ventana9=ac.getActividad9();
                ventanasAbiertas.add(ventana9);

                JFrame ventana10=ac.getVentana10();
                ventanasAbiertas.add(ventana10);

            }
        });



        //BOTONES PARA VENTANAS INDIVIDUALES
        // Crear el botón getVentana1
        JButton ventana1 = new JButton("ventana1");
        ventana1.setBounds(30, 140, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana1); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana1"
        ventana1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana1= ac.getVentana1();
                ventanasAbiertas.add(ventana1);
            }
        });

        // Crear el botón getVentana2
        JButton ventana2 = new JButton("ventana2");
        ventana2.setBounds(130, 140, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana2); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana2"
        ventana2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana2= ac.getventana2();
                ventanasAbiertas.add(ventana2);
            }
        });


        // Crear el botón getVentana3
        JButton ventana3 = new JButton("ventana3");
        ventana3.setBounds(230, 140, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana3); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana3"
        ventana3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana3= ac.getVentana3();
                ventanasAbiertas.add(ventana3);
            }
        });

        // Crear el botón getVentana4
        JButton ventana4 = new JButton("ventana4");
        ventana4.setBounds(330, 140, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana4); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana4"
        ventana4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana4= ac.getventana4();
                ventanasAbiertas.add(ventana4);
            }
        });

        // Crear el botón getVentana5
        JButton ventana5 = new JButton("ventana5");
        ventana5.setBounds(430, 140, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana5); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana5"
        ventana5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana5= ac.getactividad5();
                ventanasAbiertas.add(ventana5);
            }
        });

        // Crear el botón getVentana6
        JButton ventana6 = new JButton("ventana6");
        ventana6.setBounds(30, 200, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana6); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana2"
        ventana6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana6= ac.getActividad6();
                ventanasAbiertas.add(ventana6);
            }
        });


        // Crear el botón getVentana7
        JButton ventana7 = new JButton("ventana7");
        ventana7.setBounds(130, 200, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana7); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana7"
        ventana7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana7= ac.getventana7();
                ventanasAbiertas.add(ventana7);
            }
        });

        // Crear el botón getVentana8
        JButton ventana8 = new JButton("ventana8");
        ventana8.setBounds(230, 200, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana8); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana4"
        ventana8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana8= ac.getventana8();
                ventanasAbiertas.add(ventana8);
            }
        });

        // Crear el botón getVentana9
        JButton ventana9 = new JButton("ventana9");
        ventana9.setBounds(330, 200, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana9); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana7"
        ventana9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana9= ac.getActividad9();
                ventanasAbiertas.add(ventana9);
            }
        });

        // Crear el botón getVentana10
        JButton ventana10 = new JButton("ventana10");
        ventana10.setBounds(430, 200, 100, 30); // Posición y tamaño del botón
        ventana.add(ventana10); // Agregar el botón al panel

        // Añadir ActionListener al botón "getVentana4"
        ventana10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana10= ac.getVentana10();
                ventanasAbiertas.add(ventana10);
            }
        });


        ventana.setVisible(true);

    }
}
