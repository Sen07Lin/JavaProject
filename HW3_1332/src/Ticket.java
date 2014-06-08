/**
 * This class describes the Ticket data structure. DO NOT ALTER!!
 * 
 * @author Steven Wojcio
 * 
 */
public class Ticket {
    private int id;
    public Ticket() {
        id = AmusementPark.ticketNumber;
        AmusementPark.ticketNumber++;
    }
    /**
     * Simple getter for ID of ticket.
     * 
     * @return int id
     */
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "" + id;
    }
}
