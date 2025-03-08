package repaso.exercise8.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    List<Contact> phoneBook = new ArrayList<>();

    public PhoneBook() {
    }

    public List<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    /**Añadir contacto*/
    public void addContact (String name, long number){
        Contact contact= new Contact(name,number);
        phoneBook.add(contact);
    }

    /**Buscar contacto por nombre*/
    public Contact findContactbyName (String name){
        for (Contact c:phoneBook){
            if (c.getName().equalsIgnoreCase(name))
                return c;
        }
        System.out.println("No se ha encontrado ningun contacto que coincida con ese nombre");
        return null;
    }

    /**Buscar contacto por número*/
    public Contact findContactbyNumber (long number){
        for (Contact c:phoneBook){
            if (c.getNumber()==number)
                return c;
        }
        System.out.println("No se ha encontrado ningun contacto con ese número");
        return null;
    }

    /**Eliminar contacto*/
    public boolean deleteContact (Contact contact){
        for (Contact c:phoneBook){
            if (c.equals(contact)) {
                phoneBook.remove(c);
                return true;
            }
        }
        System.out.println("No se ha podido eliminar este contacto");
        return false;
    }

    /**Eliminar contacto*/
    public boolean deleteContactbyNumber (long number){
        for (Contact c:phoneBook){
            if (c.getNumber()==number) {
                phoneBook.remove(c);
                return true;
            }
        }
        System.out.println("No se ha encontrado este contacto");
        return false;
    }



    /**Buscar si un contacto esta duplicado*/
    public  boolean isContactDuplicated (long number){
        for (Contact c:phoneBook){
            if (c.getNumber()==number)
                return true;
        }
        System.out.println("No se ha encontrado ningun contacto qu coincida");
        return false;
    }
}
