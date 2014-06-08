public class DoublyLinkedList<E> {

    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        public Node(E data, Node<E> next, Node<E> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node<E> first;
    private Node<E> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void addFront(E item) {
        first = new Node<E>(item, first, null);
        Node<E> second = first.next;
        if (second != null) {
            // There was already at leat one node
            second.previous = first;
        } else {
            // This is the first addition, last and first are same
            last = first;
        }
    }

    public E removeFront() {
        if (null == first) {
            throw new RuntimeException("Can't removeFront() on empty list.");
        }
        E answer = first.data;
        first = first.next;
        first.previous = null;
        return answer;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (Node node = first; node != null; node = node.next) {
            sb.append(node.data + " ");
        }
        return sb.toString() + "]";
    }

    public String toReverseString() {
        StringBuffer sb = new StringBuffer("[");
        for (Node node = last; node != null; node = node.previous) {
            sb.append(node.data + " ");
        }
        return sb.toString() + "]";
    }

    public int length() {
        int len = 0;
        Node node = first;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public int length2() {
        int len = 0;
        for (Node node = first; node != null; node = node.next, len++) {
            ;
        }
        return len;
    }
    public void removeAfter(E item){
        Node<E> cur = first;
        while(cur.next!= null &&!cur.data.equals(item)){
            cur = cur.next;
        }
        cur.next = null;
        last = cur;
    }
    public boolean removeFirstOcc(E data){
        if(data!= null && first != null){
            Node<E> cur = first;
            while (cur.next!=null & !cur.data.equals(data)){
                cur = cur.next;
            }
            if(cur.previous == null && cur.next == null){
                cur = null;
                first = null;
            } else if(cur.previous != null && cur.next == null){
                cur.previous.next = null;
                cur = null;
            } else if(cur.previous == null && cur.next != null){
                cur.next.previous = null;
                first = cur.next;
                cur = null;
            } else if(cur.previous != null && cur.next != null){
                cur.previous.next = cur.next;
                cur.next.previous = cur.previous;
                cur = null;
            }
            return true;
        }
        return false;
    }
    public void insertAfter(E existingItem, E newItem) {
        Node<E> curNode = first;
        while (!curNode.data.equals(existingItem) &&
                (curNode.next != null)) {
            curNode = curNode.next;
        }
        Node<E> newNode = new Node<E>(newItem, curNode.next, curNode);
        if (newNode.next == null) {
            // No existing item, or existing item is last
            last = newNode;
        } else {
            // Inserting between two nodes, set previous reference
            // in new next mode
            curNode.next.previous = newNode;
        }
        curNode.next = newNode;
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> lst = new DoublyLinkedList<>();
        // lst.insertAfter(null, "Ursula");
        lst.addFront("Thorny");
        lst.addFront("Farva");
        lst.addFront("Mac");
        lst.addFront("Rabbit");
        lst.addFront("Foster");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        System.out.println(lst.removeFirstOcc("Thorny"));
        System.out.println(lst.removeFirstOcc("Foster"));
        System.out.println(lst.removeFirstOcc("Mac"));
        System.out.println(lst);
        System.out.println(lst.toReverseString());
        /* lst.insertAfter("Rabbit", "Ursula");
        System.out.println(lst);
        lst.removeAfter("oo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.insertAfter("Spread it on!", "Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        System.out.println("In reverse: ");
        System.out.println(lst.toReverseString());*/
    }
}