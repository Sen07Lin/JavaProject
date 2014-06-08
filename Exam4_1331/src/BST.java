


public class BST{
    private Node root;
    private class Node{
        private int data;
        private Node left, right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public void add(int data){
        root = insert(data, root);
    }
    public Node insert(int data, Node node){
        if(node == null){
            Node temp = new Node(data);
            return temp;
        }else if(data < node.data){
            node.left = insert(data,node.left);
            
        }else{
            node.right = insert(data,node.right);
        }
        return node;
    }
    public void printPreOrder() {
        printPreOrder(root);
    }
    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    public static void main(String[] args){
        BST bet = new BST();
        bet.add(1);
        bet.add(0);
        bet.add(3);
        bet.add(2);
        bet.add(4);
        bet.printPreOrder();
    }
}

