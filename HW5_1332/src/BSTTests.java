import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sparky
 *
 */
public class BSTTests {
	private static final int MISSING = -1;
	private static final int TIMEOUT = 300;
	private BSTInterface<Integer> bst;
	private BSTInterface<AlwaysEqualsObject> sbst;
	private BSTInterface<UnnormalizedComparableObject> ubst;

	@Before
	public void setup() {
		bst = new BST<>();
		sbst = new BST<>();
		ubst = new BST<>();
	}

	@Test(expected = IllegalArgumentException.class, timeout = TIMEOUT)
	public void illegalGet() {
		bst.get(null);
	}

	@Test(expected = IllegalArgumentException.class, timeout = TIMEOUT)
	public void illegalAddAll() {
		bst.addAll(null);
	}

	@Test(expected = IllegalArgumentException.class, timeout = TIMEOUT)
	public void illegalAddAllItem() {
		LinkedList<Integer> items = new LinkedList<Integer>();
		items.add(null);
		bst.addAll(items);
	}

	@Test(expected = IllegalArgumentException.class, timeout = TIMEOUT)
	public void illegalRemove() {
		bst.remove(null);
	}

	@Test(expected = IllegalArgumentException.class, timeout = TIMEOUT)
	public void illegalContains() {
		bst.contains(null);
	}

	@Test(expected = IllegalArgumentException.class, timeout = TIMEOUT)
	public void illegalAdd() {
		bst.add(null);
	}

	@Test(timeout = TIMEOUT)
	public void parameterNotSameGet() {
		AlwaysEqualsObject parameter = new AlwaysEqualsObject();
		AlwaysEqualsObject addition = new AlwaysEqualsObject();
		sbst.add(addition);
		AlwaysEqualsObject returned = sbst.get(parameter);
		assertNotSame(parameter, returned);
		assertSame(addition, returned);
	}

	@Test(timeout = TIMEOUT)
	public void parameterNotSameRemove() {
		AlwaysEqualsObject parameter = new AlwaysEqualsObject();
		AlwaysEqualsObject addition = new AlwaysEqualsObject();
		sbst.add(addition);
		AlwaysEqualsObject returned = sbst.remove(parameter);
		assertNotSame(parameter, returned);
		assertSame(addition, returned);
	}

	@Test(timeout = TIMEOUT)
	public void unnormalizedComparableRight() {
		UnnormalizedComparableObject lesser = new UnnormalizedComparableObject(
				0);
		UnnormalizedComparableObject greater = new UnnormalizedComparableObject(
				1);
		ubst.add(lesser);
		ubst.add(greater);
		assertTrue(ubst.contains(lesser));
		assertTrue(ubst.contains(greater));
		assertEquals(lesser, ubst.get(lesser));
		assertEquals(greater, ubst.get(greater));
		assertEquals(greater, ubst.remove(greater));
		assertEquals(1, ubst.size());
	}

	@Test(timeout = TIMEOUT)
	public void unnormalizedComparableLeft() {
		UnnormalizedComparableObject lesser = new UnnormalizedComparableObject(
				0);
		UnnormalizedComparableObject greater = new UnnormalizedComparableObject(
				1);
		ubst.add(greater);
		ubst.add(lesser);
		assertTrue(ubst.contains(lesser));
		assertTrue(ubst.contains(greater));
		assertEquals(lesser, ubst.get(lesser));
		assertEquals(greater, ubst.get(greater));
		assertEquals(lesser, ubst.remove(lesser));
		assertEquals(1, ubst.size());
	}

	@Test(timeout = TIMEOUT)
	public void emptyCaseMissing() {
		assertMissing();
	}

	@Test(timeout = TIMEOUT)
	public void emptyCaseEmpty() {
		assertTrue(bst.isEmpty());
	}

	@Test(timeout = TIMEOUT)
	public void emptyCaseSize() {
		assertEquals(0, bst.size());
	}

//	@Test(timeout = TIMEOUT)
//	public void emptyCaseLevelOrder() {
//		assertEquals(0, bst.levelOrder().size());
//	}

	@Test(timeout = TIMEOUT)
	public void emptyCaseInOrder() {
		assertEquals(0, bst.inOrder().size());
	}

	@Test(timeout = TIMEOUT)
	public void emptyCasePreOrder() {
		assertEquals(0, bst.preOrder().size());
	}

	@Test(timeout = TIMEOUT)
	public void emptyCasePostOrder() {
		assertEquals(0, bst.postOrder().size());
	}

	@Test(timeout = TIMEOUT)
	public void emptyCaseString() {
		assertEquals("()", bst.toString());
	}
	
	@Test(timeout = TIMEOUT)
	public void emptyCase() {
		assertMissing();
		assertEmpty();
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void emptyAddAllCase() {
		LinkedList<Integer> items = new LinkedList<Integer>();
		bst.addAll(items);

		assertMissing();
		assertEmpty();
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCase() {
		bst.add(0);

		assertMissing();
		assertSizeOne(0);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCaseMissing() {
		bst.add(0);

		assertMissing();
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCaseEmpty() {
		bst.add(0);

		assertFalse(bst.isEmpty());
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCaseGet() {
		bst.add(0);

		assertEquals((Integer) 0, bst.get(0));
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCaseContains() {
		bst.add(0);

		assertTrue(bst.contains(0));
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCaseSize() {
		bst.add(0);

		assertEquals(1, bst.size());
	}

//	@Test(timeout = TIMEOUT)
//	public void sizeOneCaseLevelOrder() {
//		bst.add(0);
//
//		assertArrayEquals(new Integer[] {0 }, bst.levelOrder().toArray());
//	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCaseInOrder() {
		bst.add(0);

		assertArrayEquals(new Integer[] {0 }, bst.inOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCasePreOrder() {
		bst.add(0);

		assertArrayEquals(new Integer[] {0 }, bst.preOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCasePostOrder() {
		bst.add(0);

		assertArrayEquals(new Integer[] {0 }, bst.postOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneCaseString() {
		bst.add(0);

		assertEquals("(0()())", bst.toString());
	}
	
	@Test(timeout = TIMEOUT)
	public void sizeOneDuplicatesCase() {
		bst.add(0);
		bst.add(0);

		assertMissing();
		assertSizeOne(0);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneRemoveCase() {
		bst.add(0);
		assertEquals((Integer) 0, bst.remove(0));

		assertFalse(bst.contains(0));
		assertNull(bst.get(0));
		assertMissing();
		assertEmpty();
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeOneClearCase() {
		bst.add(0);
		bst.clear();

		assertFalse(bst.contains(0));
		assertNull(bst.get(0));
		assertMissing();
		assertEmpty();
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void oneAddAllCase() {
		LinkedList<Integer> items = new LinkedList<Integer>();
		items.add(0);
		bst.addAll(items);

		assertMissing();
		assertSizeOne(0);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTwo01Case() {
		bst.add(0);
		bst.add(1);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertEquals(2, bst.size());

//		assertArrayEquals(new Integer[] {0, 1 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {1, 0 }, bst.postOrder().toArray());
		assertEquals("(0()(1()()))", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTwo10Case() {
		bst.add(1);
		bst.add(0);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertEquals(2, bst.size());

//		assertArrayEquals(new Integer[] {1, 0 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {1, 0 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1 }, bst.postOrder().toArray());
		assertEquals("(1(0()())())", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTwo10Remove0Case() {
		bst.add(1);
		bst.add(0);
		assertEquals((Integer) 0, bst.remove(0));

		assertMissing();
		assertNull(bst.get(0));
		assertFalse(bst.contains(0));
		assertSizeOne(1);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTwo10Remove1Case() {
		bst.add(1);
		bst.add(0);
		assertEquals((Integer) 1, bst.remove(1));

		assertMissing();
		assertNull(bst.get(1));
		assertFalse(bst.contains(1));
		assertSizeOne(0);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTwo01Remove0Case() {
		bst.add(0);
		bst.add(1);
		assertEquals((Integer) 0, bst.remove(0));

		assertMissing();
		assertNull(bst.get(0));
		assertFalse(bst.contains(0));
		assertSizeOne(1);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTwo01Remove1Case() {
		bst.add(0);
		bst.add(1);
		assertEquals((Integer) 1, bst.remove(1));

		assertMissing();
		assertNull(bst.get(1));
		assertFalse(bst.contains(1));
		assertSizeOne(0);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeThree102Case() {
		bst.add(1);
		bst.add(0);
		bst.add(2);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertEquals(3, bst.size());

//		assertArrayEquals(new Integer[] {1, 0, 2 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {1, 0, 2 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {0, 2, 1 }, bst.postOrder().toArray());
		assertEquals("(1(0()())(2()()))", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeThree102Remove1Case() {
		bst.add(1);
		bst.add(0);
		bst.add(2);
		assertEquals((Integer) 1, bst.remove(1));

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertNull(bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertTrue(bst.contains(0));
		assertFalse(bst.contains(1));
		assertTrue(bst.contains(2));
		assertEquals(2, bst.size());

//		assertArrayEquals(new Integer[] {2, 0 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 2 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {2, 0 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {0, 2 }, bst.postOrder().toArray());
		assertEquals("(2(0()())())", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeThree102ClearCase() {
		bst.add(1);
		bst.add(0);
		bst.add(2);
		bst.clear();

		assertFalse(bst.contains(0));
		assertFalse(bst.contains(1));
		assertFalse(bst.contains(2));
		assertNull(bst.get(0));
		assertNull(bst.get(1));
		assertNull(bst.get(2));
		assertMissing();
		assertEmpty();
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeThree012Case() {
		bst.add(0);
		bst.add(1);
		bst.add(2);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertEquals(3, bst.size());

//		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {2, 1, 0 }, bst.postOrder().toArray());
		assertEquals("(0()(1()(2()())))", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeThree210Case() {
		bst.add(2);
		bst.add(1);
		bst.add(0);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertEquals(3, bst.size());

//		assertArrayEquals(new Integer[] {2, 1, 0 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {2, 1, 0 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.postOrder().toArray());
		assertEquals("(2(1(0()())())())", bst.toString());
		bst.clear();
	}

	public void sizeThree201Case() {
		bst.add(2);
		bst.add(0);
		bst.add(1);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertEquals(3, bst.size());

		assertArrayEquals(new Integer[] {2, 0, 1 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {2, 0, 1 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {1, 0, 2 }, bst.postOrder().toArray());
		assertEquals("(2(0(1()())())())", bst.toString());
		bst.clear();
	}

	public void sizeThree021Case() {
		bst.add(0);
		bst.add(2);
		bst.add(1);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertEquals(3, bst.size());

		assertArrayEquals(new Integer[] {0, 2, 1 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {0, 2, 1 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {1, 2, 0 }, bst.postOrder().toArray());
		assertEquals("(0()(2(1()())()))", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeThree012Remove2Case() {
		bst.add(0);
		bst.add(1);
		bst.add(2);
		assertEquals((Integer) 2, bst.remove(2));

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertNull(bst.get(2));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertFalse(bst.contains(2));
		assertEquals(2, bst.size());

//		assertArrayEquals(new Integer[] {0, 1 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {1, 0 }, bst.postOrder().toArray());
		assertEquals("(0()(1()()))", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeThree210Remove0Case() {
		bst.add(2);
		bst.add(1);
		bst.add(0);
		assertEquals((Integer) 0, bst.remove(0));

		assertMissing();
		assertFalse(bst.isEmpty());
		assertNull(bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertFalse(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertEquals(2, bst.size());

//		assertArrayEquals(new Integer[] {2, 1 }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {1, 2 }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {2, 1 }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {1, 2 }, bst.postOrder().toArray());
		assertEquals("(2(1()())())", bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCase() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertFalse(bst.contains(3));
		assertFalse(bst.contains(4));
		assertFalse(bst.contains(5));
		assertFalse(bst.contains(6));
		assertFalse(bst.contains(7));
		assertNull(bst.get(3));
		assertNull(bst.get(4));
		assertNull(bst.get(5));
		assertNull(bst.get(6));
		assertNull(bst.get(7));
		assertMissing();
		assertSizeOne(2);
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseRemoveOne() {
		createSizeSeven5372468();
		assertEquals((Integer) 5, bst.remove(5));
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseRemoveTwo() {
		createSizeSeven5372468();
		assertEquals((Integer) 5, bst.remove(5));
		assertEquals((Integer) 6, bst.remove(6));
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseRemoveThree() {
		createSizeSeven5372468();
		assertEquals((Integer) 5, bst.remove(5));
		assertEquals((Integer) 6, bst.remove(6));
		assertEquals((Integer) 7, bst.remove(7));

	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseRemoveFour() {
		createSizeSeven5372468();
		assertEquals((Integer) 5, bst.remove(5));
		assertEquals((Integer) 6, bst.remove(6));
		assertEquals((Integer) 7, bst.remove(7));
		assertEquals((Integer) 8, bst.remove(8));
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseRemoveFive() {
		createSizeSeven5372468();
		assertEquals((Integer) 5, bst.remove(5));
		assertEquals((Integer) 6, bst.remove(6));
		assertEquals((Integer) 7, bst.remove(7));
		assertEquals((Integer) 8, bst.remove(8));
		assertEquals((Integer) 3, bst.remove(3));
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseRemoveSix() {
		createSizeSeven5372468();

		removeAllRootsExceptOne();
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseContains() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertTrue(bst.contains(2));
		assertFalse(bst.contains(3));
		assertFalse(bst.contains(4));
		assertFalse(bst.contains(5));
		assertFalse(bst.contains(6));
		assertFalse(bst.contains(7));
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseGet() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertEquals((Integer) 2, bst.get(2));
		assertNull(bst.get(3));
		assertNull(bst.get(4));
		assertNull(bst.get(5));
		assertNull(bst.get(6));
		assertNull(bst.get(7));
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseMissing() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertMissing();
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseEmpty() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertFalse(bst.isEmpty());
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseSize() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertEquals(1, bst.size());
	}

//	@Test(timeout = TIMEOUT)
//	public void sizeSeven5372468RemoveAllRootsExceptOneCaseLevelOrder() {
//		createSizeSeven5372468();
//		removeAllRootsExceptOne();
//
//		assertArrayEquals(new Integer[] {2 }, bst.levelOrder().toArray());
//	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseInOrder() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertArrayEquals(new Integer[] {2 }, bst.inOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCasePreOrder() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertArrayEquals(new Integer[] {2 }, bst.preOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCasePostOrder() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertArrayEquals(new Integer[] {2 }, bst.postOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeSeven5372468RemoveAllRootsExceptOneCaseString() {
		createSizeSeven5372468();
		removeAllRootsExceptOne();

		assertEquals("(2()())", bst.toString());
	}
	
	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354Case() {
		createSizeTen9081726354();

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertEquals((Integer) 3, bst.get(3));
		assertEquals((Integer) 4, bst.get(4));
		assertEquals((Integer) 5, bst.get(5));
		assertEquals((Integer) 6, bst.get(6));
		assertEquals((Integer) 7, bst.get(7));
		assertEquals((Integer) 8, bst.get(8));
		assertEquals((Integer) 9, bst.get(9));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertTrue(bst.contains(3));
		assertTrue(bst.contains(4));
		assertTrue(bst.contains(5));
		assertTrue(bst.contains(6));
		assertTrue(bst.contains(7));
		assertTrue(bst.contains(8));
		assertTrue(bst.contains(9));
		assertEquals(10, bst.size());

//		assertArrayEquals(new Integer[] {9, 0, 8, 1, 7, 2, 6, 3, 5, 4 }, bst
//				.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bst
				.inOrder().toArray());
		assertArrayEquals(new Integer[] {9, 0, 8, 1, 7, 2, 6, 3, 5, 4 }, bst
				.preOrder().toArray());
		assertArrayEquals(new Integer[] {4, 5, 3, 6, 2, 7, 1, 8, 0, 9 }, bst
				.postOrder().toArray());
		String treeString = "(9(0()(8(1()(7(2()(6(3()(5(4()())()))()))()))()))())";
		assertEquals(treeString, bst.toString());
		bst.clear();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CaseMissing() {
		createSizeTen9081726354();

		assertMissing();
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CaseEmpty() {
		createSizeTen9081726354();

		assertFalse(bst.isEmpty());
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CaseGet() {
		createSizeTen9081726354();

		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertEquals((Integer) 3, bst.get(3));
		assertEquals((Integer) 4, bst.get(4));
		assertEquals((Integer) 5, bst.get(5));
		assertEquals((Integer) 6, bst.get(6));
		assertEquals((Integer) 7, bst.get(7));
		assertEquals((Integer) 8, bst.get(8));
		assertEquals((Integer) 9, bst.get(9));
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CaseContains() {
		createSizeTen9081726354();

		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertTrue(bst.contains(3));
		assertTrue(bst.contains(4));
		assertTrue(bst.contains(5));
		assertTrue(bst.contains(6));
		assertTrue(bst.contains(7));
		assertTrue(bst.contains(8));
		assertTrue(bst.contains(9));
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CaseSize() {
		createSizeTen9081726354();

		assertEquals(10, bst.size());
	}

//	@Test(timeout = TIMEOUT)
//	public void sizeTen9081726354CaseLevelOrder() {
//		createSizeTen9081726354();
//
//		assertArrayEquals(new Integer[] {9, 0, 8, 1, 7, 2, 6, 3, 5, 4 }, bst
//				.levelOrder().toArray());
//	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CaseInOrder() {
		createSizeTen9081726354();

		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bst
				.inOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CasePreOrder() {
		createSizeTen9081726354();

		assertArrayEquals(new Integer[] {9, 0, 8, 1, 7, 2, 6, 3, 5, 4 }, bst
				.preOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CasePostOrder() {
		createSizeTen9081726354();

		assertArrayEquals(new Integer[] {4, 5, 3, 6, 2, 7, 1, 8, 0, 9 }, bst
				.postOrder().toArray());
	}

	@Test(timeout = TIMEOUT)
	public void sizeTen9081726354CaseString() {
		createSizeTen9081726354();

		String treeString = "(9(0()(8(1()(7(2()(6(3()(5(4()())()))()))()))()))())";
		assertEquals(treeString, bst.toString());
	}
	
	@Test(timeout = TIMEOUT)
	public void sizeTen0123456789AddAllCase() {
		bst.add(0);
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		bst.add(7);
		bst.add(8);
		bst.add(9);

		assertMissing();
		assertFalse(bst.isEmpty());
		assertEquals((Integer) 0, bst.get(0));
		assertEquals((Integer) 1, bst.get(1));
		assertEquals((Integer) 2, bst.get(2));
		assertEquals((Integer) 3, bst.get(3));
		assertEquals((Integer) 4, bst.get(4));
		assertEquals((Integer) 5, bst.get(5));
		assertEquals((Integer) 6, bst.get(6));
		assertEquals((Integer) 7, bst.get(7));
		assertEquals((Integer) 8, bst.get(8));
		assertEquals((Integer) 9, bst.get(9));
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertTrue(bst.contains(3));
		assertTrue(bst.contains(4));
		assertTrue(bst.contains(5));
		assertTrue(bst.contains(6));
		assertTrue(bst.contains(7));
		assertTrue(bst.contains(8));
		assertTrue(bst.contains(9));
		assertEquals(10, bst.size());

//		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bst
//				.levelOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bst
				.inOrder().toArray());
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bst
				.preOrder().toArray());
		assertArrayEquals(new Integer[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, bst
				.postOrder().toArray());
		bst.clear();
	}

	/*****************************************************************
	 *
	 * Helper Methods and Objects
	 *
	 *****************************************************************/

	/**
	 * create the zig zagging size 10 case
	 */
	private void createSizeTen9081726354() {
		bst.add(9);
		bst.add(0);
		bst.add(8);
		bst.add(1);
		bst.add(7);
		bst.add(2);
		bst.add(6);
		bst.add(3);
		bst.add(5);
		bst.add(4);
	}

	/**
	 * removes for the size seven case
	 */
	private void removeAllRootsExceptOne() {
		assertEquals((Integer) 5, bst.remove(5));
		assertEquals((Integer) 6, bst.remove(6));
		assertEquals((Integer) 7, bst.remove(7));
		assertEquals((Integer) 8, bst.remove(8));
		assertEquals((Integer) 3, bst.remove(3));
		assertEquals((Integer) 4, bst.remove(4));
	}

	/**
	 * creates the size seven case
	 */
	private void createSizeSeven5372468() {
		bst.add(5);
		bst.add(3);
		bst.add(7);
		bst.add(2);
		bst.add(4);
		bst.add(6);
		bst.add(8);
	}

	/**
	 * asserts that the bst does not say it contains something that it doesn't
	 */
	private void assertMissing() {
		assertNull(bst.remove(MISSING));
		assertFalse(bst.contains(MISSING));
		assertNull(bst.get(MISSING));
	}

	/**
	 * asserts that the bst is empty
	 */
	private void assertEmpty() {
		assertTrue(bst.isEmpty());
		assertEquals(0, bst.size());
//		assertEquals(0, bst.levelOrder().size());
		assertEquals(0, bst.inOrder().size());
		assertEquals(0, bst.preOrder().size());
		assertEquals(0, bst.postOrder().size());
		assertEquals("()", bst.toString());
	}

	/**
	 * asserts that only one item is in the tree
	 * @param item the only item the tree contains
	 */
	private void assertSizeOne(int item) {
		assertFalse(bst.isEmpty());
		assertEquals((Integer) item, bst.get(item));
		assertTrue(bst.contains(item));
		assertEquals(1, bst.size());

//		assertArrayEquals(new Integer[] {item }, bst.levelOrder().toArray());
		assertArrayEquals(new Integer[] {item }, bst.inOrder().toArray());
		assertArrayEquals(new Integer[] {item }, bst.preOrder().toArray());
		assertArrayEquals(new Integer[] {item }, bst.postOrder().toArray());
		assertEquals("(" + item + "()())", bst.toString());
	}

	
	private static class AlwaysEqualsObject implements
			Comparable<AlwaysEqualsObject> {
		@Override
		public boolean equals(Object o) {
			return true;
		}

		@Override
		public int compareTo(AlwaysEqualsObject o) {
			return 0;
		}
	}

	private static class UnnormalizedComparableObject implements
			Comparable<UnnormalizedComparableObject> {
		private static final int SCALING = 10;
		private int state;

		public UnnormalizedComparableObject(int state) {
			this.state = state;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof UnnormalizedComparableObject) {
				return ((UnnormalizedComparableObject) o).state == state;
			} else {
				return false;
			}
		}

		@Override
		public int compareTo(UnnormalizedComparableObject o) {
			return (state - o.state) * SCALING;
		}
	}
}
