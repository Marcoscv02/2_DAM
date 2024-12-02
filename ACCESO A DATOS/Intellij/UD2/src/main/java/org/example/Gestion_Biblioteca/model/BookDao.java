package org.example.Gestion_Biblioteca.model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements DAO<Book>{
    //Lista temporal de libros
    Connection connection= BibliotecaConnectionMaganer.getInstance().getConnection(); //Establecer conexion con BD

    @Override
    public Book get(int id) {
        Book book= new Book();
        try(var ps= connection.prepareStatement("SELECT * FROM Book WHERE id = ?")){
            ps.setInt(1,id);

            try (ResultSet rs= ps.executeQuery()){
                if (rs.next()){

                    book.setIdBook(rs.getInt("idBook"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setTitle(rs.getString("titulo"));
                    book.setAuthor(rs.getString("autor"));
                    book.setAno(rs.getInt("anho"));
                    book.setAvailable(rs.getBoolean("disponible"));
                    book.setPortada(rs.getBytes("portada"));

                    System.out.println("libro obtenido correctamente");

                }
            }
        } catch (SQLException e) {
            System.out.println("Error SQL en metodo get");
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book>libros=new ArrayList<>();

        try (var ps= connection.prepareStatement("SELECT * FROM Book");
            var rs= ps.executeQuery()){

            while (rs.next()){
                Book book=new Book();

                book.setIdBook(rs.getInt("idBook"));
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("titulo"));
                book.setAuthor(rs.getString("autor"));
                book.setAno(rs.getInt("anho"));
                book.setAvailable(rs.getBoolean("disponible"));
                book.setPortada(rs.getBytes("portada"));

                libros.add(book);
            }

            System.out.println("Lista de libros obtenida correctamente");
            return libros;
        } catch (SQLException e) {
            System.out.println("Error SQL en método getAll");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Book book) {
        try (var ps=connection.prepareStatement(
                "INSERT INTO Book (idBook, isbn, titulo, autor, anho, disponible, portada) VALUES (?,?,?,?,?,?,?)")
        ){
            ps.setInt(1,book.getIdBook());
            ps.setString(2, book.getIsbn());
            ps.setString(3, book.getTitle());
            ps.setString(4, book.getAuthor());
            ps.setInt(5, book.getYear());
            ps.setBoolean(6,book.isAvailable());
            ps.setBytes(7,book.getPortada());

            int rows= ps.executeUpdate();//Devuelve el numero de columnas afectadas

            if (rows>0) System.out.println("Elemento guardado correctamente correctamente");
            else System.out.println("El elemento no se ha guardado");

        } catch (SQLException e) {
            System.out.println("Error SQL en metodo save");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book book) {
        try (var ps= connection.prepareStatement(
                "UPDATE Book SET idBook = ?, isbn = ?, titulo = ?, autor = ?, anho = ?, disponible = ?, portada = ? WHERE idBook = ?;"
        )){

            ps.setInt(1,book.getIdBook());
            ps.setString(2, book.getIsbn());
            ps.setString(3, book.getTitle());
            ps.setString(4, book.getAuthor());
            ps.setInt(5, book.getYear());
            ps.setBoolean(6,book.isAvailable());
            ps.setBytes(7,book.getPortada());
            ps.setInt(8,book.getIdBook());

            int rows= ps.executeUpdate();//Devuelve el numero de columnas afectadas

            if (rows>0) System.out.println("Elemento actualizado correctamente");
            else System.out.println("El elemento no se ha actualizado");

        } catch (SQLException e) {
            System.out.println("Error SQL en metodo update");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Book book) {

        try(var ps= connection.prepareStatement("DELETE FROM Book WHERE titulo = ?;")){
            ps.setString(1, book.getTitle());

            int rows= ps.executeUpdate();//Devuelve el numero de columnas afectadas

            if (rows>0) System.out.println("Elemento eliminado correctamente");
            else System.out.println("El elemento no se ha eliminado");

        } catch (SQLException e) {
            System.out.println("Error SQL en metodo delete");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {

        try(var ps= connection.prepareStatement("DELETE FROM Book WHERE idBook = ?;")){
            ps.setLong(1, id);

            int rows= ps.executeUpdate();//Devuelve el numero de columnas afectadas

            if (rows>0) System.out.println("Elemento eliminado correctamente");
            else System.out.println("El elemento no se ha eliminado");

        } catch (SQLException e) {
            System.out.println("Error SQL en metodo delete");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateImage(Book book, String f) {

    }

    @Override
    public void updateImageById(long id, String f) {

    }

    @Override
    public void deleteAll() {

    }
}
