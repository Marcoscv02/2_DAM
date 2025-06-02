package marcos.psp.UD3.exercise8.udp.model;

import java.util.List;

public class PhoneBook {
    private List<Contact> phoneBook;

    public PhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public List<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addContact (Contact contact){
        phoneBook.add(contact);
    }

    public Contact findContact (Contact contact){
        for (Contact c: phoneBook){
            if (c.equals(contact)){
                return c;
            }
        }
        return null;
    }

    public Contact findContactbyName (String name){
        for (Contact c: phoneBook){
            if (c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }

    public boolean contactAlreadyExists ( Contact contact){
        for (Contact c: phoneBook){
            if (c.equals(contact)){
                return true;
            }
        }
        return false;
    }

}
