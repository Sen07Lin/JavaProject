import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * This class describes a binary search tree. It's not a balanced tree.
 * @author Sen
 * @param <T> generic type of the class
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    private Node<T> root;
    private int size = 0;
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
            return temp;
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(data, node.getLeft()));
            return node;
        } else {
            node.setRight(insert(data, node.getRight()));
            return node;
        }
    }
    @Override
    public void addAll(Collection<T> c) {
        if (c != null && !c.isEmpty()) {
            for (T data : c) {
                add(data);
            }
        }
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
            if (size == 1) {
                root = null;
                size--;
                return data;
            } else {
                root = removeHelper(root, data);
                size--;
                return data;
            }
        }
        return null;
    }
    /**
     * This is private method that checks if a child node is a parent node's
     * left subtree.
     * @param parent the parent node
     * @param child the child node
     * @return return true if the child node is the parent's left
     *         subtree,otherwise return false
     */
    private boolean isleftChild(Node<T> parent, Node<T> child) {
        return (parent.getLeft() != null && parent.getLeft().getData()
                .equals(child.getData()));
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
                return cur;
            }
        } else if (data.compareTo(cur.getData()) < 0) {
            cur.setLeft(removeHelper(cur.getLeft(), data));
            return cur;
        } else {
            cur.setRight(removeHelper(cur.getRight(), data));
            return cur;
        }
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
    /**
     * This is private method that finds the parent node according to the data.
     * @param data the query data
     * @param node current parent node
     * @return return the parent node in which its child node has the query
     *         data, return null if doesn't
     *         have that data.
     */
    private Node<T> findParentNode(T data, Node<T> node) {
        if (contains(data)) {
            // parent of root is still root.
            if (root.getData().equals(data)) {
                return root;
            } else if ((node.getLeft() != null && node.getLeft().getData()
                    .equals(data))
                    || (node.getRight() != null && node.getRight().getData()
                    .equals(data))) {
                return node;
            } else if (data.compareTo(node.getData()) < 0) {
                return findParentNode(data, node.getLeft());
            } else {
                return findParentNode(data, node.getRight());
            }
        }
        return null;
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
}
