import java.util.Scanner;
/**
 * The class to run string search.
 * @author Sen
 */
public class Driver {
    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Please enter a haystack(enter empty to quit)");
            @SuppressWarnings("resource")
            Scanner keyboard = new Scanner(System.in);
            String haystack = keyboard.nextLine();
            if (haystack.length() <= 0){
                System.out.println("You have exited string search");
                quit = true;
            }
            System.out
            .println("Please enter a haystack(enter empty string to quit)");
            String needle = keyboard.nextLine();
            if (needle.length() <= 0) {
                System.out.println("You have exited string search");
                quit = true;
            } else {
                StringSearch stringSearch = new StringSearch();
                long startTime = System.nanoTime();
                System.out.println("The Boyer Moore :");
                System.out.print("String found at :"
                        + stringSearch.boyerMoore(needle, haystack));
                long stopTime = System.nanoTime();
                long elapsedTime = stopTime - startTime;
                System.out.println("\n");
                System.out.println("Time spent : " + elapsedTime / 1000000000.0
                        + " seconds");
                startTime = System.nanoTime();
                System.out.println("The Rabin Karp :");
                System.out.print("String found at :"
                        + stringSearch.rabinKarp(needle, haystack));
                stopTime = System.nanoTime();
                elapsedTime = stopTime - startTime;
                System.out.println("\n");
                System.out.println("Time spent : " + elapsedTime / 1000000000.0
                        + " seconds");
            }
        }
    }
}
