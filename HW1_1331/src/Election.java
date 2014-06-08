import java.util.Scanner;

/**
 * This class represents the procedure of the election.
 * @author Sen
 * @version 1.0
 */
public class Election {
    /**
     * the main method of the procedure.
     * @param args takes java Election
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the election!");
        boolean quit = false;
        BallotBox myBox = new BallotBox();
        while (!quit) {
            @SuppressWarnings("resource")
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1: Vote for a candidate");
            System.out.println("2: Count the number of votes for a candidate");
            System.out.println("3: Remove a vote");
            System.out.println("4: Get number of votes in the ballot box");
            System.out.println("5: Empty the ballot box");
            System.out.println("6: Print all votes");
            System.out.println("7: Quit");
            System.out.print("Enter your choice (1-7) here:");
            int answer = keyboard.nextInt();
            keyboard.nextLine();
            if (answer == 1) {
                System.out.print("Enter the name of the candidate you"
                        + " would like to vote for: ");
                String name = keyboard.nextLine();
                System.out.print("Enter bribe amount: ");
                int bribe = keyboard.nextInt();
                myBox.add(new Ballot(name, bribe));
            } else if (answer == 2) {
                boolean found = false;
                System.out.println("Enter the name of the candidate:");
                String cN = keyboard.nextLine();
                for (Ballot b : myBox.toArray()) {
                    if (b.getName().equals(cN)) {
                        found = true;
                        System.out.println("Number of votes for " + cN
                                + " is: " + myBox.getFrequencyOf(b));
                    }
                }
                if (!found) {
                    System.out.println("This candidate has not been voted!");
                }
            } else if (answer == 3) {
                myBox.remove();
            } else if (answer == 4) {
                System.out.println("The number of votes in the box is:"
                        + myBox.getCurrentSize());
            } else if (answer == 5) {
                myBox.clear();
                System.out.println("The box is empty now!");
            } else if (answer == 6) {
                if (myBox.isEmpty()) {
                    System.out.println("The box is empty!");
                }
                for (int j = 0; j < myBox.getCurrentSize(); j++) {
                    System.out.println(myBox.toArray()[j].toString());
                }
            } else if (answer == 7) {
                quit = true;
                System.out.println("You have exited the voting system!");
            } else {
                System.out.println("Wrong entry, "
                        + "please enter an integer between 1-7");
            }
        }
    }
}
