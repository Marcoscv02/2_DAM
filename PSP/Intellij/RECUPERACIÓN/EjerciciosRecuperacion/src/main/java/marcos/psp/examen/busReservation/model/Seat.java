package marcos.psp.examen.busReservation.model;

public class Seat {
    private int number;
    private String userName;
    private boolean free = true;
    private String email;


    public Seat() {
    }

    public Seat(int number) {
        this.number = number;
    }

    public Seat(int number, String userName, boolean free, String email) {
        this.number = number;
        this.userName = userName;
        this.free = free;
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Seat:\tnumber: " + number +"\tuserName:" + userName;
    }
}
