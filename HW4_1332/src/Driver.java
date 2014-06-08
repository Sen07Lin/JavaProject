import java.util.Scanner;
/**
 * The Driver class runs everything a user needs to add, remove, list, reverse a
 * list.
 * @author Sen
 * @version 1.0
 */
public class Driver {
    public static void main(final String[] args) {
        LinkedListInterface<Integer> list = new DoublyLinkedList<>();
        boolean exit = false;
        System.out.println("This list currently has " + list.size()
                + " elements :");
        while (!exit) {
            System.out.println("Enter a command line: ");
            @SuppressWarnings("resource")
            Scanner keyboard = new Scanner(System.in);
            String answer = keyboard.nextLine();
            if (answer.equals("Add") || answer.equals("add")) {
                System.out.print("What number would you like to add ?");
                int i = keyboard.nextInt();
                System.out.print("Where would you like to add? ");
                keyboard.nextLine();
                String addPosition = keyboard.nextLine();
                if (addPosition.equals("front") || addPosition.equals("Front")) {
                    // add front
                    list.add(0, i);
                } else if (addPosition.equals("back")
                        || addPosition.equals("Back")) {
                    // add back
                    list.add(list.size(), i);
                } else if (Integer.parseInt(addPosition) >= 0
                        && Integer.parseInt(addPosition) <= list.size()) {
                    // add middle
                    list.add(Integer.parseInt(addPosition), i);
                } else {
                    System.out.println("Wrong entry!");
                }
            } else if (answer.equals("Remove") || answer.equals("remove")) {
                if (!list.isEmpty()) {
                    System.out.print("Remove by location(1) or by data(2)? ");
                    int k = keyboard.nextInt();
                    keyboard.nextLine();
                    if (k == 1) {
                        System.out.print("Where would you like to remove? ");
                        String removePosition = keyboard.nextLine();
                        if (removePosition.equals("front")
                                || removePosition.equals("Front")) {
                            // remove front
                            list.remove(0);
                        } else if (removePosition.equals("back")
                                || removePosition.equals("Back")) {
                            // remove back
                            list.remove(list.size() - 1);
                        } else if (Integer.parseInt(removePosition) >= 0
                                && Integer.parseInt(removePosition) < list
                                .size()) {
                            // remove middle
                            list.remove(Integer.parseInt(removePosition));
                        } else {
                            System.out.println("Wrong entry!");
                        }
                    } else if (k == 2) {
                        System.out.print("What would you like to remove? ");
                        int removeItem = keyboard.nextInt();
                        if (list.contains(removeItem)) {
                            list.remove((Object) removeItem);
                        } else {
                            System.out
                            .println("Doesn't contain this item in the list ");
                        }
                    } else {
                        System.out.println("Wrong entry!");
                    }
                } else {
                    System.out.println("List is empty now");
                }
            } else if (answer.equals("reverse") || answer.equals("Reverse")) {
                list.reverseList();
            } else if (answer.equals("list") || answer.equals("List")) {
                if (!list.isEmpty()) {
                    System.out.print("List: ");
                    for (Integer j : list) {
                        System.out.print(j + " ");
                    }
                    System.out.println("");
                } else {
                    System.out.println("List is empty!");
                }
            } else if (answer.equals("exit") || answer.equals("Exit")) {
                exit = true;
            } else {
                System.out.println("Wrong entry!");
            } // end of big if statement
        } // end of while loop
    } // end of main
} // end of class
