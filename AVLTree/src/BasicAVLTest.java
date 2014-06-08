import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Before;
import org.junit.Test;

/**
 * Basic Test Cases for
 * Adelson-Velskii and Landis' Tree
 * Student Edition
 *
 * @author Jonathan Jemson
 * @version 1.0
 */
public class BasicAVLTest {
    private AVL<Integer> tree;
    private AVL<Integer> avl;
    
    @Before
    public void setup() {
        avl = new AVL<Integer>();
        tree = new AVL<Integer>();
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullAdd() {
        tree.add(null);
        assertNull(tree.get(null));
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullAddAll() {
        tree.addAll(null);
        assertNull(tree.get(null));
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullRemove() {
        assertNull(tree.remove(null));
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullContains() {
        assertFalse(tree.contains(null));
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullGet() {
        assertNull(tree.get(null));
    }
    /* Basic Tree tests
     * A tree consisting of three nodes (25, 50, 75) */
    /**
     * Adds a basic tree of three nodes.
     * Used for the basic tests.
     */
    private void addBasicTree() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
    }
    @Test(timeout = 200)
    public void testBasicAdd() throws Exception {
        addBasicTree();
        assertTrue(tree.contains(new Integer(50)));
        assertTrue(tree.contains(new Integer(25)));
        assertTrue(tree.contains(new Integer(75)));
        List<Integer> preOrder = tree.preOrder();
        List<Integer> inOrder = tree.inOrder();
        List<Integer> postOrder = tree.postOrder();
        List<Integer> levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 50, 25, 75 }, preOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 50, 75 }, inOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 75, 50 }, postOrder.toArray());
        assertArrayEquals(new Integer[] { 50, 25, 75 }, levelOrder.toArray());
    }
    @Test(timeout = 200)
    public void testAdd() {
        // no rotation
        avl.add(2);
        avl.add(4);
        
        // Data Checks
        assertEquals((Integer) 2, avl.getRoot().getData());
        assertEquals((Integer) 4, avl.getRoot().getRight().getData());
        
        // Height and Balance Factor Checks
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(-1, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
    }
    @Test(timeout = 200)
    public void testBasicAddAll() throws Exception {
        Collection<Integer> ints = new ArrayList<Integer>();
        ints.add(50);
        ints.add(25);
        ints.add(75);
        tree.addAll(ints);
        assertTrue(tree.contains(new Integer(50)));
        assertTrue(tree.contains(new Integer(25)));
        assertTrue(tree.contains(new Integer(75)));
        List<Integer> preOrder = tree.preOrder();
        List<Integer> inOrder = tree.inOrder();
        List<Integer> postOrder = tree.postOrder();
        List<Integer> levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 50, 25, 75 }, preOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 50, 75 }, inOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 75, 50 }, postOrder.toArray());
        assertArrayEquals(new Integer[] { 50, 25, 75 }, levelOrder.toArray());
    }
    
    public List<Integer> level(){
        List<Integer> arrayList = new ArrayList<Integer>();
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(tree.getRoot());
        while (!queue.isEmpty()) {
            Node<Integer> node = queue.poll();
            arrayList.add(node.getBalanceFactor());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return arrayList;
    }
    public boolean isBalance(int i){
        return i<=1 && i>= -1;
    }
    @Test(timeout = 200)
    public void testBasicRemove() throws Exception {
        addBasicTree();
        // remove root that has two childs
        assertEquals(new Integer(50), tree.remove(50));
        System.out.println("After remove 50" + tree.inOrder().toString());
        System.out.println("After remove 50");
        System.out.println(tree.size());
        assertFalse(tree.contains(new Integer(50)));
        assertTrue(tree.contains(new Integer(25)));
        assertTrue(tree.contains(new Integer(75)));
        List<Integer> preOrder = tree.preOrder();
        List<Integer> inOrder = tree.inOrder();
        List<Integer> postOrder = tree.postOrder();
        List<Integer> levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 75, 25 }, preOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 75 }, inOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 75 }, postOrder.toArray());
        assertArrayEquals(new Integer[] { 75, 25 }, levelOrder.toArray());
        // remove root that has one left child
        assertEquals(new Integer(75), tree.remove(75));
        System.out.println("After remove 75" + tree.inOrder().toString());
        System.out.println("After remove 75");
        System.out.println(tree.size());
        assertTrue(tree.contains(new Integer(25)));
        assertFalse(tree.contains(new Integer(75)));
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 25 }, preOrder.toArray());
        assertArrayEquals(new Integer[] { 25 }, inOrder.toArray());
        assertArrayEquals(new Integer[] { 25 }, postOrder.toArray());
        assertArrayEquals(new Integer[] { 25 }, levelOrder.toArray());
        // remove single root that has no child
        assertEquals(new Integer(25), tree.remove(25));
        assertTrue(tree.isEmpty());
        addBasicTree();
        // remove left subtree
        assertEquals(new Integer(25), tree.remove(25));
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 50, 75 }, preOrder.toArray());
        assertArrayEquals(new Integer[] { 50, 75 }, inOrder.toArray());
        assertArrayEquals(new Integer[] { 75, 50 }, postOrder.toArray());
        assertArrayEquals(new Integer[] { 50, 75 }, levelOrder.toArray());
        // remove right subtree
        assertEquals(new Integer(75), tree.remove(75));
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 50 }, preOrder.toArray());
        assertArrayEquals(new Integer[] { 50 }, inOrder.toArray());
        assertArrayEquals(new Integer[] { 50 }, postOrder.toArray());
        assertArrayEquals(new Integer[] { 50 }, levelOrder.toArray());
        tree.add(25);
        tree.add(30);
        tree.add(75);
        // remove that requires left right rotation
        assertEquals(new Integer(25), tree.remove(25));
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 50, 30, 75 },
                preOrder.toArray());
        assertArrayEquals(new Integer[] { 30, 50, 75, },
                inOrder.toArray());
        assertArrayEquals(new Integer[] { 30, 75, 50},
                postOrder.toArray());
        //System.out.println(levelOrder.toString());
        assertArrayEquals(new Integer[] { 50, 30, 75},
                levelOrder.toArray());
        //System.out.println(levelOrder.toArray().toString());
        // remove that requires right rotation
        tree.add(25);
        assertEquals(new Integer(75), tree.remove(75));
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 30, 25, 50 },
                preOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 30, 50, },
                inOrder.toArray());
        assertArrayEquals(new Integer[] { 25, 50, 30,},
                postOrder.toArray());
        assertArrayEquals(new Integer[] { 30, 25, 50},
                levelOrder.toArray());
        // remove an item that not in the tree
        assertEquals(null, tree.remove(90));
        // remove that requires left rotation
        tree.add(125);
        assertEquals(new Integer(25), tree.remove(25));
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        assertArrayEquals(new Integer[] { 50, 30, 125 }, preOrder.toArray());
        assertArrayEquals(new Integer[] { 30, 50, 125 }, inOrder.toArray());
        assertArrayEquals(new Integer[] { 30, 125, 50 }, postOrder.toArray());
        assertArrayEquals(new Integer[] { 50, 30, 125 }, levelOrder.toArray());
        //test size
        for (Integer i: tree.inOrder()){
            int j = tree.size();
            assertEquals(i,tree.get(i));
            tree.remove(i);
            j--;
            assertEquals(j,tree.size());
            assertFalse(avl.contains(i));
            //assertEquals(i,tree.get(i));
        }
        assertTrue(tree.isEmpty());
        tree.clear();
        for (int i = 0; i< 20; i++){
            tree.add(i);
        }
        for(int i= 0; i <20; i++){
            tree.remove(i);
        }
        assertTrue(tree.isEmpty());
        for (int i = 0; i< 20; i++){
            tree.add(i);
        }
        for(int i= 0; i <20; i+=2){
            tree.remove(i);
        }
        for(int i= 1; i <20; i+=2){
            tree.remove(i);
        }
        assertTrue(tree.isEmpty());
        
        
        for (int i = 0; i< 20; i++){
            tree.add(i);
            System.out.println("After add an item" +tree.levelOrder().toString());
        }
        System.out.println(tree.size());
        System.out.println(tree.levelOrder().toString());
        
        System.out.println(level().toString());
        for(int i= 19; i >= 0; i-=2){
            tree.remove(i);
            System.out.println("after remove " + i+ level().toString());
            System.out.println(tree.levelOrder().toString());
            System.out.println(tree.size());
        }
        System.out.println(level().toString());
        System.out.println(tree.levelOrder().toString());
        for(int i= 18; i >= 0; i-=2){
            tree.remove(i);
            
            //System.out.println(tree.size());
        }
        System.out.println("sndiasdnaisdnaisdas" +tree.size());
        assertTrue(tree.isEmpty());
        for (int i = 0; i< 30; i++){
            tree.add(i);
        }
        for(int i= 29; i >= 0; i-=3){
            tree.remove(i);
            System.out.println("after remove " + i+ level().toString());
            System.out.println(tree.levelOrder().toString());
            //System.out.println(tree.size());
        }
        for(int i= 29; i >= 0; i-=2){
            tree.remove(i);
            System.out.println("after remove " + i+ level().toString());
            System.out.println(tree.levelOrder().toString());
        }
        for(int i= 29; i >= 0; i-=1){
            tree.remove(i);
            
        }
        assertTrue(tree.isEmpty());
        for (int i = 100; i>= 0; i--){
            tree.add(i);
        }
        for(int i= 100; i >= 0; i-=3){
            tree.remove(i);
        }
        for(int i= 90; i >= 0; i-=2){
            tree.remove(i);
            
        }
        for(int i= 100; i >= 0; i-=1){
            tree.remove(i);
            
        }
        assertTrue(tree.isEmpty());
        for (int i = 10; i>= 0; i--){
            tree.add(i);
            
        }
        System.out.println(level().toString());
        System.out.println("asdaa" + tree.levelOrder().toString());
        for(int i= 0; i <=10 ; i+=2){
            tree.remove(i);
            System.out.println(tree.size());
        }
        for(int i= 0; i <=10 ; i+=3){
            tree.remove(i);
            System.out.println(tree.size());
        }
        System.out.println(level().toString());
        System.out.println("asdaa" + tree.levelOrder().toString());
        //  System.out.println(tree.size());
        /*for(int i= 0; i >= -200; i-=2){
            tree.remove(i);
            System.out.println(tree.size());
        }
        System.out.println(tree.inOrder().toString());
        for(int i= -1; i >= -200; i-=2){
            tree.remove(i);
            System.out.println("two"+ tree.size());
        }
        System.out.println(tree.inOrder().toString());
        System.out.println(tree.size());
        for(int i= 200; i >= 0; i--){
            tree.remove(i);
            // System.out.println(tree.size());
        }
        System.out.println(tree.inOrder().toString());
        for(int i= 0; i >= -100; i-=5){
            tree.remove(i);
        }
        System.out.println(tree.size());
        for(int i= 200; i >= 0; i--){
            tree.remove(-i);
        }*/
        // System.out.println(tree.inOrder().toString());
        //System.out.println(tree.size());
        //assertTrue(tree.isEmpty());
    }
    @Test(timeout = 200)
    public void testAddSuper1() {
        tree.clear();
        for (int i= 0; i < 10 ; i ++){
            tree.add(i);
            tree.add(-i);
            tree.add(-2*i);
            tree.add(2*i);
            if(!tree.isEmpty()) {
                for (int t: level()){
                    assertTrue(isBalance(t));
                }
            }
            //System.out.println(i);
        }
        System.out.println("first" +tree.inOrder().toString());
        for (int i= -10; i < 10 ; i +=2){
            tree.remove(i);
            System.out.println(i);
            if(!tree.isEmpty()) {
                for (int t: level()){
                    assertTrue(isBalance(t));
                }
            }
        }
        System.out.println("second" +tree.inOrder().toString());
        for (int i= -18; i <0 ; i +=3){
            tree.remove(i);
            //System.out.println(i);
            if(!tree.isEmpty()) {
                for (int t: level()){
                    assertTrue(isBalance(t));
                }
            }
        }
        
        System.out.println(tree.size());
        
        
        
        //List<Integer> levelOrder2 = tree.levelOrder();
        /* assertArrayEquals(new Integer[] {0,1,2,3,4,5,6,7,8,9 }, tree.inOrder().toArray());
    assertArrayEquals(new Integer[] {0,2,1,4,6,5,9,8,7,3}, tree.postOrder().toArray());
    assertArrayEquals(new Integer[] {3,1,0,2 ,7,5,4,6,8,9}, tree.preOrder().toArray());
    tree.remove(0);
    tree.remove(2);
    assertArrayEquals(new Integer[] {1,3,4,5,6,7,8,9 }, tree.inOrder().toArray());
    System.out.println("this is level order" + tree.levelOrder().toString());
    assertArrayEquals(new Integer[] {7,3,8,1,5,9,4,6 }, tree.levelOrder().toArray());
    
    assertArrayEquals(new Integer[] {1,4,6,5,3,9,8,7}, tree.postOrder().toArray());
    assertArrayEquals(new Integer[] {7,3,1,5,4,6,8,9}, tree.preOrder().toArray());*/
        //tree.clear();
        /* for (int i= 0; i < 5 ; i ++){
            tree.add(i);
            tree.add(-i);
            //System.out.println(i);
        }*/
        /*assertArrayEquals(new Integer[] {-4,-3,-2,-1,0,1,2,3,4 }, tree.inOrder().toArray());
        assertArrayEquals(new Integer[] {0,2,1,4,6,5,9,8,7,3}, tree.postOrder().toArray());
        assertArrayEquals(new Integer[] {3,1,0,2 ,7,5,4,6,8,9}, tree.preOrder().toArray());
        for (int i= 30; i >= 0 ; i -=2){
            tree.add(i);
            List<Integer> levelOrder2 = tree.levelOrder();
        }*/
        
        
    }
    @Test(timeout = 200)
    public void testRemove() {
        avl.add(4);
        avl.add(20);
        avl.add(-200);
        avl.remove(4);
        
        assertEquals((Integer) 20, avl.getRoot().getData());
        assertEquals((Integer) (-200), avl.getRoot().getLeft().getData());
    }
    
    @Test(timeout = 200)
    public void testGet() {
        avl.add(2);
        avl.add(54);
        avl.add(420);
        assertEquals((Integer) 420, avl.get(420));
    }
    
    @Test(timeout = 200)
    public void testContains() {
        avl.add(3);
        avl.add(2);
        avl.add(1000000);
        assertTrue(avl.contains(3));
        assertTrue(avl.contains(2));
        assertTrue(avl.contains(1000000));
        avl.remove(2);
        assertFalse(avl.contains(2));
    }
    
    @Test(timeout = 200)
    public void testIsEmpty() {
        avl.add(2);
        avl.add(5);
        
        assertFalse(avl.isEmpty());
        avl.clear();
        assertTrue(avl.isEmpty());
    }
    
    @Test(timeout = 200)
    public void testSize() {
        avl.add(3);
        avl.add(6);
        avl.add(9);
        assertEquals(3, avl.size());
    }
    
    @Test(timeout = 200)
    public void testClear() {
        avl.clear();
        assertNull(avl.getRoot());
    }
    
    /*
     * Additional add/remove test cases
     * For AVL rotations
     */
    
    public void addRightHeavy() {
        // Left Rotation
        avl.add(2);
        avl.add(4);
        avl.add(6);
    }
    
    @Test(timeout = 200)
    public void testRightHeavyAdd() {
        addRightHeavy();
        
        // Data Checks
        assertEquals((Integer) 4, avl.getRoot().getData());
        assertEquals((Integer) 6, avl.getRoot().getRight().getData());
        assertEquals((Integer) 2, avl.getRoot().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
    }
    public void testAddTen(){
        tree.clear();
        for (int i = 0; i <10; i++){
            tree.add(i);}
        
    }
    public void addLeftHeavy() {
        // Right Rotation
        avl.add(2);
        avl.add(4);
        avl.add(6);
    }
    @Test(timeout = 200)
    public void testLeftHeavyAdd() {
        addLeftHeavy();
        
        // Data Checks
        assertEquals((Integer) 4, avl.getRoot().getData());
        assertEquals((Integer) 6, avl.getRoot().getRight().getData());
        assertEquals((Integer) 2, avl.getRoot().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
    }
    
    public void addRightLeft() {
        // Right-Left Rotation
        avl.add(3);
        avl.add(8);
        avl.add(7);
    }
    @Test(timeout = 200)
    public void testRightLeftAdd() {
        addRightLeft();
        
        // Data Checks
        assertEquals((Integer) 7, avl.getRoot().getData());
        assertEquals((Integer) 8, avl.getRoot().getRight().getData());
        assertEquals((Integer) 3, avl.getRoot().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
    }
    public void addLeftRight() {
        // Left Right Rotation
        avl.add(8);
        avl.add(3);
        avl.add(7);
    }
    @Test(timeout = 200)
    public void testLeftRightAdd() {
        addLeftRight();
        
        // Data Checks
        assertEquals((Integer) 7, avl.getRoot().getData());
        assertEquals((Integer) 8, avl.getRoot().getRight().getData());
        assertEquals((Integer) 3, avl.getRoot().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
    }
    public void addForRemoveLeftRight() {
        // Adds a balanced tree to unbalance
        // by remove for a left-right rotation
        avl.add(8);
        avl.add(6);
        avl.add(10);
        avl.add(7);
    }
    @Test(timeout = 200)
    public void testRemoveLeftRight() {
        addForRemoveLeftRight();
        
        // Data Checks
        assertEquals((Integer) 8, avl.getRoot().getData());
        assertEquals((Integer) 10, avl.getRoot().getRight().getData());
        assertEquals((Integer) 7, avl.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 6, avl.getRoot().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(3, avl.getRoot().getHeight());
        assertEquals(1, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getRight().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getRight().getBalanceFactor());
        assertEquals(2, avl.getRoot().getLeft().getHeight());
        assertEquals(-1, avl.getRoot().getLeft().getBalanceFactor());
        
        // Remove
        assertEquals((Integer) 10, avl.remove(10));
        
        // Data Checks
        assertEquals((Integer) 7, avl.getRoot().getData());
        assertEquals((Integer) 8, avl.getRoot().getRight().getData());
        assertEquals((Integer) 6, avl.getRoot().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
        
        //remove root with total size 3
        assertEquals((Integer) 7, avl.remove(7));
        assertEquals((Integer) 8, avl.getRoot().getData());
        assertEquals((Integer) 6, avl.getRoot().getLeft().getData());
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(1, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
        
        assertEquals((Integer) 8, avl.remove(8));
        assertEquals((Integer) 6, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        
        
    }
    public void addForRemoveRightLeft() {
        // Adds a balanced tree to unbalance
        // by remove for a right-left rotation
        avl.add(8);
        avl.add(6);
        avl.add(10);
        avl.add(9);
    }
    @Test(timeout = 200)
    public void testRemoveRightLeft() {
        addForRemoveRightLeft();
        
        // Data Checks
        assertEquals((Integer) 8, avl.getRoot().getData());
        assertEquals((Integer) 10, avl.getRoot().getRight().getData());
        assertEquals((Integer) 6, avl.getRoot().getLeft().getData());
        assertEquals((Integer) 9, avl.getRoot().getRight().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(3, avl.getRoot().getHeight());
        assertEquals(-1, avl.getRoot().getBalanceFactor());
        assertEquals(2, avl.getRoot().getRight().getHeight());
        assertEquals(1, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getRight().getLeft().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
        
        // Remove
        assertEquals((Integer) 6, avl.remove(6));
        
        // Data Checks
        assertEquals((Integer) 9, avl.getRoot().getData());
        assertEquals((Integer) 10, avl.getRoot().getRight().getData());
        assertEquals((Integer) 8, avl.getRoot().getLeft().getData());
        
        // Height and Balance Factor Checks
        assertEquals(2, avl.getRoot().getHeight());
        assertEquals(0, avl.getRoot().getBalanceFactor());
        assertEquals(1, avl.getRoot().getRight().getHeight());
        assertEquals(0, avl.getRoot().getRight().getBalanceFactor());
        assertEquals(1, avl.getRoot().getLeft().getHeight());
        assertEquals(0, avl.getRoot().getLeft().getBalanceFactor());
    }
    
}
