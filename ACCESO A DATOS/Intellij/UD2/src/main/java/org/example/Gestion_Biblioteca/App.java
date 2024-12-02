package org.example.Gestion_Biblioteca;

import org.example.Gestion_Biblioteca.model.BibliotecaConnectionMaganer;
import org.example.Gestion_Biblioteca.model.Book;
import org.example.Gestion_Biblioteca.model.BookDao;

import java.sql.Connection;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) { // Obtener la instancia del gestor de conexiones
        // Obtener la instancia del gestor de conexiones
        BibliotecaConnectionMaganer connectionManager = BibliotecaConnectionMaganer.getInstance();

        // Probar la conexión
        try (Connection connection = connectionManager.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexión establecida con éxito.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
