package UD3.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class calculator {
    private static JTextField campoNums;
    private static int primerNumero;
    private static String operacion;
    private static boolean nuevaOperacion;

    public static void main(String[] args) {
        List<JButton>botones= new ArrayList<>();

        JFrame ventana= new JFrame("Calculadora");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(630, 650);
        ventana.setLayout(null);


        //TextField superior
        campoNums= new JTextField();
        campoNums.setBounds(50, 60,520, 40);
        campoNums.setFont(new Font("Arial", Font.PLAIN, 29));
        campoNums.setEditable(false);
        ventana.add(campoNums);

        //Panel Números
        JPanel panelnums= new JPanel();
        panelnums.setBounds(50, 150, 290, 310);
        panelnums.setLayout(null);
        ventana.add(panelnums);

        //Botones números
        JButton btn1= new JButton("1");
        btn1.setBounds(0,0,90,90);
        botones.add(btn1);
        panelnums.add(btn1);

        JButton btn2 = new JButton("2");
        btn2.setBounds(100,0,90,90);
        botones.add(btn2);
        panelnums.add(btn2);

        JButton btn3 = new JButton("3");
        btn3.setBounds(200,0,90,90);
        botones.add(btn3);
        panelnums.add(btn3);

        JButton btn4= new JButton("4");
        btn4.setBounds(0,110,90,90);
        botones.add(btn4);
        panelnums.add(btn4);

        JButton btn5 = new JButton("5");
        btn5.setBounds(100,110,90,90);
        botones.add(btn5);
        panelnums.add(btn5);

        JButton btn6= new JButton("6");
        btn6.setBounds(200,110,90,90);
        botones.add(btn6);
        panelnums.add(btn6);

        JButton btn7= new JButton("7");
        btn7.setBounds(0,220,90,90);
        botones.add(btn7);
        panelnums.add(btn7);

        JButton btn8 = new JButton("8");
        btn8.setBounds(100,220,90,90);
        botones.add(btn8);
        panelnums.add(btn8);

        JButton btn9= new JButton("9");
        btn9.setBounds(200,220,90,90);
        botones.add(btn9);
        panelnums.add(btn9);

        //Panel Números
        JPanel panelOperations= new JPanel();
        panelOperations.setBounds(380, 150, 190, 310);
        panelOperations.setLayout(null);
        ventana.add(panelOperations);

        //Botones de Operaciones
        JButton sumar= new JButton("+");
        sumar.setBounds(0,0,90,90);
        botones.add(sumar);
        panelOperations.add(sumar);

        JButton restar = new JButton("-");
        restar.setBounds(100,0,90,90);
        botones.add(restar);
        panelOperations.add(restar);

        JButton multiplicar= new JButton("*");
        multiplicar.setBounds(0,110,90,90);
        botones.add(multiplicar);
        panelOperations.add(multiplicar);

        JButton dividir = new JButton("/");
        dividir.setBounds(100,110,90,90);
        botones.add(dividir);
        panelOperations.add(dividir);

        JButton cero= new JButton("0");
        cero.setBounds(0,220,90,90);
        botones.add(cero);
        panelOperations.add(cero);

        JButton borrar = new JButton("C");
        borrar.setBounds(100,220,90,90);
        botones.add(borrar);
        panelOperations.add(borrar);

        JButton igual = new JButton("=");
        igual.setBounds(200,500,200,90);
        botones.add(igual);
        ventana.add(igual);

        for (JButton boton:botones){
            boton.setFont(new Font("Arial", Font.PLAIN, 20));
            boton.addActionListener(new BotonListener());
        }


        ventana.setVisible(true);
    }

    // Clase estática para manejar los eventos de los botones
    private static class BotonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtiene el texto del botón que fue presionado
            String comando = e.getActionCommand();

            // Si el comando es un número (del 0 al 9)
            if ("0123456789".contains(comando)) {
                // Si se está iniciando una nueva operación, reemplaza el contenido actual
                if (nuevaOperacion) {
                    campoNums.setText(comando);
                    nuevaOperacion = false; // Resetea el estado de nueva operación
                } else {
                    // Añade el número presionado al contenido existente
                    campoNums.setText(campoNums.getText() + comando);
                }
            }
            // Si el comando es una operación (+, -, *, /)
            else if ("+-*/".contains(comando)) {
                // Almacena el número actualmente visible en el campo de texto
                primerNumero = Integer.parseInt(campoNums.getText());
                // Almacena la operación seleccionada
                operacion = comando;
                // Activa el estado de nueva operación para recibir el segundo número
                nuevaOperacion = true;
            }
            // Si el comando es "=" (calcular el resultado)
            else if ("=".equals(comando)) {
                // Obtiene el segundo número ingresado
                int segundoNumero = Integer.parseInt(campoNums.getText());
                int resultado = 0; // Variable para almacenar el resultado de la operación

                // Realiza la operación seleccionada previamente
                switch (operacion) {
                    case "+" -> resultado = primerNumero + segundoNumero; // Suma
                    case "-" -> resultado = primerNumero - segundoNumero; // Resta
                    case "*" -> resultado = primerNumero * segundoNumero; // Multiplicación
                    case "/" -> {
                        // Manejo de error: división por 0
                        if (segundoNumero == 0) {
                            campoNums.setText("Error"); // Muestra mensaje de error
                            return; // Termina la ejecución
                        }
                        resultado = primerNumero / segundoNumero; // División
                    }
                }
                // Muestra el resultado en el campo de texto
                campoNums.setText(String.valueOf(resultado));
                // Activa el estado de nueva operación para futuras acciones
                nuevaOperacion = true;
            }
            // Si el comando es "C" (limpiar)
            else if ("C".equals(comando)) {
                // Limpia el campo de texto
                campoNums.setText("");
                // Reinicia las variables de la calculadora
                primerNumero = 0;
                operacion = "";
                nuevaOperacion = false;
            }
        }
    }
}
