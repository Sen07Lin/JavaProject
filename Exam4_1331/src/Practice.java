
public class Practice<T> {
	private class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	private Node<T> front;
	public void addFront(T data){
		front = new Node<T>(data, front);
	}
	public int length(){
		int i = 0;
		for (Node<T> node = front; node != null; node = node.next){
			i ++;
		}
		return i;
	}
	public void insertAfter(T existing, T item){
		Node<T> curNode = front;
		while (!curNode.data.equals(item) && curNode.next != null){
			curNode = curNode.next;
		}
		Node<T> newNode = new Node<T>(item, curNode.next);
		curNode.next = newNode;
	}
	public boolean contains(T item){
		Node<T> curNode = front;
		while (!curNode.data.equals(item) && curNode.next != null){
			if (curNode.next == null){
				return false;
			}
			curNode = curNode.next;
		}
		return true;
	}
	public boolean empty(){
		return front == null;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[ ");
		for (Node<T> node = front; node != null; node = node.next){
			sb.append(node.data + " ");
		}
		return sb.toString() + " ]";
	}
	public T removeFront(){
		if (front == null){
			throw new RuntimeException("error");
		}
		T answer = front.data;
		front = front.next;
		return answer;
	}
	public static int fac(int n){
		if (n<=1) return 1;
		else {
			return n*fac(n-1);
		}
	}
	public static int facIter(int n){
		return facHelper(n, 1);
	}
	public static int facHelper(int n, int accum) {
		if (n <= 1){
			return accum;
		} else {
			return facHelper(n-1, accum*n);
		}
	}
	public static void main(String[] args) {
		Practice<String> lst = new Practice<String>();
        lst.addFront("Thorny");
        lst.addFront("Farva");
        lst.addFront("Mac");
        lst.addFront("Rabbit");
        lst.addFront("Foster");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        System.out.println("If contain Farva? " + lst.contains("Farva"));
        System.out.println("If contain Farva? " + lst.contains("Farva"));
        System.out.println("If contain arva? " + lst.contains("arva"));
        lst.removeFront();
        System.out.println(lst);
        int n = 5;
        //Integer.parseInt(args[0]);
        System.out.println(fac(n));
        System.out.println(facIter(n));
        /*lst.insertAfter("Rabbit", "Ursula");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.insertAfter("Spread it on!", "Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.insertAfter("Chimpo" , "Rabbit");;
        System.out.println(lst);
        System.out.println("How many? " + lst.length());*/
    }
}
