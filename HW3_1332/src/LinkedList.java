/**
 * This class describes a singly linked list. It's not circular, but it has two
 * pointers.
 * @author Sen
 * 
 * @param <T> The generic type of the LinkedList,type of element.
 */
public class LinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int numOfData;
    @Override
    public void addToFront(T t) {
        if (t != null) {
            numOfData++;
            head = new Node<T>(t, head);
            Node<T> second = head.next;
            if (second == null) {
                tail = head;
            }
        }
    }
    @Override
    public void addToBack(T t) {
        if (t != null) {
            Node<T> temp = new Node<T>(t, null);
            numOfData++;
            if (head == null) {
                head = temp;
                tail = head;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
    }
    @Override
    public T removeFromFront() {
        if (null != head) {
            numOfData--;
            T answer = head.data;
            head = head.next;
            if (null == head) {
                tail = head;
            }
            return answer;
        }
        return null;
    }
    @Override
    public T removeFromBack() {
        if (null != tail) {
            numOfData--;
            T answer = tail.data;
            int i = numOfData;
            if (i == 0) {
                tail = null;
                head = tail;
            } else {
                for (Node<T> node = head; (node != null) && i > 0; node = node.next, i--) {
                    tail = node;
                }
                tail.next = null;
            }
            return answer;
        } else {
            return null;
        }
    }
    @Override
    public boolean isEmpty() {
        return (numOfData == 0);
    }
    @Override
    public int size() {
        return numOfData;
    }
    @Override
    public void clear() {
        while (numOfData > 0) {
            removeFromFront();
        }
    }
    /**
     * The node class. Remember that this is a singularly linked list.
     * 
     * @author Steven Wojcio
     */
    @SuppressWarnings("hiding")
    private class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    @Override
    public T[] toList() {
        // TODO Auto-generated method stub
        return null;
    }
}
