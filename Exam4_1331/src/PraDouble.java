
public class PraDouble<T> {

	private class Node<T>{
		private Node<T> next;
		private Node<T> previous;
		private T data;
		public Node(T data, Node<T> next, Node<T> previous){
			this.next = next;
			this.previous = previous;
			this.data = data;
		}
	}
	private Node<T> first;
	private Node<T> last;
	public PraDouble() {
		first = null;
		last = null;
	}
	public void addFront(T data, Node<T> next, Node<T> previous){
		first = new Node<T>(data, first, null);
		Node<T> second = first.next;
		if (second == null) {
			last = first;
		} else {
			second.previous = first;
		}
	}
	public int length(){
		int i = 0;
		for (Node<T> node = first; node != null; node = node.next){
			i ++;
		}
		return i;
	}
	public T removeFront(){
		if (first == null){
			throw new RuntimeException("error");
		}
		T answer = first.data;
		first = first.next;
		first.previous = null;
		return answer;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[ ");
		for (Node<T> node = first; node != null; node = node.next){
			sb.append(node.data + " ");
		}
		return sb.toString() + " ]";
	}
	public String toReverseString(){
		StringBuilder sb = new StringBuilder("[ ");
		for (Node<T> node = last; node != null; node = node.previous){
			sb.append(node.data + " ");
		}
		return sb.toString() + " ]";
	}
	public void insertAfter(T existing, T item){
		Node<T> node = first;
		while (!(node.data.equals(item) && node.next != null)){
			node = node.next;
		}
		Node<T> newNode = new Node<T>(item,node.next, node);
		if(node.next == null){
			last = newNode;
		} else {
			node.next.previous = newNode;// Originally was node.next.previosu was node. but now is changed
		}
		node.next = newNode;
	}
	public static void main(String[] args) {
        DoublyLinkedList<String> lst = new DoublyLinkedList<>();
        lst.addFront("Thorny");
        lst.addFront("Farva");
        lst.addFront("Mac");
        lst.addFront("Rabbit");
        lst.addFront("Foster");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());

        lst.insertAfter("Rabbit", "Ursula");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.insertAfter("Spread it on!", "Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        System.out.println("In reverse: ");
        System.out.println(lst.toReverseString());
    }
}
