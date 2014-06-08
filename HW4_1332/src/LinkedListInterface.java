/**
 * This interface describes the public methods needed for 
 * Linked List.
 * 
 * DO NOT ALTER THIS FILE!!
 * 
 * @author Joonho Kim
 */
public interface LinkedListInterface<E> extends Iterable<E> {
	
	/**
	 * Appends element before the element at the specified index.
	 * 
	 * @param index Index being appended to.  If the index is equal to the size of the list
	 * 			then append to end of list.
	 * @param data Element being appended
	 * @return whether add was successful, null data or invalid indexes should return false.
	 */
	public boolean add(int index, E data);
	
	/**
	 * Clears list
	 */
	public void clear();

	/**
	 * Checks if specified element is within the List
	 * 
	 * @param o Object being searched
	 * @return whether Object element is found
	 */
	public boolean contains(Object o);

	/**
	 * Gets element at specified index
	 * 
	 * @param index Index of Element
	 * @return element at index, invalid index and not found element returns null.
	 */
	public E get(int index);

	/**
	 * Returns the index of the first occurrence of the given element.
	 * 
	 * @param data The element to search for
	 * @return The first occurrence of the given element, or -1 if it is not in
	 *         the list
	 */
	public int indexOf(E data);
	
	/**
	 * @return whether list is empty or not
	 */
	public boolean isEmpty();

	/**
	 * Removes the first instance of specified element
	 * from the list.
	 * 
	 * @param o Object element being removed
	 * @return whether remove was successful
	 */
	public E remove(Object o);

	/**
	 * Removes element at specified index
	 * 
	 * @param index Index of element being removed
	 * @return Element being removed, invalid index returns null
	 */
	public E remove(int index);

	/**
	 * Replaces the element at the given index.
	 * 
	 * @param index Index of the element to be replace
	 * @param data Data of new element
	 * @return The old element, invalid index or null data returns null
	 */
	public E replace(int index, E data);
	
	/**
	 * @return size of List
	 */
	public int size();
	
	/**
	 * Getter for head
	 * NOTE: This is purely for our testing purposes, in real life you would not want
	 * someone to have access to your head
	 * 
	 * @return Head of the list
	 */
	public Node<E> getHead();

	
	/*
	 * Reverse the current linked list
	 * NOTE: Do not copy the list to an external datastructure i.e. ArrayList, or create
	 * new object nodes.  It's possible to do this with Node references and reference 
	 * manipulation.
	 */
	public void reverseList();
}
