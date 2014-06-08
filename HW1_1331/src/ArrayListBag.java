import java.util.ArrayList;
import java.util.Random;

/**
 * ArrayListBag implements BagInterface<T>. and defines the methods of
 * BagInterface inside this class.
 * @param <T> Generic type class.
 * @author Sen
 * @version 1.0
 */
public class ArrayListBag<T> implements BagInterface<T> {
    private int numOfItems;
    private ArrayList<T> list;
    /**
     * Public constructor for ArrayListBag.
     */
    public ArrayListBag() {
        list = new ArrayList<T>();
        numOfItems = 0;
    }
    @Override
    /**
     * get # of items in the bags.
     */
    public int getCurrentSize() {
        return numOfItems;
    }
    /**
     * setter method for numOfItems.
     * @param numOfItems number to be set
     */
    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
    /**
     * getter method for list.
     * @return return the list
     */
    public ArrayList<T> getList() {
        return list;
    }
    /**
     * setter method for list.
     * @param list the list that sets this.list
     */
    public void setList(ArrayList<T> list) {
        this.list = list;
    }
    @Override
    /**
     * Sees whether this bag is empty.
     * @return true if the bag is empty, or false if not
     */
    public boolean isEmpty() {
        return (numOfItems == 0);
    }
    @Override
    /**
     * Adds a new entry to this bag. If the new entry is null it should not be
     * added.
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
    public boolean add(T newEntry) {
        if (newEntry == null) {
            return false;
        } else {
            numOfItems++;
            return list.add(newEntry);
        }
    }
    @Override
    /**
     * Removes one unspecified entry from this bag, if possible. Entry must be
     * randomly chosen. (NOTE: the book's code in the ArrayBag implementation
     * did not chose randomly. This method must choose the entry randomly.)
     * @return the removed entry if the removal was successful, or null
     *         otherwise
     */
    public T remove() {
        if (!isEmpty()) {
            numOfItems--;
            Random generator = new Random();
            int index = generator.nextInt(numOfItems + 1);
            return list.remove(index);
        } else {
            return null;
        }
    }
    @Override
    /**
     * Removes one occurrence of a given entry from this bag.
     * @param anEntry the entry to be removed
     * @return true if the removal was successful, or false otherwise
     */
    public boolean remove(T anEntry) {
        if (!isEmpty()) {
            numOfItems--;
            return list.remove(anEntry);
        } else {
            return false;
        }
    }
    /**
     * Removes all entries from this bag.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }
    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (T item : list) {
            if (item.equals(anEntry)) {
                count++;
            }
        }
        return count;
    }
    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry the entry to locate
     * @return true if this bag contains anEntry, or false otherwise
     */
    @Override
    public boolean contains(T anEntry) {
        for (T item : list) {
            if (item.equals(anEntry)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Creates an array of all entries that are in this bag. It does not destroy
     * or alter the bag in any way. If the bag is actually empty, this will
     * still create an array, but it will have length 0.
     * @return a newly allocated array of all the entries in the bag
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) list.toArray(); // unchecked cast
        return result;
    }
}
