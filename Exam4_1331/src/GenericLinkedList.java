public class GenericLinkedList<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public GenericLinkedList() {
        head = null;
    }

    /**
     * Add a new item to the front of this list.
     */
    public void addFront(E item) {
        head = new Node<E>(item, head);
    }

    /**
     * Return the item at the front of this list and remove it from the list.
     */
    public E removeFront() {
        if (null == head) {
            throw new RuntimeException("Can't removeFront() on empty list.");
        }
        E answer = head.data;
        head = head.next;
        return answer;
    }

    /**
     * The number of items in this list.
     */
    public int length() {
        int len = 0;
        Node node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    /**
     * @return true if this list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (Node node = head; node != null; node = node.next) {
            sb.append(node.data + " ");
        }
        return sb.toString() + "]";
    }

    public int length2() {
        int len = 0;
        for (Node node = head; node != null; node = node.next, len++) {
            ;
        }
        return len;
    }

    public void insertAfter(E existingItem, E newItem) {
        Node<E> curNode = head;
        while (!curNode.data.equals(existingItem) &&
                (curNode.next != null)) {
            curNode = curNode.next;
        }
        Node<E> newNode = new Node<E>(newItem, curNode.next);
        curNode.next = newNode;
    }

    public static void main(String[] args) {
        GenericLinkedList<String> lst = new GenericLinkedList<>();
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

        // Note that type arguments must be reference types
        // This won't compile becuase int is a primitive type
        // GenericLinkedList<int> ints = new GenericLinkedList<>();
    }
}