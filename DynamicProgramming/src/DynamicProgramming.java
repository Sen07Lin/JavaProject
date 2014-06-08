/**
 * Assignment to teach dynamic programming using 3 simple example problems:
 * 1. Fibonacci numbers
 * 2. Longest common subsequence
 * 3. Edit distance
 * @author Sen Lin
 */
public class DynamicProgramming {
    /**
     * Calculates the nth fibonacci number: fib(n) = fib(n-1) + fib(n-2).
     * Remember that fib(0) = 0 and fib(1) = 1.
     * This should NOT be done recursively - instead, use a 1 dimensional
     * array so that intermediate fibonacci values are not re-calculated.
     * The running time of this function should be O(n).
     * @param n A number
     * @return The nth fibonacci number
     */
    public static int fib(int n) {
        // n+2 avoiding out of boundary when n = 0
        int[] memArray = new int[n + 2];
        memArray[0] = 0;
        memArray[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            memArray[i] = memArray[i - 2] + memArray[i - 1];
        }
        return memArray[n];
    }
    /**
     * Calculates the length of the longest common subsequence between a and b.
     * @param a
     * @param b
     * @return The length of the longest common subsequence between a and b
     */
    public static int lcs(String a, String b) {
        int[][] array = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 0;
        }
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = 0;
        }
        for (int j = 1; j < array[0].length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (a.charAt(i - 1) == (b.charAt(j - 1))) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
        return array[array.length - 1][array[0].length - 1];
    }
    /**
     * Calculates the edit distance between two strings.
     * @param a A string
     * @param b A string
     * @return The edit distance between a and b
     */
    public static int edit(String a, String b) {
        int[][] array = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < array.length; i++) {
            array[i][0] = i;
        }
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = i;
        }
        for (int j = 1; j < array[0].length; j++) {
            for (int i = 1; i < array.length; i++) {
                // System.out.println(a.charAt(i - 1) + " " + b.charAt(j - 1));
                if (a.charAt(i - 1) != (b.charAt(j - 1))) {
                    array[i][j] =
                            Math.min(Math.min(array[i - 1][j] + 1,
                                    array[i][j - 1] + 1),
                                    array[i - 1][j - 1] + 1);
                } else {
                    array[i][j] =
                            Math.min(Math.min(array[i - 1][j] + 1,
                                    array[i][j - 1] + 1), array[i - 1][j - 1]);
                }
            }
        }
        /*for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array[0].length; i++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }*/
        
        return array[array.length - 1][array[0].length - 1];
    }
}
