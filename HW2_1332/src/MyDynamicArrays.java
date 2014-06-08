import java.util.Collection;
import java.util.Iterator;


/**
 * This class provides an implementation of an Array that
 * dynamically resizes.
 * @author Alexander Langford
 */
public class MyDynamicArrays<T> implements DynamicArrayInterface<T> {

    private static final int DEFAULT_CAPACITY = 10;

    //Add instance variables here, they must be private
    private T[] arr;
    private int numberOfElements;
    private int initialCapacity;

    /**
     * Default constructor for MyDynamicArray.
     * Default capacity is 10.
     */
    public MyDynamicArrays() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor for MyDynamicArray.
     * @param capacity The initial capacity of the Dynamic Array.
     */
    public MyDynamicArrays(int capacity) {
        this.numberOfElements = 0;
        this.initialCapacity = capacity;
        @SuppressWarnings("unchecked")
        T[] initArr = (T[]) new Object[capacity];
        this.arr = initArr;
    }

    /**
     * Adds an item to the Dynamic Array.
     * Checks to see if the backing array is full, and resizes it
     * accordingly.
     * @param toAdd The item to be added.
     */
    @Override
    public void add(T toAdd) {
        if (toAdd == null) {
            return;
        }
        if (isFull()) {
            resize();
        }
        this.arr[this.numberOfElements] = toAdd;
        this.numberOfElements++;
    }

    /**
     * Adds all the itmes of a collection to this DynamicArray.
     * Depending on the type of collection, there is no guarantee
     * for the order of the items. Null items are not added.
     * @param collection The collection to be added.
     */
    @Override
    public void addAll(Collection<T> collection) {
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T toAdd = iter.next();
            if (toAdd != null) {
                this.add(toAdd);
            }
        }
    }

    /**
     * Method to remove a specific item from the DynamicArray.
     * Only removes the first instance of the item.
     * @param toRemove The item to remove
     * @return The removed element.
     */
    @Override
    public T remove(T toRemove) {
        boolean exists = false;
        int i = 0;
        // "While" was chosen over "for" to avoid using a break statement
        // and preserving the ability to discontinue once found
        while (i < this.arr.length && !exists) {
            if (this.arr[i].equals(toRemove)) {
                exists = true;
            }
            i++;
        }

        if (exists) {
            // i - 1 because i was incremented after the item was found
            return this.remove(i - 1);
        }

        return null;
    }

    /**
     * Removes the item at given index, assuming the index is valid.
     * @param index The index at which the item to be removed is located.
     * @return The removed item. Null if the index is not valid.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index > this.arr.length - 1) {
            return null;
        }
        T removed = this.arr[index];
        this.arr[index] = null;
        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i - 1] = this.arr[i];
        }
        this.arr[this.arr.length - 1] = null;
        this.numberOfElements--;
        return removed;
    }

    /**
     * Method to get the item at a given index.
     * Checks for the validity of the index.
     * @param inde The index at which to look for the element.
     * @return The item at the index. Otherwise, returns null.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > this.arr.length - 1) {
            return null;
        }
        return this.arr[index];
    }

    /**
     * Method to check if a given object is in the DynamicArray.
     * @param obj The object to check for.
     * @return True if the object is in the DynamicArray. False otherwise.
     */
    @Override
    public boolean contains(T obj) {
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the Dynamic Array in array form.
     * Because DynamicArrays are implemented using arrays,
     * it can just return the backing array.
     * @return The backing array.
     */
    @Override
    public T[] toArray() {
        return this.arr;
    }

    /**
     * Method to check if the DynamicArray is empty.
     * @return True if DynamicArray is empty. False otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.numberOfElements == 0;
    }

    /**
     * Clears the DynamicArray, setting it back to its original state.
     */
    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] initArr = (T[]) new Object[initialCapacity];
        this.arr = initArr;
        this.numberOfElements = 0;
    }

    /**
     * Method to return the number of elements in the Dynamic Array.
     * @return The number of elements in the Dynamic Array.
     */
    @Override
    public int size() {
        return this.numberOfElements;
    }

    private boolean isFull() {
        return this.arr.length == this.numberOfElements;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        T[] biggerArr = (T[]) new Object[this.arr.length * 2];

        for (int i = 0; i < this.arr.length; i++) {
            biggerArr[i] = this.arr[i];
        }

        this.arr = biggerArr;
    }
}
