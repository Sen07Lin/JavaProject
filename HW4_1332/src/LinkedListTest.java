import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import org.junit.Test;

/**
 * @author Sen
 * Please let me know if the test misses some cases.
 */
public class LinkedListTest {
    DoublyLinkedList<String> array = new DoublyLinkedList<String>();

    @Test
    public void testAdd1() {
        array.add(0 , "Zero"); // add front
        array.add(0 ,"Wongoo");
        assertEquals(array.remove(10),null);
        assertEquals("Zero", array.get(1));
        assertEquals("Wongoo", array.get(0));
    }
    @Test
    public void testAdd21() { // add back
        array.add(0,"Zero");
        array.add(1 ,"Wongoo");

        assertEquals("Zero", array.get(0));
        assertEquals("Wongoo", array.get(1));
    }
    @Test
    public void testAdd3() { // out bound
        array.add(2,"Zero");
        array.add(1,"Wongoo");
        assertTrue(array.isEmpty());
        assertTrue(array.isEmpty());
    }
    @Test
    public void testAdd4() {
        // test null
        assertFalse(array.contains(null));
        assertFalse(array.contains("asda"));
        assertFalse(array.contains("Zero"));
        assertEquals(array.indexOf("Zero"), -1);
        assertEquals(array.indexOf("Won2goo"),-1);
        assertEquals(array.indexOf("ongoo"), -1);
        assertEquals(array.indexOf(null), -1);
        assertEquals(array.get(0), null);
        assertEquals(array.get(2), null);
        assertEquals(array.get(-1), null);
        assertEquals(array.get(99), null);
        assertEquals(array.size(), 0);
        assertTrue(array.isEmpty());


        array.add(0,"Zero"); // contains, size, clear, isempty,indexOf,get
        array.add(1,"Wongoo");
        array.add(2,"Won2goo");
        array.add(1,"Wo22222ngoo");

        assertEquals(array.indexOf("Zero"), 0);
        assertEquals(array.indexOf("Won2goo"),3);
        assertEquals(array.indexOf("ongoo"), -1);
        assertEquals(array.indexOf(null), -1);

        assertEquals(array.get(0), "Zero");
        assertEquals(array.get(2), "Wongoo");
        assertEquals(array.get(-1), null);
        assertEquals(array.get(99), null);

        assertFalse(array.contains(null));
        assertFalse(array.contains("asda"));
        assertFalse(!array.contains("Zero"));
        array.clear();
        assertTrue(array.isEmpty());
        assertEquals(0, array.size());
        array.clear();
    }
    @Test
    public void testAddBack() {
        array.add(0 ,"Zero");
        array.add(1 ,"Wongoo");
        System.out.println("size" + array.isEmpty() + array.size());
        assertEquals("Zero", array.get(0));
        assertEquals("Wongoo", array.get(1));
    }
    @Test
    public void testRemove1() {
        array.add(0 ,"Wongoo8");
        assertEquals("Wongoo8" , array.remove("Wongoo8"));
        array.clear();
        array.add(0 ,"Wongoo1");
        array.add(0 ,"Wongoo2");
        array.add(0 ,"Wongoo3");
        array.add(0 ,"Wongoo4");
        assertEquals("Wongoo4",array.remove(0)); // remove front
        assertEquals("Wongoo2",array.remove(1)); // remove middle
        System.out.println("ater remove" + array.get(1));
        assertEquals("Wongoo1",array.remove(1)); // remove back
        assertEquals("Wongoo3",array.remove(0)); // remove single
        assertEquals(0,array.size());
        //Object[] arr = array.toList();
        //assertEquals("Wongoo", arr[0]);
    }
    @Test
    public void testRemove2() {
        array.add(0 ,"Wongoo1");
        array.add(0 ,"Wongoo2");
        array.add(0 ,"Wongoo4");
        array.add(0 ,"Wongoo5");
        array.add(array.size(),"Wongoo6");
        array.add(0 ,"Wongoo7");
        array.add(array.size(),"Wongoo8");
        assertEquals("Wongoo8" ,array.remove(array.size() - 1));
        assertEquals("Wongoo7" , array.remove(0));
        assertEquals("Wongoo6" ,array.remove(array.size() -1 ));
        assertEquals("Wongoo5" , array.remove(0));

        assertEquals("Wongoo4", array.get(0));
        assertEquals("Wongoo2", array.get(1));
        assertEquals("Wongoo1", array.get(2));
        array.clear();
        assertNull(array.remove(array.size()));
        array.remove(-1);
        assertTrue(array.isEmpty());
        array.add(0 ,"Wongoo1");
        array.add(0 ,"Wongoo2");
        array.add(array.size(),"Wongoo4");
        array.add(0 ,"Wongoo5");
        array.add(array.size(),"Wongoo6");
        array.add(0 ,"Wongoo7");
        array.add(array.size(),"Wongoo8");
        assertEquals("Wongoo8" , array.remove("Wongoo8"));
        assertEquals("Wongoo7" , array.remove("Wongoo7"));
        assertEquals("Wongoo6" , array.remove("Wongoo6"));
        assertEquals("Wongoo5" , array.remove("Wongoo5"));
        assertNull(array.remove(array.size()));
        array.remove(-1);
        array.remove(-1);
        array.remove(array.size() + 1);
        assertNull(array.remove(null));

        assertEquals("Wongoo2", array.get(0));
        assertEquals("Wongoo1", array.get(1));
        assertEquals("Wongoo4", array.get(2));

    }

    public void testNull2() {
        assertNull(array);
        assertEquals(null,array.remove(array.size()));
        assertEquals(null,array.remove(0));
        array.clear();
    }
    @Test (timeout = 200)
    public void testAdd11(){
        // add one item
        array.add(0 ,"what");
        //  array.addFront("wht");
        assertEquals("what",array.get(0));
        assertEquals(array.indexOf("what"), 0);
        assertEquals(array.indexOf("Won2goo"),-1);
        assertEquals(array.indexOf("ongoo"), -1);
        assertEquals(array.indexOf(null), -1);

        assertEquals(array.get(0), "what");
        assertEquals(array.get(2), null);
        assertEquals(array.get(-1), null);
        assertEquals(array.get(99), null);

        assertFalse(array.contains(null));
        assertFalse(array.contains("asda"));
        assertFalse(!array.contains("what"));
        array.clear();
        assertTrue(array.isEmpty());
        assertEquals(0, array.size());
    }

    @Test (timeout = 200)
    public void testAdd12(){
        array.add(0 ,new String("What"));
        array.add(0 ,new String("What"));
        assertEquals(new String("What"),array.get(1));
    }

    @Test (timeout = 200)
    public void testAdd13(){
        //add front
        for(int i=0; i<15; i++){
            array.add(0 ,""+i);
        }

        assertTrue(array.size()>14);
        String[] arr1 = new String[20];
        array.clear();
        for(int i =14; i>=0; i--){
            array.add(0 ,new String(""+i));
            arr1[i] = new String(""+i);
        }


        for(int i=0; i<array.size();i++){
            assertEquals(array.get(i),arr1[i]);
        }
        array.clear();
    }

    @Test (timeout = 200)
    public void testAdd14(){
        //add back
        String[] arr = new String[20];
        for(int i=0; i<15; i++){
            array.add(i ,new String(""+i));
            arr[i] = new String(""+i);
        }
        //Object[] toArr = array.toList();
        for(int i=0; i<array.size();i++){
            assertEquals(array.get(i),arr[i]);
        }
    }
    @Test (timeout = 200)
    public void replace(){
        //add back
        String[] arr = new String[20];
        for(int i=0; i<15; i++){
            array.add(i,new String(""+i));
            arr[i] = new String(""+i);
        }
        assertEquals(array.replace(14, "19"), "14");
        assertEquals("19", array.get(14));
        array.replace(-1, "19");
        array.replace(16, "19");
        array.replace(14, "14");
        //assertNull(array.replace(14, "14"));
        //Object[] toArr = array.toList();
        for(int i=0; i<array.size();i++){
            assertEquals(array.get(i),arr[i]);
        }
    }
    @Test (timeout = 200)
    public void reverseTest(){
        // reverse get. indexof. contains.
        //reverse empty
        array.reverseList();
        // reverse single
        array.add(0 ,"1");
        array.reverseList();
        assertEquals("1",array.get(0));
        array.add(0 ,"2");
        //reverse two elements
        array.reverseList();
        assertEquals("1",array.get(0));
        assertEquals("2",array.get(1));
        String[] arr = new String[20];
        array.clear();
        for(int i=0; i<15; i++){
            array.add(i ,new String(""+i));
            arr[i] = new String(""+i);
        }
        // reverse twice
        array.reverseList();
        array.reverseList();
        System.out.println(array.toString() + array.get(14) + array.indexOf("14"));
        assertEquals(array.replace(14, "19"), "14");
        assertEquals(array.indexOf("19"), 14);
        assertEquals("19", array.get(14));
        array.replace(-1, "19");
        array.replace(16, "19");
        array.replace(14, "14");
        //Object[] toArr = array.toList();
        for(int i=0; i<array.size();i++){
            assertEquals(array.get(i),arr[i]);
            assertEquals(array.indexOf(""+i), i);
        }
        // reverse three time
        array.reverseList();
        array.reverseList();
        array.reverseList();
        array.clear();
        for(int i=0; i<15; i++){
            array.add(0 ,new String(""+i));
            arr[i] = new String(""+i);
        }
        array.reverseList();
        for(int i=0; i<array.size();i++){
            assertEquals(array.get(i),arr[i]);
        }
        array.reverseList();
        array.reverseList();
        Iterator<String> it = array.iterator();
        int w = 0;
        for (String s: array){
            assertEquals(s,arr[w]);
            w++;
        }
        for(int i=0; i<array.size();i++){
            assertEquals(array.get(i),arr[i]);
        }
    }
}

