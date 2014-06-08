
/**
 * This is a basic recursive list to demonstrate the basic principles of 
 * linked data structures, and sneak in a little funtional-ish programming.
 */
public class RecursiveList {
    public Object head;
    public RecursiveList tail;

    public RecursiveList(Object head) {
        this(head, null);
    }

    public RecursiveList(Object head, RecursiveList tail) {
        this.head = head;
        this.tail = tail;
    }

    public RecursiveList add(Object item) {
        return new RecursiveList(item, this);
    }

    public int length() {
        return length(tail, 1);
    }

    private int length(RecursiveList lst, int lengthSoFar) {
        if (null == lst) {
            return lengthSoFar;
        } else {
            return length(lst.tail, lengthSoFar + 1);
        }
    }

    public boolean contains(Object item) {
        return contains(item, this);
    }

    private boolean contains(Object item, RecursiveList lst) {
        if (null == lst) {
            return false;
        } else if (item.equals(lst.head)) {
            return true;
        } else {
            return contains(item, lst.tail);
        }
    }

    public String toString() {
        return mkString(this, new StringBuffer("["));
    }

    public String mkString(RecursiveList lst, StringBuffer sb) {
        if (null == lst) {
            return sb.toString() + "]";
        } else {
            sb.append(lst.head.toString() + " ");
            return mkString(lst.tail, sb);
        }
    }

    public static void main(String[] args) {
    	RecursiveList girls = new RecursiveList("");
        RecursiveList boys = new RecursiveList("Cartman");
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