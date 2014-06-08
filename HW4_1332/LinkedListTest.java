import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	LinkedListInterface<String> myList = new LinkedList<String>();
	
	@Test
	public void testAdd1() {
		LinkedListInterface<String> myList = new LinkedList<String>();
		myList.addToFront("Zero");
		myList.addToFront("Wongoo");
		Object[] arr = myList.toList();
		//assertEquals(myArray.remove(10),null);
		assertEquals("Zero", arr[1]);
		assertEquals("Wongoo", arr[0]);
	}
	@Test
	public void testAdd2() {
		myList.addToBack("Zero");
		myList.addToBack("Wongoo");
		Object[] arr = myList.toList();
		assertEquals("Zero", arr[0]);
		assertEquals("Wongoo", arr[1]);
	}
	@Test
	public void testRemove1() {
		myList.addToFront("Wongoo");
		myList.addToFront("Wongoo2");
		myList.removeFromFront();
		Object[] arr = myList.toList();
		assertEquals("Wongoo", arr[0]);
	}
	@Test
	public void testRemove2() {
		myList.addToFront("Wongoo1");
		myList.addToFront("Wongoo2");
		myList.addToBack("Wongoo4");
		myList.addToFront("Wongoo5");
	    myList.addToBack("Wongoo6");
	    myList.addToFront("Wongoo7");
        myList.addToBack("Wongoo8");
		myList.removeFromBack();
	    myList.removeFromFront();
	    myList.removeFromBack();
	    myList.removeFromFront();
		Object[] arr = myList.toList();
		assertEquals("Wongoo2", arr[0]);
		assertEquals("Wongoo1", arr[1]);
		assertEquals("Wongoo4", arr[2]);
		myList.clear();
		assertEquals(null,myList.toList());
		myList.addToFront("Wongoo1");
        myList.addToFront("Wongoo2");
        myList.addToBack("Wongoo4");
        myList.addToFront("Wongoo5");
        myList.addToBack("Wongoo6");
        myList.addToFront("Wongoo7");
        myList.addToBack("Wongoo8");
        myList.removeFromBack();
        myList.removeFromFront();
        myList.removeFromBack();
        myList.removeFromFront();
        Object[] arr2 = myList.toList();
        assertEquals("Wongoo2", arr2[0]);
        assertEquals("Wongoo1", arr2[1]);
        assertEquals("Wongoo4", arr2[2]);
		
	}
	
	@Test
	public void testNull() {
	    assertEquals(null,myList.toList());
	    assertEquals(null,myList.removeFromBack());
	    assertEquals(null,myList.removeFromFront());
	    myList.clear();
	    
	}
	
	@Test
	public void testSizeOne() {
	    myList.addToFront("Wongoo");
	    myList.removeFromBack();
	    myList.addToFront("Wongoo");
	    myList.removeFromFront();
	    myList.addToBack("Wongoo");
	    myList.removeFromBack();
	    myList.addToBack("Wongoo");
	    myList.removeFromFront();
	}
}
	
	