package marcos.psp.examen.clemenRaffle_examen.model;

public class Winner {
    private Ticket ticket;
    private boolean iswinner;

    public Winner() {
    }

    public Winner(Ticket ticket, boolean iswinner) {
        this.ticket = ticket;
        this.iswinner = iswinner;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isIswinner() {
        return iswinner;
    }

    public void setIswinner(boolean iswinner) {
        this.iswinner = iswinner;
    }

    @Override
    public String toString() {
        return "Winner{" +
                "ticket=" + ticket +
                ", iswinner=" + iswinner +
                '}';
    }
}
