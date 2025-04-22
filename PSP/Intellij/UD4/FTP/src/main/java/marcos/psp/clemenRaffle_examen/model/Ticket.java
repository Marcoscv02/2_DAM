package marcos.psp.clemenRaffle_examen.model;

import java.util.Random;

public class Ticket {
    private String clientName;
    private int numChars;
    private String value;

    public Ticket(String clientName, int numChars) {
        this.clientName = clientName;
        this.numChars = numChars;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getNumChars() {
        return numChars;
    }

    public void setNumChars(int numChars) {
        this.numChars = numChars;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String generatedValue (){
        StringBuilder sb = new StringBuilder();
        Random random= new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        for (int i = 0; i < numChars; i++) {
            sb.append(chars[random.nextInt(chars.length)]);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "clientName='" + clientName + '\'' +
                ", numChars=" + numChars +
                ", value='" + value + '\'' +
                '}';
    }
}
