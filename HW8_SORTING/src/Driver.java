import java.util.Random;
import java.util.Scanner;
/**
 * Driver class to run sorting
 * @author Sen
 *
 */
public class Driver {
    public static void main(final String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out
            .println("Please enter the size of the array you would like to sort or enter 0 to exit:");
            @SuppressWarnings("resource")
            Scanner keyboard = new Scanner(System.in);
            int size = keyboard.nextInt();
            if (size == 0) {
                quit = true;
            } else {
                Sorting sort = new Sorting();
                Random r = new Random();
                Integer[] array1 = new Integer[size];
                Integer[] array2 = new Integer[size];
                Integer[] array3 = new Integer[size];
                Integer[] array4 = new Integer[size];
                Integer[] array5 = new Integer[size];
                int[] array6 = new int[size];
                
                for (int i = 0; i < size; i++) {
                    array1[i] = r.nextInt(size * 100);
                    array2[i] = array1[i];
                    array3[i] = array1[i];
                    array4[i] = array1[i];
                    array5[i] = array1[i];
                    array6[i] = array1[i];
                }
                long startTime = System.nanoTime();
                System.out.print("The unsorted list is :");
                for (Integer i : array1) {
                    System.out.print(i + " ");
                }
                System.out.println("");
                sort.mergesort(array1);
                System.out.print("The sorted list is :");
                for (int i = 0; i < array1.length; i++) {
                    System.out.print(array1[i] + " ");
                }
                long stopTime = System.nanoTime();
                long elapsedTime = stopTime - startTime;
                System.out.println("\n");
                System.out.println("Time spent on bubble sort was: "
                        + elapsedTime / 1000000000.0 + " seconds");
                
                
                startTime = System.nanoTime();
                sort.insertionsort(array2);
                stopTime = System.nanoTime();
                elapsedTime = stopTime - startTime;
                System.out.println("Time spent on insertion sort was: "
                        + elapsedTime / 1000000000.0 + " seconds");
                
                
                
                startTime = System.nanoTime();
                sort.selectionsort(array3);
                stopTime = System.nanoTime();
                elapsedTime = stopTime - startTime;
                System.out.println("Time spent on selection sort was: "
                        + elapsedTime / 1000000000.0 + " seconds");
                
                
                
                startTime = System.nanoTime();
                sort.mergesort(array4);
                stopTime = System.nanoTime();
                elapsedTime = stopTime - startTime;
                System.out.println("Time spent on merge sort was: "
                        + elapsedTime / 1000000000.0 + " second");
                
                startTime = System.nanoTime();
                
                sort.quicksort(array5, r);
                stopTime = System.nanoTime();
                elapsedTime = stopTime - startTime;
                System.out.println("Time spent on quick sort was: "
                        + elapsedTime / 1000000000.0 + " second");
                
                startTime = System.nanoTime();
                
                sort.radixsort(array6);
                stopTime = System.nanoTime();
                elapsedTime = stopTime - startTime;
                System.out.println("Time spent on radix sort was: "
                        + elapsedTime / 1000000000.0 + " second");
            }
        }
    }
}
