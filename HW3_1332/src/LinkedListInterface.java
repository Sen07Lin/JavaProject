/**
 * This interface describes the public methods needed for 
 * Linked List, which should be singly linked and should
 * have a head and tail pointer.  It will not be circular.
 * 
 * DO NOT ALTER THIS FILE!!
 * 
 * @author Steven Wojcio
 */
public interface LinkedListInterface<T> {
		
	/**
	 * Add a new node to the front of your linked list 
	 * that holds the given data.
	 * 
	 * @param t The data that the new node should hold.
	 */
	public void addToFront(T t);
	
	/**
	 * Add a new node to the back of your linked list
	 * that holds the given data.
	 * 
	 * @param t The data that the new node should hold.
	 */
	public void addToBack(T t);
	
	/**
	 * Remove the front node from the list and return the
	 * data from it.
	 * 
	 * @return The data from the front node or null.
	 */
	public T removeFromFront();
	
	/**
	 * Remove the back node from the list and return the 
	 * data from it.
	 * 
	 * @return The data from the last node or null.
	 */
	public T removeFromBack();
	
	/**
	 * Return the linked list represented as a list of objects.
	 * 
	 * @return A copy of the linked list data as a list.
	 */
	public T[] toList();
	
	/**
	 * Return a boolean value representing whether or not
	 * the list is empty.
	 * 
	 * @return True if empty. False otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Return the size of the list as an integer.
	 * 
	 * @return The size of the list.
	 */
	public int size();
	
	/**
	 * Clear the list.
	 */
	public void clear();
}
