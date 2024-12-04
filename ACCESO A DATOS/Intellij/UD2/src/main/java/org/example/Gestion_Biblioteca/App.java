package org.example.Gestion_Biblioteca;

import org.example.Gestion_Biblioteca.model.Book;
import org.example.Gestion_Biblioteca.model.BookDao;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menú de Gestión de Biblioteca ===");
            System.out.println("1. Guardar Libro");
            System.out.println("2. Obtener Libro por ID");
            System.out.println("3. Obtener Todos los Libros");
            System.out.println("4. Actualizar Libro");
            System.out.println("5. Eliminar Libro por Título");
            System.out.println("6. Eliminar Libro por ID");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1 -> {
                    Book book = new Book();
                    System.out.print("ID del libro: ");
                    book.setIdBook(scanner.nextInt());
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("ISBN: ");
                    book.setIsbn(scanner.nextLine());
                    System.out.print("Título: ");
                    book.setTitle(scanner.nextLine());
                    System.out.print("Autor: ");
                    book.setAuthor(scanner.nextLine());
                    System.out.print("Año de publicación: ");
                    book.setAno(scanner.nextInt());
                    System.out.print("Disponible (true/false): ");
                    book.setAvailable(scanner.nextBoolean());// Se puede configurar si se maneja portada
                    bookDao.save(book);
                }
                case 2 -> {
                    System.out.print("Ingresa el ID del libro: ");
                    int id = scanner.nextInt();
                    Book book = bookDao.get(id);
                    if (book != null) {
                        System.out.println("Título: " + book.getTitle());
                        System.out.println("Autor: " + book.getAuthor());
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                }
                case 3 -> {
                    List<Book> books = bookDao.getAll();
                    if (books.isEmpty()) {
                        System.out.println("No hay libros en la base de datos.");
                    } else {
                        books.forEach(b -> System.out.println("ID: " + b.getIdBook() + ", Título: " + b.getTitle()));
                    }
                }
                case 4 -> {
                    System.out.print("Ingresa el ID del libro a actualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    Book book = bookDao.get(id);
                    if (book != null) {
                        System.out.print("Nuevo Título: ");
                        book.setTitle(scanner.nextLine());
                        System.out.print("Nuevo Autor: ");
                        book.setAuthor(scanner.nextLine());
                        System.out.print("Nuevo Año: ");
                        book.setAno(scanner.nextInt());
                        System.out.print("Disponible (true/false): ");
                        book.setAvailable(scanner.nextBoolean());
                        bookDao.update(book);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Ingresa el título del libro a eliminar: ");
                    String title = scanner.nextLine();
                    Book book = new Book();
                    book.setTitle(title);
                    bookDao.delete(book);
                }
                case 6 -> {
                    System.out.print("Ingresa el ID del libro a eliminar: ");
                    int id = scanner.nextInt();
                    bookDao.deleteById(id);
                }
                case 7 -> {
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        }
    }
}
