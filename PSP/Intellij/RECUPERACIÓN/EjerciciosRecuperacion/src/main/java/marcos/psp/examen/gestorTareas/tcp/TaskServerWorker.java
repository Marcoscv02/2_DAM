package marcos.psp.examen.gestorTareas.tcp;

import marcos.psp.examen.gestorTareas.pop3.GetMails;
import marcos.psp.examen.gestorTareas.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class TaskServerWorker implements Runnable{

    private Socket socket;
    private List<Task> tareas;

    public TaskServerWorker(Socket socket, List<Task> tareas) {
        this.socket = socket;
        this.tareas = tareas;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        String userName = null;
        boolean logged = false;


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){

            while (true){
                String [] userInput = reader.readLine().trim().split(" ");
                String command = userInput[0].toLowerCase();

                switch (command){
                    case "start":
                        if (!logged){
                            userName = userInput[1];
                            logged = true;
                            writer.println("ACCEPT: hello "+userName);
                        }else {
                            writer.println("NOT ACCEPT: You are logged already");
                        }
                        break;

                    case "task":
                        if (!logged){
                            writer.println("NOT ACCEPT: You need to be logged");
                        }else {
                            if (!userName.equalsIgnoreCase("boss")){
                                writer.println("NOT ACCEPT: You have not permission to do this");

                            }else {
                                String taskName = userInput[1];
                                String description = userInput[2];
                                String worker = userInput[3];

                                TaskServer.createNewTask(taskName,description,worker);
                                writer.println("ACCEPT: Task have been created");
                            }
                        }
                        break;

                    case "complete":
                        if (!logged){
                            writer.println("NOT ACCEPT: You need to be logged");
                        }else {
                            int id = Integer.parseInt(userInput[1]);
                            boolean success = TaskServer.completeTask(id, userName);

                            if (success)
                                writer.println("ACCEPT: Task have been completed");
                            else
                                writer.println("NOT ACCEPT: Task cant be completed, check if the task is at your name or taskId exists");
                        }
                        break;

                    case "show":
                        List<Task> incompleteTask = TaskServer.getIncompleteTasks();
                        writer.println(incompleteTask);
                        break;

                    case "upload":
                        if (!logged){
                            writer.println("NOT ACCEPT: You need to be logged");
                        }else {
                            if (!userName.equalsIgnoreCase("boss")){
                                writer.println("NOT ACCEPT: You have not permission to do this");

                            }else {
                                TaskServer.uploadMails();
                                writer.println("ACCEPT: Files was uploaded to server");
                            }
                        }
                        break;

                    case "exit":
                        writer.println("NOT ACCEPT: Good bye "+userName);
                        break;

                    default:
                        writer.println("NOT ACCEPT: this command doesn't exists");
                        break;
                }

                if (command.equalsIgnoreCase("exit"))
                    break;
            }

        } catch (IOException|InterruptedException e) {
            System.out.println("Error en el worker del servidor");
            throw new RuntimeException(e);
        }
    }
}
