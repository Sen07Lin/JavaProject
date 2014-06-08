/**
 * Your queue implementation. Don't add any new public methods.
 * 
 * @author Sen Lin
 *
 */
public class Queue<T> implements QueueInterface<T> {

    private LinkedListInterface<T> queue = new LinkedList<T>();

    @Override
    public void enqueue(T t) {
        queue.addToBack(t);
    }

    @Override
    public T dequeue() {
        return queue.removeFromFront();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
