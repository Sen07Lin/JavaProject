import java.util.List;
import java.util.Scanner;
/**
 * The Driver class runs everything a user needs to add, remove, list, debug a
 * data structure that is collected by BST.
 * @author Sen
 * @version 1.0
 */
public class Driver {
    public static void main(final String[] args) {
        BSTInterface<User> tree = new BST<>();
        boolean exit = false;
        while (!exit) {
            System.out.print("Please enter a command line: ");
            @SuppressWarnings("resource")
            Scanner keyboard = new Scanner(System.in);
            String answer = keyboard.nextLine();
            if (answer.equals("Add") || answer.equals("add")) {
                System.out.print("Please enter the user name: ");
                String userName = keyboard.nextLine();
                System.out.print("Please enter the name: ");
                String name = keyboard.nextLine();
                User newUser = new User(userName, name);
                if (!tree.contains(newUser)) {
                    tree.add(newUser);
                }
            } else if (answer.equals("Remove") || answer.equals("remove")) {
                if (!tree.isEmpty()) {
                    System.out
                    .print("Please enter a username you would like to remove : ");
                    String toRemove = keyboard.nextLine();
                    User toRemoveUser = new User(toRemove, "temp");
                    if (!tree.contains(toRemoveUser)) {
                        System.out.println("User does not exist!");
                    } else {
                        tree.remove(toRemoveUser);
                        System.out.println("Remove was successful !");
                    }
                } else {
                    System.out.println("List is empty now");
                }
            } else if (answer.equals("debug") || answer.equals("Debug")) {
                System.out.println("String representation of tree :");
                System.out.println(tree.toString());
            } else if (answer.equals("list") || answer.equals("List")) {
                if (!tree.isEmpty()) {
                    System.out.println("List of current users :");
                    List<User> userList = tree.inOrder();
                    for (User u : userList) {
                        System.out.print(u.toString() + ", ");
                    }
                    System.out.println("");
                } else {
                    System.out.println("List is empty!");
                }
            } else if (answer.equals("find") || answer.equals("Find")) {
                if (!tree.isEmpty()) {
                    System.out
                    .print("Please enter a username you would like to find : ");
                    String toFind = keyboard.nextLine();
                    User queryUser = new User(toFind, "temp");
                    if (!tree.contains(queryUser)) {
                        System.out.println("User does not exist!");
                    } else {
                        System.out.println(tree.get(queryUser).toString());
                    }
                } else {
                    System.out.println("List is empty!");
                }
            } else if (answer.equals("exit") || answer.equals("Exit")) {
                exit = true;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Wrong entry!");
            } // end of big if statement
        } // end of while loop
    } // end of main
} // end of class
