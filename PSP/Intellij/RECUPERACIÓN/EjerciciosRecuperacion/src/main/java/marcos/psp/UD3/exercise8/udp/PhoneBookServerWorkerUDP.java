package marcos.psp.UD3.exercise8.udp;


import marcos.psp.UD3.exercise8.udp.model.Contact;
import marcos.psp.UD3.exercise8.udp.model.PhoneBook;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookServerWorkerUDP implements Runnable{
    private List<Contact> contactList = new ArrayList<>();
    DatagramSocket datagramSocket;
    DatagramPacket datagramPacket;

    public PhoneBookServerWorkerUDP(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        this.datagramSocket = datagramSocket;
        this.datagramPacket = datagramPacket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try {
            PhoneBook phoneBook = new PhoneBook(contactList);

            while (true){
                //Recibir comando del usuario
                System.out.println("Se ha recibido el paquete en el hilo");
                String userinput = new String(datagramPacket.getData(),0,datagramPacket.getLength(),"UTF-8");
                System.out.println(userinput);
                String[] userInputSplit = userinput.trim().split(" ");

                String command = userInputSplit[0];
                System.out.println("command = " + command);

                switch (command){
                    case "add":
                        if (userInputSplit.length == 3){
                            String name = userInputSplit[1];
                            int number = Integer.parseInt(userInputSplit[2]);
                            Contact contact = new Contact(name,number);

                            if (phoneBook.contactAlreadyExists(contact)){
                                sendData("REJECTED: El contacto ya existe.");
                            }else {
                                phoneBook.addContact(contact);
                                sendData("ACCEPTED: El contacto ha sido añadido");
                            }

                        }else {
                            sendData("INVALID: formato incorrecto");
                        }
                        break;

                    case "find":
                        if (userInputSplit.length==2){
                            String name = userInputSplit[1];

                            Contact c = phoneBook.findContactbyName(name);
                            if (c==null)
                                sendData("REJECTED. Contacto no encontrado");
                            else
                                sendData(c.toString());

                        }else {
                            sendData("INVALID: formato incorrecto");
                        }
                        break;

                    case "exit":
                        break;

                    default:
                        sendData("INVALID: Este comando no existe");
                        break;
                }

                if (command.equalsIgnoreCase("exit")) break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void  sendData (String data) throws IOException {
        byte [] output = data.getBytes();

        int port= datagramPacket.getPort();
        InetAddress clientAddres = datagramPacket.getAddress();
        DatagramPacket sendPacket = new DatagramPacket (output, output.length, clientAddres, port);

        datagramSocket.send(sendPacket);
        System.out.println("Se ha enviado información al cliente: "+ data);
    }
}
