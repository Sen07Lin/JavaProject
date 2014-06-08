import java.util.Scanner;
/**
 * This is where you will put your main method. For instructions on how to
 * create it, refer to the PDF for this homework assignment.
 * 
 * @author Sen Lin
 * 
 */
public class AmusementPark {
    // Leave this variable alone. It is necessary for compilation.
    public static int ticketNumber = 1000;
    public static void main(String[] args) {
        StackInterface<Ticket> ticketStack = new Stack<Ticket>();
        QueueInterface<Patron> patronLine = new Queue<Patron>();
        QueueInterface<Patron> patronHasTicket = new Queue<Patron>();
        System.out.println("Welcome to Sen Lin's Amusement park!");
        boolean quit = false;
        while (!quit) {
            @SuppressWarnings("resource")
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1: Add patron to the back of the line.");
            System.out.println("2: Put a ticket in the pile.");
            System.out.println("3: Get the number of patrons in line.");
            System.out.println("4: Get the number of available tickets.");
            System.out.println("5: Administer a ticket.");
            System.out.println("6: Show patrons with tickets.");
            System.out.println("7: Quit Leave the program.");
            System.out.print("Enter your choice (1-7) here:");
            int answer = keyboard.nextInt();
            keyboard.nextLine();
            if (answer == 1) {
                System.out.print("Enter the name of the patron you"
                        + " would like to add: ");
                String name = keyboard.nextLine();
                patronLine.enqueue(new Patron(name));
                System.out.println("Sucessfully processed");
            } else if (answer == 2) {
                ticketStack.push(new Ticket());
                System.out.println("Sucessfully processed");
            } else if (answer == 3) {
                System.out.println("Number of patronss in the line is: "
                        + patronLine.size());
            } else if (answer == 4) {
                System.out.println("Number of available tickets is: "
                        + ticketStack.size());
            } else if (answer == 5) {
                if (ticketStack.size() == 0) {
                    System.out.println("NO TICKET IS AVAILABLE!");
                } else if (patronLine.size() == 0) {
                    System.out.println("NO PATRON IS ON THE LINE!");
                } else {
                    Patron p = patronLine.dequeue();
                    p.giveTicket(ticketStack.pop());
                    patronHasTicket.enqueue(p);
                    System.out.println("Sucessfully processed");
                }
            } else if (answer == 6) {
                if (patronHasTicket.isEmpty()) {
                    System.out.println("No ticket has been adminstered!");
                }
                QueueInterface<Patron> tempList = new Queue<Patron>();
                while (!patronHasTicket.isEmpty()) {
                    Patron p = patronHasTicket.dequeue();
                    tempList.enqueue(p);
                    System.out.println(p.toString());
                }
                patronHasTicket = tempList;
            } else if (answer == 7) {
                quit = true;
                System.out.println("You have exited the amusement park!");
            } else {
                System.out.println("Wrong entry, "
                        + "please enter an integer between 1-7");
            }
        }
    }
}
