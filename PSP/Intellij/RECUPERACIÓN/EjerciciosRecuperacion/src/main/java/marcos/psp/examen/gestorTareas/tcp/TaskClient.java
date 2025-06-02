package marcos.psp.examen.gestorTareas.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TaskClient {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Socket socket= new Socket(HOST,PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writter = new PrintWriter(socket.getOutputStream(),true)){

            System.out.println("___TASKS APP___\n" +
                    "- START <userName> para iniciar sesión\n" +
                    "- TASK <name> <description> <worker> para crear una nueva tarea\n" +
                    "- COMPLETE <id> marcar tarea como completada (solo disponible para perfil boss)\n" +
                    "- SHOW mostrar listado de tareas sin completar\n" +
                    "- UPLOAD subir reporte de tareas diario (completadas y no completadas), (solo disponible para perfil boss)\n" +
                    "- EXIT para salir");

            while (true){
                System.out.println("Write command:");
                String command = sc.nextLine();

                writter.println(command);

                System.out.println(reader.readLine());


                if (command.equalsIgnoreCase("exit"))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente");
            throw new RuntimeException(e);
        }
    }
}
