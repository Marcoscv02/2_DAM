package UD3.validacion_formulario;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Formulario de Registro");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 700);
        ventana.setLayout(null);


        // Crear una etiqueta
        JLabel etiqueta = new JLabel("Seleccione la ventana que desea abrir:");
        etiqueta.setBounds(60, 20, 500, 20);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 24));
        ventana.add(etiqueta);

        // Etiquetas y campos de texto
        JLabel labelNombre = new JLabel("Nombre:");
        JTextField textNombre = new JTextField();
        labelNombre.setBounds(60, 100, 100, 20);
        textNombre.setBounds(300, 90, 200, 40);
        JLabel labelErrorNombre = new JLabel();
        labelErrorNombre.setBounds(150, 360, 400, 30);
        labelErrorNombre.setForeground(Color.RED);

        JLabel labelCorreo = new JLabel("Correo Electrónico:");
        JTextField textCorreo = new JTextField();
        labelCorreo.setBounds(60, 200, 200, 20);
        textCorreo.setBounds(300, 190, 200, 40);
        JLabel labelErrorCorreo = new JLabel();
        labelErrorCorreo.setBounds(150, 400, 400, 30);
        labelErrorCorreo.setForeground(Color.RED);

        JLabel labelContrasenha = new JLabel("Contraseña:");
        JPasswordField textContrasenha = new JPasswordField();
        labelContrasenha.setBounds(60, 300, 100, 20);
        textContrasenha.setBounds(300, 290, 200, 40);
        JLabel labelErrorContrasenha = new JLabel();
        labelErrorContrasenha.setBounds(150, 440, 400, 30);
        labelErrorContrasenha.setForeground(Color.RED);

        // Botón de enviar
        JButton buttonEnviar = new JButton("Enviar");
        buttonEnviar.setBounds(150, 500, 200, 40);
        JLabel labelResultado = new JLabel("", SwingConstants.CENTER);
        labelResultado.setBounds(150, 550, 200, 40);
        labelResultado.setForeground(Color.BLUE);

        // Agregar componentes al formulario
        ventana.add(labelNombre);
        ventana.add(textNombre);
        ventana.add(labelErrorNombre);

        ventana.add(labelCorreo);
        ventana.add(textCorreo);
        ventana.add(labelErrorCorreo);

        ventana.add(labelContrasenha);
        ventana.add(textContrasenha);
        ventana.add(labelErrorContrasenha);

        ventana.add(buttonEnviar);
        ventana.add(labelResultado);

        // Acción del botón "Enviar"
        buttonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = true;

                // Validación del nombre
                String nombre = textNombre.getText().trim();
                if (nombre.isEmpty()) {
                    labelErrorNombre.setText("El nombre no puede estar vacío.");
                    isValid = false;
                } else {
                    labelErrorNombre.setText("");
                }

                // Validación del correo electrónico
                String correo = textCorreo.getText().trim();
                if (!correo.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
                    labelErrorCorreo.setText("Formato de correo inválido.");
                    isValid = false;
                } else {
                    labelErrorCorreo.setText("");
                }

                // Validación de la contraseña
                String contraseña = new String(textContrasenha.getPassword());
                if (contraseña.length() < 8) {
                    labelErrorContrasenha.setText("La contraseña debe tener al menos 8 caracteres.");
                    isValid = false;
                } else {
                    labelErrorContrasenha.setText("");
                }

                // Mostrar resultado
                if (isValid) {
                    labelResultado.setText("Formulario enviado con éxito.");
                    textNombre.setText("");
                    textCorreo.setText("");
                    textContrasenha.setText("");
                } else {
                    labelResultado.setText("");
                }
            }
        });

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}

