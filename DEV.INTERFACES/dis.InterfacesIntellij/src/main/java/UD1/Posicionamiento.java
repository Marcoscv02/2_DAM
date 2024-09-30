package UD1;

import javax.swing.*;
import java.awt.*;

public class Posicionamiento extends JFrame {

    public Posicionamiento() {
        // Declaración de colores personalizados para utilizar en los paneles
        Color marron = new Color(202, 158, 97);
        Color azul = new Color(1, 80, 159);
        Color verde = new Color(56, 120, 0);
        Color amarillo = new Color(240, 0, 255);
        Color naranja = new Color(255, 109, 0);
        Color rojo = new Color(252, 0, 0);
        Color aqua = new Color(71, 220, 158);

        // Configuración de la ventana principal (título, tamaño y comportamiento al cerrar)
        setTitle("Posicionamiento Java Swing"); // Establece el título de la ventana
        setSize(800, 600); // Define el tamaño de la ventana en píxeles (800x600)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la ventana al presionar la "X"

        // Establece el layout de la ventana como GridBagLayout (un sistema de rejilla flexible)
        setLayout(new GridBagLayout());

        // Creación de un objeto GridBagConstraints para configurar el comportamiento de los componentes en el GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Hace que los componentes llenen completamente el área asignada
        gbc.weightx =1; // Permite que las columnas se expandan (más espacio horizontal)
        gbc.weighty = 1; // Permite que las filas se expandan (más espacio vertical)

        // Creación y configuración del primer panel: COLUMNA IZQUIERDA
        JPanel colizq = new JPanel();
        colizq.setBackground(rojo); // Establece el color de fondo del panel en rojo

        // Configuración del GridBagConstraints para el panel de la izquierda
        gbc.gridx = 0; // Posición en la columna 0 (la primera columna)
        gbc.gridy = 1; // Posición en la fila 1 (la segunda fila)
        gbc.gridwidth = 2; // El panel ocupará 2 columnas de ancho
        gbc.gridheight = 2; // El panel ocupará 2 filas de alto
        gbc.weighty = 1; // Permite que crezca verticalmente cuando la ventana se redimensione

        // Añade el panel izquierdo a la ventana principal
        add(colizq, gbc);

        // Creación y configuración del segundo panel: COLUMNA DERECHA
        JPanel colder = new JPanel();
        colder.setBackground(aqua); // Establece el color de fondo del panel en color aqua

        // Configuración del GridBagConstraints para el panel derecho
        gbc.gridx = 2; // Posición en la columna 2 (la tercera columna)
        gbc.gridy = 1; // Posición en la fila 1 (la segunda fila)
        gbc.gridwidth = 1; // El panel ocupará 1 columna de ancho
        gbc.gridheight = 2; // El panel ocupará 2 filas de alto
        gbc.weighty = 1; // Permite que crezca verticalmente cuando la ventana se redimensione

        // Añade el panel derecho a la ventana principal
        add(colder, gbc);

        // Creación y configuración del tercer panel: DERECHA SUPERIOR
        JPanel derup = new JPanel();
        derup.setBackground(verde); // Establece el color de fondo del panel en color verde

        // Configuración del GridBagConstraints para el panel derecho superior
        gbc.gridx = 0; // Posición en la columna 0 (la primera columna)
        gbc.gridy = 1; // Posición en la fila 1 (la segunda fila)
        gbc.gridwidth = 1; // El panel ocupará 1 columna de ancho
        gbc.gridheight = 2; // El panel ocupará 2 filas de alto
        gbc.weighty = 1; // Permite que crezca verticalmente cuando la ventana se redimensione

        // Añade el panel superior derecho a la ventana principal
        add(derup, colder);

        // Hace visible la ventana
        setVisible(true);
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        new Posicionamiento(); // Crea una instancia de la ventana Posicionamiento y la muestra
    }
}
