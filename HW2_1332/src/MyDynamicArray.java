import java.util.Collection;
/**
 * This generic class implements DynamicArrayInterface<T>. It basically does all
 * features of a dynamic bag. It uses a backing array to collect data, will
 * increase its size dynamically.
 * 
 * @author Sen Lin
 * @version 1.0
 */
public class MyDynamicArray<T> implements DynamicArrayInterface<T> {

    private T[] items;
    private int count;
    private int capacity;
    private static final int DEFAULT_INITIAL_CAPACITY =  10;
    /**
     * Public constructor of MyDynamicArray. It initiates itss size to 10.
     */
    public MyDynamicArray() {
        this(DEFAULT_INITIAL_CAPACITY);
        this.capacity = DEFAULT_INITIAL_CAPACITY;
    }
    /**
     * Creates an empty MyDynamicArray having a given initial capacity.
     * 
     * @param capacity the integer capacity desired
     */
    @SuppressWarnings("unchecked")
    public MyDynamicArray(int capacity) {
        count = 0;
        this.capacity = capacity;
        items  = (T[]) new Object[capacity];
    }
    @SuppressWarnings("unchecked")
    @Override
    /**
     * Appends an item to the array.
     * if an item is null, then doesn't make any change
     * @param toAdd the item to be added
     */
    public void add(T toAdd) {
        if (toAdd != null) {
            //System.out.println(count);
            if (capacity > count) {
                items[count] = toAdd;
                count++;
            } else {
                T[] newArray = (T[]) new Object[capacity * 2];
                for (int i = 0; i < count; i++) {
                    newArray[i] = items[i];
                }
                items = newArray;
                items[count++] = toAdd;
            }

            //System.out.println("length" + items.length);
        }
    }
    @Override
    /**
     * Append all the items of the collection to the array.
     * if an item is null, then doesn't make any change
     * @param collection
     */
    public void addAll(Collection<T> collection) {
        if (!collection.isEmpty()) {
            for (T element : collection) {
                add(element);
            }
        }
    }
    @Override
    /**
     * Remove the given item (first occurrence) from the array
     * Return the item removed, not the one passed in
     * Move all items ahead of the one removed back one space
     * 
     * @param toRemove item to be removed
     * @return the item removed
     */
    public T remove(T toRemove) {
        return remove(indexOf(toRemove));
    }
    /**
     * get the index of a particular item in the array
     * Return the index of that found item.
     * 
     * @param toRemove item to be removed
     * @return the item removed
     */
    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < count; i++) {
                if (o.equals(items[i])) {
                    //System.out.println("test"+i);
                    return i;
                }
            }
        }
        System.out.println("test3");
        return -1;
    }
    @SuppressWarnings("unchecked")
    @Override
    /**
     * Remove the item at the given index
     * Move all items ahead of the one removed back one space
     * Again, check for validity of the index
     * @param index
     * @return item removed, otherwise null
     */
    public T remove(int index) {
        T result = get(index);
        if (contains(items[index])) {
            Object[] newArray = new Object[items.length - 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = items[i];
            }
            for (int a = index; a < newArray.length; a++) {
                newArray[a] = items[a + 1];
            }
            count--;
            items = (T[]) newArray;
        }
        return result;
    }
    @Override
    /**
     * Gets the item at the given index
     * Again, check for validity of the index
     * @param index
     * @return the item at the index, null otherwise
     */
    public T get(int index) {
        if (index <= count && index >= 0) {
            return items[index];
        } else {
            return null;
        }
    }
    @Override
    /**
     * Checks whether the array contains the given object
     * @param obj the object that we are finding
     * @return true if object is in the array, false otherwise
     */
    public boolean contains(T obj) {
        return (indexOf(obj) >= 0);
    }
    @Override
    /**
     * Return the backing array
     * This is for testing purposes only, normally we would
     * not want the user to have access to the backing structure
     * @return The backing array itself, not a copy
     */
    public T[] toArray() {
        return items;
    }
    @Override
    /**
     * Returns whether the array is empty
     * 
     * @return whether the array is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    @SuppressWarnings("unchecked")
    @Override
    /**
     * Clears the array, resets it to the original state
     */
    public void clear() {
        count = 0;
        items = (T[]) new Object[capacity]; // unchecked cast
    }
    @Override
    /**
     * The number of items in the array
     * 
     * @return the number of items in the array
     */
    public int size() {
        return count;
    }
}
