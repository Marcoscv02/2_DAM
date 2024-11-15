package UD3.creacion_elementos_ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividades {

    public JFrame getVentana1(){

        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana Básica");
        ventana.setSize(400, 200); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel();
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el botón
        JButton boton = new JButton("Presióname");
        boton.setBounds(150, 70, 100, 30); // Posición y tamaño del botón
        panel.add(boton); // Agregar el botón al panel

        // Añadir ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("¡Botón presionado!"); // Mensaje en la consola
            }
        });

        // Hacer visible la ventana
        ventana.setVisible(true);

        return ventana;
    }


    public JFrame  getventana2(){

        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana con multiples botones");
        ventana.setSize(400, 200); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel();
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el botón
        JButton aceptar = new JButton("aceptar");
        aceptar.setBounds(100, 70, 100, 30); // Posición y tamaño del botón
        panel.add(aceptar); // Agregar el botón al panel

        // Crear el botón
        JButton cancelar = new JButton("cancelar");
        cancelar.setBounds(220, 70, 100, 30); // Posición y tamaño del botón
        panel.add(cancelar); // Agregar el botón al panel

        // Añadir ActionListener al botón "Aceptar"
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar mensaje "Aceptado"
                JOptionPane.showMessageDialog(null, "Aceptado");
            }
        });

        // Añadir ActionListener al botón "Cancelar"
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Cancelado");
            }
        });

        // Hacer visible la ventana
        ventana.setVisible(true);

        return ventana;
    }


    public  JFrame getVentana3(){

        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana con campo de texto");
        ventana.setSize(400, 200); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel();
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el campo de texto
        JTextField campoTexto = new JTextField(20);
        campoTexto.setBounds(100, 50, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoTexto); // Agregar el campo de texto al panel

        // Crear el botón
        JButton nombre = new JButton("Mostrar nombre");
        nombre.setBounds(100, 110, 200, 30); // Posición y tamaño del botón
        panel.add(nombre); // Agregar el botón al panel



        // Añadir ActionListener al botón "Cancelar"
        nombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= campoTexto.getText();
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Nombre: "+nombre);
            }
        });
        // Hacer visible la ventana
        ventana.setVisible(true);

        return ventana;
    }


    public JFrame getventana4(){
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana con multiples botones");
        ventana.setSize(400, 300); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel(); // Crear un panel para agregar el botón
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el campo de texto
        JTextField campoNombre = new JTextField(20);
        campoNombre.setBounds(100, 50, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoNombre); // Agregar el campo de texto al panel

        // Crear el campo de texto
        JTextField campoApellido = new JTextField(20);
        campoApellido.setBounds(100, 100, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoApellido); // Agregar el campo de texto al panel

        // Crear el botón
        JButton saludo = new JButton("Saludar");
        saludo.setBounds(100, 140, 200, 30); // Posición y tamaño del botón
        panel.add(saludo); // Agregar el botón al panel



        // Añadir ActionListener al botón "Cancelar"
        saludo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= campoNombre.getText();
                String apellido=campoApellido.getText();
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Saludos Terrícola "+nombre+apellido+"!!");
            }
        });


        // Hacer visible la ventana
        ventana.setVisible(true);


        return ventana;
    }



    public JFrame getactividad5(){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Actividad 5: Uso de JOptionPane");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setLayout(null);

        // Crear el botón
        JButton boton = new JButton("Ingresar Edad");
        boton.setBounds(80, 70, 140, 30);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar cuadro de diálogo para ingresar edad
                String edadIngresada = JOptionPane.showInputDialog(ventana, "Ingrese su edad:");

                // Validar si se ingresó algo
                if (edadIngresada != null) {
                    // Mostrar cuadro de diálogo con la edad ingresada
                    JOptionPane.showMessageDialog(ventana, "La edad ingresada es: " + edadIngresada);
                } else {
                    // Mensaje si no se ingresó nada
                    JOptionPane.showMessageDialog(ventana, "No ingresaste ninguna edad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        ventana.add(boton);
        ventana.setVisible(true);

        return ventana;
    }


    public JFrame getActividad6 (){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Actividad 6: Menú Desplegable");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setLayout(null);

        // Crear etiquetas y menú desplegable
        JLabel etiqueta = new JLabel("Seleccione un color:");
        etiqueta.setBounds(30, 30, 150, 20);

        String[] colores = {"Rojo", "Verde", "Azul"};
        JComboBox<String> comboBox = new JComboBox<>(colores);
        comboBox.setBounds(30, 60, 100, 25);

        // Agregar acción al menú desplegable
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String colorSeleccionado = (String) comboBox.getSelectedItem();
                System.out.println("Color seleccionado: " + colorSeleccionado);
            }
        });

        // Agregar componentes al marco
        ventana.add(etiqueta);
        ventana.add(comboBox);

        // Hacer visible la ventana
        ventana.setVisible(true);

        return ventana;
    }


    public JFrame getventana7(){
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Ventana log in");
        ventana.setSize(400, 300); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana

        // Crear un panel para agregar el botón
        JPanel panel = new JPanel(); // Crear un panel para agregar el botón
        ventana.add(panel); // Agregar el panel a la ventana

        panel.setLayout(null); // Sin layout para posicionar el botón manualmente

        // Crear el campo de texto
        JTextField campoNombre = new JTextField(20);
        campoNombre.setBounds(100, 50, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoNombre); // Agregar el campo de texto al panel

        // Crear el campo de texto
        JPasswordField campoContraseña = new JPasswordField(20);
        campoContraseña.setBounds(100, 100, 200, 30); // Posición y tamaño del campo de texto
        panel.add(campoContraseña); // Agregar el campo de texto al panel

        // Crear el botón
        JButton saludo = new JButton("Insertar");
        saludo.setBounds(100, 140, 200, 30); // Posición y tamaño del botón
        panel.add(saludo); // Agregar el botón al panel



        // Añadir ActionListener al botón "Cancelar"
        saludo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= campoNombre.getText();
                String apellido=campoContraseña.getText();
                // Mostrar mensaje "Cancelado"
                JOptionPane.showMessageDialog(null, "Nombre: "+nombre+" \nContraseña: "+apellido);
            }
        });


        // Hacer visible la ventana
        ventana.setVisible(true);


        return ventana;
    }


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


    public JFrame getActividad9(){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Ordenar Pizza");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLayout(null);

        // Crear una etiqueta
        JLabel etiqueta = new JLabel("Seleccione los toppings para su pizza:");
        etiqueta.setBounds(30, 20, 250, 20);

        // Crear casillas de verificación (checkboxes)
        JCheckBox quesoExtra = new JCheckBox("Queso Extra");
        quesoExtra.setBounds(30, 60, 150, 20);

        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        pepperoni.setBounds(30, 100, 150, 20);

        JCheckBox aceitunas = new JCheckBox("Aceitunas");
        aceitunas.setBounds(30, 140, 150, 20);

        // Crear botón "Ordenar"
        JButton ordenar = new JButton("Ordenar");
        ordenar.setBounds(30, 200, 120, 30);

        // Agregar funcionalidad al botón "Ordenar"
        ordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder toppingsSeleccionados = new StringBuilder("Toppings seleccionados: ");

                if (quesoExtra.isSelected()) {
                    toppingsSeleccionados.append("Queso Extra, ");
                }
                if (pepperoni.isSelected()) {
                    toppingsSeleccionados.append("Pepperoni, ");
                }
                if (aceitunas.isSelected()) {
                    toppingsSeleccionados.append("Aceitunas, ");
                }

                if (toppingsSeleccionados.toString().endsWith(", ")) {
                    // Quitar la última coma y espacio
                    toppingsSeleccionados.setLength(toppingsSeleccionados.length() - 2);
                } else {
                    toppingsSeleccionados.append("Ninguno");
                }

                // Mostrar los toppings seleccionados en la consola
                System.out.println(toppingsSeleccionados);
            }
        });

        // Agregar componentes al marco
        ventana.add(etiqueta);
        ventana.add(quesoExtra);
        ventana.add(pepperoni);
        ventana.add(aceitunas);
        ventana.add(ordenar);

        // Hacer visible la ventana
        ventana.setVisible(true);

        return  ventana;
    }


    public JFrame getVentana10 (){
        // Crear el marco (ventana)
        JFrame ventana = new JFrame("Menú de Barra");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setLayout(null);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear los menús principales
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuEdicion = new JMenu("Edición");

        // Crear los submenús de "Archivo"
        JMenuItem menuAbrir = new JMenuItem("Abrir");
        JMenuItem menuGuardar = new JMenuItem("Guardar");

        // Agregar submenús al menú "Archivo"
        menuArchivo.add(menuAbrir);
        menuArchivo.add(menuGuardar);

        // Agregar menús principales a la barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(menuEdicion);

        // Agregar la barra de menú al marco
        ventana.setJMenuBar(menuBar);

        // Acción para "Abrir"
        menuAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seleccionaste la opción: Abrir");
            }
        });

        // Acción para "Guardar"
        menuGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seleccionaste la opción: Guardar");
            }
        });

        // Mostrar el marco
        ventana.setVisible(true);
        return ventana;
    }
}
