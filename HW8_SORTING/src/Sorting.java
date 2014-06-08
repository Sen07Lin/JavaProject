import java.util.ArrayList;
import java.util.Random;
/**
 * The class for 6 sorting methods
 * @author Sen
 *
 */
public class Sorting implements SortingInterface {
    @Override
    public <T extends Comparable<T>> void bubblesort(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    @Override
    public <T extends Comparable<T>> void insertionsort(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i < arr.length; i++) {
            T toBeSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(toBeSort) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = toBeSort;
        }
    }
    @Override
    public <T extends Comparable<T>> void selectionsort(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfSmallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[indexOfSmallest].compareTo(arr[j]) > 0) {
                    indexOfSmallest = j;
                }
            }
            T temp = arr[indexOfSmallest];
            arr[indexOfSmallest] = arr[i];
            arr[i] = temp;
        }
    }
    @Override
    public <T extends Comparable<T>> void quicksort(T[] arr, Random r) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quicksortHelper(arr, r, 0, arr.length - 1);
    }
    /**
     * The private helper method for quick sort
     * @param arr the array to be sorted
     * @param r the random object
     * @param low the index of the low side
     * @param high the index of the high side
     */
    private <T extends Comparable<T>> void quicksortHelper(T[] arr, Random r,
            int low, int high) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        int i = low;
        int j = high;
        int pivotIndex = r.nextInt(j - i) + i;
        while (i <= j) {
            while (arr[i].compareTo(arr[pivotIndex]) < 0) {
                i++;
            }
            while (arr[j].compareTo(arr[pivotIndex]) > 0) {
                j--;
            }
            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quicksortHelper(arr, r, low, j);
        }
        if (i < high) {
            quicksortHelper(arr, r, i, high);
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public <T extends Comparable<T>> T[] mergesort(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        if (arr.length > 1) {
            int mid = arr.length / 2;
            T[] leftArray = (T[]) new Comparable[mid];
            T[] rightArray = (T[]) new Comparable[arr.length - mid];
            for (int i = 0; i < mid; i++) {
                leftArray[i] = arr[i];
            }
            for (int j = mid; j < arr.length; j++) {
                rightArray[j - mid] = arr[j];
            }
            // merge
            merge(arr, mergesort(leftArray), mergesort(rightArray));
        }
        return arr;
    }
    /**
     * The private method to merger to sorted arrays
     * @param arr the array to store values of the merged array
     * @param a left sorted array
     * @param b right sorted array
     */
    private <T extends Comparable<T>> void merge(T[] arr, T[] a, T[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        // One of a or b will be running out of element during the comparison
        // process.
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) < 0) {
                arr[k] = a[i];
                k++;
                i++;
            } else {
                arr[k] = b[j];
                k++;
                j++;
            }
        }
        // copying the rest of b into mergedArray
        if (i >= a.length) {
            for (int o = 0; o < b.length - j; o++) {
                arr[o + k] = b[o + j];
            }
        } else {
            // copying the rest of a into mergedArray
            for (int o = 0; o < a.length - i; o++) {
                arr[o + k] = a[o + i];
            }
        }
    }
    @Override
    public int[] radixsort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        int maxDigitLenth = findMaxDigit(arr);
        if (maxDigitLenth != -1) {
            int exp = 1;
            for (int i = 0; i < maxDigitLenth; i++) {
                @SuppressWarnings("unchecked")
                ArrayList<Integer>[] bucketList = new ArrayList[10];
                for (int k = 0; k < 10; k++) {
                    bucketList[k] = new ArrayList<Integer>();
                }
                for (int j = 0; j < arr.length; j++) {
                    // get digit of each number
                    int hashNum = (arr[j] / exp) % 10;
                    bucketList[hashNum].add(arr[j]);
                }
                exp *= 10;
                int index = 0;
                // update the arr
                for (int k = 0; k < 10; k++) {
                    for (Integer num : bucketList[k]) {
                        arr[index] = num;
                        index++;
                    }
                }
            }
            return arr;
        } else {
            return null;
        }
    }
    /**
     * The helper method to find the maximum digit length
     * @param arr the array to be sorted
     * @return the length of the maximum digit length, -1 if the array is empty
     */
    private int findMaxDigit(int[] arr) {
        if (arr.length > 0) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            int divisor = 1;
            int digitLength = 0;
            boolean done = false;
            while (!done) {
                if (max / divisor > 0) {
                    digitLength++;
                    divisor *= 10;
                } else {
                    done = true;
                }
            }
            return digitLength;
        } else {
            return -1;
        }
    }
}
