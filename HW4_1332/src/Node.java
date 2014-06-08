/**
 * Node class for the Doubly Linked List. This is a generic class
 * @author Sen
 * @version 1.0
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;
    /**
     * constructor of the node class.
     * @param data the data to be initiated when the constructor is called
     */
    public Node(E data) {
        setData(data);
    }
    @Override
    public String toString() {
        return "" + data;
    }
    /**
     * getter for next.
     * @return return next node of a node
     */
    public Node<E> getNext() {
        return next;
    }
    /**
     * getter for prev.
     * @return return previous node of a node
     */
    public Node<E> getPrev() {
        return prev;
    }
    /**
     * getter for data.
     * @return return the data of a node
     */
    public E getData() {
        return data;
    }
    /**
     * setter for next.
     * @param next the node that sets to next
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    /**
     * setter for prev.
     * @param prev the node that sets to prev
     */
    public void setPre(Node<E> prev) {
        this.prev = prev;
    }
    /**
     * setter for data
     * @param data : data to be set to
     */
    public void setData(E data) {
        this.data = data;
    }
}