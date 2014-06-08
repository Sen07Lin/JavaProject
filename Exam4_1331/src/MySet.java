import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;

/**
 * This class describes basic MySet collection. It contains an inner class
 * MyIterator. It implements Set<E>.
 * @param <E> This describes my type parameter.
 * @author Sen Lin
 */
public class MySet<E> implements Set<E> {
    /**
     * This is MySet<E>'s inner class.It helps traverse collection. It
     * implements Iterator<E>.
     * @param <E> This describes my type parameter.
     */
    private class MyIterator<E> implements Iterator<E> {
        /**
         * position of an object in the collection.
         */
        private int position = 0;
        /**
         * remove method.
         */
        public void remove() {
        }
        /**
         * remove method.
         * @return It return true if there is element on the next position.
         */
        public boolean hasNext() {
            return ((position < items.length) && (items[position] != null));
        }
        /**
         * get the next element.
         * @return my parameter type.
         */
        public E next() {
            return (E) (items[position++]);
        }
    } // end of inner class
    /**
     * An Array contains E type Objects.
     */
    private E[] items;
    /**
     * number of elements.
     */
    private int count;

    /**
     * Default constructor for MySet class.
     */
    public MySet() {
        items = (E[]) (new Object[2]);
        count = 0;
    }

    /**
     * The iterator method.
     * @return an Iterator in Iterator<E> type
     */
    public Iterator<E> iterator() {
        MyIterator<E> it = new MyIterator<E>();
        return it;
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * @param newItem This is the object that adds into array.
     * @return true if there is no duplication.
     */
    public boolean add(E newItem) {
        if (!contains(newItem)) {
            if (newItem != null) {
                if (count < this.items.length) {
                    items[count] = newItem;
                    count++;
                } else {
                    items = Arrays.copyOf(items, items.length * 2);
                    items[count] = newItem;
                    count++;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Adds all of the elements in the specified collection to this set.
     * @param c The target collection
     * @return true if there is no duplication.
     */
    public boolean addAll(Collection<? extends E> c) {
        boolean allTrue = false;
        if (!c.isEmpty()) {
            for (E element : c) {
                allTrue = add(element);
                System.out.println("HI");
            }
        }
        return allTrue;
    }

    /**
     * Size of element in the items array.
     * @return the size in int
     */
    public int size() {
        int p = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                p++;
            }
        }
        return p;
    }

    /**
     * Removes the specified element from this set if it is present.
     * @param o The target Object
     * @return true if there is no duplication, and target object is removed
     *         successfully.
     */
    public boolean remove(Object o) {
        if (contains(o)) {
            if (o != null) {
                int index = indexOf(o);
                Object[] newArray = new Object[items.length - 1];
                for (int i = 0; i < index; i++) {
                    newArray[i] = items[i];
                }
                for (int a = index; a < newArray.length; a++) {
                    newArray[a] = items[a + 1];
                }
                items = (E[]) newArray;
                return true;
            }
        }
        return false;
    }

    /**
     * get the index of duplicated object.
     * @param o The target object
     * @return the index in int type
     */
    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < items.length; i++) {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *  Removes from this set all of its elements that.
     *  are contained in the specified collection
     * @param c The target collection
     * @return true if there is no duplication.
     */
    public boolean removeAll(Collection<?> c) {
        boolean allTrue = false;
        if (!isEmpty()) {
            for (Object element : c) {
                if (contains(element) && (element != null)) {
                    allTrue = true;
                    remove(element);
                }
            }
        }
        return allTrue;
    }

    /**
     * check if the set contains particular object.
     * @param key The target Object
     * @return true if the set contains key
     */
    public boolean contains(Object key) {
        return (indexOf(key) >= 0);
    }

    /**
     * check if the set contains all objects of a particular set.
     * @param c The target collection
     * @return true if the set contains all objects of the particular set
     */
    public boolean containsAll(Collection<?> c) {
        boolean allTrue = false;
        for (Object element : c) {
            E target = (E) element;
            allTrue = contains(target);
        }
        return allTrue;
    }

    /**
     * clear all elements in the set.
     */
    public void clear() {
        items = ((E[]) (new Object[0]));
    }

    /**
     * check if the set is empty.
     * @return true if there is no element in the set
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * retains only elements in c.
     * @param c The target collection
     * @return true if there is no duplication.
     */
    public boolean retainAll(Collection<?> c) {
        boolean allTrue = false;
        E[] temp = (E[]) (new Object[items.length]);
        int counter = 0;
        for (Object element : c) {
            E target = (E) element;
            if (contains(target) && (target != null)) {
                allTrue = true;
                temp[counter] = target;
                counter++;
            }
        }
        items = (E[]) temp;
        return allTrue;
    }

    /**
     * return an array containing all of the elements in this set.
     * @return an array containing all of the elements in this set.
     */
    public Object[] toArray() {
        Object[] temp = new Object[items.length];
        for (int i = 0; i < items.length; i++) {
            temp[i] = (Object) items[i];
        }
        return temp;
    }

    /**
     * Returns an array containing all of the elements in this set.
     * the runtime type of the returned array is that of the specified array.
     * @param arr The target array in E[]
     * @param <E> my parameter type
     * @return null since Array says so.
     */
    public <E> E[] toArray(E[] arr) {
        return null;
    }
}
