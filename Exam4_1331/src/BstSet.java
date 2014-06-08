public class BstSet<E extends Comparable<E>> extends BinarySearchTree<E> {

    protected Node<E> insert(E newItem, Node<E> node) {
        if (node == null) {
            return new Node<E>(newItem, null, null);
        } else if (newItem.compareTo(node.item) < 0) {
            node.left = insert(newItem, node.left);
            return node;
        } else if (newItem.equals(node.item)) {
            // This added case is all we need to turn our BST into a set.
            // Notice that we simply return the node without adding the
            // new element.
            return node;
        } else {
            node.right = insert(newItem, node.right);
            return node;
        }
  }
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> nums = new BstSet<>();
        nums.add(3);
        nums.add(4);
        nums.add(1);
        nums.add(5);
        nums.add(2);
        nums.add(4);
        nums.add(1);
        System.out.println(nums);
    }
}