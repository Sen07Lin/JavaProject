
public class PraRe {
	private Object head;
	private PraRe tail;
	public PraRe(Object head){
		this(head, null);
	}
	public PraRe(Object head, PraRe tail){
		this.tail = tail;
		this.head = head;
	}
	public PraRe add(Object item){
		return tail = new PraRe(item, this);
	}
	public String toString() {
        return mkString(this, new StringBuffer("["));
    }

    public String mkString(PraRe lst, StringBuffer sb) {
        if (null == lst) {
            return sb.toString() + "]";
        } else {
            sb.append(lst.head.toString() + " ");
            return mkString(lst.tail, sb);
        }
    }
	public int length(){
		return lengthHelper(this, 0);
	}
	public int lengthHelper(PraRe list, int n){
		if(list == null){
			return n;
		} else {
			n++;
			return lengthHelper(list.tail, n);
		}
	}
	public boolean contains(Object item){
		return containsHelper(this,item);
	}
	public boolean containsHelper(PraRe list, Object item){
		if (list == null){
			return false;
		} else if (list.head.equals(item)) {
			return true;
		} else {
			return containsHelper(list.tail, item);
		}
	}
	public static void main(String[] args) {
		PraRe girls = new PraRe("");
		PraRe boys = new PraRe("Cartman");
		boys = boys.add("Stan");
		boys = boys.add("Kyle");
		boys = boys.add("Kenny");
		System.out.println("The list: " + boys);
		System.out.println("The list: gilrs " + girls);
		System.out.println("How many? girl" + girls.length());
		System.out.println("How many? " + boys.length());

		// You killed Kenny!
		System.out.println("The tail: " + boys.tail);

		System.out.println("Length of tail: " + boys.tail.length());

		// What about Butters?
		System.out.println("Butters? " + boys.contains("Butters"));

		// Can always count on Cartman.
		System.out.println("Cartman? " + boys.contains("Cartman"));
	}
}
