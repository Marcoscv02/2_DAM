package repaso.exercise8.server;

import repaso.exercise8.model.Contact;
import repaso.exercise8.model.PhoneBook;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ContactServerWorker implements Runnable{
    private SSLSocket clientSocket;
    public  static PhoneBook phoneBook = new PhoneBook();
    private static String name;
    private static long number;

    public ContactServerWorker(SSLSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writter = new PrintWriter(clientSocket.getOutputStream());

            while (true){
                String command = reader.readLine();
                command = command.toLowerCase();
                System.out.println("Comando recibido "+command);

                String [] userInput = command.split(" ");
                String first = userInput[0];



                switch (first){
                    case "add":

                        System.out.println("add");
                        if (userInput.length!=3){
                            writter.println("ERROR. This command is invalid");
                            writter.flush();
                            break;

                        }else {
                             name = userInput[1];
                             number = Long.parseLong(userInput[2]);

                            if (!phoneBook.isContactDuplicated(number)){

                                phoneBook.addContact(name,number);
                                writter.println("ACCEPTED. The contact didn't exists and it's already agregated");
                                writter.flush();
                                break;

                            }else {
                                writter.println("REJECTED. The contact already exists");
                                writter.flush();
                                break;
                            }
                        }


                    case "find":

                        System.out.println("find");
                        if (userInput.length!=2){
                            writter.println("ERROR. This command is invalid");
                            writter.flush();
                            break;

                        }else {

                            String name = userInput[1];
                            Contact contact = phoneBook.findContactbyName(name);

                            if (contact!=null){
                                writter.println(contact.toString());
                                writter.flush();
                                break;

                            }else {
                                writter.println("INVALID. This contact doesn't exist");
                                writter.flush();
                                break;
                            }
                        }



                    case "delete":

                        if (userInput.length!=2){
                            writter.println("ERROR. This command is invalid");
                            writter.flush();
                            break;

                        }else {
                            System.out.println("delete");
                            number = Long.parseLong(userInput[1]);

                            boolean isDeleted = phoneBook.deleteContactbyNumber(number);

                            if (isDeleted){
                                writter.println("this contact has been deleted");
                                writter.flush();
                                break;

                            }else {
                                writter.println("This contact couldn't be deleted");
                                writter.flush();
                                break;
                            }
                        }


                    case "exit":
                        System.out.println("exit");
                        writter.write("BYE. Closing program...");
                        writter.flush();
                        break;


                    default:
                        System.out.println("default");
                        writter.println("INVALID. This command doesnt exists");
                        writter.flush();
                        break;
                }

                if (command.equalsIgnoreCase("exit"))
                    break;
            }
            clientSocket.close();
            writter.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("ERROR. Has ocurred an error in server's thread");
            throw new RuntimeException(e);
        }


    }
}
