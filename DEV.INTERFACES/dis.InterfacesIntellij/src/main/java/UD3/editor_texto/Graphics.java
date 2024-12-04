package UD3.editor_texto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Graphics {
    public JFrame getGraphics() {
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Editor de Texto");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLayout(new BorderLayout());
        ventana.setLocationRelativeTo(null); // Centrar la ventana


        // Crear el área de texto con un JScrollPane
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Crear la barra de herramientas
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false); // Desactivar la capacidad de mover la barra

        // Crear botones para la barra de herramientas
        JButton btnAbrir = new JButton("Abrir");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnSalir = new JButton("Salir");

        // Agregar botones a la barra de herramientas
        toolBar.add(btnAbrir);
        toolBar.add(btnGuardar);
        toolBar.add(btnSalir);

        // Agregar acciones a los botones
        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(ventana);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.read(reader, null);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ventana, "Error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(ventana);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        textArea.write(writer);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ventana, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Agregar componentes al marco
        ventana.add(toolBar, BorderLayout.NORTH);
        ventana.add(scrollPane, BorderLayout.CENTER);

        // Mostrar el marco
        ventana.setVisible(true);
        return ventana;
    }
}
