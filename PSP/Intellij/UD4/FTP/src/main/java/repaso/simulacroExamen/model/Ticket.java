package repaso.simulacroExamen.model;

public class Ticket {
    private int idTicket;
    private String name;
    private  boolean ocupado = false;

    public Ticket() {
    }

    public Ticket(int idTicket, String name, boolean ocupado) {
        this.idTicket = idTicket;
        this.name = name;
        this.ocupado = ocupado;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", name='" + name + '\'' +
                ", ocupado=" + ocupado +
                '}';
    }
}
