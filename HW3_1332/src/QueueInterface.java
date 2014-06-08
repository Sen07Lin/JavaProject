public interface QueueInterface<T> {
    /**
     * Add a node with the given data to the back of your queue.
     * 
     * @param t The data to add.
     */
    public void enqueue(T t);
    /**
     * Dequeue from the front of your queue.
     * 
     * @return The data from the front node or null.
     */
    public T dequeue();
    /**
     * Return the size of the stack.
     * 
     * @return int size
     */
    public int size();
    /**
     * Return true if empty. False otherwise.
     * 
     * @return boolean result
     */
    public boolean isEmpty();
}
