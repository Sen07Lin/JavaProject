public class Fac {

    /**
     * The factorial of n is n * facotrial of n-1 for n > 1, otherwise 1.
     */
    public static int fac(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fac(n-1) + fac(n-2) ;
        }
    }

    /**
     * An iterative facotrial function using a helper method to create
     * the iterations.
     */
    private static int facIter(int n) {
        return facHelper(n, 1);
    }

    /**
     * Designed to be called by facIter.  accum accumulates the answer as
     * n decrements to the base case.
     */
    private static int facHelper(int n, int accum) {
        if (n <= 1) {
            return accum;
        } else {
            return facHelper(n - 1, n * accum);
        }
    }

    /*
    Iterative process
    facHelper(5);
    facHelper(4, 5);
    facHelper(3, 20);
    facHelper(2, 60);
    facHelper(1, 120);
    120

    Recursive process
    fac(5);
    5 * fac(4);
    5 * 4 * fac(3);
    5 * 4 * 3 * fac(2);
    5 * 4 * 3 * 2 *fac(1);
    5 * 4 * 3 * 2 * 1;
    5 * 4 * 3 * 2;
    5 * 4 * 6;
    5 * 24;
    120;
     */

    public static void main(String[] args) {
        int n = 6;
        //Integer.parseInt(args[0]);
        System.out.println(fac(n));
        System.out.println(facIter(n));
    }
}
