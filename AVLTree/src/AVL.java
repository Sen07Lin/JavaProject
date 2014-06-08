import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * This class describes an AVL tree.
 * @author Sen Lin
 * @param <T> The generic type for the tree's elements
 */
public class AVL<T extends Comparable<? super T>> implements BSTInterface<T> {
    private Node<T> root;
    private int size;
    @Override
    public String toString() {
        if (root == null) {
            return "()";
        }
        return root.toString();
    }
    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (!contains(data)) {
            root = insert(data, root);
            size++;
        }
        root = balanceTree(root);
    }
    @Override
    public void addAll(Collection<T> c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        if (c != null && !c.isEmpty()) {
            for (T data : c) {
                add(data);
            }
        }
    }
    /**
     * This private method that inserts a node into the tree.
     * @param data the data of the node that to be inserted
     * @param node the node that to be inserted
     * @return return the root node that has updated tree
     */
    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            Node<T> temp = new Node<T>(data);
            temp.setLeft(null);
            temp.setRight(null);
            temp.setHeight(heightHelper(temp));
            temp.setBalanceFactor(balFactorHelper(temp));
            return temp;
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else {
            node.setRight(insert(data, node.getRight()));
        }
        node.setHeight(heightHelper(node));
        node.setBalanceFactor(balFactorHelper(node));
        node = balanceTree(node);
        return node;
    }
    /**
     * This is a helper method to re-balance the tree after addition or removal.
     * @param node the root node that contains a branch to be balanced
     * @return the root node that contains a balanced branch
     */
    private Node<T> balanceTree(Node<T> node) {
        if (node.getBalanceFactor() > 1) {
            if (node.getLeft().getBalanceFactor() >= 0) {
                // item was added to left subtree of the left child
                node = rightRotate(node);
            } else {
                // item was added to right subtree of the left child
                node = leftRightRotate(node);
            }
        } else if (node.getBalanceFactor() < -1) {
            // right subtree is too heavy
            if (node.getRight().getBalanceFactor() <= 0) {
                // item was added to right subtree of the right child
                node = leftRotate(node);
            } else {
                // item was added to left subtree of the right child
                node = rightLeftRotate(node);
            }
        }
        return node;
    }
    /**
     * right rotation.
     * @param nodeN the node to be rotated
     * @return return the node after rotation
     */
    private Node<T> rightRotate(Node<T> nodeN) {
        Node<T> nodeC = nodeN.getLeft();
        nodeN.setLeft(nodeC.getRight());
        // update nodeN
        nodeN.setHeight(heightHelper(nodeN));
        nodeN.setBalanceFactor(balFactorHelper(nodeN));
        nodeC.setRight(nodeN);
        // update nodeC
        nodeC.setHeight(heightHelper(nodeC));
        nodeC.setBalanceFactor(balFactorHelper(nodeC));
        return nodeC;
    }
    /**
     * left rotation.
     * @param nodeN the node to be rotated
     * @return return the node after rotation
     */
    private Node<T> leftRotate(Node<T> nodeN) {
        Node<T> nodeC = nodeN.getRight();
        nodeN.setRight(nodeC.getLeft());
        // update nodeN
        nodeN.setHeight(heightHelper(nodeN));
        nodeN.setBalanceFactor(balFactorHelper(nodeN));
        nodeC.setLeft(nodeN);
        // update nodeC
        nodeC.setHeight(heightHelper(nodeC));
        nodeC.setBalanceFactor(balFactorHelper(nodeC));
        return nodeC;
    }
    /**
     * left rotation then right rotation.
     * @param nodeN the node to be rotated
     * @return return the node after rotation
     */
    private Node<T> leftRightRotate(Node<T> nodeN) {
        Node<T> nodeC = nodeN.getLeft();
        nodeN.setLeft(leftRotate(nodeC));
        return rightRotate(nodeN);
    }
    /**
     * right rotation then left rotation.
     * @param nodeN the node to be rotated
     * @return return the node after rotation
     */
    private Node<T> rightLeftRotate(Node<T> nodeN) {
        Node<T> nodeC = nodeN.getRight();
        nodeN.setRight(rightRotate(nodeC));
        return leftRotate(nodeN);
    }
    /**
     * Helper method to update a node's height
     * @param node the node to be updated
     * @return new height of a node
     */
    private int heightHelper(Node<T> node) {
        if (isLeaf(node)) {
            return 1;
        } else if (onlyHasLeft(node)) {
            return node.getLeft().getHeight() + 1;
        } else if (onlyHasRight(node)) {
            return node.getRight().getHeight() + 1;
        }
        return max(node) + 1;
    }
    /**
     * helper max to get the maximum height from node's child.
     * @param node a node to get maximum height
     * @return return the max height of a node's child
     */
    private int max(Node<T> node) {
        int leftH = node.getLeft().getHeight();
        int rightH = node.getRight().getHeight();
        if (leftH >= rightH) {
            return leftH;
        }
        return rightH;
    }
    /**
     * This is a helper method to update the balance Factor of a node.
     * @param node The node to be update
     * @return an updated node with new balance factor
     */
    private int balFactorHelper(Node<T> node) {
        if (isLeaf(node)) {
            return 0;
        } else if (onlyHasLeft(node)) {
            return node.getLeft().getHeight();
        } else if (onlyHasRight(node)) {
            return -node.getRight().getHeight();
        }
        return node.getLeft().getHeight() - node.getRight().getHeight();
    }
    /**
     * check if a node is a leaf node.
     * @param node the node to be checked
     * @return true if a node is a leaf node, false otherwise.
     */
    private boolean isLeaf(Node<T> node) {
        return node.getLeft() == null && node.getRight() == null;
    }
    /**
     * check if a node only has left subtree.
     * @param node the node to be checked
     * @return true if a node only has left subtree, false otherwise.
     */
    private boolean onlyHasLeft(Node<T> node) {
        return node.getLeft() != null && node.getRight() == null;
    }
    /**
     * check if a node only has right subtree.
     * @param node the node to be checked
     * @return true if a node only has right subtree, false otherwise.
     */
    private boolean onlyHasRight(Node<T> node) {
        return node.getLeft() == null && node.getRight() != null;
    }
    /**
     * get the smallest node of a branch of a tree.
     * @param node the root node of a branch of a tree
     * @return the smallest node of a branch of a tree
     */
    private Node<T> smallestNode(Node<T> node) {
        if (node.getLeft() == null) {
            return node;
        }
        return smallestNode(node.getLeft());
    }
    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (!isEmpty() && contains(data)) {
            T result = get(data);
            if (size == 1) {
                root = null;
                size--;
            } else {
                root = removeHelper(root, data);
                size--;
            }
            return result;
        }
        return null;
    }
    /**
     * This is private helper method for remove.
     * @param cur current node
     * @param data the data to be remove
     * @return return the data of the removed node
     */
    private Node<T> removeHelper(Node<T> cur, T data) {
        if (data.equals(cur.getData())) {
            if (isLeaf(cur)) {
                return null;
            } else if (onlyHasLeft(cur)) {
                return cur.getLeft();
            } else if (onlyHasRight(cur)) {
                return cur.getRight();
            } else {
                Node<T> successor = smallestNode(cur.getRight());
                cur.setData(remove(successor.getData()));
                size++;
                cur.setHeight(heightHelper(cur));
                cur.setBalanceFactor(balFactorHelper(cur));
                cur = balanceTree(cur);
                return cur;
            }
        } else if (data.compareTo(cur.getData()) < 0) {
            cur.setLeft(removeHelper(cur.getLeft(), data));
        } else {
            cur.setRight(removeHelper(cur.getRight(), data));
        }
        cur.setHeight(heightHelper(cur));
        cur.setBalanceFactor(balFactorHelper(cur));
        cur = balanceTree(cur);
        return cur;
    }
    /**
     * This is private method that finds a node according to the data.
     * @param data the query data
     * @param node current node
     * @return return the node that has the query data, return null if doesn't
     *         have that data.
     *         throw exception if the query data is null
     */
    private Node<T> findNode(T data, Node<T> node) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (!isEmpty()) {
            if (node == null) {
                return null;
            } else if (data.equals(node.getData())) {
                return node;
            } else if (data.compareTo(node.getData()) < 0) {
                return findNode(data, node.getLeft());
            } else {
                return findNode(data, node.getRight());
            }
        }
        return null;
    }
    @Override
    public T get(T data) {
        if (contains(data) && !isEmpty()) {
            return findNode(data, root).getData();
        }
        return null;
    }
    @Override
    public boolean contains(T data) {
        return findNode(data, root) != null;
    }
    @Override
    public List<T> preOrder() {
        return preOrderHelper(root, new ArrayList<T>());
    }
    /**
     * This is a private helper method for preOrder
     * @param cur current node
     * @param list the list that appends data
     * @return return a list in preOrder
     */
    private List<T> preOrderHelper(Node<T> cur, List<T> list) {
        if (cur != null) {
            list.add(cur.getData());
            preOrderHelper(cur.getLeft(), list);
            preOrderHelper(cur.getRight(), list);
        }
        return list;
    }
    @Override
    public List<T> inOrder() {
        return inOrderHelper(root, new ArrayList<T>());
    }
    /**
     * This is a private helper method for inOrder.
     * @param cur current node
     * @param list the list that appends data
     * @return return a list in inOrder
     */
    private List<T> inOrderHelper(Node<T> cur, List<T> list) {
        if (cur != null) {
            inOrderHelper(cur.getLeft(), list);
            list.add(cur.getData());
            inOrderHelper(cur.getRight(), list);
        }
        return list;
    }
    @Override
    public List<T> postOrder() {
        return postOrderHelper(root, new ArrayList<T>());
    }
    /**
     * This is a private helper method for postOrder.
     * @param cur current node
     * @param list the list that appends data
     * @return return a list in postOrder
     */
    private List<T> postOrderHelper(Node<T> cur, List<T> list) {
        if (cur != null) {
            postOrderHelper(cur.getLeft(), list);
            postOrderHelper(cur.getRight(), list);
            list.add(cur.getData());
        }
        return list;
    }
    @Override
    public List<T> levelOrder() {
        List<T> arrayList = new ArrayList<T>();
        if (!isEmpty()) {
            Queue<Node<T>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<T> node = queue.poll();
                arrayList.add(node.getData());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }
        return arrayList;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    // DO NOT MODIFY OR USE ANY OF THE METHODS BELOW IN YOUR IMPLEMENTATION
    // These methods are for testing purposes only
    /**
     * Getter method to get root.
     * @return return root of a tree
     */
    public Node<T> getRoot() {
        return root;
    }
    /**
     * Setter method for root.
     * @param root new root to be set to
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
