package org.example.Gestion_Biblioteca;

//CLASE PARA GESTIONAR LA BASE DE DATOS

import java.sql.*; // Importa todas las librerias de sql
import java.text.MessageFormat; // Permite formatear mensajes de texto.
import org.slf4j.Logger; // API para registrar logs.
import org.slf4j.LoggerFactory; // Proporciona instancias del logger.

public class BibliotecaConnectionMaganer {
    //VARIABLES
    // Logger para registrar eventos (información, errores, etc.).
    private static final Logger log = LoggerFactory.getLogger(BibliotecaConnectionMaganer.class);
    // URL de conexión a la base de datos. Contiene la ubicación del archivo de la base de datos H2.
    public static final String URL = "jdbc:h2:E:\\98 - Bases de datos\\h2\\biblioteca2"
            + ";DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE;FILE_LOCK=NO";
    // Nombre del driver JDBC para la base de datos H2.
    public static final String DRIVER = "org.h2.Driver";
    // Instancia única de la clase (patrón Singleton).
    private static BibliotecaConnectionMaganer instance;
    // Objeto Connection que representa la conexión a la base de datos.
    private Connection conexion;


    private BibliotecaConnectionMaganer() {
        // Constructor privado para evitar instanciación directa (Singleton).
        try {
            // Carga el driver de la base de datos H2 en tiempo de ejecución.
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            // Si el driver no se encuentra, se registra un error en el log.
            log.error("Driver not found: %s".formatted(e.getMessage()));
        }
        // Obtiene la conexión a la base de datos.
        conexion = getConnection();
    }

    public static BibliotecaConnectionMaganer getInstance() {
        // Devuelve la instancia única de la clase.
        if (instance == null) {
            // Si la instancia aún no existe, sincroniza el bloque de código para asegurar que
            // solo un hilo pueda crearla (manejo de concurrencia).
            synchronized (BibliotecaConnectionMaganer.class) {
                if (instance == null) {
                    // Crea la instancia única de la clase.
                    instance = new BibliotecaConnectionMaganer();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        // Obtiene la conexión a la base de datos.
        try {
            if (conexion == null || conexion.isClosed()) {
                // Si la conexión no existe o está cerrada, sincroniza el bloque de código.
                synchronized (BibliotecaConnectionMaganer.class) {
                    if (conexion == null || conexion.isClosed()) {
                        try {
                            // Intenta establecer la conexión utilizando el DriverManager y la URL.
                            conexion = DriverManager.getConnection(URL);
                            log.info("Establecida conexión"); // Log de éxito.
                        } catch (SQLException ex) {
                            // Log de error si ocurre un problema al conectar.
                            log.error("Erro ó establecer a conexión: %s".formatted(ex.getMessage()));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            // Manejo de errores adicionales si ocurre un problema al comprobar la conexión.
            log.debug(MessageFormat.format("Erro ó establecer a conexión: {0}", e.getMessage()));
        }
        return conexion; // Devuelve la conexión a la base de datos.
    }
}
