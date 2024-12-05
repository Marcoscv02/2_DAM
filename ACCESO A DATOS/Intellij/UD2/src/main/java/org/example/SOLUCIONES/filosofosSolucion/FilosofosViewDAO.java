package org.example.SOLUCIONES.filosofosSolucion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

/**
 * Clase que implementa una interfaz gráfica para gestionar una base de datos de filósofos.
 * Permite visualizar, navegar y actualizar los registros de la base de datos.
 *
 * <p>Requiere la base de datos H2 y una tabla llamada "Filosofo" con las siguientes columnas:
 * - idFilosofo (int)
 * - nome (String)
 * - apelidos (String)
 * - idade (int)
 * - dataNacemento (Date)</p>
 *
 * @author Pepe Calo
 */
public class FilosofosViewDAO extends JFrame {

    /**
     * URL de conexión a la base de datos H2.
     */
    public static final String URL = "jdbc:h2:C:\\Users\\a24marcoscv\\Documents\\2_DAM\\ACCESO A DATOS\\DB\\filosofos\\filosofosv2.3"
            + ";IFEXISTS=TRUE;DATABASE_TO_UPPER=FALSE;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";

    /**
     * Driver para la base de datos H2.
     */
    public static final String DRIVER = "org.h2.Driver";

    /**
     * Etiquetas para los campos de entrada en la interfaz gráfica.
     */
    public static final String[] ETIQUETAS = {"Nome: ", "Apelidos: ", "Idade: ", "Data Nacemento: "};

    /**
     * ResultSet que contiene los datos recuperados de la base de datos.
     */
    private ResultSet rs;

    // Componentes de la interfaz gráfica
    private JButton btSeguinte; // Botón para avanzar al siguiente registro
    private JButton btAnterior; // Botón para retroceder al registro anterior
    private final JTextField[] campos = new JTextField[4]; // Campos de texto para mostrar datos del registro
    private JLabel etiquetaMensaxes; // Etiqueta para mensajes o identificadores
    private JButton btActualizar; // Botón para actualizar registros
    private JButton btLimpar; // Botón para limpiar los campos
    private JButton btNovo; // Botón para añadir un nuevo registro

    /**
     * Constructor que inicializa la interfaz gráfica y establece la conexión con la base de datos.
     *
     * @param title Título de la ventana.
     */
    public FilosofosViewDAO(String title) throws HeadlessException {
        super(title);
        createGUI();
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setConnection();
        setVisible(true);
    }

    /**
     * Método para construir y organizar los elementos de la interfaz gráfica.
     */
    private void createGUI() {
        // Configuración de paneles y diseño
        add(new JPanel(), BorderLayout.LINE_END);
        add(new JPanel(), BorderLayout.LINE_START);

        // Panel central con campos de texto
        JPanel panelCentral = new JPanel(new SpringLayout());
        for (int i = 0; i < campos.length; i++) {
            JLabel etiqueta = new JLabel(ETIQUETAS[i], JLabel.RIGHT);
            panelCentral.add(etiqueta);
            campos[i] = new JTextField(16);
            panelCentral.add(campos[i]);
        }
        setGridCompacto(panelCentral, ETIQUETAS.length, 2, 6, 6, 6, 6);
        add(panelCentral);

        // Panel inferior con botones de navegación
        btAnterior = new JButton(" < ");
        btSeguinte = new JButton(" > ");
        btAnterior.addActionListener((ActionEvent e) -> {
            try {
                if (rs.previous()) setValores();
            } catch (SQLException ex) {
                // Manejo de error
            }
        });
        btSeguinte.addActionListener(e -> {
            try {
                if (rs.next()) setValores();
            } catch (SQLException ex) {
                // Manejo de error
            }
        });

        JPanel panelSur = new JPanel();
        panelSur.add(btAnterior);
        panelSur.add(btSeguinte);
        etiquetaMensaxes = new JLabel("    ");
        panelSur.add(etiquetaMensaxes);
        add(panelSur, BorderLayout.PAGE_END);

        // PANEL SUPERIOR
        JPanel panelSup = new JPanel();
        //btn Actualizar
        btActualizar = new JButton("Actualizar");
        btActualizar.addActionListener(e -> {
            try (var ps = rs
                    .getStatement()
                    .getConnection()
                    .prepareStatement("UPDATE Filosofo SET nome = ?, apelidos = ?, idade = ?, dataNacemento = ? WHERE idFilosofo = ?");
            ){

                ps.setString(1, campos[0].getText());
                ps.setString(2, campos[1].getText());
                ps.setInt(3, Integer.parseInt(campos[2].getText()));
                ps.setDate(4, Date.valueOf(campos[3].getText()));
                ps.setInt(5, Integer.parseInt(etiquetaMensaxes.getText()));

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    etiquetaMensaxes.setText("Registro actualizado correctamente.");
                }
            } catch (SQLException | NumberFormatException ex) {
                etiquetaMensaxes.setText("Error al actualizar: " + ex.getMessage());
            }
        });

        //BtnLimpiar
        btLimpar = new JButton("Limpar");
        btLimpar.addActionListener(e -> {
            for (JTextField campo : campos) {
                campo.setText("");
            }
            etiquetaMensaxes.setText("Formulario limpiado.");
        });


        //BtnNuevo
        btNovo = new JButton("Novo");
        btNovo.addActionListener(e -> {
            try {
                String insertQuery = "INSERT INTO Filosofo (nome, apelidos, idade, dataNacemento) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = rs.getStatement().getConnection().prepareStatement(insertQuery);

                ps.setString(1, campos[0].getText());
                ps.setString(2, campos[1].getText());
                ps.setInt(3, Integer.parseInt(campos[2].getText()));
                ps.setDate(4, Date.valueOf(campos[3].getText()));

                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    etiquetaMensaxes.setText("Nuevo registro añadido correctamente.");
                    // Recargar el ResultSet para incluir el nuevo registro
                    rs = rs.getStatement().executeQuery("SELECT idFilosofo, nome, apelidos, idade, dataNacemento FROM Filosofo");
                    rs.last(); // Ir al nuevo registro
                    setValores();
                }
            } catch (SQLException | NumberFormatException ex) {
                etiquetaMensaxes.setText("Error al añadir nuevo registro: " + ex.getMessage());
            }
        });


        panelSup.add(btActualizar);
        panelSup.add(btLimpar);
        panelSup.add(btNovo);
        add(panelSup, BorderLayout.PAGE_START);

        // Evento para gestionar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                sair();
            }
        });
    }

    /**
     * Configura la conexión a la base de datos y recupera los datos iniciales.
     */
    private void setConnection() {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL);
            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT idFilosofo, nome, apelidos, idade, dataNacemento FROM Filosofo");
            if (rs.next()) {
                setValores();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro na base de datos: " + ex.getMessage());
        }
    }

    /**
     * Cierra la conexión a la base de datos y el programa.
     */
    private void sair() {
        if (JOptionPane.showConfirmDialog(this, "Queres saír?", "Cerrar programa",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                rs.getStatement().getConnection().close();
            } catch (SQLException ex) {
                // Manejo de error
            }
            System.exit(0);
        }
    }

    /**
     * Establece los valores de los campos de texto con los datos del registro actual.
     */
    private void setValores() throws SQLException {
        if (rs != null && !rs.isClosed() && !rs.isBeforeFirst() && !rs.isAfterLast()) {
            campos[0].setText(rs.getString("nome"));
            campos[1].setText(rs.getString("apelidos"));
            campos[2].setText(rs.getString("idade"));
            campos[3].setText(String.valueOf(rs.getDate("dataNacemento")));
            etiquetaMensaxes.setText(String.valueOf(rs.getInt("idFilosofo")));
            btSeguinte.setEnabled(!rs.isLast());
            btAnterior.setEnabled(!rs.isFirst());
        }
    }

    /**
     * Método estático que organiza componentes en un contenedor con SpringLayout.
     */
    public static void setGridCompacto(Container contenedor, int filas, int columnas,
                                       int xInicial, int yInicial, int xPad, int yPad) {
        SpringLayout layout = (SpringLayout) contenedor.getLayout();
        Spring x = Spring.constant(xInicial);
        for (int c = 0; c < columnas; c++) {
            Spring ancho = Spring.constant(0);
            for (int fila = 0; fila < filas; fila++) {
                ancho = Spring.max(ancho, getRestriccionesParaCelda(fila, c, contenedor, columnas).getWidth());
            }
            for (int fila = 0; fila < filas; fila++) {
                SpringLayout.Constraints constraints = getRestriccionesParaCelda(fila, c, contenedor, columnas);
                constraints.setX(x);
                constraints.setWidth(ancho);
            }
            x = Spring.sum(x, Spring.sum(ancho, Spring.constant(xPad)));
        }
        Spring y = Spring.constant(yInicial);
        for (int fila = 0; fila < filas; fila++) {
            Spring altura = Spring.constant(0);
            for (int c = 0; c < columnas; c++) {
                altura = Spring.max(altura, getRestriccionesParaCelda(fila, c, contenedor, columnas).getHeight());
            }
            for (int c = 0; c < columnas; c++) {
                SpringLayout.Constraints constraints = getRestriccionesParaCelda(fila, c, contenedor, columnas);
                constraints.setY(y);
                constraints.setHeight(altura);
            }
            y = Spring.sum(y, Spring.sum(altura, Spring.constant(yPad)));
        }
        SpringLayout.Constraints pCons = layout.getConstraints(contenedor);
        pCons.setConstraint(SpringLayout.SOUTH, y);
        pCons.setConstraint(SpringLayout.EAST, x);
    }

    /**
     * Obtiene las restricciones de un componente específico en el SpringLayout.
     */
    private static SpringLayout.Constraints getRestriccionesParaCelda(int fila, int columna,
                                                                      Container padre, int columnas) {
        SpringLayout layout = (SpringLayout) padre.getLayout();
        Component c = padre.getComponent(fila * columnas + columna);
        return layout.getConstraints(c);
    }

    /**
     * Método principal para iniciar la aplicación.
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new FilosofosViewDAO("Filósofos");
    }
}