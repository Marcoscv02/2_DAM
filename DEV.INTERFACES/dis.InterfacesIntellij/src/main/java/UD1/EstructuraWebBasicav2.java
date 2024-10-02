package UD1;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class EstructuraWebBasicav2 extends JFrame {

    public EstructuraWebBasicav2() {
        setTitle("Estructura Web Básica"); // Establece el título de la ventana
        setSize(800, 600); // Establece el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación cuando se cierra la ventana
        setLayout(new GridBagLayout()); // Establece el layout principal como GridBagLayout para organizar los componentes

        // Crear el objeto GridBagConstraints para controlar la posición y el tamaño de los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Hace que los componentes llenen su área asignada
        gbc.weightx = 1; // Peso horizontal
        gbc.weighty = 1; // Peso vertical

        // DEFINICIÓN DE COLORES
        Color rojo = new Color(210, 73, 58); // Color rojo personalizado
        Color amarillo = new Color(203, 190, 130); // Color amarillo personalizado

        // HEADER SUPERIOR
        JPanel header = new JPanel(); // Crear un panel para el header
        header.setBorder(new MatteBorder(0, 0, 10, 0, Color.WHITE)); // Establece un borde blanco en la parte inferior
        header.setBackground(rojo); // Establece el fondo rojo para el header

        // Etiqueta para el header
        JLabel headerLabel = new JLabel("cabeceira");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Establece la fuente de la etiqueta
        headerLabel.setForeground(Color.white); // Establece el color del texto en blanco
        header.add(headerLabel); // Agrega la etiqueta al panel del header

        // Configuración del layout del header
        gbc.gridx = 0; // Colocar el header en la columna 0
        gbc.gridy = 0; // Colocar el header en la fila 0
        gbc.gridwidth = 3; // Hace que el header ocupe tres columnas de ancho
        gbc.gridheight = 1; // Hace que el header ocupe una fila de altura
        gbc.weighty = 0; // Sin peso vertical, para que no se expanda verticalmente
        add(header, gbc); // Agrega el header a la ventana

        // NAV (menú de navegación)
        JPanel nav = new JPanel(); // Crear un panel para el menú de navegación
        nav.setBorder(new MatteBorder(0, 0, 0, 10, Color.WHITE)); // Establece un borde blanco a la derecha
        nav.setBackground(rojo); // Establece el fondo rojo para el nav

        // Etiqueta para la navegación
        JLabel navLabel = new JLabel("Menu");
        navLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Establece la fuente de la etiqueta
        navLabel.setForeground(Color.white); // Establece el color del texto en blanco
        nav.add(navLabel); // Agrega la etiqueta al panel del nav

        // Configuración del layout del nav
        gbc.gridx = 0; // Colocar el nav en la columna 0
        gbc.gridy = 1; // Colocar el nav en la fila 1
        gbc.gridwidth = 1; // El nav ocupa una columna de ancho
        gbc.gridheight = 2; // El nav ocupa dos filas de altura
        gbc.weighty = 1; // Peso vertical, para que se expanda verticalmente
        gbc.weightx = 0.3; // Establece el 30% de ancho para el nav
        add(nav, gbc); // Agrega el nav a la ventana

        // SECTION (contenido principal)
        JPanel section = new JPanel(new GridBagLayout()); // Crear un panel con GridBagLayout para el contenido principal
        section.setBackground(rojo); // Establece el fondo rojo para la sección
        GridBagConstraints gbcSection = new GridBagConstraints(); // Crear un GridBagConstraints para los componentes dentro de la sección
        section.setBorder(new MatteBorder(-130, 0, 0, 0, rojo)); // Bordes del section

        gbcSection.fill = GridBagConstraints.BOTH; // Hace que los componentes llenen su área asignada
        gbcSection.weightx = 0.7; // Establece el 70% de ancho para el section
        gbcSection.weighty = 1; // Peso vertical, para que se expanda verticalmente

        // HEADER2 (dentro de SECTION)
        JPanel header2 = new JPanel(); // Crear un panel para el header dentro del section
        header2.setBorder(new MatteBorder(50, 10, 10, 10, rojo)); // Establece bordes en el header2
        header2.setBackground(amarillo); // Fondo amarillo para el header2
        JLabel header2Label = new JLabel("artigo");
        header2Label.setFont(new Font("Arial", Font.BOLD, 30)); // Fuente del texto del header2
        header2Label.setForeground(Color.white); // Texto en blanco
        header2.add(header2Label); // Agregar etiqueta al header2

        // Configuración del layout de header2
        gbcSection.gridx = 0; // Colocar el header2 en la columna 0 del section
        gbcSection.gridy = 0; // Colocar el header2 en la fila 0 del section
        gbcSection.gridwidth = 2; // Ocupar dos columnas de ancho
        gbcSection.gridheight = 1; // Ocupar una fila de altura
        gbcSection.weighty = 1; // Peso vertical, para que se expanda verticalmente
        section.add(header2, gbcSection); // Agrega header2 al section

        // ARTICLE (dentro de SECTION)
        JPanel article = new JPanel(); // Crear un panel para el artículo dentro del section
        article.setBorder(new MatteBorder(0, 10, 10, 10, rojo)); // Bordes en el artículo
        article.setBackground(amarillo); // Fondo amarillo para el artículo
        JLabel articleLabel = new JLabel("artigo");
        articleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Fuente del texto del artículo
        articleLabel.setForeground(Color.white); // Texto en blanco
        article.add(articleLabel); // Agregar etiqueta al artículo

        // Configuración del layout de article
        gbcSection.gridx = 0; // Colocar el artículo en la columna 0 del section
        gbcSection.gridy = 1; // Colocar el artículo en la fila 1 del section
        gbcSection.weighty = 0.5; // Peso vertical, más pequeño que header2
        section.add(article, gbcSection); // Agrega artículo al section

        // FOOTER2 (dentro de SECTION)
        JPanel footer2 = new JPanel(); // Crear un panel para el footer2 dentro del section
        footer2.setBorder(new MatteBorder(0, 10, 10, 10, rojo)); // Bordes en footer2
        footer2.setBackground(amarillo); // Fondo amarillo para footer2
        JLabel footer2Label = new JLabel("artigo");
        footer2Label.setFont(new Font("Arial", Font.BOLD, 30)); // Fuente del texto del footer2
        footer2Label.setForeground(Color.white); // Texto en blanco
        footer2.add(footer2Label); // Agregar etiqueta a footer2

        // Configuración del layout de footer2
        gbcSection.gridx = 0; // Colocar footer2 en la columna 0 del section
        gbcSection.gridy = 2; // Colocar footer2 en la fila 2 del section
        gbcSection.weighty = 0.1; // Peso vertical pequeño
        section.add(footer2, gbcSection); // Agrega footer2 al section

        // Agregar la sección principal al layout principal
        gbc.gridx = 1; // Colocar la sección en la columna 1
        gbc.gridy = 1; // Colocar la sección en la fila 1
        gbc.gridwidth = 1; // Ocupar una columna de ancho
        gbc.gridheight = 2; // Ocupar dos filas de altura
        gbc.weightx = 0.7; // Establece el 70% de ancho para el section
        add(section, gbc); // Agrega la sección al layout principal

        // FOOTER (footer principal)
        JPanel footer = new JPanel(); // Crear un panel para el footer
        footer.setBorder(new MatteBorder(10, 0, 0, 0, Color.WHITE)); // Borde superior blanco en el footer
        footer.setBackground(rojo); // Fondo rojo para el footer
        JLabel footerLabel = new JLabel("pé");
        footerLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Fuente del texto del footer
        footerLabel.setForeground(Color.white); // Texto en blanco
        footer.add(footerLabel); // Agregar etiqueta al footer

        // Configuración del layout de footer
        gbc.gridx = 0; // Colocar el footer en la columna 0
        gbc.gridy = 3; // Colocar el footer en la fila 3
        gbc.gridwidth = 3; // Ocupar tres columnas de ancho
        gbc.gridheight = 1; // Ocupar dos filas de altura
        gbc.weighty = 0.1;// Establece el 70% de ancho para el section
        add(footer, gbc);

        // Hace visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new EstructuraWebBasicav2();
    }
}

