import java.util.Collection;
import java.util.List;


public class AVL<T extends Comparable<? super T>> implements BSTInterface<T> {
	//Add instance variables here
	private Node<T> root;
	
	
	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(Collection<T> c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> inOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * A suggested private helper method
	 * You do not have to use this if you don't want to
	 * @param unbalanced Node of subtree that is unbalanced
	 * @return the balanced subtree
	 */
	private Node<T> rotate(Node<T> unbalanced) {
		return null;
	}

	
	//DO NOT MODIFY OR USE ANY OF THE METHODS BELOW IN YOUR IMPLEMENTATION
	//These methods are for testing purposes only
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
