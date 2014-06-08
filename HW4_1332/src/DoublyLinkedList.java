import java.util.Iterator;
/**
 * This is a Doubly LinkedList that has both a head an tail pointer.
 * @param <T> type of elements in the list
 * @author Sen
 * @version 1.0
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T>, Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    /**
     * This is a Doubly LinkedList that has both a head an tail pointer.
     */
    private class MyIterator<E> implements Iterator<E> {
        private Node<T> current;
        /**
         * This is the default constructor for MyIterator.
         */
        public MyIterator() {
            current = getHead();
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("problem");
            }
            @SuppressWarnings("unchecked")
            E result = (E) current.getData();
            current = current.getNext();
            return result;
        }
        @Override
        public void remove() {
        }
    } // end of inner class
    @Override
    public boolean add(int index, T data) {
        if (data != null && index >= 0 && index <= size) {
            if (index == 0) {
                addFront(data);
            } else if (index == size) {
                addBack(data);
            } else {
                Node<T> newNode = new Node<T>(data);
                Node<T> cur = getHead();
                for (int i = 0; cur != null && i < index; i++) {
                    cur = cur.getNext();
                }
                newNode.setNext(cur);
                newNode.setPre(cur.getPrev());
                cur.getPrev().setNext(newNode);
                cur.setPre(newNode);
                size++;
            }
        }
        return (data != null && index >= 0 && index <= size);
    }
    /**
     * inner helper method for adding an item to the front.
     * @param data data to be added to the front
     * @return return true if adding is successful. false if data is null.
     */
    private boolean addFront(T data) {
        if (data != null) {
            Node<T> newNode = new Node<T>(data);
            newNode.setPre(null);
            newNode.setNext(head);
            head = newNode;
            Node<T> second = head.getNext();
            if (second == null) {
                tail = head;
            } else {
                second.setPre(head);
            }
            size++;
            return true;
        }
        return false;
    }
    /**
     * inner helper method for adding an item to the back.
     * @param data data to be added to the back
     * @return return true if adding is successful. false if data is null.
     */
    private boolean addBack(T data) {
        if (data != null) {
            Node<T> newNode = new Node<T>(data);
            newNode.setPre(tail);
            newNode.setNext(null);
            tail = newNode;
            Node<T> pre = tail.getPrev();
            if (pre == null) {
                head = newNode;
            } else {
                pre.setNext(tail);
            }
            size++;
            return true;
        }
        return false;
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public boolean contains(Object o) {
        if (!isEmpty()) {
            @SuppressWarnings("unchecked")
            T obj = (T) o;
            return indexOf(obj) >= 0;
        }
        return false;
    }
    @Override
    public T get(int index) {
        if (!isEmpty() && index >= 0 && index < size) {
            return getNode(index).getData();
        }
        return null;
    }
    /**
     * inner helper method to get a node.
     * @param index of a node to be found.
     * @return return the node<T> in the list. null if index is invalid or list
     *         is empty.
     */
    private Node<T> getNode(int index) {
        if (index >= 0 && index < size && !isEmpty()) {
            Node<T> cur = getHead();
            int i = 0;
            while (cur != null && i < index) {
                cur = cur.getNext();
                i++;
            }
            return cur;
        }
        return null;
    }
    @Override
    public int indexOf(T data) {
        if (data != null && head != null) {
            Node<T> cur = getHead();
            for (int i = 0; cur != null && i < size; i++) {
                if (cur.getData().equals(data)) {
                    return i;
                }
                cur = cur.getNext();
            }
        }
        return -1;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public T remove(Object o) {
        if (o != null && contains(o)) {
            @SuppressWarnings("unchecked")
            T obj = (T) o;
            return remove(indexOf(obj));
        }
        return null;
    }
    @Override
    public T remove(int index) {
        if (!isEmpty() && getNode(index) != null) {
            Node<T> cur = getNode(index);
            T result = cur.getData();
            Node<T> next = cur.getNext();
            Node<T> prev = cur.getPrev();
            if (prev == null && next != null) {
                // remove the head node
                next.setPre(null);
                head = next;
            } else if (prev != null && next == null) {
                // remove the tail node
                prev.setNext(null);
                tail = prev;
            } else if (prev == null && next == null) {
                // remove a single node
                head = null;
                tail = null;
            } else {
                // remove a middle node
                prev.setNext(next);
                next.setPre(prev);
                cur = null;
            }
            size--;
            return result;
        }
        return null;
    }
    @Override
    public T replace(int index, T data) {
        if (!isEmpty() && data != null && index >= 0 && index < size) {
            Node<T> cur = getNode(index);
            T original = cur.getData();
            cur.setData(data);
            return original;
        }
        return null;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public Node<T> getHead() {
        return head;
    }
    @Override
    public void reverseList() {
        if (size > 1) {
            Node<T> cur = head;
            head = tail;
            tail = cur;
            while (cur != null) {
                Node<T> temp = cur.getNext();
                cur.setNext(cur.getPrev());
                cur.setPre(temp);
                cur = temp;
            }
        }
    }
    @Override
    public Iterator<T> iterator() {
        MyIterator<T> iterator = new MyIterator<>();
        return iterator;
    }
    public static void main(String[] arg){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.add(0,2);
        Node<Integer> node = list.getNode(0);
        node = null;
        System.out.println(list.size());
    }
}