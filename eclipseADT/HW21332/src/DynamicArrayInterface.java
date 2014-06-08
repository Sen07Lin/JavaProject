import java.util.Collection;

/**
 * This interface describes the behavior of operations 
 * on a Dynamic Array object
 * 
 * @author Kushagra Mansingh
 *
 */
public interface DynamicArrayInterface<T> {

	/**
	 * Appends an item to the array
	 * @param toAdd the item to be added
	 */
	public void add(T toAdd);
	

	/**
	 * Append all the items of the collection to the array
	 * @param collection
	 */
	public void addAll(Collection<T> collection);
	
	/**
	 * Remove the given item (first occurrence) from the array
	 * Return the item removed, not the one passed in
	 * Move all items ahead of the one removed back one space
	 * 
	 * @param toRemove item to be removed
	 * @return the item removed
	 */
	public T remove(T toRemove);
	
	/**
	 * Remove the item at the given index
	 * Move all items ahead of the one removed back one space
	 * Again, check for validity of the index
	 * @param index
	 * @return item removed, otherwise null
	 */
	public T remove(int index);
	
	/**
	 * Gets the item at the given index
	 * Again, check for validity of the index
	 * @param index
	 * @return the item at the index, null otherwise
	 */
	public T get(int index);
	
	/**
	 * Checks whether the array contains the given object
	 * @param obj the object that we are finding
	 * @return true if object is in the array, false otherwise
	 */
	public boolean contains(T obj);
	
	/**
	 * Return the backing array
	 * This is for testing purposes only, normally we would 
	 * not want the user to have access to the backing structure
	 * @return The backing array itself, not a copy
	 */
	public T[] toArray();
	
	/**
	 * Returns whether the array is empty
	 * 
	 * @return whether the array is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Clears the array, resets it to the original state
	 */
	public void clear();
	
	/**
	 * The number of items in the array
	 * 
	 * @return the number of items in the array
	 */
	public int size();
	

	
}
