package marcos.psp.UD3.exercise8.tcp;

import marcos.psp.UD3.exercise8.tcp.model.Contact;
import marcos.psp.UD3.exercise8.tcp.model.PhoneBook;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookServerWorkerTCP implements Runnable{
    SSLSocket socket;
    private List<Contact> contactList = new ArrayList<>();

    public PhoneBookServerWorkerTCP(SSLSocket socket) {
        this.socket = socket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        PhoneBook phoneBook = new PhoneBook(contactList);

        try (BufferedReader reader = new BufferedReader( new InputStreamReader( socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){
            System.out.println("Se ha iniciado el hilo");

            while (true){
             String [] userInput = reader.readLine().trim().split(" ");
             String command = userInput[0].toLowerCase();

             switch (command){
                 case "add":
                     if (userInput.length == 3){
                         String name = userInput[1];
                         int number = Integer.parseInt(userInput[2]);
                         Contact contact = new Contact(name,number);

                         if (phoneBook.contactAlreadyExists(contact)){
                            writer.println("REJECTED: El contacto ya existe.");
                         }else {
                            phoneBook.addContact(contact);
                            writer.println("ACCEPTED: El contacto ha sido añadido");
                         }

                     }else {
                         writer.println("INVALID: formato incorrecto");
                     }
                     break;

                 case "find":
                     if (userInput.length==2){
                        String name = userInput[1];

                        Contact c = phoneBook.findContactbyName(name);
                        writer.println(c.toString());

                     }else {
                         writer.println("INVALID: formato incorrecto");
                     }
                     break;

                 case "exit":
                     break;

                 default:
                     writer.println("INVALID: Este comando no existe");
                     break;

             }

             if (command.equalsIgnoreCase("exit")){
                 writer.println("BYE.");
                 break;
             }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
