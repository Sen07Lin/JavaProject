/**
 * This class describes the Patron data structure. DO NOT ALTER!!
 * 
 * @author Steven Wojcio
 * 
 */
public class Patron {
    private String name;
    private Ticket ticket = null;
    public Patron(String name) {
        this.name = name;
    }
    /**
     * Simple getter for name field.
     * 
     * @return String name of the patron
     */
    public String getName() {
        return name;
    }
    /**
     * Simple setter for the ticket. Called 'give' instead of set for
     * verisimilitude.
     * 
     * @param ticket
     */
    public void giveTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    /**
     * Simple getter for ticket
     * 
     * @return Ticket object associated with patron
     */
    public Ticket getTicket() {
        return ticket;
    }
    @Override
    public String toString() {
        if (ticket != null) {
            return name + " => Ticket Number: " + ticket;
        } else {
            return name + " => [NO TICKET]";
        }
    }
}
