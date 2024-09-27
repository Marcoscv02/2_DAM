package UD1;
import javax.swing.*;
import java.awt.*;

public class Posicionamiento extends JFrame {
    public void posicionamiento(){
        JFrame frame=new JFrame(); //se crea la ventana principal
        frame.setTitle("Posicionamiento Java Swimg");
        frame.setSize(800,600); //tamaño da ventana en px
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //accion ao cerrar a ventana
        frame.setLayout(new GridBagLayout); //tipo de layout da ventana


    }

    public static void main(String[] args) {
        new Posicionamiento();
    }
}
