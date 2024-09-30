package UD1;

import java.awt.*;
import javax.swing.*;

public class Posicionamiento2 extends JFrame {

    public Posicionamiento2() {
        //Configuración de la ventana
        setTitle("UD2.P2-Exercicio 5");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel principal con diseño de caja
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //Panel izquierdo
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(480, 600));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Panel superior izquierdo
        JPanel leftTop = new JPanel();
        leftTop.setBackground(Color.cyan);
        leftTop.setPreferredSize(new Dimension(480, 290));
        leftTop.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        //Panel inferior izquierdo
        JPanel leftBottom = new JPanel();
        leftBottom.setLayout(new BorderLayout());
        leftBottom.setPreferredSize(new Dimension(480, 290));
        leftBottom.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        //Panel inferior izquierdo superior
        JPanel leftBottomTop = new JPanel();
        leftBottomTop.setLayout(new BorderLayout());
        leftBottomTop.setPreferredSize(new Dimension(200, 290));
        leftBottomTop.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Panel rojo en la parte superior del panel inferior izquierdo
        JPanel leftBottomBottomTop = new JPanel();
        leftBottomBottomTop.setBackground(Color.red);
        leftBottomBottomTop.setPreferredSize(new Dimension(200, 85));
        leftBottomBottomTop.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        //Panel naranja en la parte inferior del panel inferior izquierdo
        JPanel leftBottomBottomBottom = new JPanel();
        leftBottomBottomBottom.setBackground(Color.orange);
        leftBottomBottomBottom.setPreferredSize(new Dimension(200, 165));
        leftBottomBottomBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Panel fucsia en el panel inferior izquierdo
        JPanel leftBottomBottom = new JPanel();
        leftBottomBottom.setBackground(Color.magenta);	//fuchsia no existe en Java como color básico
        leftBottomBottom.setPreferredSize(new Dimension(260, 290));
        leftBottomBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        leftBottomTop.add(leftBottomBottomTop, BorderLayout.NORTH);
        leftBottomTop.add(leftBottomBottomBottom, BorderLayout.SOUTH);
        leftBottom.add(leftBottomTop, BorderLayout.WEST);
        leftBottom.add(leftBottomBottom, BorderLayout.EAST);

        leftPanel.add(leftTop, BorderLayout.NORTH);
        leftPanel.add(leftBottom, BorderLayout.CENTER);

        //Panel derecho
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(250, 580));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Panel verde en la parte superior del panel derecho
        JPanel rightTop = new JPanel();
        rightTop.setBackground(Color.green);
        rightTop.setPreferredSize(new Dimension(240, 100));
        rightTop.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        //Panel azul en el centro del panel derecho
        JPanel rightCenter = new JPanel();
        rightCenter.setBackground(new Color(0, 59, 94)); // Azul oscuro
        rightCenter.setPreferredSize(new Dimension(240, 300));
        rightCenter.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        //Panel marrón en la parte inferior del panel derecho
        JPanel rightBottom = new JPanel();
        rightBottom.setBackground(new Color(163, 128, 85)); // Marrón
        rightBottom.setPreferredSize(new Dimension(240, 100));
        rightBottom.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        rightPanel.add(rightTop, BorderLayout.NORTH);
        rightPanel.add(rightCenter, BorderLayout.CENTER);
        rightPanel.add(rightBottom, BorderLayout.SOUTH);

        //Añade los paneles a la ventana principal
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        add(mainPanel);
    }

    public static void main(String[] args) {
        //Crear la ventana
        SwingUtilities.invokeLater(() -> {
            Posicionamiento2 frame = new Posicionamiento2();
            frame.setVisible(true);
        });
    }
}
