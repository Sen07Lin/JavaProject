/**
 * This is a basic recursive list to demonstrate the basic principles of linked
 * data structures, and sneak in a little funtional-ish programming.
 */
public class RecursiveListPractice {
	// recursive head store data and tail store node
	private Object head;
	private RecursiveListPractice tail;
	// 1.The reason why we don't use a private because if the main class is not
	// in
	// this class then, it won't compile
	// 2. unlike LinkedList, RecursiveList need initial data so need a constructor 
	// to be the same as the class name. And don't need to create a inner class like"node" for this.
	//
	public RecursiveListPractice(Object item) {
		this(item, null); // just instantiate once
	}

	public RecursiveListPractice(Object item, RecursiveListPractice list) {
		head = item;
		tail = list;
	}

	public RecursiveListPractice add(Object item) {
		return new RecursiveListPractice(item, this);
	}

	public int length() {
		return reLength(this, 0); // I passed in this instead of tail, that's
									// why zero works.
	}

	public int reLength(RecursiveListPractice list, int curLength) {
		if (null == list) {
			return curLength;
		} else {
			return  reLength(list.tail, curLength + 1);
		}
	}

	public boolean contains(Object item) {
		return reContain(this, item);
	}

	public boolean reContain(RecursiveListPractice list, Object item) {
		// code has the same meaning but its not clean
		// try the following
		/*
		 * if (null == lst) { return false; } else if (item.equals(lst.head)) {
		 * return true; } else { return contains(item, lst.tail); }
		 */
		boolean isHere = false;
		if (list == null) {
			return isHere;
		} else {
			if (list.head.equals(item)) {
				isHere = true;
			} else {
				isHere = reContain(list.tail, item); // since always return a
														// string type, so don't
														// worry
			}
		}
		return isHere;
	}

	public String toString() {
		return mkString(this, new StringBuffer("[ "));
	}

	public String mkString(RecursiveListPractice list, StringBuffer br) {
		if (list == null) {
			return br.toString() + "]";
		} else {
			br.append(list.head.toString() + " ");
			return mkString(list.tail, br);
		}
	}

	public static void main(String[] args) {
		RecursiveListPractice girls = new RecursiveListPractice("");
		RecursiveListPractice boys = new RecursiveListPractice("Cartman");
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
