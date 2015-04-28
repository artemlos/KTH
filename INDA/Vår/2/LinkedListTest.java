package inda2v;

import static org.junit.Assert.*;
import inda2v.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	
	
	LinkedList<Object> newList;
	
	@Before
	public void Initialization() {
		newList = new LinkedList<Object>();
	}
	
	@Test
	public void LinkedListTest() {
		//test for the constructor
		
		LinkedList<Object> aList = new LinkedList<Object>();
		
		//relies on that we declared size() correctly.
		assertEquals(0, aList.size());
		
		assertEquals(null, aList.getFirst());
		assertEquals(null, aList.getLast());
	}
	
	@Test
	public void AddFirstTest()	{
		//
		int currentSize = newList.size();
		
		Object cat = "A Cat stored as an object";
		newList.addFirst(cat);
		
		assertEquals(currentSize +1, newList.size());
		assertEquals(cat , newList.getFirst());
		
		
		// some additional tests for getFirst and getLast
		LinkedList<String> bList = new LinkedList<String>();
		
		bList.addFirst("hi");
		bList.addFirst("there");
		bList.addFirst("test");
		
		assertEquals("hi", bList.getLast());
		assertEquals("test", bList.getFirst());
		
		assertTrue(bList.isHealthy());
		
	}
	
	@Test
	public void AddLastTest() {
		int currentSize = newList.size();
		
		Object cat = "The last cat stored as an object";
		
		newList.addLast(cat);
		
		assertEquals(currentSize +1, newList.size());
		assertEquals(cat, newList.getLast());
	
		
		// some additional tests for getFirst and getLast
		LinkedList<String> bList = new LinkedList<String>();
		
		bList.addFirst("hi");
		bList.addLast("matrix");
		bList.addLast("determinant");
		
		assertEquals("determinant", bList.getLast());
		assertEquals("hi", bList.getFirst());
		
		assertTrue(bList.isHealthy());
		assertTrue(newList.isHealthy());
		
	}
	
	@Test
	public void getTest()
	{
		
		//assertTrue(newList.isHealthy());
		
		Object first = newList.getFirst();
		
		Object atIndexTwo = newList.get(2);
		
		assertEquals(first, newList.getFirst()); // pass -> nothing weird occurred because of change in reference during search.
		
		Object objBefore  = "The cat gets into a List.";
		Object objAfter = "The cat survived."; 
		
		
		newList.addFirst(objBefore);
		newList.addLast(objAfter);
		
		assertEquals(objBefore, newList.get(0));
		assertEquals(objAfter, newList.get(1));
		
		LinkedList<String> ls = new LinkedList<String>();
		ls.addFirst("hello");
		ls.addFirst("hi");
		ls.addLast("see you");
		ls.addLast("ciao");
		
		
	}
	
	@Test
	public void toStringTest() {
		
		LinkedList<String> test = new LinkedList<String>();
		
		test.addFirst("hi");
		test.addFirst("there");
		test.addFirst("test");
		
		
		assertEquals("[test, there, hi]", test.toString());
	}
	
	@Test
	public void emptyArrayTest() {
		LinkedList<String> test = new LinkedList<String>();
		
		assertTrue(test.isEmpty());
		
		test.addFirst("hi");
		
		assertEquals("hi", test.getFirst());
		assertEquals("hi", test.getLast());
		
	}
	
	
	@After
	public void removeFirstTest()
	{
		Object firstItem = newList.getFirst();
		int currentSize = newList.size();
		
		Object removedItem = newList.removeFirst();
		
		if(newList.size() != 0)
		{
			assertTrue(newList.isHealthy());
			assertEquals(currentSize-1, newList.size());
			assertEquals(firstItem, removedItem);
			assertTrue(newList.isHealthy());
		}

	}
	
	@After
	public void ClearingTest()
	{
		newList.clear();
		assertTrue(newList.isEmpty());
	}
	
	

}
