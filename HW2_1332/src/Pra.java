
import java.util.Collection;

/**
 * This interface describes the behavior of operations
 * on a Dynamic Array object
 * 
 * @author Kushagra Mansingh
 *
 */
public class Pra<T> implements DynamicArrayInterface<T> {

    private T[] arr;
    private int count;
    private int iniCapacity;
    private static final int CAPACITY = 10;
    public Pra(){
        this(CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public Pra(int cap){
        iniCapacity = cap;
        count = 0;
        arr = (T[]) new Object[cap];
    }

    /**
     * Appends an item to the array
     * @param toAdd the item to be added
     */
    @Override
    public void add(T toAdd){
        if (toAdd != null){
            if (count < arr.length){
                arr[count] = toAdd;
                count ++;
            } else {
                isFull();
                arr[count] = toAdd;
                count ++;
            }
        }
    }
    private void isFull(){
        @SuppressWarnings("unchecked")
        T[] temp  = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < count; i ++){
            temp[i] = arr[i];
        }
        arr = temp;
    }


    /**
     * Append all the items of the collection to the array
     * @param collection
     */
    @Override
    public void addAll(Collection<T> collection){
        if (!collection.isEmpty()){
            for (T o: collection){
                add(o);
            }
        }
    }

    /**
     * Remove the given item (first occurrence) from the array
     * Return the item removed, not the one passed in
     * Move all items ahead of the one removed back one space
     * 
     * @param toRemove item to be removed
     * @return the item removed
     */
    @Override
    public T remove(T toRemove){
        if (toRemove != null && !isEmpty()){
            int index = indexOf(toRemove);
            if (index >= 0) {
                T result = arr[index];
                for (; index < count - 1;index ++){
                    arr[index] = arr[index+1];
                }
                arr[index] = null;
                count --;
                return result;
            }
        }
        return null;
    }
    public int indexOf(T element){
        if (element != null){
            Object o = element;
            if (element != null){
                for (int i = 0; i < count; i++){
                    if (o.equals(arr[i])){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Remove the item at the given index
     * Move all items ahead of the one removed back one space
     * Again, check for validity of the index
     * @param index
     * @return item removed, otherwise null
     */
    @Override
    public T remove(int index){
        return remove(get(index));
    }

    /**
     * Gets the item at the given index
     * Again, check for validity of the index
     * @param index
     * @return the item at the index, null otherwise
     */
    @Override
    public T get(int index){
        if (index >= 0 && index <= count -1) {
            return arr[index];
        }
        return null;
    }

    /**
     * Checks whether the array contains the given object
     * @param obj the object that we are finding
     * @return true if object is in the array, false otherwise
     */
    @Override
    public boolean contains(T obj){
        return indexOf(obj) >= 0;
    }

    /**
     * Return the backing array
     * This is for testing purposes only, normally we would
     * not want the user to have access to the backing structure
     * @return The backing array itself, not a copy
     */
    @Override
    public T[] toArray(){
        return arr;
    }

    /**
     * Returns whether the array is empty
     * 
     * @return whether the array is empty
     */
    @Override
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * Clears the array, resets it to the original state
     */
    @Override
    public void clear(){
        @SuppressWarnings("unchecked")
        T[] newArr = (T[]) new Object[iniCapacity];
        arr = newArr;
        count = 0;
    }

    /**
     * The number of items in the array
     * 
     * @return the number of items in the array
     */
    @Override
    public int size(){
        return count;
    }
    /*public static void main(String[] args){
        Pra<String> p = new Pra<>();
        Collection<String> coll = new LinkedList<>();
        String[] arr = {new String("0"),new String("1"), new String("3"),new String("4"), null, null, null, null, null, null};

        for(int i=0; i<5; i++){
            coll.add(new String(""+i));
        }

        p.addAll(coll);
        for (int i = 0; i< p.size(); i++) {
            System.out.println(p.get(i));
        }
        System.out.println(p.indexOf(new String("2")));
        p.remove(new String("2"));
        for (int i = 0; i< p.size(); i++) {
            System.out.println(p.get(i));
        }
        for (int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }*/
}

