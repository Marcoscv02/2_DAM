package UD3.creacion_elementos_ui.actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad8 {
    public JFrame getventana8(){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Opciones de Pago");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLayout(null);

        // Crear una etiqueta
        JLabel etiqueta = new JLabel("Seleccione un método de pago:");
        etiqueta.setBounds(30, 20, 200, 20);

        // Crear botones de opción
        JRadioButton tarjetaCredito = new JRadioButton("Tarjeta de Crédito");
        tarjetaCredito.setBounds(30, 60, 200, 20);

        JRadioButton paypal = new JRadioButton("PayPal");
        paypal.setBounds(30, 100, 200, 20);

        JRadioButton transferencia = new JRadioButton("Transferencia Bancaria");
        transferencia.setBounds(30, 140, 200, 20);

        // Agrupar los botones de opción
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(tarjetaCredito);
        grupoBotones.add(paypal);
        grupoBotones.add(transferencia);

        // Crear un botón de "Confirmar"
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBounds(30, 200, 120, 30);

        // Agregar funcionalidad al botón "Confirmar"
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metodoSeleccionado = null;

                if (tarjetaCredito.isSelected()) {
                    metodoSeleccionado = "Tarjeta de Crédito";
                } else if (paypal.isSelected()) {
                    metodoSeleccionado = "PayPal";
                } else if (transferencia.isSelected()) {
                    metodoSeleccionado = "Transferencia Bancaria";
                }

                if (metodoSeleccionado != null) {
                    System.out.println("Método de pago seleccionado: " + metodoSeleccionado);
                } else {
                    System.out.println("No se ha seleccionado ningún método de pago.");
                }
            }
        });

        // Agregar componentes al marco
        ventana.add(etiqueta);
        ventana.add(tarjetaCredito);
        ventana.add(paypal);
        ventana.add(transferencia);
        ventana.add(confirmar);

        // Hacer visible la ventana
        ventana.setVisible(true);
        return ventana;
    }

    public static void main(String[] args) {
        Actividad8 ac8= new Actividad8();
        ac8.getventana8();
    }
}
