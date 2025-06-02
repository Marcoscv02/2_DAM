package marcos.psp.examen.harryPotter.tcp;

import marcos.psp.examen.harryPotter.model.Book;
import marcos.psp.examen.harryPotter.model.Character;
import marcos.psp.examen.harryPotter.model.House;
import marcos.psp.examen.harryPotter.model.Spell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HarryPotterServerWorker implements Runnable{
    private final Socket socket;
    private final Book[] books;
    private final Character[] characters;
    private final House[] houses;
    private final Spell[] spells;

    public HarryPotterServerWorker(Socket socket, Book[] books, Character[] strings, House[] houses, Spell[] spells) {
        this.socket = socket;
        this.books = books;
        this.characters = strings;
        this.houses = houses;
        this.spells = spells;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writter = new PrintWriter(socket.getOutputStream(),true)){
            System.out.println("se ha iniciado un nuevo hilo");

            while (true){
                String[] userInput = reader.readLine().trim().split(" ");
                String command = userInput[0].toUpperCase();

                switch (command){
                    case "SEEBOOKS":
                        if (userInput.length!=1)
                            writter.println("User input format incorrect");
                        else {
                            StringBuilder sbbooks = new StringBuilder();

                            for (Book book: books){
                                sbbooks.append(book.getTitle()).append(" (").append(book.getIndex()).append(")").append(", ");
                            }
                            writter.println(sbbooks);
                        }
                        break;

                    case "BOOK":
                        if (userInput.length!=2)
                            writter.println("User input format incorrect");
                        else {
                            int index = Integer.parseInt(userInput[1]);
                            boolean found = false;

                            for (Book book: books){
                                if (book.getIndex() == index) {
                                    found = true;
                                    writter.println(book);
                                }
                            }

                            if (!found)
                                writter.println("NO coincidences");
                        }
                        break;

                    case "SEECHARACTERS":
                        if (userInput.length!=1)
                            writter.println("User input format incorrect");
                        else {
                            StringBuilder sbCharacters = new StringBuilder();

                            for (Character character: characters){
                                sbCharacters.append(character.getNickname()).append(" (").append(character.getIndex()).append(")").append(", ");
                            }
                            writter.println(sbCharacters);
                        }
                        break;

                    case "CHARACTER":
                        if (userInput.length!=2)
                            writter.println("User input format incorrect");
                        else {
                            int index = Integer.parseInt(userInput[1]);
                            boolean found = false;

                            for (Character character: characters){
                                if (character.getIndex() == index) {
                                    found = true;
                                    writter.println(character);
                                }
                            }

                            if (!found)
                                writter.println("NO coincidences");

                        }
                        break;

                    case "SEEHOUSES":
                        if (userInput.length!=1)
                            writter.println("User input format incorrect");
                        else {
                            StringBuilder sbhouses = new StringBuilder();

                            for (House house: houses){
                                sbhouses.append(house.getHouse()).append(" (").append(house.getIndex()).append(")").append(", ");
                            }
                            writter.println(sbhouses);
                        }
                        break;

                    case "HOUSE":
                        if (userInput.length!=2)
                            writter.println("User input format incorrect");
                        else {
                            int index = Integer.parseInt(userInput[1]);
                            boolean found = false;

                            for (House house: houses){
                                if (house.getIndex()== index) {
                                    found = true;
                                    writter.println(house);
                                }
                            }

                            if (!found)
                                writter.println("NO coincidences");
                        }
                        break;

                    case "SEESPELLS":
                        if (userInput.length!=1)
                            writter.println("User input format incorrect");
                        else {
                            StringBuilder sbspells = new StringBuilder();

                            for (Spell spell: spells){
                                sbspells.append(spell.getSpell()).append(" (").append(spell.getIndex()).append(")").append(", ");
                            }
                            writter.println(sbspells);
                        }
                        break;

                    case "SPELL":
                        if (userInput.length!=2)
                            writter.println("User input format incorrect");
                        else {
                            int index = Integer.parseInt(userInput[1]);
                            boolean found = false;

                            for (Spell spell: spells){
                                if (spell.getIndex()== index) {
                                    found = true;
                                    writter.println(spell);
                                }
                            }

                            if (!found)
                                writter.println("NO coincidences");
                        }
                        break;

                    case "EXIT":
                        if (userInput.length!=1)
                            writter.println("User input format incorrect");
                        else {
                            System.out.println("Se ha desconectado un cliente");
                            writter.println("Good bye");
                        }
                        break;
                    default:
                        writter.println("Unknow command");
                        break;
                }

                if (command.equalsIgnoreCase("exit")) break;
            }


        } catch (IOException e) {
            System.out.println("Error en el worker del servidor: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
