import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class BasicDynamicArrayTests {

    private DynamicArrayInterface<Thing> array;

    @Before
    public void setup(){
        array = new Pra<Thing>();
    }

    @Test (timeout = 200)
    public void testAdd1(){
        array.add(new Thing("what"));
        assertEquals(new Thing("what"),array.get(0));
    }

    @Test (timeout = 200)
    public void testAdd2(){
        array.add(new Thing("what"));
        array.add(new Thing("What"));
        assertEquals(new Thing("What"),array.get(1));
    }

    @Test (timeout = 200)
    public void testAdd3(){
        for(int i=0; i<15; i++){
            array.add(new Thing(""+i));
        }
        Object[] arr = array.toArray();
        assertTrue(arr.length>14);
    }

    @Test (timeout = 200)
    public void testAdd4(){
        Thing[] arr = new Thing[20];
        for(int i=0; i<15; i++){
            array.add(new Thing(""+i));
            arr[i] = new Thing(""+i);
        }
        Object[] toArr = array.toArray();
        for(int i=0; i<array.size();i++){
            assertEquals(toArr[i],arr[i]);
        }
    }

    @Test (timeout = 200)
    public void testAddAll1(){
        Collection<Thing> coll = new LinkedList<>();
        Thing[] arr = new Thing[10];

        for(int i=0; i<9; i++){
            coll.add(new Thing(""+i));
            arr[i] = new Thing(""+i);
        }
        array.addAll(coll);
        assertArrayEquals(array.toArray(),arr);
    }

    @Test (timeout = 200)
    public void testAddAll2(){
        Collection<Thing> coll = new LinkedList<>();
        Thing[] arr = new Thing[10];

        array.add(new Thing("0"));
        arr[0] = new Thing("0");

        for(int i=0; i<8; i++){
            coll.add(new Thing(""+i));
            arr[i+1] = new Thing(""+i);
        }
        array.addAll(coll);
        assertArrayEquals(array.toArray(),arr);
    }

    @Test (timeout = 200)
    public void testAddAll3(){
        Collection<Thing> coll = new LinkedList<>();

        for(int i=0; i<15; i++){
            coll.add(new Thing(""+i));
        }
        array.addAll(coll);
        Object[] arr = array.toArray();
        assertTrue(arr.length>14);
    }

    @Test (timeout = 200)
    public void testRemove1(){
        array.add(new Thing("all the small"));
        array.remove(new Thing("all the small"));
        assertTrue(array.size()==0);
    }

    @Test (timeout = 200)
    public void testRemove2(){
        array.add(new Thing("all the small",1));
        Thing removed = array.remove(new Thing("all the small",2));
        assertTrue(removed.number==1);
    }

    @Test (timeout = 200)
    public void testRemove3(){
        assertNull(array.remove(new Thing("always")));
    }

    @Test (timeout = 200)
    public void testRemove4(){
        Collection<Thing> coll = new LinkedList<>();
        Thing[] arr = {new Thing("0"),new Thing("1"), new Thing("3"),new Thing("4"), null, null, null, null, null, null};

        for(int i=0; i<5; i++){
            coll.add(new Thing(""+i));
        }
        array.addAll(coll);
        array.remove(new Thing("2"));
        assertArrayEquals(array.toArray(),arr);
    }

    @Test (timeout = 200)
    public void testRemove5(){
        assertNull(array.remove(-1));
        assertNull(array.remove(32));
    }

    @Test (timeout = 200)
    public void testRemove6(){
        array.add(new Thing("you'll be"));
        assertEquals(array.remove(0), new Thing("you'll be"));
    }

    @Test (timeout = 200)
    public void testRemove7(){
        Collection<Thing> coll = new LinkedList<>();
        Thing[] arr = {new Thing("0"),new Thing("1"), new Thing("3"),new Thing("4"), null, null, null, null, null, null};

        for(int i=0; i<5; i++){
            coll.add(new Thing(""+i));
        }
        array.addAll(coll);
        array.remove(2);
        assertArrayEquals(array.toArray(),arr);
    }

    @Test (timeout = 200)
    public void testGet1(){
        assertNull(array.get(-1));
        assertNull(array.get(26));
    }

    @Test (timeout = 200)
    public void testGet2(){
        array.add(new Thing("blink"));
        assertEquals(array.get(0),new Thing("blink"));
        assertNull(array.get(1));
    }

    @Test (timeout = 200)
    public void testGet3(){
        for(int i=0; i<15; i++){
            array.add(new Thing(""+i));
        }
        assertEquals(array.get(3),new Thing("3"));
        assertEquals(array.get(11),new Thing("11"));
    }

    @Test (timeout = 200)
    public void testContains1(){
        assertFalse(array.contains(new Thing()));
    }

    @Test (timeout = 200)
    public void testContains2(){
        array.add(new Thing("what's"));
        assertTrue(array.contains(new Thing("what's")));
    }

    @Test (timeout = 200)
    public void testContains3(){
        for(int i=0; i<15; i++){
            array.add(new Thing(""+i));
        }
        assertTrue(array.contains(new Thing("3")));
        assertTrue(array.contains(new Thing("12")));
    }

    @Test (timeout = 200)
    public void testIsEmpty1(){
        assertTrue(array.isEmpty());
    }

    @Test (timeout = 200)
    public void testIsEmpty2(){
        array.add(new Thing());
        array.remove(new Thing());
        assertTrue(array.isEmpty());
    }

    @Test (timeout = 200)
    public void testClear1(){
        Thing[] arr = new Thing[10];
        array.add(new Thing());
        array.add(new Thing());
        array.add(new Thing());
        array.clear();
        assertArrayEquals(array.toArray(),arr);
    }

    @Test (timeout = 200)
    public void testSize1(){
        assertTrue(array.size()==0);
    }

    @Test (timeout = 200)
    public void testSize2(){
        array.add(new Thing());
        assertTrue(array.size()==1);
    }


    @Test (timeout = 200)
    public void testSize3(){
        for(int i=0; i<15; i++){
            array.add(new Thing());
        }
        assertTrue(array.size()==15);
    }

    @Test (timeout = 200)
    public void testSize4(){
        for(int i=0; i<15; i++){
            array.add(new Thing());
        }
        array.clear();
        assertTrue(array.size()==0);
    }

    private class Thing{
        public String name;
        public int number;

        public Thing(){
            this("What",0);
        }
        public Thing(String name){
            this(name,0);
        }
        public Thing(String name,int number){
            this.name = name;
            this.number = number;
        }

        @Override
        public boolean equals(Object o){
            return name.equals(((Thing)o).name);
        }
    }
}