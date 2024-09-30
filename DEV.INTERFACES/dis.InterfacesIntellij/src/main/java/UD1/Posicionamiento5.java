package UD1;
import javax.swing.*;
import java.awt.*;

public class Posicionamiento5 extends JFrame {
    public Posicionamiento5() {
        // Declaración de colores personalizados para utilizar en los paneles
        Color marron = new Color(202, 158, 97);
        Color azul = new Color(1, 80, 159);
        Color verde = new Color(56, 120, 0);
        Color magneta = new Color(240, 0, 255);
        Color naranja = new Color(255, 109, 0);
        Color rojo = new Color(252, 0, 0);
        Color aqua = new Color(71, 220, 158);

        // Configuración básica de la ventana
        setTitle("Ejercicio 5 - Grid Layout");  // Título de la ventana
        setSize(800, 600);  // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar la aplicación al cerrar la ventana

        // Crear un panel con GridBagLayout para organizar los componentes en una cuadrícula flexible
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;  // Establecer que los componentes deben llenar todo el espacio disponible
        gbc.insets = new Insets(5, 5, 5, 5);  // Añadir márgenes entre los componentes (5 píxeles)

        // Primer rectángulo (verde claro - similar al cian)
        gbc.gridx = 0;  // Posición de columna 0
        gbc.gridy = 0;  // Posición de fila 0
        gbc.gridwidth = 2;  // Este componente ocupará 2 columnas
        gbc.gridheight = 2;  // Este componente ocupará 2 filas
        gbc.weightx = 0.6;  // El componente ocupará el 60% del ancho disponible
        gbc.weighty = 0.6;  // El componente ocupará el 60% del alto disponible
        panel.add(createColoredPanel(aqua), gbc);  // Añadir el panel coloreado al panel principal

        // Segundo rectángulo (verde oscuro)
        gbc.gridx = 2;  // Colocarlo en la tercera columna (columna 2)
        gbc.gridy = 0;  // En la primera fila (fila 0)
        gbc.gridwidth = 1;  // Ocupará solo 1 columna
        gbc.gridheight = 1;  // Ocupará solo 1 fila
        gbc.weightx = 0.3;  // Ocupará el 30% del ancho
        gbc.weighty = 0.3;  // Ocupará el 30% del alto
        panel.add(createColoredPanel(verde), gbc);  // Añadir panel verde oscuro

        // Tercer rectángulo (azul)
        gbc.gridx = 2;  // Tercera columna
        gbc.gridy = 1;  // Segunda fila
        gbc.gridwidth = 1;  // 1 columna
        gbc.gridheight = 2;  // Ocupará 2 filas
        gbc.weightx = 0.3;  // 30% del ancho
        gbc.weighty = 0.6;  // 60% del alto
        panel.add(createColoredPanel(azul), gbc);  // Añadir panel azul

        // Cuarto rectángulo (rojo)
        gbc.gridx = 0;  // Primera columna
        gbc.gridy = 2;  // Tercera fila
        gbc.gridwidth = 1;  // 1 columna
        gbc.gridheight = 1;  // 1 fila
        gbc.weightx = 0.3;  // 30% del ancho
        gbc.weighty = 0.3;  // 30% del alto
        panel.add(createColoredPanel(rojo), gbc);  // Añadir panel rojo

        // Quinto rectángulo (naranja)
        gbc.gridx = 0;  // Primera columna
        gbc.gridy = 3;  // Cuarta fila
        gbc.gridwidth = 1;  // 1 columna
        gbc.gridheight = 1;  // 1 fila
        gbc.weightx = 0.3;  // 30% del ancho
        gbc.weighty = 0.3;  // 30% del alto
        panel.add(createColoredPanel(naranja), gbc);  // Añadir panel naranja

        // Sexto rectángulo (magenta)
        gbc.gridx = 1;  // Segunda columna
        gbc.gridy = 2;  // Tercera fila
        gbc.gridwidth = 1;  // 1 columna
        gbc.gridheight = 2;  // Ocupará 2 filas
        gbc.weightx = 0.3;  // 30% del ancho
        gbc.weighty = 0.6;  // 60% del alto
        panel.add(createColoredPanel(magneta), gbc);  // Añadir panel magenta

        // Séptimo rectángulo (marrón claro)
        gbc.gridx = 2;  // Tercera columna
        gbc.gridy = 3;  // Cuarta fila
        gbc.gridwidth = 1;  // 1 columna
        gbc.gridheight = 1;  // 1 fila
        gbc.weightx = 0.3;  // 30% del ancho
        gbc.weighty = 0.2;  // Ocupará solo el 20% del alto
        panel.add(createColoredPanel(marron), gbc);  // Añadir panel marrón claro

        // Añadir el panel principal a la ventana
        add(panel);
    }

    // Método para crear paneles de colores
    private JPanel createColoredPanel(Color color) {
        JPanel panel = new JPanel();  // Crear un panel
        panel.setBackground(color);  // Establecer el color de fondo
        return panel;  // Devolver el panel
    }

    public static void main(String[] args) {
        // Crear la ventana y hacerla visible
        SwingUtilities.invokeLater(() -> {
            Posicionamiento5 frame = new Posicionamiento5();  // Crear una instancia de la ventana
            frame.setVisible(true);  // Hacer la ventana visible
        });
    }
}

