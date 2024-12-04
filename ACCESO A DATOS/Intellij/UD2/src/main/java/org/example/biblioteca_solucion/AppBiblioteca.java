package org.example.biblioteca_solucion;



import org.example.biblioteca_solucion.controller.BookController;
import org.example.biblioteca_solucion.controller.IBookController;
import org.example.biblioteca_solucion.model.BibliotecaConnectionMaganer;
import org.example.biblioteca_solucion.model.Book;
import org.example.biblioteca_solucion.model.BookDAO;
import org.example.biblioteca_solucion.model.DAO;
import org.example.biblioteca_solucion.view.BookView;
import org.example.biblioteca_solucion.view.IBookView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppBiblioteca {

    public static InputStream getFromURL(){
        try {
            URL url  = new URL("https://m.media-amazon.com/images/I/51pHAyAG4DL._SY445_SX342_.jpg");
            return url.openStream();
        } catch (MalformedURLException e) {
            System.err.println("URL incorrecta");
        } catch (IOException e) {
            System.err.println("Erro ó ler o arcquivo");
        }
        return null;
    }


    public static void main(String[] args) {

        BibliotecaConnectionMaganer bibliotecaConnection = BibliotecaConnectionMaganer.getInstance();

        DAO<Book> bookDAO = new BookDAO(bibliotecaConnection.getConnection());

        IBookController bookControler = BookController.getInstance();
        bookControler.setDao(bookDAO);
        IBookView bookView =  new BookView(bookControler); // new BookViewCutre(bookControler); // new BookView(bookControler);

        bookView.setVisible(true);
    }

    public static void admiteRetencion(Connection conn) throws SQLException {

        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println("ResultSet.HOLD_CURSORS_OVER_COMMIT = " +
                ResultSet.HOLD_CURSORS_OVER_COMMIT);
        System.out.println("ResultSet.CLOSE_CURSORS_AT_COMMIT = " +
                ResultSet.CLOSE_CURSORS_AT_COMMIT);
        System.out.println("Retención predeterminada del cursor: " +
                dbMetaData.getResultSetHoldability());
        System.out.println("¿Admite HOLD_CURSORS_OVER_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.HOLD_CURSORS_OVER_COMMIT));
        System.out.println("¿Admite CLOSE_CURSORS_AT_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.CLOSE_CURSORS_AT_COMMIT));
        try {
            if (conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Soporta TYPE_SCROLL_INSENSITIVE");
            } else {
                System.out.println("No soporta TYPE_SCROLL_INSENSITIVE");
            }
            if (conn.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                System.out.println("Soporta CONCUR_UPDATABLE");
            } else {
                System.out.println("No soporta CONCUR_UPDATABLE");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener metadatos: " + ex.getMessage());
        }

        if (conn != null) {
            System.out.println("Conexión establecida");
        }
    }


}
