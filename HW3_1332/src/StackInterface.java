
public interface StackInterface<T> {
	/**
	 * Push a new node onto the stack with the given data.
	 * 
	 * @param t The data to push.
	 */
	public void push(T t);
	
	/**
	 * Should pop from the stack.
	 * 
	 * @return Data from node or null.
	 */
	public T pop();
	
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
